// このファイルはGitHubのイシュー（課題）をRecyclerViewで表示するためのアダプターを提供します。
// データの差分を検出してリストを効率的に更新します。

package com.example.sasakitest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sasakitest.R
import com.example.sasakitest.model.Issue

class IssueAdapter(
    private val onEdit: (Issue) -> Unit,
    private val onDelete: (Issue) -> Unit
) : RecyclerView.Adapter<IssueAdapter.IssueViewHolder>() {

    private val issueList = mutableListOf<Issue>()

    fun submitList(issues: List<Issue>) {
        val oldSize = issueList.size
        issueList.clear()
        issueList.addAll(issues)

        if (oldSize == 0) {
            notifyItemRangeInserted(0, issues.size) // 初回データセット
        } else if (issues.isEmpty()) {
            notifyItemRangeRemoved(0, oldSize) // 全て削除された場合
        } else {
            notifyDataSetChanged() // 最後の手段として使用
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_issue, parent, false)
        return IssueViewHolder(view)
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        val issue = issueList[position]
        holder.bind(issue)
    }

    override fun getItemCount(): Int = issueList.size

    inner class IssueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val issueTitle: TextView = itemView.findViewById(R.id.issueTitle)
        private val issueBody: TextView = itemView.findViewById(R.id.issueBody)
        private val editButton: Button = itemView.findViewById(R.id.editCommentButton)
        private val deleteButton: Button = itemView.findViewById(R.id.deleteCommentButton)

        fun bind(issue: Issue) {
            issueTitle.text = issue.title
            issueBody.text = issue.body ?: "No description"
            editButton.setOnClickListener { onEdit(issue) }
            deleteButton.setOnClickListener { onDelete(issue) }
        }
    }
}
