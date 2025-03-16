package com.example.sasakitest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sasakitest.R
import com.example.sasakitest.model.RepositoryResponse

// Adapter クラス（RecyclerView にデータを表示するためのクラス）
class RepositoryAdapter(
    private val onClick: (RepositoryResponse.Item) -> Unit //① onClick 関数を定義
) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() { //② RecyclerView.Adapter を継承

    private val repositoryList = mutableListOf<RepositoryResponse.Item>() //③ データを格納するリストを定義

    // データのリセットと更新
    fun setRepositories(newRepositories: List<RepositoryResponse.Item>) { //④ データを更新する関数を定義
        val diffCallback = RepositoryDiffCallback(repositoryList, newRepositories) //⑤ DiffUtil の比較クラスを利用
        val diffResult = DiffUtil.calculateDiff(diffCallback) //⑥ DiffUtil を使って変更点を計算
        repositoryList.clear()  //③ のリストをクリア //③
        repositoryList.addAll(newRepositories)  //③ のリストに新しいデータを追加 //③
        diffResult.dispatchUpdatesTo(this) //⑥ RecyclerView に変更を通知
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder { //⑦ ViewHolder（アイテムの枠）を作成
        val view = LayoutInflater.from(parent.context) //⑧ LayoutInflater を利用して XML を View に変換
            .inflate(R.layout.item_repository, parent, false) //⑨ item_repository.xml を View にする（外部の XML）
        return RepositoryViewHolder(view) //⑩ 作成した View を RepositoryViewHolder に渡す //⑩
    }




    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) { //⑪ データをセットする関数を定義
        val repository = repositoryList[position] //③ からデータを取得 //③
        holder.bind(repository) //⑫ ViewHolder にデータを渡す //⑫
    }




    override fun getItemCount(): Int = repositoryList.size //⑬ データの個数を取得 //③

    // ビューホルダー（リストの1行ごとにデータを表示するためのクラス）
    inner class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { //⑭ ViewHolder を定義

        private val repositoryNameTextView: TextView = itemView.findViewById(R.id.repositoryName) //⑮ 名前を表示する TextView
        private val repositoryDescriptionTextView: TextView = itemView.findViewById(R.id.repositoryDescription) //⑯ 説明を表示する TextView
        private val repositoryOwnerTextView: TextView = itemView.findViewById(R.id.repositoryOwner) //⑰ 所有者を表示する TextView

        fun bind(repository: RepositoryResponse.Item) { //⑱ データを TextView にセットする関数を定義
            repositoryNameTextView.text = repository.name //⑮ にデータをセット //⑮
            repositoryDescriptionTextView.text = repository.description
                ?: itemView.context.getString(R.string.no_description) //⑯ にデータをセット //⑯
            repositoryOwnerTextView.text =
                itemView.context.getString(R.string.owner_text, repository.owner.login) //⑰ にデータをセット //⑰

            itemView.setOnClickListener { onClick(repository) } //① を実行（クリック時の処理） //①
        }
    }











    // DiffUtil コールバック（リストの変更点を検出するクラス）
    class RepositoryDiffCallback(
        private val oldList: List<RepositoryResponse.Item>, //⑲ 古いリストを保持
        private val newList: List<RepositoryResponse.Item> //⑳ 新しいリストを保持
    ) : DiffUtil.Callback() { //㉑ DiffUtil の Callback クラスを継承

        override fun getOldListSize(): Int = oldList.size //⑲ のサイズを返す //⑲
        override fun getNewListSize(): Int = newList.size //⑳ のサイズを返す //⑳


        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean { //㉒ ID が同じｃかチェック
            return oldList[oldItemPosition].id == newList[newItemPosition].id //⑲,⑳ のリストを比較 //⑲,⑳
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean { //㉓ 内容が同じかチェック
            return oldList[oldItemPosition] == newList[newItemPosition] //⑲,⑳ のリストを比較 //⑲,⑳
        }
    }
}
