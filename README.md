# filememo
## IssueListActivity

```kotlin
package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sasakitest.adapter.IssueAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class IssueListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var nextPageButton: Button
    private lateinit var prevPageButton: Button
    private val issueAdapter = IssueAdapter()

    private var currentPage = 1
    private var isLoading = false
    private var hasNextPage = true
    private lateinit var repositoryName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = issueAdapter

        nextPageButton = findViewById(R.id.nextPageButton)
        prevPageButton = findViewById(R.id.prevPageButton)

        // 「新規Issue作成」ボタン
        val createIssueButton = findViewById<Button>(R.id.createIssueButton)
        repositoryName = intent.getStringExtra("repositoryName") ?: ""

        createIssueButton.setOnClickListener {
            if (repositoryName.isNotEmpty()) {
                val intent = Intent(this, CreateIssueActivity::class.java)
                intent.putExtra("repositoryName", repositoryName)
                startActivity(intent)
            } else {
                Toast.makeText(this, "リポジトリ名が無効です", Toast.LENGTH_SHORT).show()
            }
        }

        // 「次のページへ」ボタン
        nextPageButton.setOnClickListener {
            if (hasNextPage && !isLoading) {
                currentPage++
                loadIssues(repositoryName)
            }
        }

        // 「前のページへ」ボタン
        prevPageButton.setOnClickListener {
            if (currentPage > 1 && !isLoading) {
                currentPage--
                loadIssues(repositoryName)
            }
        }

        loadIssues(repositoryName)
    }

    private fun loadIssues(repositoryName: String) {
        isLoading = true
        nextPageButton.visibility = View.GONE
        prevPageButton.visibility = View.GONE

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val issues = GitHubApiService.getIssues(this@IssueListActivity, repositoryName, currentPage, 25)
                withContext(Dispatchers.Main) {
                    if (issues.isNotEmpty()) {
                        issueAdapter.submitList(issues)
                        hasNextPage = issues.size == 25

                        // ボタンの表示・非表示を制御
                        nextPageButton.visibility = if (hasNextPage) View.VISIBLE else View.GONE
                        prevPageButton.visibility = if (currentPage > 1) View.VISIBLE else View.GONE
                    } else {
                        hasNextPage = false
                        Toast.makeText(this@IssueListActivity, "データがありません", Toast.LENGTH_SHORT).show()
                    }
                    isLoading = false
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@IssueListActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                }
                isLoading = false
            }
        }
    }
}


```
##mainactivity

```kotlin

package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_QUERY = "query"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchBox = findViewById<EditText>(R.id.searchBox)
        val searchButton = findViewById<Button>(R.id.searchButton)

        searchButton.setOnClickListener {
            val query = searchBox.text.toString().trim()

            if (query.isBlank() || query.length < 3) {
                searchBox.error = "有効な検索クエリを入力してください (3文字以上)"
                return@setOnClickListener
            }

            val intent = Intent(this, RepositoryListActivity::class.java).apply {
                putExtra(EXTRA_QUERY, query)
            }
            startActivity(intent)
        }
    }
}
```
##issuelistkotlin


```kotlin

package com.example.sasakitest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sasakitest.adapter.IssueAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class IssueListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var nextPageButton: Button
    private lateinit var prevPageButton: Button
    private val issueAdapter = IssueAdapter()

    private var currentPage = 1
    private var isLoading = false
    private var hasNextPage = true
    private lateinit var repositoryName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = issueAdapter

        nextPageButton = findViewById(R.id.nextPageButton)
        prevPageButton = findViewById(R.id.prevPageButton)

        // 「新規Issue作成」ボタン
        val createIssueButton = findViewById<Button>(R.id.createIssueButton)
        repositoryName = intent.getStringExtra("repositoryName") ?: ""

        createIssueButton.setOnClickListener {
            if (repositoryName.isNotEmpty()) {
                val intent = Intent(this, CreateIssueActivity::class.java)
                intent.putExtra("repositoryName", repositoryName)
                startActivity(intent)
            } else {
                Toast.makeText(this, "リポジトリ名が無効です", Toast.LENGTH_SHORT).show()
            }
        }

        // 「次のページへ」ボタン
        nextPageButton.setOnClickListener {
            if (hasNextPage && !isLoading) {
                currentPage++
                loadIssues(repositoryName)
            }
        }

        // 「前のページへ」ボタン
        prevPageButton.setOnClickListener {
            if (currentPage > 1 && !isLoading) {
                currentPage--
                loadIssues(repositoryName)
            }
        }

        loadIssues(repositoryName)
    }

    private fun loadIssues(repositoryName: String) {
        isLoading = true
        nextPageButton.visibility = View.GONE
        prevPageButton.visibility = View.GONE

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val issues = GitHubApiService.getIssues(this@IssueListActivity, repositoryName, currentPage, 25)
                withContext(Dispatchers.Main) {
                    if (issues.isNotEmpty()) {
                        issueAdapter.submitList(issues)
                        hasNextPage = issues.size == 25

                        // ボタンの表示・非表示を制御
                        nextPageButton.visibility = if (hasNextPage) View.VISIBLE else View.GONE
                        prevPageButton.visibility = if (currentPage > 1) View.VISIBLE else View.GONE
                    } else {
                        hasNextPage = false
                        Toast.makeText(this@IssueListActivity, "データがありません", Toast.LENGTH_SHORT).show()
                    }
                    isLoading = false
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@IssueListActivity, "エラー: ${e.message}", Toast.LENGTH_SHORT).show()
                }
                isLoading = false
            }
        }
    }
}

```
##Issueadapter

```kotlin


package com.example.sasakitest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sasakitest.R
import com.example.sasakitest.model.Issue

class IssueAdapter : ListAdapter<Issue, IssueAdapter.IssueViewHolder>(IssueDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_issue, parent, false)
        return IssueViewHolder(view)
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class IssueViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val issueTitle: TextView = view.findViewById(R.id.issueTitle)
        private val issueBody: TextView = view.findViewById(R.id.issueBody)

        fun bind(issue: Issue) {
            issueTitle.text = issue.title
            issueBody.text = issue.body ?: "No description available"
        }
    }

    class IssueDiffCallback : DiffUtil.ItemCallback<Issue>() {
        override fun areItemsTheSame(oldItem: Issue, newItem: Issue): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Issue, newItem: Issue): Boolean = oldItem == newItem
    }
}

```
##
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="16dp"
    android:background="@android:color/white">

    <!-- イシュータイトル -->
    <TextView
        android:id="@+id/issueTitle"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:textStyle="bold"
        android:paddingBottom="8dp"
        android:textColor="@android:color/black" />

    <!-- 仕切り線 -->
    <View
        android:layout_width="match_parent"
        android:layout_height="1dp"
        android:background="@color/light_gray"
        android:layout_marginBottom="8dp" />

    <!-- イシュー内容 -->
    <TextView
        android:id="@+id/issueBody"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="14sp"
        android:textColor="@android:color/darker_gray" />

    <!-- 点線 -->
    <View
        android:layout_width="match_parent"
        android:layout_height="1dp"
        android:background="@drawable/dotted_line"
        android:layout_marginTop="16dp" />
</LinearLayout>

```



##githubapiservise
```kotlin

package com.example.sasakitest

import android.content.Context
import android.util.Log
import com.example.sasakitest.model.Issue
import com.example.sasakitest.model.RepositoryResponse
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
// GitHub APIを操作するためのサービス
object GitHubApiService {
    private const val BASE_URL = "https://api.github.com"
    private val client = OkHttpClient()

    // トークン取得
    private fun getToken(context: Context): String {
        val sharedPreferences = context.getSharedPreferences("GitHubPrefs", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("GitHubToken", "") ?: ""
        Log.d("GitHubApiService", "Retrieved token: $token")
        if (token.isEmpty()) {
            throw IllegalStateException("GitHub Token is not set")
        }
        return token
    }


    fun searchRepositories(
        context: Context,
        query: String,
        page: Int
    ): Pair<RepositoryResponse, Boolean> {
        val token = getToken(context)
        val url = "$BASE_URL/search/repositories?q=$query&page=$page&per_page=25"
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .build()

        Log.d("GitHubApiService", "API Request URL: $url")

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("API request failed: ${response.code}")
            }
            val body = response.body?.string() ?: throw Exception("Empty response")
            val hasNextPage = response.headers["Link"]?.contains("rel=\"next\"") ?: false
            return Pair(Gson().fromJson(body, RepositoryResponse::class.java), hasNextPage)
        }
    }


    // イシュー（課題）を取得するメソッド（ページング対応）
    fun getIssues(context: Context, repositoryName: String, page: Int, perPage: Int): List<Issue> {
        val token = getToken(context)
        val url = "$BASE_URL/repos/$repositoryName/issues?per_page=$perPage&page=$page"
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .build()

        Log.d("GitHubApiService", "Fetching issues with URL: $url for repository: $repositoryName")

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("Failed to fetch issues: ${response.code}")
            }
            val body = response.body?.string() ?: throw Exception("Empty response")
            return Gson().fromJson(body, Array<Issue>::class.java).toList()
        }
    }

    // 新しいイシューを作成するメソッド
    fun createIssue(context: Context, repositoryName: String, title: String, body: String) {
        val token = getToken(context) // context を使ってトークンを取得
        val url = "$BASE_URL/repos/$repositoryName/issues"
        val json = """{ "title": "$title", "body": "$body" }"""
        val requestBody = json.toRequestBody("application/json".toMediaType())
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw Exception("Failed to create issue: ${response.code}")
            }
        }
    }


}
```
##activityxml
```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingTop="24dp"
    android:padding="16dp">
    <!-- res/layout/activity_main.xml -->
    <EditText
        android:id="@+id/searchBox"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/search_hint"
        android:inputType="text"
        android:padding="8dp"
        android:autofillHints="username" />

    <Button
        android:id="@+id/searchButton"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/search_button"
        android:layout_marginTop="16dp" />
</LinearLayout>


```

##
```kotlin
git 
```
---


