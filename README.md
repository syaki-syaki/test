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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // UI要素
    private lateinit var searchButton: Button
    private lateinit var queryEditText: EditText
    private lateinit var starsEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton = findViewById(R.id.searchButton)
        queryEditText = findViewById(R.id.queryEditText)
        starsEditText = findViewById(R.id.starsEditText)

        searchButton.setOnClickListener {
            val query = queryEditText.text.toString()
            val stars = starsEditText.text.toString().toIntOrNull() ?: 0
            if (query.isNotEmpty()) {
                val intent = Intent(this, RepositoryListActivity::class.java)
                intent.putExtra("query", query)
                intent.putExtra("stars", stars)
                startActivity(intent)
            } else {
                Toast.makeText(this, "検索キーワードを入力してください", Toast.LENGTH_SHORT).show()
            }
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

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sasakitest.adapter.RepositoryAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepositoryListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var nextPageButton: Button
    private lateinit var prevPageButton: Button

    private val repositoryAdapter = RepositoryAdapter { repository ->
        // リポジトリクリック時の処理
        val intent = Intent(this, IssueListActivity::class.java).apply {
            putExtra("repositoryName", "${repository.owner.login}/${repository.name}")
            putExtra("fromActivity", "RepositoryListActivity") // 遷移元を指定
        }
        startActivity(intent)
    }


    private var currentPage = 1 // 現在のページ番号
    private var hasNextPage = true // 次のページが存在するか
    private lateinit var query: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_list)

        val repositoryName = intent.getStringExtra("repositoryName") ?: ""
        val keyword = intent.getStringExtra("keyword") // キーワードを取得

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = repositoryAdapter

        nextPageButton = findViewById(R.id.nextPageButton)
        prevPageButton = findViewById(R.id.prevPageButton)

        loadRepositories(repositoryName, keyword)

        // 次のページボタン
        nextPageButton.setOnClickListener {
            if (hasNextPage) {
                currentPage++
                loadRepositories(repositoryName, keyword)
            } else {
                Toast.makeText(this, "次のページはありません", Toast.LENGTH_SHORT).show()
            }
        }

        // 前のページボタン
        prevPageButton.setOnClickListener {
            if (currentPage > 1) {
                currentPage--
                loadRepositories(repositoryName, keyword)
            } else {
                Toast.makeText(this, "前のページはありません", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadRepositories(repositoryName: String, keyword: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // GitHubApiServiceにリポジトリ名とキーワードを渡して検索
                val (repositories, nextPageAvailable) = GitHubApiService.searchRepositoriesWithKeyword(
                    this@RepositoryListActivity,
                    repositoryName,
                    keyword,
                    currentPage // 現在のページ番号を渡す
                )
                withContext(Dispatchers.Main) {
                    if (repositories.isNotEmpty()) {
                        repositoryAdapter.setRepositories(repositories)
                        hasNextPage = nextPageAvailable
                        updatePagingButtons()
                    } else {
                        Toast.makeText(
                            this@RepositoryListActivity,
                            "該当するリポジトリが見つかりませんでした",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@RepositoryListActivity,
                        "エラー: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun updatePagingButtons() {
        // ボタンの有効/無効を更新
        prevPageButton.isEnabled = currentPage > 1
        nextPageButton.isEnabled = hasNextPage
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


