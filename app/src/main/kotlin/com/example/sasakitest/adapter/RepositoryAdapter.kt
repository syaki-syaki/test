package com.example.sasakitest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sasakitest.R
import com.example.sasakitest.model.RepositoryResponse

class RepositoryAdapter(
    private val onClick: (RepositoryResponse.Item) -> Unit
) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    private val repositoryList = mutableListOf<RepositoryResponse.Item>()

    // データのリセットと更新
    fun setRepositories(newRepositories: List<RepositoryResponse.Item>) {
        val diffCallback = RepositoryDiffCallback(repositoryList, newRepositories)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        repositoryList.clear()
        repositoryList.addAll(newRepositories)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repository, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = repositoryList[position]
        holder.bind(repository)
    }

    override fun getItemCount(): Int = repositoryList.size

    // ビューホルダー
    inner class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val repositoryNameTextView: TextView = itemView.findViewById(R.id.repositoryName)
        private val repositoryDescriptionTextView: TextView =
            itemView.findViewById(R.id.repositoryDescription)
        private val repositoryOwnerTextView: TextView = itemView.findViewById(R.id.repositoryOwner)

        fun bind(repository: RepositoryResponse.Item) {
            repositoryNameTextView.text = repository.name
            repositoryDescriptionTextView.text = repository.description
                ?: itemView.context.getString(R.string.no_description)
            repositoryOwnerTextView.text =
                itemView.context.getString(R.string.owner_text, repository.owner.login)

            itemView.setOnClickListener { onClick(repository) }
        }
    }

    // DiffUtil コールバック
    class RepositoryDiffCallback(
        private val oldList: List<RepositoryResponse.Item>,
        private val newList: List<RepositoryResponse.Item>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}
