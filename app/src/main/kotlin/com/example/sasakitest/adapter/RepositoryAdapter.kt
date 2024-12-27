// このファイルは、GitHubリポジトリのリストをRecyclerViewで表示するためのアダプターを提供します。
// リポジトリのデータと次のページボタンを扱い、動的にリストを更新します。

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
    private val onClick: (RepositoryResponse.Item) -> Unit, // リポジトリがクリックされたときの処理
    private val onNextPageClick: () -> Unit // 次のページボタンがクリックされたときの処理
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_ITEM = 0 // 通常のリポジトリアイテム
        private const val VIEW_TYPE_NEXT_PAGE = 1 // 次のページボタン
    }

    private val repositories = mutableListOf<RepositoryResponse.Item>() // リポジトリのデータリスト



    // リポジトリのリストを新しいリストで置き換える
    fun submitList(newRepositories: List<RepositoryResponse.Item>) {
        val diffCallback = RepositoryDiffCallback(repositories, newRepositories) // リストの差分を計算
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        repositories.clear() // 古いリストをクリア
        repositories.addAll(newRepositories) // 新しいリストを追加
        diffResult.dispatchUpdatesTo(this) // RecyclerViewに変更を通知
    }



    // リポジトリのリストを追加する
    fun addRepositories(newRepositories: List<RepositoryResponse.Item>) {
        val startIndex = repositories.size // 追加前のリストサイズ
        repositories.addAll(newRepositories) // 新しいリストを追加
        notifyItemRangeInserted(startIndex, newRepositories.size) // 変更を通知
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < repositories.size) VIEW_TYPE_ITEM else VIEW_TYPE_NEXT_PAGE // アイテムタイプを判定
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
            RepositoryViewHolder(view, onClick) // 通常アイテムのViewHolderを生成
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_next_page, parent, false)
            NextPageViewHolder(view, onNextPageClick) // 次のページボタンのViewHolderを生成
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RepositoryViewHolder) {
            holder.bind(repositories[position]) // リポジトリデータをViewHolderにバインド
        } else if (holder is NextPageViewHolder) {
            holder.bind() // 次のページボタンのバインド
        }
    }

    override fun getItemCount(): Int {
        return repositories.size + 1 // リポジトリの数 + 次のページボタン
    }

    class RepositoryViewHolder(
        itemView: View,
        private val onClick: (RepositoryResponse.Item) -> Unit // クリック時の処理
    ) : RecyclerView.ViewHolder(itemView) {
        private val repositoryName: TextView = itemView.findViewById(R.id.repositoryName) // リポジトリ名
        private val repositoryDescription: TextView = itemView.findViewById(R.id.repositoryDescription) // リポジトリ説明

        fun bind(repository: RepositoryResponse.Item) {
            repositoryName.text = repository.name // リポジトリ名を設定
            repositoryDescription.text = repository.description ?: "No description available" // 説明を設定
            itemView.setOnClickListener { onClick(repository) } // クリック時の処理を設定
        }
    }

    class NextPageViewHolder(
        itemView: View,
        private val onNextPageClick: () -> Unit // クリック時の処理
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            itemView.setOnClickListener { onNextPageClick() } // 次のページボタンのクリック処理を設定
        }
    }

    class RepositoryDiffCallback(
        private val oldList: List<RepositoryResponse.Item>, // 古いリスト
        private val newList: List<RepositoryResponse.Item> // 新しいリスト
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size // 古いリストのサイズを返す
        override fun getNewListSize() = newList.size // 新しいリストのサイズを返す

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id // IDが同じか判定
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition] // 内容が同じか判定
        }
    }
}
