//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.example.sasakitest.graphql.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.example.sasakitest.graphql.type.GraphQLString
import com.example.sasakitest.graphql.type.User
import kotlin.collections.List

public object GetViewerQuerySelections {
  private val __viewer: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "login",
          type = GraphQLString.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "viewer",
          type = User.type.notNull()
        ).selections(__viewer)
        .build()
      )
}
