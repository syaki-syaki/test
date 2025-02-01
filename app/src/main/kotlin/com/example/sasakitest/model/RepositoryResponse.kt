package com.example.sasakitest.model

data class RepositoryResponse(
    val data: SearchData
) {
    data class SearchData(
        val search: SearchResult
    )

    data class SearchResult(
        val pageInfo: PageInfo,
        val edges: List<Edge>
    )

    // 🔹 `endCursor` を追加（リポジトリ検索で必要）
    data class PageInfo(
        val hasNextPage: Boolean,
        val endCursor: String?  // 🔹 これを維持
    )

    data class Edge(
        val node: RepositoryNode
    )

    data class RepositoryNode(
        val id: String,
        val name: String,
        val description: String?,
        val url: String,
        val owner: OwnerNode
    )

    data class OwnerNode(
        val login: String
    )

    data class Item(
        val id: String,
        val name: String,
        val description: String?,
        val htmlUrl: String,
        val owner: Owner
    )

    data class Owner(
        val login: String
    )

    fun toItemList(): List<Item> {
        return data.search.edges.map { edge ->
            Item(
                id = edge.node.id,
                name = edge.node.name,
                description = edge.node.description,
                htmlUrl = edge.node.url,
                owner = Owner(edge.node.owner.login)
            )
        }
    }
}
