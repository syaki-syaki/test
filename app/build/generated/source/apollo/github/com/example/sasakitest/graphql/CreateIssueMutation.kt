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
import com.apollographql.apollo3.api.Mutation
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.example.sasakitest.graphql.adapter.CreateIssueMutation_ResponseAdapter
import com.example.sasakitest.graphql.adapter.CreateIssueMutation_VariablesAdapter
import com.example.sasakitest.graphql.selections.CreateIssueMutationSelections
import kotlin.String
import kotlin.Unit

public data class CreateIssueMutation(
  public val repositoryId: String,
  public val title: String,
  public val body: Optional<String?> = Optional.Absent,
) : Mutation<CreateIssueMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    CreateIssueMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = CreateIssueMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.example.sasakitest.graphql.type.Mutation.type
  )
  .selections(selections = CreateIssueMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(CreateIssueMutation_ResponseAdapter.Data::class)
  public data class Data(
    /**
     * Creates a new issue.
     */
    public val createIssue: CreateIssue?,
  ) : Mutation.Data

  public data class CreateIssue(
    /**
     * The new issue.
     */
    public val issue: Issue?,
  )

  public data class Issue(
    /**
     * The Node ID of the Issue object
     */
    public val id: String,
    /**
     * Identifies the issue title.
     */
    public val title: String,
    /**
     * Identifies the body of the issue.
     */
    public val body: String,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "c3bd8417b17fc7eaaa58457cf3187c0795560bec5f4273a6d5211ff86db6c493"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation CreateIssue($repositoryId: ID!, $title: String!, $body: String) {
     *   createIssue(input: {
     *     repositoryId: $repositoryId
     *     title: $title
     *     body: $body
     *   }
     *   ) {
     *     issue {
     *       id
     *       title
     *       body
     *     }
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation CreateIssue(${'$'}repositoryId: ID!, ${'$'}title: String!, ${'$'}body: String) { createIssue(input: { repositoryId: ${'$'}repositoryId title: ${'$'}title body: ${'$'}body } ) { issue { id title body } } }"

    public const val OPERATION_NAME: String = "CreateIssue"
  }
}
