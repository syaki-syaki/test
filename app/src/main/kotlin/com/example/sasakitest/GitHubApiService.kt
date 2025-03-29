package com.example.sasakitest

import android.content.Context
import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.exception.ApolloException
import com.apollographql.apollo3.network.http.DefaultHttpEngine
import com.example.sasakitest.graphql.CreateIssueMutation
import com.example.sasakitest.graphql.DeleteIssueMutation
import com.example.sasakitest.graphql.GetIssuesQuery
import com.example.sasakitest.graphql.GetRepositoriesQuery
import com.example.sasakitest.graphql.GetUserRepositoriesQuery
import com.example.sasakitest.graphql.GetViewerQuery
import com.example.sasakitest.graphql.SearchRepositoriesQuery
import com.example.sasakitest.graphql.UpdateIssueMutation
import com.example.sasakitest.model.Issue
import com.example.sasakitest.model.RepositoryResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor



object GitHubApiService {
    private const val BASE_URL = "https://api.github.com/graphql"

    private fun createApolloClient(context: Context): ApolloClient {
        val token = getToken(context)
        Log.d("Apollo", "Using token: $token")  // ✅ トークンが正しく取得されているか確認
        // ApolloClient にログインターセプタを追加
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(Interceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("Authorization", "Bearer $token")
                    .header("Content-Type", "application/json")
                val request = requestBuilder.build()

                Log.d("Apollo", "Sending request to: ${request.url}")
                val response = chain.proceed(request)
                Log.d("Apollo", "Response Code: ${response.code}")

                response
            })
            .build()

        return ApolloClient.Builder()
            .serverUrl(BASE_URL)
            .httpEngine(DefaultHttpEngine(okHttpClient))
            .build()
    }

    private fun getToken(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("GitHubPrefs", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("GitHubToken", null)
            ?: throw IllegalStateException("GitHub Token is not set. Please enter a valid token.")

        Log.d("Apollo", "getToken() = $token")
        return token
    }

    suspend fun getViewerUsername(context: Context): String? {
        val apolloClient = createApolloClient(context)
        return try {
            val response = apolloClient.query(GetViewerQuery()).execute() // 🔑 GetViewerQuery() に変更
            val username = response.data?.viewer?.login
            Log.d("Apollo", "Current Viewer Username: $username")
            username
        } catch (e: ApolloException) {
            Log.e("Apollo", "Failed to get viewer username", e)
            null
        }
    }


    suspend fun getUserRepositories(context: Context, username: String): List<RepositoryResponse.Item> {
        val apolloClient = createApolloClient(context)
        return try {
            Log.d("Apollo", "getUserRepositories: username=$username")
            val response = apolloClient.query(GetUserRepositoriesQuery(username)).execute()
            response.data?.user?.repositories?.nodes?.mapNotNull {
                RepositoryResponse.Item(
                    id = it?.id.orEmpty(),
                    name = it?.name.orEmpty(),
                    description = it?.description.orEmpty(),
                    htmlUrl = it?.url.orEmpty(),
                    owner = RepositoryResponse.Owner(it?.owner?.login.orEmpty())
                )
            } ?: emptyList()
        } catch (e: ApolloException) {
            Log.e("Apollo", "getUserRepositories failed", e)
            emptyList()
        }
    }


    suspend fun getRepository(context: Context, username: String): List<RepositoryResponse.Item> {
        val apolloClient = createApolloClient(context)
        return try {
            Log.d("Apollo", "getRepository: username=$username")
            val response = apolloClient.query(GetRepositoriesQuery(username)).execute()
            response.data?.user?.repositories?.nodes?.mapNotNull {
                RepositoryResponse.Item(
                    id = it?.id.orEmpty(),
                    name = it?.name.orEmpty(),
                    description = it?.description.orEmpty(),
                    htmlUrl = it?.url.orEmpty(),
                    owner = RepositoryResponse.Owner(it?.owner?.login.orEmpty())
                )
            } ?: emptyList()
        } catch (e: ApolloException) {
            Log.e("Apollo", "getRepository failed", e)
            emptyList()
        }
    }

    suspend fun searchRepositoriesWithKeyword(context: Context, query: String, first: Int): List<RepositoryResponse.Item> {
        val apolloClient = createApolloClient(context)
        return try {
            Log.d("Apollo", "searchRepositoriesWithKeyword: query=$query, first=$first")
            val response = apolloClient.query(SearchRepositoriesQuery(query, first, Optional.absent())).execute()
            response.data?.search?.edges?.mapNotNull {
                val repo = it?.node?.onRepository
                if (repo != null) {
                    RepositoryResponse.Item(
                        id = repo.id,
                        name = repo.name,
                        description = repo.description.orEmpty(),
                        htmlUrl = repo.url,
                        owner = RepositoryResponse.Owner(repo.owner.login)
                    )
                } else null
            } ?: emptyList()
        } catch (e: ApolloException) {
            Log.e("Apollo", "searchRepositoriesWithKeyword failed", e)
            emptyList()
        }
    }
    suspend fun getIssues(
        context: Context,
        username: String,
        repositoryName: String,
        first: Int,
        after: String? = null
    ): List<Issue> {
        val apolloClient = createApolloClient(context)
        return try {
            val response = apolloClient.query(
                GetIssuesQuery(username, repositoryName, Optional.presentIfNotNull(first), Optional.presentIfNotNull(after))
            ).execute()

            if (response.hasErrors()) {
                response.errors?.forEach { error ->
                    Log.e("GitHubApiService", "GraphQL Error: ${error.message}")
                }
                return emptyList()
            }

            response.data?.repository?.issues?.nodes?.mapNotNull {
                Issue(
                    id = it?.id.orEmpty(),
                    title = it?.title.orEmpty(),
                    body = it?.body.orEmpty()
                )
            } ?: emptyList()
        } catch (e: ApolloException) {
            Log.e("GitHubApiService", "ApolloException: ${e.message}")
            emptyList()
        }
    }


    suspend fun createIssue(context: Context, repositoryId: String, title: String, body: String?) {
        val apolloClient = createApolloClient(context)
        try {
            Log.d("Apollo", "createIssue: repoId=$repositoryId, title=$title")
            apolloClient.mutation(
                CreateIssueMutation(repositoryId, title, Optional.presentIfNotNull(body))
            ).execute()
        } catch (e: ApolloException) {
            Log.e("Apollo", "createIssue failed", e)
        }
    }

    suspend fun deleteIssue(context: Context, issueId: String): Boolean {
        val apolloClient = createApolloClient(context)
        return try {
            Log.d("Apollo", "deleteIssue: issueId=$issueId")
            val response = apolloClient.mutation(DeleteIssueMutation(issueId)).execute()
            response.data?.deleteIssue != null
        } catch (e: ApolloException) {
            Log.e("Apollo", "deleteIssue failed", e)
            false
        }
    }

    suspend fun editIssue(context: Context, issueId: String, title: String, body: String?) {
        val apolloClient = createApolloClient(context)
        try {
            Log.d("Apollo", "editIssue: issueId=$issueId, title=$title")
            apolloClient.mutation(
                UpdateIssueMutation(issueId, title, Optional.presentIfNotNull(body))
            ).execute()
        } catch (e: ApolloException) {
            Log.e("Apollo", "editIssue failed", e)
        }
    }
}
