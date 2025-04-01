//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.example.sasakitest.graphql.type

import com.apollographql.apollo3.api.ObjectType

/**
 * A user is an individual's account on GitHub that owns repositories and can make new content.
 */
public class User {
  public companion object {
    public val type: ObjectType =
        ObjectType.Builder(name = "User").interfaces(listOf(Actor.type, Node.type, PackageOwner.type, ProfileOwner.type, ProjectOwner.type, ProjectV2Owner.type, ProjectV2Recent.type, RepositoryDiscussionAuthor.type, RepositoryDiscussionCommentAuthor.type, RepositoryOwner.type, Sponsorable.type, UniformResourceLocatable.type)).build()
  }
}
