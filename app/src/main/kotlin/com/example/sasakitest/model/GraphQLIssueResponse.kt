package com.example.sasakitest.model

data class GraphQLIssueResponse(
    val data: RepositoryData
) {
    data class RepositoryData(
        val repository: Repository
    )

    data class Repository(
        val issues: Issues
    )

    data class Issues(
        val pageInfo: PageInfo,
        val edges: List<Edge>
    )

    // 🔹 endCursor を維持（イシューのページネーションに必要）
    data class PageInfo(
        val hasNextPage: Boolean,
        val endCursor: String?
    )

    data class Edge(
        val node: IssueNode
    )

    data class IssueNode(
        val id: String,
        val title: String,
        val body: String?
    )
}