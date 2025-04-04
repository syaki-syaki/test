//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.example.sasakitest.graphql

import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.example.sasakitest.graphql.adapter.GetViewerQuery_ResponseAdapter
import com.example.sasakitest.graphql.selections.GetViewerQuerySelections
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

public class GetViewerQuery() : Query<GetViewerQuery.Data> {
  public override fun equals(other: Any?): Boolean = other != null && other::class == this::class

  public override fun hashCode(): Int = this::class.hashCode()

  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    // This operation doesn't have any variable
  }

  public override fun adapter(): Adapter<Data> = GetViewerQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.example.sasakitest.graphql.type.Query.type
  )
  .selections(selections = GetViewerQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(GetViewerQuery_ResponseAdapter.Data::class)
  public data class Data(
    /**
     * The currently authenticated user.
     */
    public val viewer: Viewer,
  ) : Query.Data

  public data class Viewer(
    /**
     * The username used to login.
     */
    public val login: String,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "09407d5f5a2ad04e8163bfb884625c0aa6bf0aa0b1480162766683490db68dd5"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query GetViewer {
     *   viewer {
     *     login
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() = "query GetViewer { viewer { login } }"

    public const val OPERATION_NAME: String = "GetViewer"
  }
}
