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

    val issueList = mutableListOf<Issue>()

    fun submitList(issues: List<Issue>) {
        issueList.clear()
        issueList.addAll(issues)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_issue, parent, false)
        return IssueViewHolder(view)
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        val issue = issueList[position]
        holder.bind(issue) // `isListEmpty` を渡さないシンプルな呼び出しに修正
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

            // ボタンを常に表示する場合
            editButton.visibility = View.VISIBLE
            deleteButton.visibility = View.VISIBLE

            editButton.setOnClickListener { onEdit(issue) }
            deleteButton.setOnClickListener { onDelete(issue) }
        }
    }
}
