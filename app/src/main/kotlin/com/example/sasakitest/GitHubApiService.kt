package com.example.sasakitest

import android.content.Context
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.exception.ApolloException
import com.example.sasakitest.graphql.CreateIssueMutation
import com.example.sasakitest.graphql.DeleteIssueMutation
import com.example.sasakitest.graphql.GetIssuesQuery
import com.example.sasakitest.graphql.GetRepositoriesQuery
import com.example.sasakitest.graphql.GetUserRepositoriesQuery
import com.example.sasakitest.graphql.SearchRepositoriesQuery
import com.example.sasakitest.graphql.UpdateIssueMutation
import com.example.sasakitest.model.Issue
import com.example.sasakitest.model.RepositoryResponse


object GitHubApiService {
    private const val BASE_URL = "https://api.github.com/graphql"

    // ✅ Apollo Client のインスタンス作成
    private fun createApolloClient(context: Context): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(BASE_URL)
            .addHttpHeader("Authorization", "Bearer ${getToken(context)}") // 🔹 トークン取得
            .build()
    }

    // ✅ GitHub トークンを取得（SharedPreferences から取得）
    private fun getToken(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("GitHubPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString("GitHubToken", null)
            ?: throw IllegalStateException("GitHub Token is not set. Please enter a valid token.")
    }

    // 🆕 **入力したユーザーのリポジトリ一覧を取得**
    suspend fun getUserRepositories(context: Context, username: String): List<RepositoryResponse.Item> {
        val apolloClient = createApolloClient(context)

        return try {
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
            emptyList()
        }
    }

    // 📂 **リポジトリ一覧を取得**
    suspend fun getRepository(context: Context, username: String): List<RepositoryResponse.Item> {
        val apolloClient = createApolloClient(context)

        return try {
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
            emptyList()
        }
    }

    // 🔎 **リポジトリ検索**
    suspend fun searchRepositoriesWithKeyword(context: Context, query: String, first: Int): List<RepositoryResponse.Item> {
        val apolloClient = createApolloClient(context)

        return try {
            val response = apolloClient.query(
                SearchRepositoriesQuery(query, first, Optional.absent())
            ).execute()

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
                } else {
                    null
                }
            } ?: emptyList()
        } catch (e: ApolloException) {
            emptyList()
        }
    }

    // 📝 **イシュー一覧を取得**
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
                GetIssuesQuery(
                    username,
                    repositoryName,
                    Optional.presentIfNotNull(first), // ✅ Optional にラップ
                    Optional.presentIfNotNull(after) // ✅ Optional にラップ
                )
            ).execute()

            response.data?.user?.repository?.issues?.nodes?.mapNotNull {
                Issue(
                    id = it?.id.orEmpty(),
                    title = it?.title.orEmpty(),
                    body = it?.body.orEmpty()
                )
            } ?: emptyList()
        } catch (e: ApolloException) {
            emptyList()
        }
    }


    // 📝 **イシューの作成**
    suspend fun createIssue(context: Context, repositoryId: String, title: String, body: String?) {
        val apolloClient = createApolloClient(context)

        apolloClient.mutation(
            CreateIssueMutation(repositoryId, title, Optional.presentIfNotNull(body))
        ).execute()
    }

    // 🗑 **イシュー削除**
    suspend fun deleteIssue(context: Context, issueId: String): Boolean {
        val apolloClient = createApolloClient(context)
        return try {
            val response = apolloClient.mutation(DeleteIssueMutation(issueId)).execute()
            response.data?.deleteIssue != null
        } catch (e: ApolloException) {
            false
        }
    }

    // 📝 **イシューの編集**
    suspend fun editIssue(context: Context, issueId: String, title: String, body: String?) {
        val apolloClient = createApolloClient(context)

        apolloClient.mutation(
            UpdateIssueMutation(issueId, title, Optional.presentIfNotNull(body))
        ).execute()
    }
}
