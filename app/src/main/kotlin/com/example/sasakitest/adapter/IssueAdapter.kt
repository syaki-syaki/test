// このファイルはGitHubのイシュー（課題）をRecyclerViewで表示するためのアダプターを提供します。
// データの差分を検出してリストを効率的に更新します。

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

// イシュー（課題）を扱うアダプター
class IssueAdapter : ListAdapter<Issue, IssueAdapter.IssueViewHolder>(IssueDiffCallback()) {

    // ViewHolderを作成するメソッド
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        // item_issueレイアウトを膨らませてViewを作成
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_issue, parent, false)
        return IssueViewHolder(view) // 作成したViewをViewHolderに渡す
    }

    // ViewHolderにデータをバインドするメソッド
    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        val issue = getItem(position) // 現在の位置のイシューを取得
        holder.bind(issue) // イシューのデータをViewHolderにバインド
    }

    // 個々のイシューを表示するViewHolder
    class IssueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.issueTitle) // タイトルを表示するTextView
        private val bodyTextView: TextView = itemView.findViewById(R.id.issueBody) // 本文を表示するTextView

        // イシューのデータをUIに設定
        fun bind(issue: Issue) {
            titleTextView.text = issue.title // イシューのタイトルを設定
            bodyTextView.text = issue.body ?: "No description provided" // 本文を設定（なければデフォルトメッセージ）
        }
    }

    // イシューの差分を計算するためのクラス
    class IssueDiffCallback : DiffUtil.ItemCallback<Issue>() {
        // イシューのIDで同じアイテムかを比較
        override fun areItemsTheSame(oldItem: Issue, newItem: Issue): Boolean {
            return oldItem.id == newItem.id
        }

        // イシューの内容が同じかを比較
        override fun areContentsTheSame(oldItem: Issue, newItem: Issue): Boolean {
            return oldItem == newItem
        }
    }
}
