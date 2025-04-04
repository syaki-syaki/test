//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.example.sasakitest.graphql.type

import com.apollographql.apollo3.api.CustomScalarType

/**
 * Represents a unique identifier that is Base64 obfuscated. It is often used to refetch an object
 * or as key for a cache. The ID type appears in a JSON response as a String; however, it is not
 * intended to be human-readable. When expected as an input type, any string (such as `"VXNlci0xMA=="`)
 * or integer (such as `4`) input value will be accepted as an ID.
 */
public class GraphQLID {
  public companion object {
    public val type: CustomScalarType = CustomScalarType("ID", "kotlin.String")
  }
}
