//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.example.sasakitest.graphql.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.example.sasakitest.graphql.GetIssuesQuery
import com.example.sasakitest.graphql.type.URI
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object GetIssuesQuery_ResponseAdapter {
  public object Data : Adapter<GetIssuesQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("repository")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetIssuesQuery.Data {
      var _repository: GetIssuesQuery.Repository? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _repository = Repository.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetIssuesQuery.Data(
        repository = _repository
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetIssuesQuery.Data,
    ): Unit {
      writer.name("repository")
      Repository.obj().nullable().toJson(writer, customScalarAdapters, value.repository)
    }
  }

  public object Repository : Adapter<GetIssuesQuery.Repository> {
    public val RESPONSE_NAMES: List<String> = listOf("issues")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetIssuesQuery.Repository {
      var _issues: GetIssuesQuery.Issues? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _issues = Issues.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetIssuesQuery.Repository(
        issues = _issues!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetIssuesQuery.Repository,
    ): Unit {
      writer.name("issues")
      Issues.obj().toJson(writer, customScalarAdapters, value.issues)
    }
  }

  public object Issues : Adapter<GetIssuesQuery.Issues> {
    public val RESPONSE_NAMES: List<String> = listOf("nodes")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetIssuesQuery.Issues {
      var _nodes: List<GetIssuesQuery.Node?>? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _nodes = Node.obj().nullable().list().nullable().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return GetIssuesQuery.Issues(
        nodes = _nodes
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetIssuesQuery.Issues,
    ): Unit {
      writer.name("nodes")
      Node.obj().nullable().list().nullable().toJson(writer, customScalarAdapters, value.nodes)
    }
  }

  public object Node : Adapter<GetIssuesQuery.Node> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "title", "body", "url")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetIssuesQuery.Node {
      var _id: String? = null
      var _title: String? = null
      var _body: String? = null
      var _url: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _title = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _body = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _url = customScalarAdapters.responseAdapterFor<String>(URI.type).fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return GetIssuesQuery.Node(
        id = _id!!,
        title = _title!!,
        body = _body!!,
        url = _url!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetIssuesQuery.Node,
    ): Unit {
      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("title")
      StringAdapter.toJson(writer, customScalarAdapters, value.title)

      writer.name("body")
      StringAdapter.toJson(writer, customScalarAdapters, value.body)

      writer.name("url")
      customScalarAdapters.responseAdapterFor<String>(URI.type).toJson(writer, customScalarAdapters,
          value.url)
    }
  }
}
