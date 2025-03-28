package  com.example.sasakitest.graphql

import androidx.compose.foundation.pager.PageInfo


data class Viewer(
    val repositories: RepositoryConnection
)

data class RepositoryConnection(
    val edges: List<RepositoryEdge>,
    val pageInfo: PageInfo
)

data class RepositoryEdge(
    val node: Repository
)
data class SearchRepositories(
    val search: RepositorySearchResult
)

data class RepositorySearchResult(
    val edges: List<RepositoryEdge>,
    val pageInfo: PageInfo

//以上追加code
data class AbortQueuedMigrationsInput(
    val clientMutationId: String? = null,
    val ownerId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["ownerId"] as Any
  )
}



data class AbortRepositoryMigrationInput(
    val clientMutationId: String? = null,
    val migrationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["migrationId"] as Any
  )
}



data class AcceptEnterpriseAdministratorInvitationInput(
    val clientMutationId: String? = null,
    val invitationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["invitationId"] as Any
  )
}



data class AcceptEnterpriseMemberInvitationInput(
    val clientMutationId: String? = null,
    val invitationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["invitationId"] as Any
  )
}



data class AcceptTopicSuggestionInput(
    val clientMutationId: String? = null,
    val name: String? = null,
    val repositoryId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["name"] as String?,
      args["repositoryId"] as Any?
  )
}



data class AccessUserNamespaceRepositoryInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["repositoryId"] as Any
  )
}





/** The actor's type. */
enum class ActorType(val label: String) {
      Team("TEAM"),
      User("USER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ActorType? {
      return values().find { it.label == label }
    }
  }
}

data class AddAssigneesToAssignableInput(
    val assignableId: Any,
    val assigneeIds: Iterable<Any>,
    val clientMutationId: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["assignableId"] as Any,
      args["assigneeIds"] as Iterable<Any>,
      args["clientMutationId"] as String?
  )
}



data class AddCommentInput(
    val body: String,
    val clientMutationId: String? = null,
    val subjectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["clientMutationId"] as String?,
      args["subjectId"] as Any
  )
}



data class AddDiscussionCommentInput(
    val body: String,
    val clientMutationId: String? = null,
    val discussionId: Any,
    val replyToId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["clientMutationId"] as String?,
      args["discussionId"] as Any,
      args["replyToId"] as Any?
  )
}



data class AddDiscussionPollVoteInput(
    val clientMutationId: String? = null,
    val pollOptionId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["pollOptionId"] as Any
  )
}



data class AddEnterpriseOrganizationMemberInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val organizationId: Any,
    val role: OrganizationMemberRole? = null,
    val userIds: Iterable<Any>
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["organizationId"] as Any,
      args["role"] as OrganizationMemberRole?,
      args["userIds"] as Iterable<Any>
  )
}



data class AddEnterpriseSupportEntitlementInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val login: String
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["login"] as String
  )
}



data class AddLabelsToLabelableInput(
    val clientMutationId: String? = null,
    val labelIds: Iterable<Any>,
    val labelableId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["labelIds"] as Iterable<Any>,
      args["labelableId"] as Any
  )
}



data class AddProjectCardInput(
    val clientMutationId: String? = null,
    val contentId: Any? = null,
    val note: String? = null,
    val projectColumnId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["contentId"] as Any?,
      args["note"] as String?,
      args["projectColumnId"] as Any
  )
}



data class AddProjectColumnInput(
    val clientMutationId: String? = null,
    val name: String,
    val projectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["name"] as String,
      args["projectId"] as Any
  )
}



data class AddProjectV2DraftIssueInput(
    val assigneeIds: Iterable<Any>? = null,
    val body: String? = null,
    val clientMutationId: String? = null,
    val projectId: Any,
    val title: String
) {
  constructor(args: Map<String, Any>) : this(
      args["assigneeIds"] as Iterable<Any>?,
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["projectId"] as Any,
      args["title"] as String
  )
}



data class AddProjectV2ItemByIdInput(
    val clientMutationId: String? = null,
    val contentId: Any,
    val projectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["contentId"] as Any,
      args["projectId"] as Any
  )
}



data class AddPullRequestReviewCommentInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val commitOID: any? = null,
    val inReplyTo: Any? = null,
    val path: String? = null,
    val position: Int? = null,
    val pullRequestId: Any? = null,
    val pullRequestReviewId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["commitOID"] as any?,
      args["inReplyTo"] as Any?,
      args["path"] as String?,
      args["position"] as Int?,
      args["pullRequestId"] as Any?,
      args["pullRequestReviewId"] as Any?
  )
}



data class AddPullRequestReviewInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val comments: Iterable<DraftPullRequestReviewCommentInput>? = null,
    val commitOID: any? = null,
    val event: PullRequestReviewEvent? = null,
    val pullRequestId: Any,
    val threads: Iterable<DraftPullRequestReviewThreadInput>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["comments"]?.let { comments -> (comments as List<Map<String, Any>>).map { DraftPullRequestReviewCommentInput(it) } },
      args["commitOID"] as any?,
      args["event"] as PullRequestReviewEvent?,
      args["pullRequestId"] as Any,
      args["threads"]?.let { threads -> (threads as List<Map<String, Any>>).map { DraftPullRequestReviewThreadInput(it) } }
  )
}



data class AddPullRequestReviewThreadInput(
    val body: String,
    val clientMutationId: String? = null,
    val line: Int? = null,
    val path: String,
    val pullRequestId: Any? = null,
    val pullRequestReviewId: Any? = null,
    val side: DiffSide? = DiffSide.RIGHT,
    val startLine: Int? = null,
    val startSide: DiffSide? = DiffSide.RIGHT,
    val subjectType: PullRequestReviewThreadSubjectType? = PullRequestReviewThreadSubjectType.LINE
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["clientMutationId"] as String?,
      args["line"] as Int?,
      args["path"] as String,
      args["pullRequestId"] as Any?,
      args["pullRequestReviewId"] as Any?,
      args["side"] as DiffSide? ?: DiffSide.RIGHT,
      args["startLine"] as Int?,
      args["startSide"] as DiffSide? ?: DiffSide.RIGHT,
      args["subjectType"] as PullRequestReviewThreadSubjectType? ?: PullRequestReviewThreadSubjectType.LINE
  )
}



data class AddPullRequestReviewThreadReplyInput(
    val body: String,
    val clientMutationId: String? = null,
    val pullRequestReviewId: Any? = null,
    val pullRequestReviewThreadId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["clientMutationId"] as String?,
      args["pullRequestReviewId"] as Any?,
      args["pullRequestReviewThreadId"] as Any
  )
}



data class AddReactionInput(
    val clientMutationId: String? = null,
    val content: ReactionContent,
    val subjectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["content"] as ReactionContent,
      args["subjectId"] as Any
  )
}



data class AddStarInput(
    val clientMutationId: String? = null,
    val starrableId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["starrableId"] as Any
  )
}



data class AddSubIssueInput(
    val clientMutationId: String? = null,
    val issueId: Any,
    val replaceParent: Boolean? = null,
    val subIssueId: Any? = null,
    val subIssueUrl: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["issueId"] as Any,
      args["replaceParent"] as Boolean?,
      args["subIssueId"] as Any?,
      args["subIssueUrl"] as String?
  )
}



data class AddUpvoteInput(
    val clientMutationId: String? = null,
    val subjectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["subjectId"] as Any
  )
}



data class AddVerifiableDomainInput(
    val clientMutationId: String? = null,
    val domain: any,
    val ownerId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["domain"] as any,
      args["ownerId"] as Any
  )
}









data class AppIpAllowListEntriesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: IpAllowListEntryOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { IpAllowListEntryOrderInput(it as Map<String, Any>) }
  )
}
data class AppLogoUrlArgs(
    val size: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["size"] as Int?
  )
}

data class ApproveDeploymentsInput(
    val clientMutationId: String? = null,
    val comment: String? = """""".trimIndent(),
    val environmentIds: Iterable<Any>,
    val workflowRunId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["comment"] as String? ?: """""".trimIndent(),
      args["environmentIds"] as Iterable<Any>,
      args["workflowRunId"] as Any
  )
}



data class ApproveVerifiableDomainInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class ArchiveProjectV2ItemInput(
    val clientMutationId: String? = null,
    val itemId: Any,
    val projectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["itemId"] as Any,
      args["projectId"] as Any
  )
}



data class ArchiveRepositoryInput(
    val clientMutationId: String? = null,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["repositoryId"] as Any
  )
}





data class AuditLogOrderInput(
    val direction: OrderDirection? = null,
    val field: AuditLogOrderField? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection?,
      args["field"] as AuditLogOrderField?
  )
}

/** Properties by which Audit Log connections can be ordered. */
enum class AuditLogOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): AuditLogOrderField? {
      return values().find { it.label == label }
    }
  }
}



























data class BotAvatarUrlArgs(
    val size: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["size"] as Int?
  )
}



data class BranchNamePatternParametersInput(
    val name: String? = null,
    val negate: Boolean? = null,
    val operator: String,
    val pattern: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String?,
      args["negate"] as Boolean?,
      args["operator"] as String,
      args["pattern"] as String
  )
}

data class BranchProtectionRuleBranchProtectionRuleConflictsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class BranchProtectionRuleBypassForcePushAllowancesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class BranchProtectionRuleBypassPullRequestAllowancesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class BranchProtectionRuleMatchingRefsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val query: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["query"] as String?
  )
}
data class BranchProtectionRulePushAllowancesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class BranchProtectionRuleReviewDismissalAllowancesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}











data class BulkSponsorshipInput(
    val amount: Int,
    val sponsorableId: Any? = null,
    val sponsorableLogin: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["amount"] as Int,
      args["sponsorableId"] as Any?,
      args["sponsorableLogin"] as String?
  )
}





















data class CancelEnterpriseAdminInvitationInput(
    val clientMutationId: String? = null,
    val invitationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["invitationId"] as Any
  )
}



data class CancelEnterpriseMemberInvitationInput(
    val clientMutationId: String? = null,
    val invitationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["invitationId"] as Any
  )
}



data class CancelSponsorshipInput(
    val clientMutationId: String? = null,
    val sponsorId: Any? = null,
    val sponsorLogin: String? = null,
    val sponsorableId: Any? = null,
    val sponsorableLogin: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["sponsorId"] as Any?,
      args["sponsorLogin"] as String?,
      args["sponsorableId"] as Any?,
      args["sponsorableLogin"] as String?
  )
}



data class ChangeUserStatusInput(
    val clientMutationId: String? = null,
    val emoji: String? = null,
    val expiresAt: any? = null,
    val limitedAvailability: Boolean? = false,
    val message: String? = null,
    val organizationId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["emoji"] as String?,
      args["expiresAt"] as any?,
      args["limitedAvailability"] as Boolean? ?: false,
      args["message"] as String?,
      args["organizationId"] as Any?
  )
}







data class CheckAnnotationDataInput(
    val annotationLevel: CheckAnnotationLevel,
    val location: CheckAnnotationRangeInput,
    val message: String,
    val path: String,
    val rawDetails: String? = null,
    val title: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["annotationLevel"] as CheckAnnotationLevel,
      CheckAnnotationRangeInput(args["location"] as Map<String, Any>),
      args["message"] as String,
      args["path"] as String,
      args["rawDetails"] as String?,
      args["title"] as String?
  )
}



/** Represents an annotation's information level. */
enum class CheckAnnotationLevel(val label: String) {
      Failure("FAILURE"),
      Notice("NOTICE"),
      Warning("WARNING");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): CheckAnnotationLevel? {
      return values().find { it.label == label }
    }
  }
}



data class CheckAnnotationRangeInput(
    val endColumn: Int? = null,
    val endLine: Int,
    val startColumn: Int? = null,
    val startLine: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["endColumn"] as Int?,
      args["endLine"] as Int,
      args["startColumn"] as Int?,
      args["startLine"] as Int
  )
}



/** The possible states for a check suite or run conclusion. */
enum class CheckConclusionState(val label: String) {
      ActionRequired("ACTION_REQUIRED"),
      Cancelled("CANCELLED"),
      Failure("FAILURE"),
      Neutral("NEUTRAL"),
      Skipped("SKIPPED"),
      Stale("STALE"),
      StartupFailure("STARTUP_FAILURE"),
      Success("SUCCESS"),
      TimedOut("TIMED_OUT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): CheckConclusionState? {
      return values().find { it.label == label }
    }
  }
}

data class CheckRunAnnotationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class CheckRunIsRequiredArgs(
    val pullRequestId: Any? = null,
    val pullRequestNumber: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["pullRequestId"] as Any?,
      args["pullRequestNumber"] as Int?
  )
}
data class CheckRunStepsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val number: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["number"] as Int?
  )
}

data class CheckRunActionInput(
    val description: String,
    val identifier: String,
    val label: String
) {
  constructor(args: Map<String, Any>) : this(
      args["description"] as String,
      args["identifier"] as String,
      args["label"] as String
  )
}





data class CheckRunFilterInput(
    val appId: Int? = null,
    val checkName: String? = null,
    val checkType: CheckRunType? = null,
    val conclusions: Iterable<CheckConclusionState>? = null,
    val status: CheckStatusState? = null,
    val statuses: Iterable<CheckStatusState>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["appId"] as Int?,
      args["checkName"] as String?,
      args["checkType"] as CheckRunType?,
      args["conclusions"] as Iterable<CheckConclusionState>?,
      args["status"] as CheckStatusState?,
      args["statuses"] as Iterable<CheckStatusState>?
  )
}

data class CheckRunOutputInput(
    val annotations: Iterable<CheckAnnotationDataInput>? = null,
    val images: Iterable<CheckRunOutputImageInput>? = null,
    val summary: String,
    val text: String? = null,
    val title: String
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["annotations"]?.let { annotations -> (annotations as List<Map<String, Any>>).map { CheckAnnotationDataInput(it) } },
      args["images"]?.let { images -> (images as List<Map<String, Any>>).map { CheckRunOutputImageInput(it) } },
      args["summary"] as String,
      args["text"] as String?,
      args["title"] as String
  )
}

data class CheckRunOutputImageInput(
    val alt: String,
    val caption: String? = null,
    val imageUrl: any
) {
  constructor(args: Map<String, Any>) : this(
      args["alt"] as String,
      args["caption"] as String?,
      args["imageUrl"] as any
  )
}

/** The possible states of a check run in a status rollup. */
enum class CheckRunState(val label: String) {
      ActionRequired("ACTION_REQUIRED"),
      Cancelled("CANCELLED"),
      Completed("COMPLETED"),
      Failure("FAILURE"),
      InProgress("IN_PROGRESS"),
      Neutral("NEUTRAL"),
      Pending("PENDING"),
      Queued("QUEUED"),
      Skipped("SKIPPED"),
      Stale("STALE"),
      StartupFailure("STARTUP_FAILURE"),
      Success("SUCCESS"),
      TimedOut("TIMED_OUT"),
      Waiting("WAITING");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): CheckRunState? {
      return values().find { it.label == label }
    }
  }
}



/** The possible types of check runs. */
enum class CheckRunType(val label: String) {
      All("ALL"),
      Latest("LATEST");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): CheckRunType? {
      return values().find { it.label == label }
    }
  }
}

/** The possible states for a check suite or run status. */
enum class CheckStatusState(val label: String) {
      Completed("COMPLETED"),
      InProgress("IN_PROGRESS"),
      Pending("PENDING"),
      Queued("QUEUED"),
      Requested("REQUESTED"),
      Waiting("WAITING");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): CheckStatusState? {
      return values().find { it.label == label }
    }
  }
}







data class CheckSuiteCheckRunsArgs(
    val after: String? = null,
    val before: String? = null,
    val filterBy: CheckRunFilterInput? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["filterBy"]?.let { CheckRunFilterInput(it as Map<String, Any>) },
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class CheckSuiteMatchingPullRequestsArgs(
    val after: String? = null,
    val baseRefName: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val headRefName: String? = null,
    val labels: Iterable<String>? = null,
    val last: Int? = null,
    val orderBy: IssueOrderInput? = null,
    val states: Iterable<PullRequestState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["baseRefName"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["headRefName"] as String?,
      args["labels"] as Iterable<String>?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueOrderInput(it as Map<String, Any>) },
      args["states"] as Iterable<PullRequestState>?
  )
}

data class CheckSuiteAutoTriggerPreferenceInput(
    val appId: Any,
    val setting: Boolean
) {
  constructor(args: Map<String, Any>) : this(
      args["appId"] as Any,
      args["setting"] as Boolean
  )
}





data class CheckSuiteFilterInput(
    val appId: Int? = null,
    val checkName: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["appId"] as Int?,
      args["checkName"] as String?
  )
}

data class ClearLabelsFromLabelableInput(
    val clientMutationId: String? = null,
    val labelableId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["labelableId"] as Any
  )
}



data class ClearProjectV2ItemFieldValueInput(
    val clientMutationId: String? = null,
    val fieldId: Any,
    val itemId: Any,
    val projectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["fieldId"] as Any,
      args["itemId"] as Any,
      args["projectId"] as Any
  )
}



data class CloneProjectInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val includeWorkflows: Boolean,
    val name: String,
    val public: Boolean? = null,
    val sourceId: Any,
    val targetOwnerId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["includeWorkflows"] as Boolean,
      args["name"] as String,
      args["public"] as Boolean?,
      args["sourceId"] as Any,
      args["targetOwnerId"] as Any
  )
}



data class CloneTemplateRepositoryInput(
    val clientMutationId: String? = null,
    val description: String? = null,
    val includeAllBranches: Boolean? = false,
    val name: String,
    val ownerId: Any,
    val repositoryId: Any,
    val visibility: RepositoryVisibility
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["description"] as String?,
      args["includeAllBranches"] as Boolean? ?: false,
      args["name"] as String,
      args["ownerId"] as Any,
      args["repositoryId"] as Any,
      args["visibility"] as RepositoryVisibility
  )
}



data class CloseDiscussionInput(
    val clientMutationId: String? = null,
    val discussionId: Any,
    val reason: DiscussionCloseReason? = DiscussionCloseReason.RESOLVED
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["discussionId"] as Any,
      args["reason"] as DiscussionCloseReason? ?: DiscussionCloseReason.RESOLVED
  )
}



data class CloseIssueInput(
    val clientMutationId: String? = null,
    val duplicateIssueId: Any? = null,
    val issueId: Any,
    val stateReason: IssueClosedStateReason? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["duplicateIssueId"] as Any?,
      args["issueId"] as Any,
      args["stateReason"] as IssueClosedStateReason?
  )
}



data class ClosePullRequestInput(
    val clientMutationId: String? = null,
    val pullRequestId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["pullRequestId"] as Any
  )
}









data class CodeScanningParametersInput(
    val codeScanningTools: Iterable<CodeScanningToolInput>
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["codeScanningTools"]!!.let { codeScanningTools -> (codeScanningTools as List<Map<String, Any>>).map { CodeScanningToolInput(it) } }
  )
}



data class CodeScanningToolInput(
    val alertsThreshold: String,
    val securityAlertsThreshold: String,
    val tool: String
) {
  constructor(args: Map<String, Any>) : this(
      args["alertsThreshold"] as String,
      args["securityAlertsThreshold"] as String,
      args["tool"] as String
  )
}

/** Collaborators affiliation level with a subject. */
enum class CollaboratorAffiliation(val label: String) {
      All("ALL"),
      Direct("DIRECT"),
      Outside("OUTSIDE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): CollaboratorAffiliation? {
      return values().find { it.label == label }
    }
  }
}

/** A comment author association with repository. */
enum class CommentAuthorAssociation(val label: String) {
      Collaborator("COLLABORATOR"),
      Contributor("CONTRIBUTOR"),
      FirstTimer("FIRST_TIMER"),
      FirstTimeContributor("FIRST_TIME_CONTRIBUTOR"),
      Mannequin("MANNEQUIN"),
      Member("MEMBER"),
      None("NONE"),
      Owner("OWNER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): CommentAuthorAssociation? {
      return values().find { it.label == label }
    }
  }
}

/** The possible errors that will prevent a user from updating a comment. */
enum class CommentCannotUpdateReason(val label: String) {
      Archived("ARCHIVED"),
      Denied("DENIED"),
      InsufficientAccess("INSUFFICIENT_ACCESS"),
      Locked("LOCKED"),
      LoginRequired("LOGIN_REQUIRED"),
      Maintenance("MAINTENANCE"),
      VerifiedEmailRequired("VERIFIED_EMAIL_REQUIRED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): CommentCannotUpdateReason? {
      return values().find { it.label == label }
    }
  }
}



data class CommitAssociatedPullRequestsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: PullRequestOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { PullRequestOrderInput(it as Map<String, Any>) }
  )
}
data class CommitAuthorsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class CommitBlameArgs(
    val path: String
) {
  constructor(args: Map<String, Any>) : this(
      args["path"] as String
  )
}
data class CommitCheckSuitesArgs(
    val after: String? = null,
    val before: String? = null,
    val filterBy: CheckSuiteFilterInput? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["filterBy"]?.let { CheckSuiteFilterInput(it as Map<String, Any>) },
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class CommitCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class CommitDeploymentsArgs(
    val after: String? = null,
    val before: String? = null,
    val environments: Iterable<String>? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: DeploymentOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["environments"] as Iterable<String>?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { DeploymentOrderInput(it as Map<String, Any>) }
  )
}
data class CommitFileArgs(
    val path: String
) {
  constructor(args: Map<String, Any>) : this(
      args["path"] as String
  )
}
data class CommitHistoryArgs(
    val after: String? = null,
    val author: CommitAuthorInput? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val path: String? = null,
    val since: any? = null,
    val until: any? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["author"]?.let { CommitAuthorInput(it as Map<String, Any>) },
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["path"] as String?,
      args["since"] as any?,
      args["until"] as any?
  )
}
data class CommitParentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class CommitSubmodulesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

data class CommitAuthorInput(
    val emails: Iterable<String>? = null,
    val id: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["emails"] as Iterable<String>?,
      args["id"] as Any?
  )
}



data class CommitAuthorEmailPatternParametersInput(
    val name: String? = null,
    val negate: Boolean? = null,
    val operator: String,
    val pattern: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String?,
      args["negate"] as Boolean?,
      args["operator"] as String,
      args["pattern"] as String
  )
}

data class CommitCommentReactionsArgs(
    val after: String? = null,
    val before: String? = null,
    val content: ReactionContent? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReactionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["content"] as ReactionContent?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReactionOrderInput(it as Map<String, Any>) }
  )
}
data class CommitCommentUserContentEditsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





data class CommitCommentThreadCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}



data class CommitContributionOrderInput(
    val direction: OrderDirection,
    val field: CommitContributionOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as CommitContributionOrderField
  )
}

/** Properties by which commit contribution connections can be ordered. */
enum class CommitContributionOrderField(val label: String) {
      CommitCount("COMMIT_COUNT"),
      OccurredAt("OCCURRED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): CommitContributionOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class CommitContributionsByRepositoryContributionsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: CommitContributionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { CommitContributionOrderInput(it as Map<String, Any>) }
  )
}





data class CommitMessageInput(
    val body: String? = null,
    val headline: String
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["headline"] as String
  )
}



data class CommitMessagePatternParametersInput(
    val name: String? = null,
    val negate: Boolean? = null,
    val operator: String,
    val pattern: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String?,
      args["negate"] as Boolean?,
      args["operator"] as String,
      args["pattern"] as String
  )
}

data class CommittableBranchInput(
    val branchName: String? = null,
    val id: Any? = null,
    val repositoryNameWithOwner: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["branchName"] as String?,
      args["id"] as Any?,
      args["repositoryNameWithOwner"] as String?
  )
}



data class CommitterEmailPatternParametersInput(
    val name: String? = null,
    val negate: Boolean? = null,
    val operator: String,
    val pattern: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String?,
      args["negate"] as Boolean?,
      args["operator"] as String,
      args["pattern"] as String
  )
}

data class ComparisonCommitsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}



/** The status of a git comparison between two refs. */
enum class ComparisonStatus(val label: String) {
      Ahead("AHEAD"),
      Behind("BEHIND"),
      Diverged("DIVERGED"),
      Identical("IDENTICAL");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ComparisonStatus? {
      return values().find { it.label == label }
    }
  }
}













/** Varying levels of contributions from none to many. */
enum class ContributionLevel(val label: String) {
      FirstQuartile("FIRST_QUARTILE"),
      FourthQuartile("FOURTH_QUARTILE"),
      None("NONE"),
      SecondQuartile("SECOND_QUARTILE"),
      ThirdQuartile("THIRD_QUARTILE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ContributionLevel? {
      return values().find { it.label == label }
    }
  }
}

data class ContributionOrderInput(
    val direction: OrderDirection
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection
  )
}

data class ContributionsCollectionCommitContributionsByRepositoryArgs(
    val maxRepositories: Int? = 25
) {
  constructor(args: Map<String, Any>) : this(
      args["maxRepositories"] as Int? ?: 25
  )
}
data class ContributionsCollectionIssueContributionsArgs(
    val after: String? = null,
    val before: String? = null,
    val excludeFirst: Boolean? = false,
    val excludePopular: Boolean? = false,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ContributionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["excludeFirst"] as Boolean? ?: false,
      args["excludePopular"] as Boolean? ?: false,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ContributionOrderInput(it as Map<String, Any>) }
  )
}
data class ContributionsCollectionIssueContributionsByRepositoryArgs(
    val excludeFirst: Boolean? = false,
    val excludePopular: Boolean? = false,
    val maxRepositories: Int? = 25
) {
  constructor(args: Map<String, Any>) : this(
      args["excludeFirst"] as Boolean? ?: false,
      args["excludePopular"] as Boolean? ?: false,
      args["maxRepositories"] as Int? ?: 25
  )
}
data class ContributionsCollectionPullRequestContributionsArgs(
    val after: String? = null,
    val before: String? = null,
    val excludeFirst: Boolean? = false,
    val excludePopular: Boolean? = false,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ContributionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["excludeFirst"] as Boolean? ?: false,
      args["excludePopular"] as Boolean? ?: false,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ContributionOrderInput(it as Map<String, Any>) }
  )
}
data class ContributionsCollectionPullRequestContributionsByRepositoryArgs(
    val excludeFirst: Boolean? = false,
    val excludePopular: Boolean? = false,
    val maxRepositories: Int? = 25
) {
  constructor(args: Map<String, Any>) : this(
      args["excludeFirst"] as Boolean? ?: false,
      args["excludePopular"] as Boolean? ?: false,
      args["maxRepositories"] as Int? ?: 25
  )
}
data class ContributionsCollectionPullRequestReviewContributionsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ContributionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ContributionOrderInput(it as Map<String, Any>) }
  )
}
data class ContributionsCollectionPullRequestReviewContributionsByRepositoryArgs(
    val maxRepositories: Int? = 25
) {
  constructor(args: Map<String, Any>) : this(
      args["maxRepositories"] as Int? ?: 25
  )
}
data class ContributionsCollectionRepositoryContributionsArgs(
    val after: String? = null,
    val before: String? = null,
    val excludeFirst: Boolean? = false,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ContributionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["excludeFirst"] as Boolean? ?: false,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ContributionOrderInput(it as Map<String, Any>) }
  )
}
data class ContributionsCollectionTotalIssueContributionsArgs(
    val excludeFirst: Boolean? = false,
    val excludePopular: Boolean? = false
) {
  constructor(args: Map<String, Any>) : this(
      args["excludeFirst"] as Boolean? ?: false,
      args["excludePopular"] as Boolean? ?: false
  )
}
data class ContributionsCollectionTotalPullRequestContributionsArgs(
    val excludeFirst: Boolean? = false,
    val excludePopular: Boolean? = false
) {
  constructor(args: Map<String, Any>) : this(
      args["excludeFirst"] as Boolean? ?: false,
      args["excludePopular"] as Boolean? ?: false
  )
}
data class ContributionsCollectionTotalRepositoriesWithContributedIssuesArgs(
    val excludeFirst: Boolean? = false,
    val excludePopular: Boolean? = false
) {
  constructor(args: Map<String, Any>) : this(
      args["excludeFirst"] as Boolean? ?: false,
      args["excludePopular"] as Boolean? ?: false
  )
}
data class ContributionsCollectionTotalRepositoriesWithContributedPullRequestsArgs(
    val excludeFirst: Boolean? = false,
    val excludePopular: Boolean? = false
) {
  constructor(args: Map<String, Any>) : this(
      args["excludeFirst"] as Boolean? ?: false,
      args["excludePopular"] as Boolean? ?: false
  )
}
data class ContributionsCollectionTotalRepositoryContributionsArgs(
    val excludeFirst: Boolean? = false
) {
  constructor(args: Map<String, Any>) : this(
      args["excludeFirst"] as Boolean? ?: false
  )
}

data class ConvertProjectCardNoteToIssueInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val projectCardId: Any,
    val repositoryId: Any,
    val title: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["projectCardId"] as Any,
      args["repositoryId"] as Any,
      args["title"] as String?
  )
}



data class ConvertProjectV2DraftIssueItemToIssueInput(
    val clientMutationId: String? = null,
    val itemId: Any,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["itemId"] as Any,
      args["repositoryId"] as Any
  )
}



data class ConvertPullRequestToDraftInput(
    val clientMutationId: String? = null,
    val pullRequestId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["pullRequestId"] as Any
  )
}











data class CopyProjectV2Input(
    val clientMutationId: String? = null,
    val includeDraftIssues: Boolean? = false,
    val ownerId: Any,
    val projectId: Any,
    val title: String
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["includeDraftIssues"] as Boolean? ?: false,
      args["ownerId"] as Any,
      args["projectId"] as Any,
      args["title"] as String
  )
}



data class CreateAttributionInvitationInput(
    val clientMutationId: String? = null,
    val ownerId: Any,
    val sourceId: Any,
    val targetId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["ownerId"] as Any,
      args["sourceId"] as Any,
      args["targetId"] as Any
  )
}



data class CreateBranchProtectionRuleInput(
    val allowsDeletions: Boolean? = null,
    val allowsForcePushes: Boolean? = null,
    val blocksCreations: Boolean? = null,
    val bypassForcePushActorIds: Iterable<Any>? = null,
    val bypassPullRequestActorIds: Iterable<Any>? = null,
    val clientMutationId: String? = null,
    val dismissesStaleReviews: Boolean? = null,
    val isAdminEnforced: Boolean? = null,
    val lockAllowsFetchAndMerge: Boolean? = null,
    val lockBranch: Boolean? = null,
    val pattern: String,
    val pushActorIds: Iterable<Any>? = null,
    val repositoryId: Any,
    val requireLastPushApproval: Boolean? = null,
    val requiredApprovingReviewCount: Int? = null,
    val requiredDeploymentEnvironments: Iterable<String>? = null,
    val requiredStatusCheckContexts: Iterable<String>? = null,
    val requiredStatusChecks: Iterable<RequiredStatusCheckInput>? = null,
    val requiresApprovingReviews: Boolean? = null,
    val requiresCodeOwnerReviews: Boolean? = null,
    val requiresCommitSignatures: Boolean? = null,
    val requiresConversationResolution: Boolean? = null,
    val requiresDeployments: Boolean? = null,
    val requiresLinearHistory: Boolean? = null,
    val requiresStatusChecks: Boolean? = null,
    val requiresStrictStatusChecks: Boolean? = null,
    val restrictsPushes: Boolean? = null,
    val restrictsReviewDismissals: Boolean? = null,
    val reviewDismissalActorIds: Iterable<Any>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["allowsDeletions"] as Boolean?,
      args["allowsForcePushes"] as Boolean?,
      args["blocksCreations"] as Boolean?,
      args["bypassForcePushActorIds"] as Iterable<Any>?,
      args["bypassPullRequestActorIds"] as Iterable<Any>?,
      args["clientMutationId"] as String?,
      args["dismissesStaleReviews"] as Boolean?,
      args["isAdminEnforced"] as Boolean?,
      args["lockAllowsFetchAndMerge"] as Boolean?,
      args["lockBranch"] as Boolean?,
      args["pattern"] as String,
      args["pushActorIds"] as Iterable<Any>?,
      args["repositoryId"] as Any,
      args["requireLastPushApproval"] as Boolean?,
      args["requiredApprovingReviewCount"] as Int?,
      args["requiredDeploymentEnvironments"] as Iterable<String>?,
      args["requiredStatusCheckContexts"] as Iterable<String>?,
      args["requiredStatusChecks"]?.let { requiredStatusChecks -> (requiredStatusChecks as List<Map<String, Any>>).map { RequiredStatusCheckInput(it) } },
      args["requiresApprovingReviews"] as Boolean?,
      args["requiresCodeOwnerReviews"] as Boolean?,
      args["requiresCommitSignatures"] as Boolean?,
      args["requiresConversationResolution"] as Boolean?,
      args["requiresDeployments"] as Boolean?,
      args["requiresLinearHistory"] as Boolean?,
      args["requiresStatusChecks"] as Boolean?,
      args["requiresStrictStatusChecks"] as Boolean?,
      args["restrictsPushes"] as Boolean?,
      args["restrictsReviewDismissals"] as Boolean?,
      args["reviewDismissalActorIds"] as Iterable<Any>?
  )
}



data class CreateCheckRunInput(
    val actions: Iterable<CheckRunActionInput>? = null,
    val clientMutationId: String? = null,
    val completedAt: any? = null,
    val conclusion: CheckConclusionState? = null,
    val detailsUrl: any? = null,
    val externalId: String? = null,
    val headSha: any,
    val name: String,
    val output: CheckRunOutputInput? = null,
    val repositoryId: Any,
    val startedAt: any? = null,
    val status: RequestableCheckStatusState? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["actions"]?.let { actions -> (actions as List<Map<String, Any>>).map { CheckRunActionInput(it) } },
      args["clientMutationId"] as String?,
      args["completedAt"] as any?,
      args["conclusion"] as CheckConclusionState?,
      args["detailsUrl"] as any?,
      args["externalId"] as String?,
      args["headSha"] as any,
      args["name"] as String,
      args["output"]?.let { CheckRunOutputInput(it as Map<String, Any>) },
      args["repositoryId"] as Any,
      args["startedAt"] as any?,
      args["status"] as RequestableCheckStatusState?
  )
}



data class CreateCheckSuiteInput(
    val clientMutationId: String? = null,
    val headSha: any,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["headSha"] as any,
      args["repositoryId"] as Any
  )
}



data class CreateCommitOnBranchInput(
    val branch: CommittableBranchInput,
    val clientMutationId: String? = null,
    val expectedHeadOid: any,
    val fileChanges: FileChangesInput? = null,
    val message: CommitMessageInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CommittableBranchInput(args["branch"] as Map<String, Any>),
      args["clientMutationId"] as String?,
      args["expectedHeadOid"] as any,
      args["fileChanges"]?.let { FileChangesInput(it as Map<String, Any>) },
      CommitMessageInput(args["message"] as Map<String, Any>)
  )
}



data class CreateDeploymentInput(
    val autoMerge: Boolean? = true,
    val clientMutationId: String? = null,
    val description: String? = """""".trimIndent(),
    val environment: String? = """production""".trimIndent(),
    val payload: String? = """{}""".trimIndent(),
    val refId: Any,
    val repositoryId: Any,
    val requiredContexts: Iterable<String>? = null,
    val task: String? = """deploy""".trimIndent()
) {
  constructor(args: Map<String, Any>) : this(
      args["autoMerge"] as Boolean? ?: true,
      args["clientMutationId"] as String?,
      args["description"] as String? ?: """""".trimIndent(),
      args["environment"] as String? ?: """production""".trimIndent(),
      args["payload"] as String? ?: """{}""".trimIndent(),
      args["refId"] as Any,
      args["repositoryId"] as Any,
      args["requiredContexts"] as Iterable<String>?,
      args["task"] as String? ?: """deploy""".trimIndent()
  )
}



data class CreateDeploymentStatusInput(
    val autoInactive: Boolean? = true,
    val clientMutationId: String? = null,
    val deploymentId: Any,
    val description: String? = """""".trimIndent(),
    val environment: String? = null,
    val environmentUrl: String? = """""".trimIndent(),
    val logUrl: String? = """""".trimIndent(),
    val state: DeploymentStatusState
) {
  constructor(args: Map<String, Any>) : this(
      args["autoInactive"] as Boolean? ?: true,
      args["clientMutationId"] as String?,
      args["deploymentId"] as Any,
      args["description"] as String? ?: """""".trimIndent(),
      args["environment"] as String?,
      args["environmentUrl"] as String? ?: """""".trimIndent(),
      args["logUrl"] as String? ?: """""".trimIndent(),
      args["state"] as DeploymentStatusState
  )
}



data class CreateDiscussionInput(
    val body: String,
    val categoryId: Any,
    val clientMutationId: String? = null,
    val repositoryId: Any,
    val title: String
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["categoryId"] as Any,
      args["clientMutationId"] as String?,
      args["repositoryId"] as Any,
      args["title"] as String
  )
}



data class CreateEnterpriseOrganizationInput(
    val adminLogins: Iterable<String>,
    val billingEmail: String,
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val login: String,
    val profileName: String
) {
  constructor(args: Map<String, Any>) : this(
      args["adminLogins"] as Iterable<String>,
      args["billingEmail"] as String,
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["login"] as String,
      args["profileName"] as String
  )
}



data class CreateEnvironmentInput(
    val clientMutationId: String? = null,
    val name: String,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["name"] as String,
      args["repositoryId"] as Any
  )
}



data class CreateIpAllowListEntryInput(
    val allowListValue: String,
    val clientMutationId: String? = null,
    val isActive: Boolean,
    val name: String? = null,
    val ownerId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["allowListValue"] as String,
      args["clientMutationId"] as String?,
      args["isActive"] as Boolean,
      args["name"] as String?,
      args["ownerId"] as Any
  )
}



data class CreateIssueInput(
    val assigneeIds: Iterable<Any>? = null,
    val body: String? = null,
    val clientMutationId: String? = null,
    val issueTemplate: String? = null,
    val labelIds: Iterable<Any>? = null,
    val milestoneId: Any? = null,
    val parentIssueId: Any? = null,
    val projectIds: Iterable<Any>? = null,
    val repositoryId: Any,
    val title: String
) {
  constructor(args: Map<String, Any>) : this(
      args["assigneeIds"] as Iterable<Any>?,
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["issueTemplate"] as String?,
      args["labelIds"] as Iterable<Any>?,
      args["milestoneId"] as Any?,
      args["parentIssueId"] as Any?,
      args["projectIds"] as Iterable<Any>?,
      args["repositoryId"] as Any,
      args["title"] as String
  )
}



data class CreateLabelInput(
    val clientMutationId: String? = null,
    val color: String,
    val description: String? = null,
    val name: String,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["color"] as String,
      args["description"] as String?,
      args["name"] as String,
      args["repositoryId"] as Any
  )
}



data class CreateLinkedBranchInput(
    val clientMutationId: String? = null,
    val issueId: Any,
    val name: String? = null,
    val oid: any,
    val repositoryId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["issueId"] as Any,
      args["name"] as String?,
      args["oid"] as any,
      args["repositoryId"] as Any?
  )
}



data class CreateMigrationSourceInput(
    val accessToken: String? = null,
    val clientMutationId: String? = null,
    val githubPat: String? = null,
    val name: String,
    val ownerId: Any,
    val type: MigrationSourceType,
    val url: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["accessToken"] as String?,
      args["clientMutationId"] as String?,
      args["githubPat"] as String?,
      args["name"] as String,
      args["ownerId"] as Any,
      args["type"] as MigrationSourceType,
      args["url"] as String?
  )
}



data class CreateProjectInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val name: String,
    val ownerId: Any,
    val repositoryIds: Iterable<Any>? = null,
    val template: ProjectTemplate? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["name"] as String,
      args["ownerId"] as Any,
      args["repositoryIds"] as Iterable<Any>?,
      args["template"] as ProjectTemplate?
  )
}



data class CreateProjectV2FieldInput(
    val clientMutationId: String? = null,
    val dataType: ProjectV2CustomFieldType,
    val iterationConfiguration: ProjectV2IterationFieldConfigurationInput? = null,
    val name: String,
    val projectId: Any,
    val singleSelectOptions: Iterable<ProjectV2SingleSelectFieldOptionInput>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["dataType"] as ProjectV2CustomFieldType,
      args["iterationConfiguration"]?.let { ProjectV2IterationFieldConfigurationInput(it as Map<String, Any>) },
      args["name"] as String,
      args["projectId"] as Any,
      args["singleSelectOptions"]?.let { singleSelectOptions -> (singleSelectOptions as List<Map<String, Any>>).map { ProjectV2SingleSelectFieldOptionInput(it) } }
  )
}



data class CreateProjectV2Input(
    val clientMutationId: String? = null,
    val ownerId: Any,
    val repositoryId: Any? = null,
    val teamId: Any? = null,
    val title: String
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["ownerId"] as Any,
      args["repositoryId"] as Any?,
      args["teamId"] as Any?,
      args["title"] as String
  )
}



data class CreateProjectV2StatusUpdateInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val projectId: Any,
    val startDate: any? = null,
    val status: ProjectV2StatusUpdateStatus? = null,
    val targetDate: any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["projectId"] as Any,
      args["startDate"] as any?,
      args["status"] as ProjectV2StatusUpdateStatus?,
      args["targetDate"] as any?
  )
}



data class CreatePullRequestInput(
    val baseRefName: String,
    val body: String? = null,
    val clientMutationId: String? = null,
    val draft: Boolean? = false,
    val headRefName: String,
    val headRepositoryId: Any? = null,
    val maintainerCanModify: Boolean? = true,
    val repositoryId: Any,
    val title: String
) {
  constructor(args: Map<String, Any>) : this(
      args["baseRefName"] as String,
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["draft"] as Boolean? ?: false,
      args["headRefName"] as String,
      args["headRepositoryId"] as Any?,
      args["maintainerCanModify"] as Boolean? ?: true,
      args["repositoryId"] as Any,
      args["title"] as String
  )
}



data class CreateRefInput(
    val clientMutationId: String? = null,
    val name: String,
    val oid: any,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["name"] as String,
      args["oid"] as any,
      args["repositoryId"] as Any
  )
}



data class CreateRepositoryInput(
    val clientMutationId: String? = null,
    val description: String? = null,
    val hasIssuesEnabled: Boolean? = true,
    val hasWikiEnabled: Boolean? = false,
    val homepageUrl: any? = null,
    val name: String,
    val ownerId: Any? = null,
    val teamId: Any? = null,
    val template: Boolean? = false,
    val visibility: RepositoryVisibility
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["description"] as String?,
      args["hasIssuesEnabled"] as Boolean? ?: true,
      args["hasWikiEnabled"] as Boolean? ?: false,
      args["homepageUrl"] as any?,
      args["name"] as String,
      args["ownerId"] as Any?,
      args["teamId"] as Any?,
      args["template"] as Boolean? ?: false,
      args["visibility"] as RepositoryVisibility
  )
}



data class CreateRepositoryRulesetInput(
    val bypassActors: Iterable<RepositoryRulesetBypassActorInput>? = null,
    val clientMutationId: String? = null,
    val conditions: RepositoryRuleConditionsInput,
    val enforcement: RuleEnforcement,
    val name: String,
    val rules: Iterable<RepositoryRuleInput>? = null,
    val sourceId: Any,
    val target: RepositoryRulesetTarget? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["bypassActors"]?.let { bypassActors -> (bypassActors as List<Map<String, Any>>).map { RepositoryRulesetBypassActorInput(it) } },
      args["clientMutationId"] as String?,
      RepositoryRuleConditionsInput(args["conditions"] as Map<String, Any>),
      args["enforcement"] as RuleEnforcement,
      args["name"] as String,
      args["rules"]?.let { rules -> (rules as List<Map<String, Any>>).map { RepositoryRuleInput(it) } },
      args["sourceId"] as Any,
      args["target"] as RepositoryRulesetTarget?
  )
}



data class CreateSponsorsListingInput(
    val billingCountryOrRegionCode: SponsorsCountryOrRegionCode? = null,
    val clientMutationId: String? = null,
    val contactEmail: String? = null,
    val fiscalHostLogin: String? = null,
    val fiscallyHostedProjectProfileUrl: String? = null,
    val fullDescription: String? = null,
    val residenceCountryOrRegionCode: SponsorsCountryOrRegionCode? = null,
    val sponsorableLogin: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["billingCountryOrRegionCode"] as SponsorsCountryOrRegionCode?,
      args["clientMutationId"] as String?,
      args["contactEmail"] as String?,
      args["fiscalHostLogin"] as String?,
      args["fiscallyHostedProjectProfileUrl"] as String?,
      args["fullDescription"] as String?,
      args["residenceCountryOrRegionCode"] as SponsorsCountryOrRegionCode?,
      args["sponsorableLogin"] as String?
  )
}



data class CreateSponsorsTierInput(
    val amount: Int,
    val clientMutationId: String? = null,
    val description: String,
    val isRecurring: Boolean? = true,
    val publish: Boolean? = false,
    val repositoryId: Any? = null,
    val repositoryName: String? = null,
    val repositoryOwnerLogin: String? = null,
    val sponsorableId: Any? = null,
    val sponsorableLogin: String? = null,
    val welcomeMessage: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["amount"] as Int,
      args["clientMutationId"] as String?,
      args["description"] as String,
      args["isRecurring"] as Boolean? ?: true,
      args["publish"] as Boolean? ?: false,
      args["repositoryId"] as Any?,
      args["repositoryName"] as String?,
      args["repositoryOwnerLogin"] as String?,
      args["sponsorableId"] as Any?,
      args["sponsorableLogin"] as String?,
      args["welcomeMessage"] as String?
  )
}



data class CreateSponsorshipInput(
    val amount: Int? = null,
    val clientMutationId: String? = null,
    val isRecurring: Boolean? = null,
    val privacyLevel: SponsorshipPrivacy? = SponsorshipPrivacy.PUBLIC,
    val receiveEmails: Boolean? = true,
    val sponsorId: Any? = null,
    val sponsorLogin: String? = null,
    val sponsorableId: Any? = null,
    val sponsorableLogin: String? = null,
    val tierId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["amount"] as Int?,
      args["clientMutationId"] as String?,
      args["isRecurring"] as Boolean?,
      args["privacyLevel"] as SponsorshipPrivacy? ?: SponsorshipPrivacy.PUBLIC,
      args["receiveEmails"] as Boolean? ?: true,
      args["sponsorId"] as Any?,
      args["sponsorLogin"] as String?,
      args["sponsorableId"] as Any?,
      args["sponsorableLogin"] as String?,
      args["tierId"] as Any?
  )
}



data class CreateSponsorshipsInput(
    val clientMutationId: String? = null,
    val privacyLevel: SponsorshipPrivacy? = SponsorshipPrivacy.PUBLIC,
    val receiveEmails: Boolean? = false,
    val recurring: Boolean? = false,
    val sponsorLogin: String,
    val sponsorships: Iterable<BulkSponsorshipInput>
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["privacyLevel"] as SponsorshipPrivacy? ?: SponsorshipPrivacy.PUBLIC,
      args["receiveEmails"] as Boolean? ?: false,
      args["recurring"] as Boolean? ?: false,
      args["sponsorLogin"] as String,
      args["sponsorships"]!!.let { sponsorships -> (sponsorships as List<Map<String, Any>>).map { BulkSponsorshipInput(it) } }
  )
}



data class CreateTeamDiscussionCommentInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val discussionId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["discussionId"] as Any?
  )
}



data class CreateTeamDiscussionInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val private: Boolean? = null,
    val teamId: Any? = null,
    val title: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["private"] as Boolean?,
      args["teamId"] as Any?,
      args["title"] as String?
  )
}



data class CreateUserListInput(
    val clientMutationId: String? = null,
    val description: String? = null,
    val isPrivate: Boolean? = false,
    val name: String
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["description"] as String?,
      args["isPrivate"] as Boolean? ?: false,
      args["name"] as String
  )
}





































data class DeclineTopicSuggestionInput(
    val clientMutationId: String? = null,
    val name: String? = null,
    val reason: TopicSuggestionDeclineReason? = null,
    val repositoryId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["name"] as String?,
      args["reason"] as TopicSuggestionDeclineReason?,
      args["repositoryId"] as Any?
  )
}



/** The possible base permissions for repositories. */
enum class DefaultRepositoryPermissionField(val label: String) {
      Admin("ADMIN"),
      None("NONE"),
      Read("READ"),
      Write("WRITE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DefaultRepositoryPermissionField? {
      return values().find { it.label == label }
    }
  }
}

data class DeleteBranchProtectionRuleInput(
    val branchProtectionRuleId: Any,
    val clientMutationId: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["branchProtectionRuleId"] as Any,
      args["clientMutationId"] as String?
  )
}



data class DeleteDeploymentInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class DeleteDiscussionCommentInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class DeleteDiscussionInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class DeleteEnvironmentInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class DeleteIpAllowListEntryInput(
    val clientMutationId: String? = null,
    val ipAllowListEntryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["ipAllowListEntryId"] as Any
  )
}



data class DeleteIssueCommentInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class DeleteIssueInput(
    val clientMutationId: String? = null,
    val issueId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["issueId"] as Any
  )
}



data class DeleteLabelInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class DeleteLinkedBranchInput(
    val clientMutationId: String? = null,
    val linkedBranchId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["linkedBranchId"] as Any
  )
}



data class DeletePackageVersionInput(
    val clientMutationId: String? = null,
    val packageVersionId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["packageVersionId"] as Any
  )
}



data class DeleteProjectCardInput(
    val cardId: Any,
    val clientMutationId: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["cardId"] as Any,
      args["clientMutationId"] as String?
  )
}



data class DeleteProjectColumnInput(
    val clientMutationId: String? = null,
    val columnId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["columnId"] as Any
  )
}



data class DeleteProjectInput(
    val clientMutationId: String? = null,
    val projectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["projectId"] as Any
  )
}



data class DeleteProjectV2FieldInput(
    val clientMutationId: String? = null,
    val fieldId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["fieldId"] as Any
  )
}



data class DeleteProjectV2Input(
    val clientMutationId: String? = null,
    val projectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["projectId"] as Any
  )
}

data class DeleteProjectV2ItemInput(
    val clientMutationId: String? = null,
    val itemId: Any,
    val projectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["itemId"] as Any,
      args["projectId"] as Any
  )
}





data class DeleteProjectV2StatusUpdateInput(
    val clientMutationId: String? = null,
    val statusUpdateId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["statusUpdateId"] as Any
  )
}



data class DeleteProjectV2WorkflowInput(
    val clientMutationId: String? = null,
    val workflowId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["workflowId"] as Any
  )
}



data class DeletePullRequestReviewCommentInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class DeletePullRequestReviewInput(
    val clientMutationId: String? = null,
    val pullRequestReviewId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["pullRequestReviewId"] as Any
  )
}



data class DeleteRefInput(
    val clientMutationId: String? = null,
    val refId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["refId"] as Any
  )
}



data class DeleteRepositoryRulesetInput(
    val clientMutationId: String? = null,
    val repositoryRulesetId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["repositoryRulesetId"] as Any
  )
}



data class DeleteTeamDiscussionCommentInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class DeleteTeamDiscussionInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class DeleteUserListInput(
    val clientMutationId: String? = null,
    val listId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["listId"] as Any
  )
}



data class DeleteVerifiableDomainInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}















/** The possible ecosystems of a dependency graph package. */
enum class DependencyGraphEcosystem(val label: String) {
      Actions("ACTIONS"),
      Composer("COMPOSER"),
      Go("GO"),
      Maven("MAVEN"),
      Npm("NPM"),
      Nuget("NUGET"),
      Pip("PIP"),
      Pub("PUB"),
      Rubygems("RUBYGEMS"),
      Rust("RUST"),
      Swift("SWIFT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DependencyGraphEcosystem? {
      return values().find { it.label == label }
    }
  }
}

data class DependencyGraphManifestDependenciesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}













data class DeploymentStatusesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}







data class DeploymentOrderInput(
    val direction: OrderDirection,
    val field: DeploymentOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as DeploymentOrderField
  )
}

/** Properties by which deployment connections can be ordered. */
enum class DeploymentOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DeploymentOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class DeploymentProtectionRuleReviewersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





/** The possible protection rule types. */
enum class DeploymentProtectionRuleType(val label: String) {
      BranchPolicy("BRANCH_POLICY"),
      RequiredReviewers("REQUIRED_REVIEWERS"),
      WaitTimer("WAIT_TIMER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DeploymentProtectionRuleType? {
      return values().find { it.label == label }
    }
  }
}

data class DeploymentRequestReviewersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





data class DeploymentReviewEnvironmentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





/** The possible states for a deployment review. */
enum class DeploymentReviewState(val label: String) {
      Approved("APPROVED"),
      Rejected("REJECTED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DeploymentReviewState? {
      return values().find { it.label == label }
    }
  }
}





/** The possible states in which a deployment can be. */
enum class DeploymentState(val label: String) {
      Abandoned("ABANDONED"),
      Active("ACTIVE"),
      Destroyed("DESTROYED"),
      Error("ERROR"),
      Failure("FAILURE"),
      Inactive("INACTIVE"),
      InProgress("IN_PROGRESS"),
      Pending("PENDING"),
      Queued("QUEUED"),
      Success("SUCCESS"),
      Waiting("WAITING");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DeploymentState? {
      return values().find { it.label == label }
    }
  }
}







/** The possible states for a deployment status. */
enum class DeploymentStatusState(val label: String) {
      Error("ERROR"),
      Failure("FAILURE"),
      Inactive("INACTIVE"),
      InProgress("IN_PROGRESS"),
      Pending("PENDING"),
      Queued("QUEUED"),
      Success("SUCCESS"),
      Waiting("WAITING");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DeploymentStatusState? {
      return values().find { it.label == label }
    }
  }
}

data class DequeuePullRequestInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



/** The possible sides of a diff. */
enum class DiffSide(val label: String) {
      Left("LEFT"),
      Right("RIGHT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DiffSide? {
      return values().find { it.label == label }
    }
  }
}

data class DisablePullRequestAutoMergeInput(
    val clientMutationId: String? = null,
    val pullRequestId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["pullRequestId"] as Any
  )
}





data class DiscussionCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class DiscussionLabelsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: LabelOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { LabelOrderInput(it as Map<String, Any>) }
  )
}
data class DiscussionReactionsArgs(
    val after: String? = null,
    val before: String? = null,
    val content: ReactionContent? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReactionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["content"] as ReactionContent?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReactionOrderInput(it as Map<String, Any>) }
  )
}
data class DiscussionUserContentEditsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}







/** The possible reasons for closing a discussion. */
enum class DiscussionCloseReason(val label: String) {
      Duplicate("DUPLICATE"),
      Outdated("OUTDATED"),
      Resolved("RESOLVED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DiscussionCloseReason? {
      return values().find { it.label == label }
    }
  }
}

data class DiscussionCommentReactionsArgs(
    val after: String? = null,
    val before: String? = null,
    val content: ReactionContent? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReactionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["content"] as ReactionContent?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReactionOrderInput(it as Map<String, Any>) }
  )
}
data class DiscussionCommentRepliesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class DiscussionCommentUserContentEditsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}









data class DiscussionOrderInput(
    val direction: OrderDirection,
    val field: DiscussionOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as DiscussionOrderField
  )
}

/** Properties by which discussion connections can be ordered. */
enum class DiscussionOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DiscussionOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class DiscussionPollOptionsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: DiscussionPollOptionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { DiscussionPollOptionOrderInput(it as Map<String, Any>) }
  )
}







data class DiscussionPollOptionOrderInput(
    val direction: OrderDirection,
    val field: DiscussionPollOptionOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as DiscussionPollOptionOrderField
  )
}

/** Properties by which discussion poll option connections can be ordered. */
enum class DiscussionPollOptionOrderField(val label: String) {
      AuthoredOrder("AUTHORED_ORDER"),
      VoteCount("VOTE_COUNT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DiscussionPollOptionOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible states of a discussion. */
enum class DiscussionState(val label: String) {
      Closed("CLOSED"),
      Open("OPEN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DiscussionState? {
      return values().find { it.label == label }
    }
  }
}

/** The possible state reasons of a discussion. */
enum class DiscussionStateReason(val label: String) {
      Duplicate("DUPLICATE"),
      Outdated("OUTDATED"),
      Reopened("REOPENED"),
      Resolved("RESOLVED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DiscussionStateReason? {
      return values().find { it.label == label }
    }
  }
}

data class DismissPullRequestReviewInput(
    val clientMutationId: String? = null,
    val message: String,
    val pullRequestReviewId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["message"] as String,
      args["pullRequestReviewId"] as Any
  )
}



/** The possible reasons that a Dependabot alert was dismissed. */
enum class DismissReason(val label: String) {
      FixStarted("FIX_STARTED"),
      Inaccurate("INACCURATE"),
      NotUsed("NOT_USED"),
      NoBandwidth("NO_BANDWIDTH"),
      TolerableRisk("TOLERABLE_RISK");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): DismissReason? {
      return values().find { it.label == label }
    }
  }
}

data class DismissRepositoryVulnerabilityAlertInput(
    val clientMutationId: String? = null,
    val dismissReason: DismissReason,
    val repositoryVulnerabilityAlertId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["dismissReason"] as DismissReason,
      args["repositoryVulnerabilityAlertId"] as Any
  )
}



data class DraftIssueAssigneesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class DraftIssueProjectV2ItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class DraftIssueProjectsV2Args(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

data class DraftPullRequestReviewCommentInput(
    val body: String,
    val path: String,
    val position: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["path"] as String,
      args["position"] as Int
  )
}

data class DraftPullRequestReviewThreadInput(
    val body: String,
    val line: Int,
    val path: String,
    val side: DiffSide? = DiffSide.RIGHT,
    val startLine: Int? = null,
    val startSide: DiffSide? = DiffSide.RIGHT
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["line"] as Int,
      args["path"] as String,
      args["side"] as DiffSide? ?: DiffSide.RIGHT,
      args["startLine"] as Int?,
      args["startSide"] as DiffSide? ?: DiffSide.RIGHT
  )
}



data class EnablePullRequestAutoMergeInput(
    val authorEmail: String? = null,
    val clientMutationId: String? = null,
    val commitBody: String? = null,
    val commitHeadline: String? = null,
    val expectedHeadOid: any? = null,
    val mergeMethod: PullRequestMergeMethod? = PullRequestMergeMethod.MERGE,
    val pullRequestId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["authorEmail"] as String?,
      args["clientMutationId"] as String?,
      args["commitBody"] as String?,
      args["commitHeadline"] as String?,
      args["expectedHeadOid"] as any?,
      args["mergeMethod"] as PullRequestMergeMethod? ?: PullRequestMergeMethod.MERGE,
      args["pullRequestId"] as Any
  )
}



data class EnqueuePullRequestInput(
    val clientMutationId: String? = null,
    val expectedHeadOid: any? = null,
    val jump: Boolean? = null,
    val pullRequestId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["expectedHeadOid"] as any?,
      args["jump"] as Boolean?,
      args["pullRequestId"] as Any
  )
}



data class EnterpriseAvatarUrlArgs(
    val size: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["size"] as Int?
  )
}
data class EnterpriseMembersArgs(
    val after: String? = null,
    val before: String? = null,
    val deployment: EnterpriseUserDeployment? = null,
    val first: Int? = null,
    val hasTwoFactorEnabled: Boolean? = null,
    val last: Int? = null,
    val orderBy: EnterpriseMemberOrderInput? = null,
    val organizationLogins: Iterable<String>? = null,
    val query: String? = null,
    val role: EnterpriseUserAccountMembershipRole? = null,
    val twoFactorMethodSecurity: TwoFactorCredentialSecurityType? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["deployment"] as EnterpriseUserDeployment?,
      args["first"] as Int?,
      args["hasTwoFactorEnabled"] as Boolean?,
      args["last"] as Int?,
      args["orderBy"]?.let { EnterpriseMemberOrderInput(it as Map<String, Any>) },
      args["organizationLogins"] as Iterable<String>?,
      args["query"] as String?,
      args["role"] as EnterpriseUserAccountMembershipRole?,
      args["twoFactorMethodSecurity"] as TwoFactorCredentialSecurityType?
  )
}
data class EnterpriseOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val query: String? = null,
    val viewerOrganizationRole: RoleInOrganization? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["query"] as String?,
      args["viewerOrganizationRole"] as RoleInOrganization?
  )
}
data class EnterpriseRulesetArgs(
    val databaseId: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["databaseId"] as Int
  )
}
data class EnterpriseRulesetsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class EnterpriseUserNamespaceRepositoriesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: RepositoryOrderInput? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryOrderInput(it as Map<String, Any>) },
      args["query"] as String?
  )
}











data class EnterpriseAdministratorInvitationOrderInput(
    val direction: OrderDirection,
    val field: EnterpriseAdministratorInvitationOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as EnterpriseAdministratorInvitationOrderField
  )
}

/** Properties by which enterprise administrator invitation connections can be ordered. */
enum class EnterpriseAdministratorInvitationOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseAdministratorInvitationOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible administrator roles in an enterprise account. */
enum class EnterpriseAdministratorRole(val label: String) {
      BillingManager("BILLING_MANAGER"),
      Owner("OWNER"),
      Unaffiliated("UNAFFILIATED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseAdministratorRole? {
      return values().find { it.label == label }
    }
  }
}

/** The possible values for the enterprise allow private repository forking policy value. */
enum class EnterpriseAllowPrivateRepositoryForkingPolicyValue(val label: String) {
      EnterpriseOrganizations("ENTERPRISE_ORGANIZATIONS"),
      EnterpriseOrganizationsUserAccounts("ENTERPRISE_ORGANIZATIONS_USER_ACCOUNTS"),
      Everywhere("EVERYWHERE"),
      SameOrganization("SAME_ORGANIZATION"),
      SameOrganizationUserAccounts("SAME_ORGANIZATION_USER_ACCOUNTS"),
      UserAccounts("USER_ACCOUNTS");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseAllowPrivateRepositoryForkingPolicyValue? {
      return values().find { it.label == label }
    }
  }
}





/** The possible values for the enterprise base repository permission setting. */
enum class EnterpriseDefaultRepositoryPermissionSettingValue(val label: String) {
      Admin("ADMIN"),
      None("NONE"),
      NoPolicy("NO_POLICY"),
      Read("READ"),
      Write("WRITE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseDefaultRepositoryPermissionSettingValue? {
      return values().find { it.label == label }
    }
  }
}

/** The possible values for an enabled/no policy enterprise setting. */
enum class EnterpriseDisallowedMethodsSettingValue(val label: String) {
      Insecure("INSECURE"),
      NoPolicy("NO_POLICY");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseDisallowedMethodsSettingValue? {
      return values().find { it.label == label }
    }
  }
}



/** The possible values for an enabled/disabled enterprise setting. */
enum class EnterpriseEnabledDisabledSettingValue(val label: String) {
      Disabled("DISABLED"),
      Enabled("ENABLED"),
      NoPolicy("NO_POLICY");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseEnabledDisabledSettingValue? {
      return values().find { it.label == label }
    }
  }
}

/** The possible values for an enabled/no policy enterprise setting. */
enum class EnterpriseEnabledSettingValue(val label: String) {
      Enabled("ENABLED"),
      NoPolicy("NO_POLICY");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseEnabledSettingValue? {
      return values().find { it.label == label }
    }
  }
}





data class EnterpriseIdentityProviderExternalIdentitiesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val login: String? = null,
    val membersOnly: Boolean? = null,
    val userName: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["login"] as String?,
      args["membersOnly"] as Boolean?,
      args["userName"] as String?
  )
}











data class EnterpriseMemberInvitationOrderInput(
    val direction: OrderDirection,
    val field: EnterpriseMemberInvitationOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as EnterpriseMemberInvitationOrderField
  )
}

/** Properties by which enterprise member invitation connections can be ordered. */
enum class EnterpriseMemberInvitationOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseMemberInvitationOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class EnterpriseMemberOrderInput(
    val direction: OrderDirection,
    val field: EnterpriseMemberOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as EnterpriseMemberOrderField
  )
}

/** Properties by which enterprise member connections can be ordered. */
enum class EnterpriseMemberOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Login("LOGIN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseMemberOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible values for the enterprise members can create repositories setting. */
enum class EnterpriseMembersCanCreateRepositoriesSettingValue(val label: String) {
      All("ALL"),
      Disabled("DISABLED"),
      NoPolicy("NO_POLICY"),
      Private("PRIVATE"),
      Public("PUBLIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseMembersCanCreateRepositoriesSettingValue? {
      return values().find { it.label == label }
    }
  }
}

/** The possible values for the members can make purchases setting. */
enum class EnterpriseMembersCanMakePurchasesSettingValue(val label: String) {
      Disabled("DISABLED"),
      Enabled("ENABLED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseMembersCanMakePurchasesSettingValue? {
      return values().find { it.label == label }
    }
  }
}

/** The possible values we have for filtering Platform::Objects::User#enterprises. */
enum class EnterpriseMembershipType(val label: String) {
      Admin("ADMIN"),
      All("ALL"),
      BillingManager("BILLING_MANAGER"),
      OrgMembership("ORG_MEMBERSHIP");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseMembershipType? {
      return values().find { it.label == label }
    }
  }
}

data class EnterpriseOrderInput(
    val direction: OrderDirection,
    val field: EnterpriseOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as EnterpriseOrderField
  )
}

/** Properties by which enterprise connections can be ordered. */
enum class EnterpriseOrderField(val label: String) {
      Name("NAME");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseOrderField? {
      return values().find { it.label == label }
    }
  }
}







data class EnterpriseOutsideCollaboratorEdgeRepositoriesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: RepositoryOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryOrderInput(it as Map<String, Any>) }
  )
}

data class EnterpriseOwnerInfoAdminsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val hasTwoFactorEnabled: Boolean? = null,
    val last: Int? = null,
    val orderBy: EnterpriseMemberOrderInput? = null,
    val organizationLogins: Iterable<String>? = null,
    val query: String? = null,
    val role: EnterpriseAdministratorRole? = null,
    val twoFactorMethodSecurity: TwoFactorCredentialSecurityType? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["hasTwoFactorEnabled"] as Boolean?,
      args["last"] as Int?,
      args["orderBy"]?.let { EnterpriseMemberOrderInput(it as Map<String, Any>) },
      args["organizationLogins"] as Iterable<String>?,
      args["query"] as String?,
      args["role"] as EnterpriseAdministratorRole?,
      args["twoFactorMethodSecurity"] as TwoFactorCredentialSecurityType?
  )
}
data class EnterpriseOwnerInfoAffiliatedUsersWithTwoFactorDisabledArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class EnterpriseOwnerInfoAllowPrivateRepositoryForkingSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}
data class EnterpriseOwnerInfoDefaultRepositoryPermissionSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: DefaultRepositoryPermissionField
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as DefaultRepositoryPermissionField
  )
}
data class EnterpriseOwnerInfoDomainsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val isApproved: Boolean? = null,
    val isVerified: Boolean? = null,
    val last: Int? = null,
    val orderBy: VerifiableDomainOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["isApproved"] as Boolean?,
      args["isVerified"] as Boolean?,
      args["last"] as Int?,
      args["orderBy"]?.let { VerifiableDomainOrderInput(it as Map<String, Any>) }
  )
}
data class EnterpriseOwnerInfoEnterpriseServerInstallationsArgs(
    val after: String? = null,
    val before: String? = null,
    val connectedOnly: Boolean? = false,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: EnterpriseServerInstallationOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["connectedOnly"] as Boolean? ?: false,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { EnterpriseServerInstallationOrderInput(it as Map<String, Any>) }
  )
}
data class EnterpriseOwnerInfoFailedInvitationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val query: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["query"] as String?
  )
}
data class EnterpriseOwnerInfoIpAllowListEntriesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: IpAllowListEntryOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { IpAllowListEntryOrderInput(it as Map<String, Any>) }
  )
}
data class EnterpriseOwnerInfoMembersCanChangeRepositoryVisibilitySettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}
data class EnterpriseOwnerInfoMembersCanCreateRepositoriesSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: OrganizationMembersCanCreateRepositoriesSettingValue
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as OrganizationMembersCanCreateRepositoriesSettingValue
  )
}
data class EnterpriseOwnerInfoMembersCanDeleteIssuesSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}
data class EnterpriseOwnerInfoMembersCanDeleteRepositoriesSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}
data class EnterpriseOwnerInfoMembersCanInviteCollaboratorsSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}
data class EnterpriseOwnerInfoMembersCanUpdateProtectedBranchesSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}
data class EnterpriseOwnerInfoMembersCanViewDependencyInsightsSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}
data class EnterpriseOwnerInfoOrganizationProjectsSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}
data class EnterpriseOwnerInfoOutsideCollaboratorsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val hasTwoFactorEnabled: Boolean? = null,
    val last: Int? = null,
    val login: String? = null,
    val orderBy: EnterpriseMemberOrderInput? = null,
    val organizationLogins: Iterable<String>? = null,
    val query: String? = null,
    val twoFactorMethodSecurity: TwoFactorCredentialSecurityType? = null,
    val visibility: RepositoryVisibility? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["hasTwoFactorEnabled"] as Boolean?,
      args["last"] as Int?,
      args["login"] as String?,
      args["orderBy"]?.let { EnterpriseMemberOrderInput(it as Map<String, Any>) },
      args["organizationLogins"] as Iterable<String>?,
      args["query"] as String?,
      args["twoFactorMethodSecurity"] as TwoFactorCredentialSecurityType?,
      args["visibility"] as RepositoryVisibility?
  )
}
data class EnterpriseOwnerInfoPendingAdminInvitationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: EnterpriseAdministratorInvitationOrderInput? = null,
    val query: String? = null,
    val role: EnterpriseAdministratorRole? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { EnterpriseAdministratorInvitationOrderInput(it as Map<String, Any>) },
      args["query"] as String?,
      args["role"] as EnterpriseAdministratorRole?
  )
}
data class EnterpriseOwnerInfoPendingCollaboratorInvitationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: RepositoryInvitationOrderInput? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryInvitationOrderInput(it as Map<String, Any>) },
      args["query"] as String?
  )
}
data class EnterpriseOwnerInfoPendingMemberInvitationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val invitationSource: OrganizationInvitationSource? = null,
    val last: Int? = null,
    val organizationLogins: Iterable<String>? = null,
    val query: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["invitationSource"] as OrganizationInvitationSource?,
      args["last"] as Int?,
      args["organizationLogins"] as Iterable<String>?,
      args["query"] as String?
  )
}
data class EnterpriseOwnerInfoPendingUnaffiliatedMemberInvitationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: EnterpriseMemberInvitationOrderInput? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { EnterpriseMemberInvitationOrderInput(it as Map<String, Any>) },
      args["query"] as String?
  )
}
data class EnterpriseOwnerInfoRepositoryDeployKeySettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}
data class EnterpriseOwnerInfoRepositoryProjectsSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}
data class EnterpriseOwnerInfoSamlIdentityProviderSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: IdentityProviderConfigurationState
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as IdentityProviderConfigurationState
  )
}
data class EnterpriseOwnerInfoSupportEntitlementsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: EnterpriseMemberOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { EnterpriseMemberOrderInput(it as Map<String, Any>) }
  )
}
data class EnterpriseOwnerInfoTeamDiscussionsSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}
data class EnterpriseOwnerInfoTwoFactorRequiredSettingOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val value: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["value"] as Boolean
  )
}











data class EnterpriseServerInstallationUserAccountsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: EnterpriseServerUserAccountOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { EnterpriseServerUserAccountOrderInput(it as Map<String, Any>) }
  )
}
data class EnterpriseServerInstallationUserAccountsUploadsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: EnterpriseServerUserAccountsUploadOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { EnterpriseServerUserAccountsUploadOrderInput(it as Map<String, Any>) }
  )
}









data class EnterpriseServerInstallationOrderInput(
    val direction: OrderDirection,
    val field: EnterpriseServerInstallationOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as EnterpriseServerInstallationOrderField
  )
}

/** Properties by which Enterprise Server installation connections can be ordered. */
enum class EnterpriseServerInstallationOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      CustomerName("CUSTOMER_NAME"),
      HostName("HOST_NAME");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseServerInstallationOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class EnterpriseServerUserAccountEmailsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: EnterpriseServerUserAccountEmailOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { EnterpriseServerUserAccountEmailOrderInput(it as Map<String, Any>) }
  )
}











data class EnterpriseServerUserAccountEmailOrderInput(
    val direction: OrderDirection,
    val field: EnterpriseServerUserAccountEmailOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as EnterpriseServerUserAccountEmailOrderField
  )
}

/** Properties by which Enterprise Server user account email connections can be ordered. */
enum class EnterpriseServerUserAccountEmailOrderField(val label: String) {
      Email("EMAIL");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseServerUserAccountEmailOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class EnterpriseServerUserAccountOrderInput(
    val direction: OrderDirection,
    val field: EnterpriseServerUserAccountOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as EnterpriseServerUserAccountOrderField
  )
}

/** Properties by which Enterprise Server user account connections can be ordered. */
enum class EnterpriseServerUserAccountOrderField(val label: String) {
      Login("LOGIN"),
      RemoteCreatedAt("REMOTE_CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseServerUserAccountOrderField? {
      return values().find { it.label == label }
    }
  }
}







data class EnterpriseServerUserAccountsUploadOrderInput(
    val direction: OrderDirection,
    val field: EnterpriseServerUserAccountsUploadOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as EnterpriseServerUserAccountsUploadOrderField
  )
}

/** Properties by which Enterprise Server user accounts upload connections can be ordered. */
enum class EnterpriseServerUserAccountsUploadOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseServerUserAccountsUploadOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** Synchronization state of the Enterprise Server user accounts upload */
enum class EnterpriseServerUserAccountsUploadSyncState(val label: String) {
      Failure("FAILURE"),
      Pending("PENDING"),
      Success("SUCCESS");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseServerUserAccountsUploadSyncState? {
      return values().find { it.label == label }
    }
  }
}

data class EnterpriseUserAccountAvatarUrlArgs(
    val size: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["size"] as Int?
  )
}
data class EnterpriseUserAccountEnterpriseInstallationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: EnterpriseServerInstallationOrderInput? = null,
    val query: String? = null,
    val role: EnterpriseUserAccountMembershipRole? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { EnterpriseServerInstallationOrderInput(it as Map<String, Any>) },
      args["query"] as String?,
      args["role"] as EnterpriseUserAccountMembershipRole?
  )
}
data class EnterpriseUserAccountOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null,
    val query: String? = null,
    val role: EnterpriseUserAccountMembershipRole? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) },
      args["query"] as String?,
      args["role"] as EnterpriseUserAccountMembershipRole?
  )
}

/** The possible roles for enterprise membership. */
enum class EnterpriseUserAccountMembershipRole(val label: String) {
      Member("MEMBER"),
      Owner("OWNER"),
      Unaffiliated("UNAFFILIATED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseUserAccountMembershipRole? {
      return values().find { it.label == label }
    }
  }
}

/** The possible GitHub Enterprise deployments where this user can exist. */
enum class EnterpriseUserDeployment(val label: String) {
      Cloud("CLOUD"),
      Server("SERVER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnterpriseUserDeployment? {
      return values().find { it.label == label }
    }
  }
}

data class EnvironmentProtectionRulesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





/** Properties by which environments connections can be ordered */
enum class EnvironmentOrderField(val label: String) {
      Name("NAME");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnvironmentOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** Properties by which environments connections can be ordered */
enum class EnvironmentPinnedFilterField(val label: String) {
      All("ALL"),
      None("NONE"),
      Only("ONLY");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): EnvironmentPinnedFilterField? {
      return values().find { it.label == label }
    }
  }
}

data class EnvironmentsInput(
    val direction: OrderDirection,
    val field: EnvironmentOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as EnvironmentOrderField
  )
}













data class FileAdditionInput(
    val contents: any,
    val path: String
) {
  constructor(args: Map<String, Any>) : this(
      args["contents"] as any,
      args["path"] as String
  )
}

data class FileChangesInput(
    val additions: Iterable<FileAdditionInput>? = listOf(),
    val deletions: Iterable<FileDeletionInput>? = listOf()
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["additions"]?.let { additions -> (additions as List<Map<String, Any>>).map { FileAdditionInput(it) } } ?: listOf(),
      args["deletions"]?.let { deletions -> (deletions as List<Map<String, Any>>).map { FileDeletionInput(it) } } ?: listOf()
  )
}

data class FileDeletionInput(
    val path: String
) {
  constructor(args: Map<String, Any>) : this(
      args["path"] as String
  )
}



data class FileExtensionRestrictionParametersInput(
    val restrictedFileExtensions: Iterable<String>
) {
  constructor(args: Map<String, Any>) : this(
      args["restrictedFileExtensions"] as Iterable<String>
  )
}



data class FilePathRestrictionParametersInput(
    val restrictedFilePaths: Iterable<String>
) {
  constructor(args: Map<String, Any>) : this(
      args["restrictedFilePaths"] as Iterable<String>
  )
}

/** The possible viewed states of a file . */
enum class FileViewedState(val label: String) {
      Dismissed("DISMISSED"),
      Unviewed("UNVIEWED"),
      Viewed("VIEWED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): FileViewedState? {
      return values().find { it.label == label }
    }
  }
}

data class FollowOrganizationInput(
    val clientMutationId: String? = null,
    val organizationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["organizationId"] as Any
  )
}



data class FollowUserInput(
    val clientMutationId: String? = null,
    val userId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["userId"] as Any
  )
}









/** The possible funding platforms for repository funding links. */
enum class FundingPlatform(val label: String) {
      BuyMeACoffee("BUY_ME_A_COFFEE"),
      CommunityBridge("COMMUNITY_BRIDGE"),
      Custom("CUSTOM"),
      Github("GITHUB"),
      Issuehunt("ISSUEHUNT"),
      KoFi("KO_FI"),
      LfxCrowdfunding("LFX_CROWDFUNDING"),
      Liberapay("LIBERAPAY"),
      OpenCollective("OPEN_COLLECTIVE"),
      Patreon("PATREON"),
      Polar("POLAR"),
      ThanksDev("THANKS_DEV"),
      Tidelift("TIDELIFT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): FundingPlatform? {
      return values().find { it.label == label }
    }
  }
}



data class GistCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class GistFilesArgs(
    val limit: Int? = 10,
    val oid: any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["limit"] as Int? ?: 10,
      args["oid"] as any?
  )
}
data class GistForksArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: GistOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { GistOrderInput(it as Map<String, Any>) }
  )
}
data class GistStargazersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: StarOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { StarOrderInput(it as Map<String, Any>) }
  )
}

data class GistCommentUserContentEditsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}









data class GistFileTextArgs(
    val truncate: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["truncate"] as Int?
  )
}

data class GistOrderInput(
    val direction: OrderDirection,
    val field: GistOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as GistOrderField
  )
}

/** Properties by which gist connections can be ordered. */
enum class GistOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      PushedAt("PUSHED_AT"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): GistOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The privacy of a Gist */
enum class GistPrivacy(val label: String) {
      All("ALL"),
      Public("PUBLIC"),
      Secret("SECRET");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): GistPrivacy? {
      return values().find { it.label == label }
    }
  }
}

data class GitActorAvatarUrlArgs(
    val size: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["size"] as Int?
  )
}







/** The state of a Git signature. */
enum class GitSignatureState(val label: String) {
      BadCert("BAD_CERT"),
      BadEmail("BAD_EMAIL"),
      ExpiredKey("EXPIRED_KEY"),
      GpgverifyError("GPGVERIFY_ERROR"),
      GpgverifyUnavailable("GPGVERIFY_UNAVAILABLE"),
      Invalid("INVALID"),
      MalformedSig("MALFORMED_SIG"),
      NotSigningKey("NOT_SIGNING_KEY"),
      NoUser("NO_USER"),
      OcspError("OCSP_ERROR"),
      OcspPending("OCSP_PENDING"),
      OcspRevoked("OCSP_REVOKED"),
      UnknownKey("UNKNOWN_KEY"),
      UnknownSigType("UNKNOWN_SIG_TYPE"),
      Unsigned("UNSIGNED"),
      UnverifiedEmail("UNVERIFIED_EMAIL"),
      Valid("VALID");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): GitSignatureState? {
      return values().find { it.label == label }
    }
  }
}



data class GrantEnterpriseOrganizationsMigratorRoleInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val login: String
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["login"] as String
  )
}

data class GrantEnterpriseOrganizationsMigratorRolePayloadOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

data class GrantMigratorRoleInput(
    val actor: String,
    val actorType: ActorType,
    val clientMutationId: String? = null,
    val organizationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["actor"] as String,
      args["actorType"] as ActorType,
      args["clientMutationId"] as String?,
      args["organizationId"] as Any
  )
}











/** The possible states in which authentication can be configured with an identity provider. */
enum class IdentityProviderConfigurationState(val label: String) {
      Configured("CONFIGURED"),
      Enforced("ENFORCED"),
      Unconfigured("UNCONFIGURED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): IdentityProviderConfigurationState? {
      return values().find { it.label == label }
    }
  }
}

data class ImportProjectInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val columnImports: Iterable<ProjectColumnImportInput>,
    val name: String,
    val ownerName: String,
    val public: Boolean? = false
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["columnImports"]!!.let { columnImports -> (columnImports as List<Map<String, Any>>).map { ProjectColumnImportInput(it) } },
      args["name"] as String,
      args["ownerName"] as String,
      args["public"] as Boolean? ?: false
  )
}



data class InviteEnterpriseAdminInput(
    val clientMutationId: String? = null,
    val email: String? = null,
    val enterpriseId: Any,
    val invitee: String? = null,
    val role: EnterpriseAdministratorRole? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["email"] as String?,
      args["enterpriseId"] as Any,
      args["invitee"] as String?,
      args["role"] as EnterpriseAdministratorRole?
  )
}



data class InviteEnterpriseMemberInput(
    val clientMutationId: String? = null,
    val email: String? = null,
    val enterpriseId: Any,
    val invitee: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["email"] as String?,
      args["enterpriseId"] as Any,
      args["invitee"] as String?
  )
}



/** The possible values for the IP allow list enabled setting. */
enum class IpAllowListEnabledSettingValue(val label: String) {
      Disabled("DISABLED"),
      Enabled("ENABLED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): IpAllowListEnabledSettingValue? {
      return values().find { it.label == label }
    }
  }
}







data class IpAllowListEntryOrderInput(
    val direction: OrderDirection,
    val field: IpAllowListEntryOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as IpAllowListEntryOrderField
  )
}

/** Properties by which IP allow list entry connections can be ordered. */
enum class IpAllowListEntryOrderField(val label: String) {
      AllowListValue("ALLOW_LIST_VALUE"),
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): IpAllowListEntryOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible values for the IP allow list configuration for installed GitHub Apps setting. */
enum class IpAllowListForInstalledAppsEnabledSettingValue(val label: String) {
      Disabled("DISABLED"),
      Enabled("ENABLED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): IpAllowListForInstalledAppsEnabledSettingValue? {
      return values().find { it.label == label }
    }
  }
}

data class IssueAssigneesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class IssueClosedByPullRequestsReferencesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val includeClosedPrs: Boolean? = false,
    val last: Int? = null,
    val orderByState: Boolean? = false,
    val userLinkedOnly: Boolean? = false
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["includeClosedPrs"] as Boolean? ?: false,
      args["last"] as Int?,
      args["orderByState"] as Boolean? ?: false,
      args["userLinkedOnly"] as Boolean? ?: false
  )
}
data class IssueCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: IssueCommentOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueCommentOrderInput(it as Map<String, Any>) }
  )
}
data class IssueHovercardArgs(
    val includeNotificationContexts: Boolean? = true
) {
  constructor(args: Map<String, Any>) : this(
      args["includeNotificationContexts"] as Boolean? ?: true
  )
}
data class IssueLabelsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: LabelOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { LabelOrderInput(it as Map<String, Any>) }
  )
}
data class IssueLinkedBranchesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class IssueParticipantsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class IssueProjectCardsArgs(
    val after: String? = null,
    val archivedStates: Iterable<ProjectCardArchivedState>? = listOf(Iterable<ProjectCardArchivedState>.ARCHIVED, Iterable<ProjectCardArchivedState>.NOT_ARCHIVED),
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["archivedStates"] as Iterable<ProjectCardArchivedState>? ?: listOf(Iterable<ProjectCardArchivedState>.ARCHIVED, Iterable<ProjectCardArchivedState>.NOT_ARCHIVED),
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class IssueProjectItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val includeArchived: Boolean? = true,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["includeArchived"] as Boolean? ?: true,
      args["last"] as Int?
  )
}
data class IssueProjectV2Args(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class IssueProjectsV2Args(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val minPermissionLevel: ProjectV2PermissionLevel? = ProjectV2PermissionLevel.READ,
    val orderBy: ProjectV2OrderInput? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["minPermissionLevel"] as ProjectV2PermissionLevel? ?: ProjectV2PermissionLevel.READ,
      args["orderBy"]?.let { ProjectV2OrderInput(it as Map<String, Any>) },
      args["query"] as String?
  )
}
data class IssueReactionsArgs(
    val after: String? = null,
    val before: String? = null,
    val content: ReactionContent? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReactionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["content"] as ReactionContent?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReactionOrderInput(it as Map<String, Any>) }
  )
}
data class IssueStateReasonArgs(
    val enableDuplicate: Boolean? = false
) {
  constructor(args: Map<String, Any>) : this(
      args["enableDuplicate"] as Boolean? ?: false
  )
}
data class IssueSubIssuesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class IssueTimelineArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val since: any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["since"] as any?
  )
}
data class IssueTimelineItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val itemTypes: Iterable<IssueTimelineItemsItemType>? = null,
    val last: Int? = null,
    val since: any? = null,
    val skip: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["itemTypes"] as Iterable<IssueTimelineItemsItemType>?,
      args["last"] as Int?,
      args["since"] as any?,
      args["skip"] as Int?
  )
}
data class IssueTrackedInIssuesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class IssueTrackedIssuesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class IssueTrackedIssuesCountArgs(
    val states: Iterable<TrackedIssueStates>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["states"] as Iterable<TrackedIssueStates>?
  )
}
data class IssueUserContentEditsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

/** The possible state reasons of a closed issue. */
enum class IssueClosedStateReason(val label: String) {
      Completed("COMPLETED"),
      Duplicate("DUPLICATE"),
      NotPlanned("NOT_PLANNED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): IssueClosedStateReason? {
      return values().find { it.label == label }
    }
  }
}

data class IssueCommentReactionsArgs(
    val after: String? = null,
    val before: String? = null,
    val content: ReactionContent? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReactionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["content"] as ReactionContent?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReactionOrderInput(it as Map<String, Any>) }
  )
}
data class IssueCommentUserContentEditsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





data class IssueCommentOrderInput(
    val direction: OrderDirection,
    val field: IssueCommentOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as IssueCommentOrderField
  )
}

/** Properties by which issue comment connections can be ordered. */
enum class IssueCommentOrderField(val label: String) {
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): IssueCommentOrderField? {
      return values().find { it.label == label }
    }
  }
}



data class IssueContributionsByRepositoryContributionsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ContributionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ContributionOrderInput(it as Map<String, Any>) }
  )
}



data class IssueFiltersInput(
    val assignee: String? = null,
    val createdBy: String? = null,
    val labels: Iterable<String>? = null,
    val mentioned: String? = null,
    val milestone: String? = null,
    val milestoneNumber: String? = null,
    val since: any? = null,
    val states: Iterable<IssueState>? = null,
    val viewerSubscribed: Boolean? = false
) {
  constructor(args: Map<String, Any>) : this(
      args["assignee"] as String?,
      args["createdBy"] as String?,
      args["labels"] as Iterable<String>?,
      args["mentioned"] as String?,
      args["milestone"] as String?,
      args["milestoneNumber"] as String?,
      args["since"] as any?,
      args["states"] as Iterable<IssueState>?,
      args["viewerSubscribed"] as Boolean? ?: false
  )
}

data class IssueOrderInput(
    val direction: OrderDirection,
    val field: IssueOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as IssueOrderField
  )
}

/** Properties by which issue connections can be ordered. */
enum class IssueOrderField(val label: String) {
      Comments("COMMENTS"),
      CreatedAt("CREATED_AT"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): IssueOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible states of an issue. */
enum class IssueState(val label: String) {
      Closed("CLOSED"),
      Open("OPEN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): IssueState? {
      return values().find { it.label == label }
    }
  }
}

/** The possible state reasons of an issue. */
enum class IssueStateReason(val label: String) {
      Completed("COMPLETED"),
      Duplicate("DUPLICATE"),
      NotPlanned("NOT_PLANNED"),
      Reopened("REOPENED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): IssueStateReason? {
      return values().find { it.label == label }
    }
  }
}

data class IssueTemplateAssigneesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class IssueTemplateLabelsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: LabelOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { LabelOrderInput(it as Map<String, Any>) }
  )
}









/** The possible item types found in a timeline. */
enum class IssueTimelineItemsItemType(val label: String) {
      AddedToProjectEvent("ADDED_TO_PROJECT_EVENT"),
      AssignedEvent("ASSIGNED_EVENT"),
      ClosedEvent("CLOSED_EVENT"),
      CommentDeletedEvent("COMMENT_DELETED_EVENT"),
      ConnectedEvent("CONNECTED_EVENT"),
      ConvertedNoteToIssueEvent("CONVERTED_NOTE_TO_ISSUE_EVENT"),
      ConvertedToDiscussionEvent("CONVERTED_TO_DISCUSSION_EVENT"),
      CrossReferencedEvent("CROSS_REFERENCED_EVENT"),
      DemilestonedEvent("DEMILESTONED_EVENT"),
      DisconnectedEvent("DISCONNECTED_EVENT"),
      IssueComment("ISSUE_COMMENT"),
      LabeledEvent("LABELED_EVENT"),
      LockedEvent("LOCKED_EVENT"),
      MarkedAsDuplicateEvent("MARKED_AS_DUPLICATE_EVENT"),
      MentionedEvent("MENTIONED_EVENT"),
      MilestonedEvent("MILESTONED_EVENT"),
      MovedColumnsInProjectEvent("MOVED_COLUMNS_IN_PROJECT_EVENT"),
      ParentIssueAddedEvent("PARENT_ISSUE_ADDED_EVENT"),
      ParentIssueRemovedEvent("PARENT_ISSUE_REMOVED_EVENT"),
      PinnedEvent("PINNED_EVENT"),
      ReferencedEvent("REFERENCED_EVENT"),
      RemovedFromProjectEvent("REMOVED_FROM_PROJECT_EVENT"),
      RenamedTitleEvent("RENAMED_TITLE_EVENT"),
      ReopenedEvent("REOPENED_EVENT"),
      SubscribedEvent("SUBSCRIBED_EVENT"),
      SubIssueAddedEvent("SUB_ISSUE_ADDED_EVENT"),
      SubIssueRemovedEvent("SUB_ISSUE_REMOVED_EVENT"),
      TransferredEvent("TRANSFERRED_EVENT"),
      UnassignedEvent("UNASSIGNED_EVENT"),
      UnlabeledEvent("UNLABELED_EVENT"),
      UnlockedEvent("UNLOCKED_EVENT"),
      UnmarkedAsDuplicateEvent("UNMARKED_AS_DUPLICATE_EVENT"),
      UnpinnedEvent("UNPINNED_EVENT"),
      UnsubscribedEvent("UNSUBSCRIBED_EVENT"),
      UserBlockedEvent("USER_BLOCKED_EVENT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): IssueTimelineItemsItemType? {
      return values().find { it.label == label }
    }
  }
}



data class LabelIssuesArgs(
    val after: String? = null,
    val before: String? = null,
    val filterBy: IssueFiltersInput? = null,
    val first: Int? = null,
    val labels: Iterable<String>? = null,
    val last: Int? = null,
    val orderBy: IssueOrderInput? = null,
    val states: Iterable<IssueState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["filterBy"]?.let { IssueFiltersInput(it as Map<String, Any>) },
      args["first"] as Int?,
      args["labels"] as Iterable<String>?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueOrderInput(it as Map<String, Any>) },
      args["states"] as Iterable<IssueState>?
  )
}
data class LabelPullRequestsArgs(
    val after: String? = null,
    val baseRefName: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val headRefName: String? = null,
    val labels: Iterable<String>? = null,
    val last: Int? = null,
    val orderBy: IssueOrderInput? = null,
    val states: Iterable<PullRequestState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["baseRefName"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["headRefName"] as String?,
      args["labels"] as Iterable<String>?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueOrderInput(it as Map<String, Any>) },
      args["states"] as Iterable<PullRequestState>?
  )
}





data class LabelOrderInput(
    val direction: OrderDirection,
    val field: LabelOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as LabelOrderField
  )
}

/** Properties by which label connections can be ordered. */
enum class LabelOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Name("NAME");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): LabelOrderField? {
      return values().find { it.label == label }
    }
  }
}









data class LanguageOrderInput(
    val direction: OrderDirection,
    val field: LanguageOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as LanguageOrderField
  )
}

/** Properties by which language connections can be ordered. */
enum class LanguageOrderField(val label: String) {
      Size("SIZE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): LanguageOrderField? {
      return values().find { it.label == label }
    }
  }
}





data class LinkProjectV2ToRepositoryInput(
    val clientMutationId: String? = null,
    val projectId: Any,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["projectId"] as Any,
      args["repositoryId"] as Any
  )
}



data class LinkProjectV2ToTeamInput(
    val clientMutationId: String? = null,
    val projectId: Any,
    val teamId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["projectId"] as Any,
      args["teamId"] as Any
  )
}



data class LinkRepositoryToProjectInput(
    val clientMutationId: String? = null,
    val projectId: Any,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["projectId"] as Any,
      args["repositoryId"] as Any
  )
}









data class LockLockableInput(
    val clientMutationId: String? = null,
    val lockReason: LockReason? = null,
    val lockableId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["lockReason"] as LockReason?,
      args["lockableId"] as Any
  )
}



/** The possible reasons that an issue or pull request was locked. */
enum class LockReason(val label: String) {
      OffTopic("OFF_TOPIC"),
      Resolved("RESOLVED"),
      Spam("SPAM"),
      TooHeated("TOO_HEATED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): LockReason? {
      return values().find { it.label == label }
    }
  }
}



data class MannequinAvatarUrlArgs(
    val size: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["size"] as Int?
  )
}





data class MannequinOrderInput(
    val direction: OrderDirection,
    val field: MannequinOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as MannequinOrderField
  )
}

/** Properties by which mannequins can be ordered. */
enum class MannequinOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Login("LOGIN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MannequinOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class MarkDiscussionCommentAsAnswerInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class MarkFileAsViewedInput(
    val clientMutationId: String? = null,
    val path: String,
    val pullRequestId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["path"] as String,
      args["pullRequestId"] as Any
  )
}



data class MarkProjectV2AsTemplateInput(
    val clientMutationId: String? = null,
    val projectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["projectId"] as Any
  )
}



data class MarkPullRequestReadyForReviewInput(
    val clientMutationId: String? = null,
    val pullRequestId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["pullRequestId"] as Any
  )
}







data class MarketplaceListingLogoUrlArgs(
    val size: Int? = 400
) {
  constructor(args: Map<String, Any>) : this(
      args["size"] as Int? ?: 400
  )
}







data class MaxFilePathLengthParametersInput(
    val maxFilePathLength: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["maxFilePathLength"] as Int
  )
}



data class MaxFileSizeParametersInput(
    val maxFileSize: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["maxFileSize"] as Int
  )
}











data class MergeBranchInput(
    val authorEmail: String? = null,
    val base: String,
    val clientMutationId: String? = null,
    val commitMessage: String? = null,
    val head: String,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["authorEmail"] as String?,
      args["base"] as String,
      args["clientMutationId"] as String?,
      args["commitMessage"] as String?,
      args["head"] as String,
      args["repositoryId"] as Any
  )
}



/** The possible default commit messages for merges. */
enum class MergeCommitMessage(val label: String) {
      Blank("BLANK"),
      PrBody("PR_BODY"),
      PrTitle("PR_TITLE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MergeCommitMessage? {
      return values().find { it.label == label }
    }
  }
}

/** The possible default commit titles for merges. */
enum class MergeCommitTitle(val label: String) {
      MergeMessage("MERGE_MESSAGE"),
      PrTitle("PR_TITLE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MergeCommitTitle? {
      return values().find { it.label == label }
    }
  }
}

data class MergePullRequestInput(
    val authorEmail: String? = null,
    val clientMutationId: String? = null,
    val commitBody: String? = null,
    val commitHeadline: String? = null,
    val expectedHeadOid: any? = null,
    val mergeMethod: PullRequestMergeMethod? = PullRequestMergeMethod.MERGE,
    val pullRequestId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["authorEmail"] as String?,
      args["clientMutationId"] as String?,
      args["commitBody"] as String?,
      args["commitHeadline"] as String?,
      args["expectedHeadOid"] as any?,
      args["mergeMethod"] as PullRequestMergeMethod? ?: PullRequestMergeMethod.MERGE,
      args["pullRequestId"] as Any
  )
}



data class MergeQueueEntriesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}









/** The possible states for a merge queue entry. */
enum class MergeQueueEntryState(val label: String) {
      AwaitingChecks("AWAITING_CHECKS"),
      Locked("LOCKED"),
      Mergeable("MERGEABLE"),
      Queued("QUEUED"),
      Unmergeable("UNMERGEABLE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MergeQueueEntryState? {
      return values().find { it.label == label }
    }
  }
}

/** When set to ALLGREEN, the merge commit created by merge queue for each PR in the group must pass all required checks to merge. When set to HEADGREEN, only the commit at the head of the merge group, i.e. the commit containing changes from all of the PRs in the group, must pass its required checks to merge. */
enum class MergeQueueGroupingStrategy(val label: String) {
      Allgreen("ALLGREEN"),
      Headgreen("HEADGREEN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MergeQueueGroupingStrategy? {
      return values().find { it.label == label }
    }
  }
}

/** Method to use when merging changes from queued pull requests. */
enum class MergeQueueMergeMethod(val label: String) {
      Merge("MERGE"),
      Rebase("REBASE"),
      Squash("SQUASH");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MergeQueueMergeMethod? {
      return values().find { it.label == label }
    }
  }
}

/** The possible merging strategies for a merge queue. */
enum class MergeQueueMergingStrategy(val label: String) {
      Allgreen("ALLGREEN"),
      Headgreen("HEADGREEN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MergeQueueMergingStrategy? {
      return values().find { it.label == label }
    }
  }
}



data class MergeQueueParametersInput(
    val checkResponseTimeoutMinutes: Int,
    val groupingStrategy: MergeQueueGroupingStrategy,
    val maxEntriesToBuild: Int,
    val maxEntriesToMerge: Int,
    val mergeMethod: MergeQueueMergeMethod,
    val minEntriesToMerge: Int,
    val minEntriesToMergeWaitMinutes: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["checkResponseTimeoutMinutes"] as Int,
      args["groupingStrategy"] as MergeQueueGroupingStrategy,
      args["maxEntriesToBuild"] as Int,
      args["maxEntriesToMerge"] as Int,
      args["mergeMethod"] as MergeQueueMergeMethod,
      args["minEntriesToMerge"] as Int,
      args["minEntriesToMergeWaitMinutes"] as Int
  )
}

/** Detailed status information about a pull request merge. */
enum class MergeStateStatus(val label: String) {
      Behind("BEHIND"),
      Blocked("BLOCKED"),
      Clean("CLEAN"),
      Dirty("DIRTY"),
      Draft("DRAFT"),
      HasHooks("HAS_HOOKS"),
      Unknown("UNKNOWN"),
      Unstable("UNSTABLE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MergeStateStatus? {
      return values().find { it.label == label }
    }
  }
}

/** Whether or not a PullRequest can be merged. */
enum class MergeableState(val label: String) {
      Conflicting("CONFLICTING"),
      Mergeable("MERGEABLE"),
      Unknown("UNKNOWN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MergeableState? {
      return values().find { it.label == label }
    }
  }
}





/** Represents the different GitHub Enterprise Importer (GEI) migration sources. */
enum class MigrationSourceType(val label: String) {
      AzureDevops("AZURE_DEVOPS"),
      BitbucketServer("BITBUCKET_SERVER"),
      GithubArchive("GITHUB_ARCHIVE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MigrationSourceType? {
      return values().find { it.label == label }
    }
  }
}

/** The GitHub Enterprise Importer (GEI) migration state. */
enum class MigrationState(val label: String) {
      Failed("FAILED"),
      FailedValidation("FAILED_VALIDATION"),
      InProgress("IN_PROGRESS"),
      NotStarted("NOT_STARTED"),
      PendingValidation("PENDING_VALIDATION"),
      Queued("QUEUED"),
      Succeeded("SUCCEEDED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MigrationState? {
      return values().find { it.label == label }
    }
  }
}

data class MilestoneIssuesArgs(
    val after: String? = null,
    val before: String? = null,
    val filterBy: IssueFiltersInput? = null,
    val first: Int? = null,
    val labels: Iterable<String>? = null,
    val last: Int? = null,
    val orderBy: IssueOrderInput? = null,
    val states: Iterable<IssueState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["filterBy"]?.let { IssueFiltersInput(it as Map<String, Any>) },
      args["first"] as Int?,
      args["labels"] as Iterable<String>?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueOrderInput(it as Map<String, Any>) },
      args["states"] as Iterable<IssueState>?
  )
}
data class MilestonePullRequestsArgs(
    val after: String? = null,
    val baseRefName: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val headRefName: String? = null,
    val labels: Iterable<String>? = null,
    val last: Int? = null,
    val orderBy: IssueOrderInput? = null,
    val states: Iterable<PullRequestState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["baseRefName"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["headRefName"] as String?,
      args["labels"] as Iterable<String>?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueOrderInput(it as Map<String, Any>) },
      args["states"] as Iterable<PullRequestState>?
  )
}





data class MilestoneOrderInput(
    val direction: OrderDirection,
    val field: MilestoneOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as MilestoneOrderField
  )
}

/** Properties by which milestone connections can be ordered. */
enum class MilestoneOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      DueDate("DUE_DATE"),
      Number("NUMBER"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MilestoneOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible states of a milestone. */
enum class MilestoneState(val label: String) {
      Closed("CLOSED"),
      Open("OPEN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): MilestoneState? {
      return values().find { it.label == label }
    }
  }
}



data class MinimizeCommentInput(
    val classifier: ReportedContentClassifiers,
    val clientMutationId: String? = null,
    val subjectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["classifier"] as ReportedContentClassifiers,
      args["clientMutationId"] as String?,
      args["subjectId"] as Any
  )
}



data class MoveProjectCardInput(
    val afterCardId: Any? = null,
    val cardId: Any,
    val clientMutationId: String? = null,
    val columnId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["afterCardId"] as Any?,
      args["cardId"] as Any,
      args["clientMutationId"] as String?,
      args["columnId"] as Any
  )
}



data class MoveProjectColumnInput(
    val afterColumnId: Any? = null,
    val clientMutationId: String? = null,
    val columnId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["afterColumnId"] as Any?,
      args["clientMutationId"] as String?,
      args["columnId"] as Any
  )
}





data class MutationAbortQueuedMigrationsArgs(
    val input: AbortQueuedMigrationsInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AbortQueuedMigrationsInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAbortRepositoryMigrationArgs(
    val input: AbortRepositoryMigrationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AbortRepositoryMigrationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAcceptEnterpriseAdministratorInvitationArgs(
    val input: AcceptEnterpriseAdministratorInvitationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AcceptEnterpriseAdministratorInvitationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAcceptEnterpriseMemberInvitationArgs(
    val input: AcceptEnterpriseMemberInvitationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AcceptEnterpriseMemberInvitationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAcceptTopicSuggestionArgs(
    val input: AcceptTopicSuggestionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AcceptTopicSuggestionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAccessUserNamespaceRepositoryArgs(
    val input: AccessUserNamespaceRepositoryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AccessUserNamespaceRepositoryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddAssigneesToAssignableArgs(
    val input: AddAssigneesToAssignableInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddAssigneesToAssignableInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddCommentArgs(
    val input: AddCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddDiscussionCommentArgs(
    val input: AddDiscussionCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddDiscussionCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddDiscussionPollVoteArgs(
    val input: AddDiscussionPollVoteInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddDiscussionPollVoteInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddEnterpriseOrganizationMemberArgs(
    val input: AddEnterpriseOrganizationMemberInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddEnterpriseOrganizationMemberInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddEnterpriseSupportEntitlementArgs(
    val input: AddEnterpriseSupportEntitlementInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddEnterpriseSupportEntitlementInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddLabelsToLabelableArgs(
    val input: AddLabelsToLabelableInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddLabelsToLabelableInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddProjectCardArgs(
    val input: AddProjectCardInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddProjectCardInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddProjectColumnArgs(
    val input: AddProjectColumnInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddProjectColumnInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddProjectV2DraftIssueArgs(
    val input: AddProjectV2DraftIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddProjectV2DraftIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddProjectV2ItemByIdArgs(
    val input: AddProjectV2ItemByIdInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddProjectV2ItemByIdInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddPullRequestReviewArgs(
    val input: AddPullRequestReviewInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddPullRequestReviewInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddPullRequestReviewCommentArgs(
    val input: AddPullRequestReviewCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddPullRequestReviewCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddPullRequestReviewThreadArgs(
    val input: AddPullRequestReviewThreadInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddPullRequestReviewThreadInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddPullRequestReviewThreadReplyArgs(
    val input: AddPullRequestReviewThreadReplyInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddPullRequestReviewThreadReplyInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddReactionArgs(
    val input: AddReactionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddReactionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddStarArgs(
    val input: AddStarInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddStarInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddSubIssueArgs(
    val input: AddSubIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddSubIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddUpvoteArgs(
    val input: AddUpvoteInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddUpvoteInput(args["input"] as Map<String, Any>)
  )
}
data class MutationAddVerifiableDomainArgs(
    val input: AddVerifiableDomainInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      AddVerifiableDomainInput(args["input"] as Map<String, Any>)
  )
}
data class MutationApproveDeploymentsArgs(
    val input: ApproveDeploymentsInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ApproveDeploymentsInput(args["input"] as Map<String, Any>)
  )
}
data class MutationApproveVerifiableDomainArgs(
    val input: ApproveVerifiableDomainInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ApproveVerifiableDomainInput(args["input"] as Map<String, Any>)
  )
}
data class MutationArchiveProjectV2ItemArgs(
    val input: ArchiveProjectV2ItemInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ArchiveProjectV2ItemInput(args["input"] as Map<String, Any>)
  )
}
data class MutationArchiveRepositoryArgs(
    val input: ArchiveRepositoryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ArchiveRepositoryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCancelEnterpriseAdminInvitationArgs(
    val input: CancelEnterpriseAdminInvitationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CancelEnterpriseAdminInvitationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCancelEnterpriseMemberInvitationArgs(
    val input: CancelEnterpriseMemberInvitationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CancelEnterpriseMemberInvitationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCancelSponsorshipArgs(
    val input: CancelSponsorshipInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CancelSponsorshipInput(args["input"] as Map<String, Any>)
  )
}
data class MutationChangeUserStatusArgs(
    val input: ChangeUserStatusInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ChangeUserStatusInput(args["input"] as Map<String, Any>)
  )
}
data class MutationClearLabelsFromLabelableArgs(
    val input: ClearLabelsFromLabelableInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ClearLabelsFromLabelableInput(args["input"] as Map<String, Any>)
  )
}
data class MutationClearProjectV2ItemFieldValueArgs(
    val input: ClearProjectV2ItemFieldValueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ClearProjectV2ItemFieldValueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCloneProjectArgs(
    val input: CloneProjectInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CloneProjectInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCloneTemplateRepositoryArgs(
    val input: CloneTemplateRepositoryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CloneTemplateRepositoryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCloseDiscussionArgs(
    val input: CloseDiscussionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CloseDiscussionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCloseIssueArgs(
    val input: CloseIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CloseIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationClosePullRequestArgs(
    val input: ClosePullRequestInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ClosePullRequestInput(args["input"] as Map<String, Any>)
  )
}
data class MutationConvertProjectCardNoteToIssueArgs(
    val input: ConvertProjectCardNoteToIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ConvertProjectCardNoteToIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationConvertProjectV2DraftIssueItemToIssueArgs(
    val input: ConvertProjectV2DraftIssueItemToIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ConvertProjectV2DraftIssueItemToIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationConvertPullRequestToDraftArgs(
    val input: ConvertPullRequestToDraftInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ConvertPullRequestToDraftInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCopyProjectV2Args(
    val input: CopyProjectV2Input
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CopyProjectV2Input(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateAttributionInvitationArgs(
    val input: CreateAttributionInvitationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateAttributionInvitationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateBranchProtectionRuleArgs(
    val input: CreateBranchProtectionRuleInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateBranchProtectionRuleInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateCheckRunArgs(
    val input: CreateCheckRunInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateCheckRunInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateCheckSuiteArgs(
    val input: CreateCheckSuiteInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateCheckSuiteInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateCommitOnBranchArgs(
    val input: CreateCommitOnBranchInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateCommitOnBranchInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateDeploymentArgs(
    val input: CreateDeploymentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateDeploymentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateDeploymentStatusArgs(
    val input: CreateDeploymentStatusInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateDeploymentStatusInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateDiscussionArgs(
    val input: CreateDiscussionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateDiscussionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateEnterpriseOrganizationArgs(
    val input: CreateEnterpriseOrganizationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateEnterpriseOrganizationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateEnvironmentArgs(
    val input: CreateEnvironmentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateEnvironmentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateIpAllowListEntryArgs(
    val input: CreateIpAllowListEntryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateIpAllowListEntryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateIssueArgs(
    val input: CreateIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateLabelArgs(
    val input: CreateLabelInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateLabelInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateLinkedBranchArgs(
    val input: CreateLinkedBranchInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateLinkedBranchInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateMigrationSourceArgs(
    val input: CreateMigrationSourceInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateMigrationSourceInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateProjectArgs(
    val input: CreateProjectInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateProjectInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateProjectV2Args(
    val input: CreateProjectV2Input
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateProjectV2Input(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateProjectV2FieldArgs(
    val input: CreateProjectV2FieldInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateProjectV2FieldInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateProjectV2StatusUpdateArgs(
    val input: CreateProjectV2StatusUpdateInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateProjectV2StatusUpdateInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreatePullRequestArgs(
    val input: CreatePullRequestInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreatePullRequestInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateRefArgs(
    val input: CreateRefInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateRefInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateRepositoryArgs(
    val input: CreateRepositoryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateRepositoryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateRepositoryRulesetArgs(
    val input: CreateRepositoryRulesetInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateRepositoryRulesetInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateSponsorsListingArgs(
    val input: CreateSponsorsListingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateSponsorsListingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateSponsorsTierArgs(
    val input: CreateSponsorsTierInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateSponsorsTierInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateSponsorshipArgs(
    val input: CreateSponsorshipInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateSponsorshipInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateSponsorshipsArgs(
    val input: CreateSponsorshipsInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateSponsorshipsInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateTeamDiscussionArgs(
    val input: CreateTeamDiscussionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateTeamDiscussionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateTeamDiscussionCommentArgs(
    val input: CreateTeamDiscussionCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateTeamDiscussionCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationCreateUserListArgs(
    val input: CreateUserListInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      CreateUserListInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeclineTopicSuggestionArgs(
    val input: DeclineTopicSuggestionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeclineTopicSuggestionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteBranchProtectionRuleArgs(
    val input: DeleteBranchProtectionRuleInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteBranchProtectionRuleInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteDeploymentArgs(
    val input: DeleteDeploymentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteDeploymentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteDiscussionArgs(
    val input: DeleteDiscussionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteDiscussionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteDiscussionCommentArgs(
    val input: DeleteDiscussionCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteDiscussionCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteEnvironmentArgs(
    val input: DeleteEnvironmentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteEnvironmentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteIpAllowListEntryArgs(
    val input: DeleteIpAllowListEntryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteIpAllowListEntryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteIssueArgs(
    val input: DeleteIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteIssueCommentArgs(
    val input: DeleteIssueCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteIssueCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteLabelArgs(
    val input: DeleteLabelInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteLabelInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteLinkedBranchArgs(
    val input: DeleteLinkedBranchInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteLinkedBranchInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeletePackageVersionArgs(
    val input: DeletePackageVersionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeletePackageVersionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteProjectArgs(
    val input: DeleteProjectInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteProjectInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteProjectCardArgs(
    val input: DeleteProjectCardInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteProjectCardInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteProjectColumnArgs(
    val input: DeleteProjectColumnInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteProjectColumnInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteProjectV2Args(
    val input: DeleteProjectV2Input
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteProjectV2Input(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteProjectV2FieldArgs(
    val input: DeleteProjectV2FieldInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteProjectV2FieldInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteProjectV2ItemArgs(
    val input: DeleteProjectV2ItemInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteProjectV2ItemInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteProjectV2StatusUpdateArgs(
    val input: DeleteProjectV2StatusUpdateInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteProjectV2StatusUpdateInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteProjectV2WorkflowArgs(
    val input: DeleteProjectV2WorkflowInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteProjectV2WorkflowInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeletePullRequestReviewArgs(
    val input: DeletePullRequestReviewInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeletePullRequestReviewInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeletePullRequestReviewCommentArgs(
    val input: DeletePullRequestReviewCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeletePullRequestReviewCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteRefArgs(
    val input: DeleteRefInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteRefInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteRepositoryRulesetArgs(
    val input: DeleteRepositoryRulesetInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteRepositoryRulesetInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteTeamDiscussionArgs(
    val input: DeleteTeamDiscussionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteTeamDiscussionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteTeamDiscussionCommentArgs(
    val input: DeleteTeamDiscussionCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteTeamDiscussionCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteUserListArgs(
    val input: DeleteUserListInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteUserListInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDeleteVerifiableDomainArgs(
    val input: DeleteVerifiableDomainInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DeleteVerifiableDomainInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDequeuePullRequestArgs(
    val input: DequeuePullRequestInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DequeuePullRequestInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDisablePullRequestAutoMergeArgs(
    val input: DisablePullRequestAutoMergeInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DisablePullRequestAutoMergeInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDismissPullRequestReviewArgs(
    val input: DismissPullRequestReviewInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DismissPullRequestReviewInput(args["input"] as Map<String, Any>)
  )
}
data class MutationDismissRepositoryVulnerabilityAlertArgs(
    val input: DismissRepositoryVulnerabilityAlertInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      DismissRepositoryVulnerabilityAlertInput(args["input"] as Map<String, Any>)
  )
}
data class MutationEnablePullRequestAutoMergeArgs(
    val input: EnablePullRequestAutoMergeInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      EnablePullRequestAutoMergeInput(args["input"] as Map<String, Any>)
  )
}
data class MutationEnqueuePullRequestArgs(
    val input: EnqueuePullRequestInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      EnqueuePullRequestInput(args["input"] as Map<String, Any>)
  )
}
data class MutationFollowOrganizationArgs(
    val input: FollowOrganizationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      FollowOrganizationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationFollowUserArgs(
    val input: FollowUserInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      FollowUserInput(args["input"] as Map<String, Any>)
  )
}
data class MutationGrantEnterpriseOrganizationsMigratorRoleArgs(
    val input: GrantEnterpriseOrganizationsMigratorRoleInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      GrantEnterpriseOrganizationsMigratorRoleInput(args["input"] as Map<String, Any>)
  )
}
data class MutationGrantMigratorRoleArgs(
    val input: GrantMigratorRoleInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      GrantMigratorRoleInput(args["input"] as Map<String, Any>)
  )
}
data class MutationImportProjectArgs(
    val input: ImportProjectInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ImportProjectInput(args["input"] as Map<String, Any>)
  )
}
data class MutationInviteEnterpriseAdminArgs(
    val input: InviteEnterpriseAdminInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      InviteEnterpriseAdminInput(args["input"] as Map<String, Any>)
  )
}
data class MutationInviteEnterpriseMemberArgs(
    val input: InviteEnterpriseMemberInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      InviteEnterpriseMemberInput(args["input"] as Map<String, Any>)
  )
}
data class MutationLinkProjectV2ToRepositoryArgs(
    val input: LinkProjectV2ToRepositoryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      LinkProjectV2ToRepositoryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationLinkProjectV2ToTeamArgs(
    val input: LinkProjectV2ToTeamInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      LinkProjectV2ToTeamInput(args["input"] as Map<String, Any>)
  )
}
data class MutationLinkRepositoryToProjectArgs(
    val input: LinkRepositoryToProjectInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      LinkRepositoryToProjectInput(args["input"] as Map<String, Any>)
  )
}
data class MutationLockLockableArgs(
    val input: LockLockableInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      LockLockableInput(args["input"] as Map<String, Any>)
  )
}
data class MutationMarkDiscussionCommentAsAnswerArgs(
    val input: MarkDiscussionCommentAsAnswerInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      MarkDiscussionCommentAsAnswerInput(args["input"] as Map<String, Any>)
  )
}
data class MutationMarkFileAsViewedArgs(
    val input: MarkFileAsViewedInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      MarkFileAsViewedInput(args["input"] as Map<String, Any>)
  )
}
data class MutationMarkProjectV2AsTemplateArgs(
    val input: MarkProjectV2AsTemplateInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      MarkProjectV2AsTemplateInput(args["input"] as Map<String, Any>)
  )
}
data class MutationMarkPullRequestReadyForReviewArgs(
    val input: MarkPullRequestReadyForReviewInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      MarkPullRequestReadyForReviewInput(args["input"] as Map<String, Any>)
  )
}
data class MutationMergeBranchArgs(
    val input: MergeBranchInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      MergeBranchInput(args["input"] as Map<String, Any>)
  )
}
data class MutationMergePullRequestArgs(
    val input: MergePullRequestInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      MergePullRequestInput(args["input"] as Map<String, Any>)
  )
}
data class MutationMinimizeCommentArgs(
    val input: MinimizeCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      MinimizeCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationMoveProjectCardArgs(
    val input: MoveProjectCardInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      MoveProjectCardInput(args["input"] as Map<String, Any>)
  )
}
data class MutationMoveProjectColumnArgs(
    val input: MoveProjectColumnInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      MoveProjectColumnInput(args["input"] as Map<String, Any>)
  )
}
data class MutationPinEnvironmentArgs(
    val input: PinEnvironmentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      PinEnvironmentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationPinIssueArgs(
    val input: PinIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      PinIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationPublishSponsorsTierArgs(
    val input: PublishSponsorsTierInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      PublishSponsorsTierInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRegenerateEnterpriseIdentityProviderRecoveryCodesArgs(
    val input: RegenerateEnterpriseIdentityProviderRecoveryCodesInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RegenerateEnterpriseIdentityProviderRecoveryCodesInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRegenerateVerifiableDomainTokenArgs(
    val input: RegenerateVerifiableDomainTokenInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RegenerateVerifiableDomainTokenInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRejectDeploymentsArgs(
    val input: RejectDeploymentsInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RejectDeploymentsInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveAssigneesFromAssignableArgs(
    val input: RemoveAssigneesFromAssignableInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveAssigneesFromAssignableInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveEnterpriseAdminArgs(
    val input: RemoveEnterpriseAdminInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveEnterpriseAdminInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveEnterpriseIdentityProviderArgs(
    val input: RemoveEnterpriseIdentityProviderInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveEnterpriseIdentityProviderInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveEnterpriseMemberArgs(
    val input: RemoveEnterpriseMemberInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveEnterpriseMemberInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveEnterpriseOrganizationArgs(
    val input: RemoveEnterpriseOrganizationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveEnterpriseOrganizationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveEnterpriseSupportEntitlementArgs(
    val input: RemoveEnterpriseSupportEntitlementInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveEnterpriseSupportEntitlementInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveLabelsFromLabelableArgs(
    val input: RemoveLabelsFromLabelableInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveLabelsFromLabelableInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveOutsideCollaboratorArgs(
    val input: RemoveOutsideCollaboratorInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveOutsideCollaboratorInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveReactionArgs(
    val input: RemoveReactionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveReactionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveStarArgs(
    val input: RemoveStarInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveStarInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveSubIssueArgs(
    val input: RemoveSubIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveSubIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRemoveUpvoteArgs(
    val input: RemoveUpvoteInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RemoveUpvoteInput(args["input"] as Map<String, Any>)
  )
}
data class MutationReopenDiscussionArgs(
    val input: ReopenDiscussionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ReopenDiscussionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationReopenIssueArgs(
    val input: ReopenIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ReopenIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationReopenPullRequestArgs(
    val input: ReopenPullRequestInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ReopenPullRequestInput(args["input"] as Map<String, Any>)
  )
}
data class MutationReorderEnvironmentArgs(
    val input: ReorderEnvironmentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ReorderEnvironmentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationReprioritizeSubIssueArgs(
    val input: ReprioritizeSubIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ReprioritizeSubIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRequestReviewsArgs(
    val input: RequestReviewsInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RequestReviewsInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRerequestCheckSuiteArgs(
    val input: RerequestCheckSuiteInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RerequestCheckSuiteInput(args["input"] as Map<String, Any>)
  )
}
data class MutationResolveReviewThreadArgs(
    val input: ResolveReviewThreadInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      ResolveReviewThreadInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRetireSponsorsTierArgs(
    val input: RetireSponsorsTierInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RetireSponsorsTierInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRevertPullRequestArgs(
    val input: RevertPullRequestInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RevertPullRequestInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRevokeEnterpriseOrganizationsMigratorRoleArgs(
    val input: RevokeEnterpriseOrganizationsMigratorRoleInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RevokeEnterpriseOrganizationsMigratorRoleInput(args["input"] as Map<String, Any>)
  )
}
data class MutationRevokeMigratorRoleArgs(
    val input: RevokeMigratorRoleInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      RevokeMigratorRoleInput(args["input"] as Map<String, Any>)
  )
}
data class MutationSetEnterpriseIdentityProviderArgs(
    val input: SetEnterpriseIdentityProviderInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      SetEnterpriseIdentityProviderInput(args["input"] as Map<String, Any>)
  )
}
data class MutationSetOrganizationInteractionLimitArgs(
    val input: SetOrganizationInteractionLimitInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      SetOrganizationInteractionLimitInput(args["input"] as Map<String, Any>)
  )
}
data class MutationSetRepositoryInteractionLimitArgs(
    val input: SetRepositoryInteractionLimitInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      SetRepositoryInteractionLimitInput(args["input"] as Map<String, Any>)
  )
}
data class MutationSetUserInteractionLimitArgs(
    val input: SetUserInteractionLimitInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      SetUserInteractionLimitInput(args["input"] as Map<String, Any>)
  )
}
data class MutationStartOrganizationMigrationArgs(
    val input: StartOrganizationMigrationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      StartOrganizationMigrationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationStartRepositoryMigrationArgs(
    val input: StartRepositoryMigrationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      StartRepositoryMigrationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationSubmitPullRequestReviewArgs(
    val input: SubmitPullRequestReviewInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      SubmitPullRequestReviewInput(args["input"] as Map<String, Any>)
  )
}
data class MutationTransferEnterpriseOrganizationArgs(
    val input: TransferEnterpriseOrganizationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      TransferEnterpriseOrganizationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationTransferIssueArgs(
    val input: TransferIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      TransferIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnarchiveProjectV2ItemArgs(
    val input: UnarchiveProjectV2ItemInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnarchiveProjectV2ItemInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnarchiveRepositoryArgs(
    val input: UnarchiveRepositoryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnarchiveRepositoryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnfollowOrganizationArgs(
    val input: UnfollowOrganizationInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnfollowOrganizationInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnfollowUserArgs(
    val input: UnfollowUserInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnfollowUserInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnlinkProjectV2FromRepositoryArgs(
    val input: UnlinkProjectV2FromRepositoryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnlinkProjectV2FromRepositoryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnlinkProjectV2FromTeamArgs(
    val input: UnlinkProjectV2FromTeamInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnlinkProjectV2FromTeamInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnlinkRepositoryFromProjectArgs(
    val input: UnlinkRepositoryFromProjectInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnlinkRepositoryFromProjectInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnlockLockableArgs(
    val input: UnlockLockableInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnlockLockableInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnmarkDiscussionCommentAsAnswerArgs(
    val input: UnmarkDiscussionCommentAsAnswerInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnmarkDiscussionCommentAsAnswerInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnmarkFileAsViewedArgs(
    val input: UnmarkFileAsViewedInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnmarkFileAsViewedInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnmarkIssueAsDuplicateArgs(
    val input: UnmarkIssueAsDuplicateInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnmarkIssueAsDuplicateInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnmarkProjectV2AsTemplateArgs(
    val input: UnmarkProjectV2AsTemplateInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnmarkProjectV2AsTemplateInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnminimizeCommentArgs(
    val input: UnminimizeCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnminimizeCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnpinIssueArgs(
    val input: UnpinIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnpinIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUnresolveReviewThreadArgs(
    val input: UnresolveReviewThreadInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UnresolveReviewThreadInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateBranchProtectionRuleArgs(
    val input: UpdateBranchProtectionRuleInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateBranchProtectionRuleInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateCheckRunArgs(
    val input: UpdateCheckRunInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateCheckRunInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateCheckSuitePreferencesArgs(
    val input: UpdateCheckSuitePreferencesInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateCheckSuitePreferencesInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateDiscussionArgs(
    val input: UpdateDiscussionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateDiscussionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateDiscussionCommentArgs(
    val input: UpdateDiscussionCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateDiscussionCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseAdministratorRoleArgs(
    val input: UpdateEnterpriseAdministratorRoleInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseAdministratorRoleInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseAllowPrivateRepositoryForkingSettingArgs(
    val input: UpdateEnterpriseAllowPrivateRepositoryForkingSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseAllowPrivateRepositoryForkingSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseDefaultRepositoryPermissionSettingArgs(
    val input: UpdateEnterpriseDefaultRepositoryPermissionSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseDefaultRepositoryPermissionSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseDeployKeySettingArgs(
    val input: UpdateEnterpriseDeployKeySettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseDeployKeySettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingArgs(
    val input: UpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseMembersCanCreateRepositoriesSettingArgs(
    val input: UpdateEnterpriseMembersCanCreateRepositoriesSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseMembersCanCreateRepositoriesSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseMembersCanDeleteIssuesSettingArgs(
    val input: UpdateEnterpriseMembersCanDeleteIssuesSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseMembersCanDeleteIssuesSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseMembersCanDeleteRepositoriesSettingArgs(
    val input: UpdateEnterpriseMembersCanDeleteRepositoriesSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseMembersCanDeleteRepositoriesSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseMembersCanInviteCollaboratorsSettingArgs(
    val input: UpdateEnterpriseMembersCanInviteCollaboratorsSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseMembersCanInviteCollaboratorsSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseMembersCanMakePurchasesSettingArgs(
    val input: UpdateEnterpriseMembersCanMakePurchasesSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseMembersCanMakePurchasesSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseMembersCanUpdateProtectedBranchesSettingArgs(
    val input: UpdateEnterpriseMembersCanUpdateProtectedBranchesSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseMembersCanUpdateProtectedBranchesSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseMembersCanViewDependencyInsightsSettingArgs(
    val input: UpdateEnterpriseMembersCanViewDependencyInsightsSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseMembersCanViewDependencyInsightsSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseOrganizationProjectsSettingArgs(
    val input: UpdateEnterpriseOrganizationProjectsSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseOrganizationProjectsSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseOwnerOrganizationRoleArgs(
    val input: UpdateEnterpriseOwnerOrganizationRoleInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseOwnerOrganizationRoleInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseProfileArgs(
    val input: UpdateEnterpriseProfileInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseProfileInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseRepositoryProjectsSettingArgs(
    val input: UpdateEnterpriseRepositoryProjectsSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseRepositoryProjectsSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseTeamDiscussionsSettingArgs(
    val input: UpdateEnterpriseTeamDiscussionsSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseTeamDiscussionsSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseTwoFactorAuthenticationDisallowedMethodsSettingArgs(
    val input: UpdateEnterpriseTwoFactorAuthenticationDisallowedMethodsSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseTwoFactorAuthenticationDisallowedMethodsSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnterpriseTwoFactorAuthenticationRequiredSettingArgs(
    val input: UpdateEnterpriseTwoFactorAuthenticationRequiredSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnterpriseTwoFactorAuthenticationRequiredSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateEnvironmentArgs(
    val input: UpdateEnvironmentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateEnvironmentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateIpAllowListEnabledSettingArgs(
    val input: UpdateIpAllowListEnabledSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateIpAllowListEnabledSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateIpAllowListEntryArgs(
    val input: UpdateIpAllowListEntryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateIpAllowListEntryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateIpAllowListForInstalledAppsEnabledSettingArgs(
    val input: UpdateIpAllowListForInstalledAppsEnabledSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateIpAllowListForInstalledAppsEnabledSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateIssueArgs(
    val input: UpdateIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateIssueCommentArgs(
    val input: UpdateIssueCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateIssueCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateLabelArgs(
    val input: UpdateLabelInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateLabelInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateNotificationRestrictionSettingArgs(
    val input: UpdateNotificationRestrictionSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateNotificationRestrictionSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateOrganizationAllowPrivateRepositoryForkingSettingArgs(
    val input: UpdateOrganizationAllowPrivateRepositoryForkingSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateOrganizationAllowPrivateRepositoryForkingSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateOrganizationWebCommitSignoffSettingArgs(
    val input: UpdateOrganizationWebCommitSignoffSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateOrganizationWebCommitSignoffSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdatePatreonSponsorabilityArgs(
    val input: UpdatePatreonSponsorabilityInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdatePatreonSponsorabilityInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateProjectArgs(
    val input: UpdateProjectInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateProjectInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateProjectCardArgs(
    val input: UpdateProjectCardInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateProjectCardInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateProjectColumnArgs(
    val input: UpdateProjectColumnInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateProjectColumnInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateProjectV2Args(
    val input: UpdateProjectV2Input
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateProjectV2Input(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateProjectV2CollaboratorsArgs(
    val input: UpdateProjectV2CollaboratorsInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateProjectV2CollaboratorsInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateProjectV2DraftIssueArgs(
    val input: UpdateProjectV2DraftIssueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateProjectV2DraftIssueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateProjectV2FieldArgs(
    val input: UpdateProjectV2FieldInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateProjectV2FieldInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateProjectV2ItemFieldValueArgs(
    val input: UpdateProjectV2ItemFieldValueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateProjectV2ItemFieldValueInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateProjectV2ItemPositionArgs(
    val input: UpdateProjectV2ItemPositionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateProjectV2ItemPositionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateProjectV2StatusUpdateArgs(
    val input: UpdateProjectV2StatusUpdateInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateProjectV2StatusUpdateInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdatePullRequestArgs(
    val input: UpdatePullRequestInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdatePullRequestInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdatePullRequestBranchArgs(
    val input: UpdatePullRequestBranchInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdatePullRequestBranchInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdatePullRequestReviewArgs(
    val input: UpdatePullRequestReviewInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdatePullRequestReviewInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdatePullRequestReviewCommentArgs(
    val input: UpdatePullRequestReviewCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdatePullRequestReviewCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateRefArgs(
    val input: UpdateRefInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateRefInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateRefsArgs(
    val input: UpdateRefsInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateRefsInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateRepositoryArgs(
    val input: UpdateRepositoryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateRepositoryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateRepositoryRulesetArgs(
    val input: UpdateRepositoryRulesetInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateRepositoryRulesetInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateRepositoryWebCommitSignoffSettingArgs(
    val input: UpdateRepositoryWebCommitSignoffSettingInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateRepositoryWebCommitSignoffSettingInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateSponsorshipPreferencesArgs(
    val input: UpdateSponsorshipPreferencesInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateSponsorshipPreferencesInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateSubscriptionArgs(
    val input: UpdateSubscriptionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateSubscriptionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateTeamDiscussionArgs(
    val input: UpdateTeamDiscussionInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateTeamDiscussionInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateTeamDiscussionCommentArgs(
    val input: UpdateTeamDiscussionCommentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateTeamDiscussionCommentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateTeamReviewAssignmentArgs(
    val input: UpdateTeamReviewAssignmentInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateTeamReviewAssignmentInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateTeamsRepositoryArgs(
    val input: UpdateTeamsRepositoryInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateTeamsRepositoryInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateTopicsArgs(
    val input: UpdateTopicsInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateTopicsInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateUserListArgs(
    val input: UpdateUserListInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateUserListInput(args["input"] as Map<String, Any>)
  )
}
data class MutationUpdateUserListsForItemArgs(
    val input: UpdateUserListsForItemInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      UpdateUserListsForItemInput(args["input"] as Map<String, Any>)
  )
}
data class MutationVerifyVerifiableDomainArgs(
    val input: VerifyVerifiableDomainInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      VerifyVerifiableDomainInput(args["input"] as Map<String, Any>)
  )
}

/** The possible values for the notification restriction setting. */
enum class NotificationRestrictionSettingValue(val label: String) {
      Disabled("DISABLED"),
      Enabled("ENABLED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): NotificationRestrictionSettingValue? {
      return values().find { it.label == label }
    }
  }
}

data class OidcProviderExternalIdentitiesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val login: String? = null,
    val membersOnly: Boolean? = null,
    val userName: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["login"] as String?,
      args["membersOnly"] as Boolean?,
      args["userName"] as String?
  )
}

/** The OIDC identity provider type */
enum class OidcProviderType(val label: String) {
      Aad("AAD");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OidcProviderType? {
      return values().find { it.label == label }
    }
  }
}



/** The state of an OAuth application when it was created. */
enum class OauthApplicationCreateAuditEntryState(val label: String) {
      Active("ACTIVE"),
      PendingDeletion("PENDING_DELETION"),
      Suspended("SUSPENDED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OauthApplicationCreateAuditEntryState? {
      return values().find { it.label == label }
    }
  }
}

/** The corresponding operation type for the action */
enum class OperationType(val label: String) {
      Access("ACCESS"),
      Authentication("AUTHENTICATION"),
      Create("CREATE"),
      Modify("MODIFY"),
      Remove("REMOVE"),
      Restore("RESTORE"),
      Transfer("TRANSFER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OperationType? {
      return values().find { it.label == label }
    }
  }
}

/** Possible directions in which to order a list of items when provided an `orderBy` argument. */
enum class OrderDirection(val label: String) {
      Asc("ASC"),
      Desc("DESC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrderDirection? {
      return values().find { it.label == label }
    }
  }
}





/** The permissions available to members on an Organization. */
enum class OrgAddMemberAuditEntryPermission(val label: String) {
      Admin("ADMIN"),
      Read("READ");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrgAddMemberAuditEntryPermission? {
      return values().find { it.label == label }
    }
  }
}









/** The billing plans available for organizations. */
enum class OrgCreateAuditEntryBillingPlan(val label: String) {
      Business("BUSINESS"),
      BusinessPlus("BUSINESS_PLUS"),
      Free("FREE"),
      TieredPerSeat("TIERED_PER_SEAT"),
      Unlimited("UNLIMITED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrgCreateAuditEntryBillingPlan? {
      return values().find { it.label == label }
    }
  }
}













data class OrgEnterpriseOwnerOrderInput(
    val direction: OrderDirection,
    val field: OrgEnterpriseOwnerOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as OrgEnterpriseOwnerOrderField
  )
}

/** Properties by which enterprise owners can be ordered. */
enum class OrgEnterpriseOwnerOrderField(val label: String) {
      Login("LOGIN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrgEnterpriseOwnerOrderField? {
      return values().find { it.label == label }
    }
  }
}

















/** The reason a billing manager was removed from an Organization. */
enum class OrgRemoveBillingManagerAuditEntryReason(val label: String) {
      SamlExternalIdentityMissing("SAML_EXTERNAL_IDENTITY_MISSING"),
      SamlSsoEnforcementRequiresExternalIdentity("SAML_SSO_ENFORCEMENT_REQUIRES_EXTERNAL_IDENTITY"),
      TwoFactorRequirementNonCompliance("TWO_FACTOR_REQUIREMENT_NON_COMPLIANCE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrgRemoveBillingManagerAuditEntryReason? {
      return values().find { it.label == label }
    }
  }
}



/** The type of membership a user has with an Organization. */
enum class OrgRemoveMemberAuditEntryMembershipType(val label: String) {
      Admin("ADMIN"),
      BillingManager("BILLING_MANAGER"),
      DirectMember("DIRECT_MEMBER"),
      OutsideCollaborator("OUTSIDE_COLLABORATOR"),
      Suspended("SUSPENDED"),
      Unaffiliated("UNAFFILIATED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrgRemoveMemberAuditEntryMembershipType? {
      return values().find { it.label == label }
    }
  }
}

/** The reason a member was removed from an Organization. */
enum class OrgRemoveMemberAuditEntryReason(val label: String) {
      SamlExternalIdentityMissing("SAML_EXTERNAL_IDENTITY_MISSING"),
      SamlSsoEnforcementRequiresExternalIdentity("SAML_SSO_ENFORCEMENT_REQUIRES_EXTERNAL_IDENTITY"),
      TwoFactorAccountRecovery("TWO_FACTOR_ACCOUNT_RECOVERY"),
      TwoFactorRequirementNonCompliance("TWO_FACTOR_REQUIREMENT_NON_COMPLIANCE"),
      UserAccountDeleted("USER_ACCOUNT_DELETED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrgRemoveMemberAuditEntryReason? {
      return values().find { it.label == label }
    }
  }
}



/** The type of membership a user has with an Organization. */
enum class OrgRemoveOutsideCollaboratorAuditEntryMembershipType(val label: String) {
      BillingManager("BILLING_MANAGER"),
      OutsideCollaborator("OUTSIDE_COLLABORATOR"),
      Unaffiliated("UNAFFILIATED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrgRemoveOutsideCollaboratorAuditEntryMembershipType? {
      return values().find { it.label == label }
    }
  }
}

/** The reason an outside collaborator was removed from an Organization. */
enum class OrgRemoveOutsideCollaboratorAuditEntryReason(val label: String) {
      SamlExternalIdentityMissing("SAML_EXTERNAL_IDENTITY_MISSING"),
      TwoFactorRequirementNonCompliance("TWO_FACTOR_REQUIREMENT_NON_COMPLIANCE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrgRemoveOutsideCollaboratorAuditEntryReason? {
      return values().find { it.label == label }
    }
  }
}













/** The default permission a repository can have in an Organization. */
enum class OrgUpdateDefaultRepositoryPermissionAuditEntryPermission(val label: String) {
      Admin("ADMIN"),
      None("NONE"),
      Read("READ"),
      Write("WRITE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrgUpdateDefaultRepositoryPermissionAuditEntryPermission? {
      return values().find { it.label == label }
    }
  }
}



/** The permissions available to members on an Organization. */
enum class OrgUpdateMemberAuditEntryPermission(val label: String) {
      Admin("ADMIN"),
      Read("READ");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrgUpdateMemberAuditEntryPermission? {
      return values().find { it.label == label }
    }
  }
}



/** The permissions available for repository creation on an Organization. */
enum class OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility(val label: String) {
      All("ALL"),
      Internal("INTERNAL"),
      None("NONE"),
      Private("PRIVATE"),
      PrivateInternal("PRIVATE_INTERNAL"),
      Public("PUBLIC"),
      PublicInternal("PUBLIC_INTERNAL"),
      PublicPrivate("PUBLIC_PRIVATE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrgUpdateMemberRepositoryCreationPermissionAuditEntryVisibility? {
      return values().find { it.label == label }
    }
  }
}



data class OrganizationAnyPinnableItemsArgs(
    val type: PinnableItemType? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["type"] as PinnableItemType?
  )
}
data class OrganizationAuditLogArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: AuditLogOrderInput? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { AuditLogOrderInput(it as Map<String, Any>) },
      args["query"] as String?
  )
}
data class OrganizationAvatarUrlArgs(
    val size: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["size"] as Int?
  )
}
data class OrganizationDomainsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val isApproved: Boolean? = null,
    val isVerified: Boolean? = null,
    val last: Int? = null,
    val orderBy: VerifiableDomainOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["isApproved"] as Boolean?,
      args["isVerified"] as Boolean?,
      args["last"] as Int?,
      args["orderBy"]?.let { VerifiableDomainOrderInput(it as Map<String, Any>) }
  )
}
data class OrganizationEnterpriseOwnersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrgEnterpriseOwnerOrderInput? = null,
    val organizationRole: RoleInOrganization? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrgEnterpriseOwnerOrderInput(it as Map<String, Any>) },
      args["organizationRole"] as RoleInOrganization?,
      args["query"] as String?
  )
}
data class OrganizationIpAllowListEntriesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: IpAllowListEntryOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { IpAllowListEntryOrderInput(it as Map<String, Any>) }
  )
}
data class OrganizationIsSponsoredByArgs(
    val accountLogin: String
) {
  constructor(args: Map<String, Any>) : this(
      args["accountLogin"] as String
  )
}
data class OrganizationLifetimeReceivedSponsorshipValuesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: SponsorAndLifetimeValueOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorAndLifetimeValueOrderInput(it as Map<String, Any>) }
  )
}
data class OrganizationMannequinsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val login: String? = null,
    val orderBy: MannequinOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["login"] as String?,
      args["orderBy"]?.let { MannequinOrderInput(it as Map<String, Any>) }
  )
}
data class OrganizationMemberStatusesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: UserStatusOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { UserStatusOrderInput(it as Map<String, Any>) }
  )
}
data class OrganizationMembersWithRoleArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class OrganizationPackagesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val names: Iterable<String>? = null,
    val orderBy: PackageOrderInput? = null,
    val packageType: PackageType? = null,
    val repositoryId: Any? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["names"] as Iterable<String>?,
      args["orderBy"]?.let { PackageOrderInput(it as Map<String, Any>) },
      args["packageType"] as PackageType?,
      args["repositoryId"] as Any?
  )
}
data class OrganizationPendingMembersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class OrganizationPinnableItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val types: Iterable<PinnableItemType>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["types"] as Iterable<PinnableItemType>?
  )
}
data class OrganizationPinnedItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val types: Iterable<PinnableItemType>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["types"] as Iterable<PinnableItemType>?
  )
}
data class OrganizationProjectArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class OrganizationProjectV2Args(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class OrganizationProjectsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectOrderInput? = null,
    val search: String? = null,
    val states: Iterable<ProjectState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectOrderInput(it as Map<String, Any>) },
      args["search"] as String?,
      args["states"] as Iterable<ProjectState>?
  )
}
data class OrganizationProjectsV2Args(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val minPermissionLevel: ProjectV2PermissionLevel? = ProjectV2PermissionLevel.READ,
    val orderBy: ProjectV2OrderInput? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["minPermissionLevel"] as ProjectV2PermissionLevel? ?: ProjectV2PermissionLevel.READ,
      args["orderBy"]?.let { ProjectV2OrderInput(it as Map<String, Any>) },
      args["query"] as String?
  )
}
data class OrganizationRecentProjectsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class OrganizationRepositoriesArgs(
    val affiliations: Iterable<RepositoryAffiliation>? = null,
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val hasIssuesEnabled: Boolean? = null,
    val isArchived: Boolean? = null,
    val isFork: Boolean? = null,
    val isLocked: Boolean? = null,
    val last: Int? = null,
    val orderBy: RepositoryOrderInput? = null,
    val ownerAffiliations: Iterable<RepositoryAffiliation>? = listOf(Iterable<RepositoryAffiliation>.OWNER, Iterable<RepositoryAffiliation>.COLLABORATOR),
    val privacy: RepositoryPrivacy? = null,
    val visibility: RepositoryVisibility? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["affiliations"] as Iterable<RepositoryAffiliation>?,
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["hasIssuesEnabled"] as Boolean?,
      args["isArchived"] as Boolean?,
      args["isFork"] as Boolean?,
      args["isLocked"] as Boolean?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryOrderInput(it as Map<String, Any>) },
      args["ownerAffiliations"] as Iterable<RepositoryAffiliation>? ?: listOf(Iterable<RepositoryAffiliation>.OWNER, Iterable<RepositoryAffiliation>.COLLABORATOR),
      args["privacy"] as RepositoryPrivacy?,
      args["visibility"] as RepositoryVisibility?
  )
}
data class OrganizationRepositoryArgs(
    val followRenames: Boolean? = true,
    val name: String
) {
  constructor(args: Map<String, Any>) : this(
      args["followRenames"] as Boolean? ?: true,
      args["name"] as String
  )
}
data class OrganizationRepositoryDiscussionCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val onlyAnswers: Boolean? = false,
    val repositoryId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["onlyAnswers"] as Boolean? ?: false,
      args["repositoryId"] as Any?
  )
}
data class OrganizationRepositoryDiscussionsArgs(
    val after: String? = null,
    val answered: Boolean? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: DiscussionOrderInput? = null,
    val repositoryId: Any? = null,
    val states: Iterable<DiscussionState>? = listOf()
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["answered"] as Boolean?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { DiscussionOrderInput(it as Map<String, Any>) },
      args["repositoryId"] as Any?,
      args["states"] as Iterable<DiscussionState>? ?: listOf()
  )
}
data class OrganizationRepositoryMigrationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: RepositoryMigrationOrderInput? = null,
    val repositoryName: String? = null,
    val state: MigrationState? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryMigrationOrderInput(it as Map<String, Any>) },
      args["repositoryName"] as String?,
      args["state"] as MigrationState?
  )
}
data class OrganizationRulesetArgs(
    val databaseId: Int,
    val includeParents: Boolean? = true
) {
  constructor(args: Map<String, Any>) : this(
      args["databaseId"] as Int,
      args["includeParents"] as Boolean? ?: true
  )
}
data class OrganizationRulesetsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val includeParents: Boolean? = true,
    val last: Int? = null,
    val targets: Iterable<RepositoryRulesetTarget>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["includeParents"] as Boolean? ?: true,
      args["last"] as Int?,
      args["targets"] as Iterable<RepositoryRulesetTarget>?
  )
}
data class OrganizationSponsoringArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: SponsorOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorOrderInput(it as Map<String, Any>) }
  )
}
data class OrganizationSponsorsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: SponsorOrderInput? = null,
    val tierId: Any? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorOrderInput(it as Map<String, Any>) },
      args["tierId"] as Any?
  )
}
data class OrganizationSponsorsActivitiesArgs(
    val actions: Iterable<SponsorsActivityAction>? = listOf(),
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val includeAsSponsor: Boolean? = false,
    val includePrivate: Boolean? = true,
    val last: Int? = null,
    val orderBy: SponsorsActivityOrderInput? = null,
    val period: SponsorsActivityPeriod? = SponsorsActivityPeriod.MONTH,
    val since: any? = null,
    val until: any? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["actions"] as Iterable<SponsorsActivityAction>? ?: listOf(),
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["includeAsSponsor"] as Boolean? ?: false,
      args["includePrivate"] as Boolean? ?: true,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorsActivityOrderInput(it as Map<String, Any>) },
      args["period"] as SponsorsActivityPeriod? ?: SponsorsActivityPeriod.MONTH,
      args["since"] as any?,
      args["until"] as any?
  )
}
data class OrganizationSponsorshipForViewerAsSponsorArgs(
    val activeOnly: Boolean? = true
) {
  constructor(args: Map<String, Any>) : this(
      args["activeOnly"] as Boolean? ?: true
  )
}
data class OrganizationSponsorshipForViewerAsSponsorableArgs(
    val activeOnly: Boolean? = true
) {
  constructor(args: Map<String, Any>) : this(
      args["activeOnly"] as Boolean? ?: true
  )
}
data class OrganizationSponsorshipNewslettersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: SponsorshipNewsletterOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorshipNewsletterOrderInput(it as Map<String, Any>) }
  )
}
data class OrganizationSponsorshipsAsMaintainerArgs(
    val activeOnly: Boolean? = true,
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val includePrivate: Boolean? = false,
    val last: Int? = null,
    val orderBy: SponsorshipOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["activeOnly"] as Boolean? ?: true,
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["includePrivate"] as Boolean? ?: false,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorshipOrderInput(it as Map<String, Any>) }
  )
}
data class OrganizationSponsorshipsAsSponsorArgs(
    val activeOnly: Boolean? = true,
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val maintainerLogins: Iterable<String>? = null,
    val orderBy: SponsorshipOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["activeOnly"] as Boolean? ?: true,
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["maintainerLogins"] as Iterable<String>?,
      args["orderBy"]?.let { SponsorshipOrderInput(it as Map<String, Any>) }
  )
}
data class OrganizationTeamArgs(
    val slug: String
) {
  constructor(args: Map<String, Any>) : this(
      args["slug"] as String
  )
}
data class OrganizationTeamsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val ldapMapped: Boolean? = null,
    val notificationSetting: TeamNotificationSetting? = null,
    val orderBy: TeamOrderInput? = null,
    val privacy: TeamPrivacy? = null,
    val query: String? = null,
    val role: TeamRole? = null,
    val rootTeamsOnly: Boolean? = false,
    val userLogins: Iterable<String>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["ldapMapped"] as Boolean?,
      args["notificationSetting"] as TeamNotificationSetting?,
      args["orderBy"]?.let { TeamOrderInput(it as Map<String, Any>) },
      args["privacy"] as TeamPrivacy?,
      args["query"] as String?,
      args["role"] as TeamRole?,
      args["rootTeamsOnly"] as Boolean? ?: false,
      args["userLogins"] as Iterable<String>?
  )
}
data class OrganizationTotalSponsorshipAmountAsSponsorInCentsArgs(
    val since: any? = null,
    val sponsorableLogins: Iterable<String>? = listOf(),
    val until: any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["since"] as any?,
      args["sponsorableLogins"] as Iterable<String>? ?: listOf(),
      args["until"] as any?
  )
}













data class OrganizationIdentityProviderExternalIdentitiesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val login: String? = null,
    val membersOnly: Boolean? = null,
    val userName: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["login"] as String?,
      args["membersOnly"] as Boolean?,
      args["userName"] as String?
  )
}







/** The possible organization invitation roles. */
enum class OrganizationInvitationRole(val label: String) {
      Admin("ADMIN"),
      BillingManager("BILLING_MANAGER"),
      DirectMember("DIRECT_MEMBER"),
      Reinstate("REINSTATE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrganizationInvitationRole? {
      return values().find { it.label == label }
    }
  }
}

/** The possible organization invitation sources. */
enum class OrganizationInvitationSource(val label: String) {
      Member("MEMBER"),
      Scim("SCIM"),
      Unknown("UNKNOWN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrganizationInvitationSource? {
      return values().find { it.label == label }
    }
  }
}

/** The possible organization invitation types. */
enum class OrganizationInvitationType(val label: String) {
      Email("EMAIL"),
      User("USER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrganizationInvitationType? {
      return values().find { it.label == label }
    }
  }
}





/** The possible roles within an organization for its members. */
enum class OrganizationMemberRole(val label: String) {
      Admin("ADMIN"),
      Member("MEMBER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrganizationMemberRole? {
      return values().find { it.label == label }
    }
  }
}

/** The possible values for the members can create repositories setting on an organization. */
enum class OrganizationMembersCanCreateRepositoriesSettingValue(val label: String) {
      All("ALL"),
      Disabled("DISABLED"),
      Internal("INTERNAL"),
      Private("PRIVATE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrganizationMembersCanCreateRepositoriesSettingValue? {
      return values().find { it.label == label }
    }
  }
}



/** The Octoshift Organization migration state. */
enum class OrganizationMigrationState(val label: String) {
      Failed("FAILED"),
      FailedValidation("FAILED_VALIDATION"),
      InProgress("IN_PROGRESS"),
      NotStarted("NOT_STARTED"),
      PendingValidation("PENDING_VALIDATION"),
      PostRepoMigration("POST_REPO_MIGRATION"),
      PreRepoMigration("PRE_REPO_MIGRATION"),
      Queued("QUEUED"),
      RepoMigration("REPO_MIGRATION"),
      Succeeded("SUCCEEDED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrganizationMigrationState? {
      return values().find { it.label == label }
    }
  }
}

data class OrganizationOrderInput(
    val direction: OrderDirection,
    val field: OrganizationOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as OrganizationOrderField
  )
}

/** Properties by which organization connections can be ordered. */
enum class OrganizationOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Login("LOGIN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): OrganizationOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class OrganizationTeamsHovercardContextRelevantTeamsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

data class OrganizationsHovercardContextRelevantOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) }
  )
}

data class PackageVersionArgs(
    val version: String
) {
  constructor(args: Map<String, Any>) : this(
      args["version"] as String
  )
}
data class PackageVersionsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: PackageVersionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { PackageVersionOrderInput(it as Map<String, Any>) }
  )
}











data class PackageFileOrderInput(
    val direction: OrderDirection? = null,
    val field: PackageFileOrderField? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection?,
      args["field"] as PackageFileOrderField?
  )
}

/** Properties by which package file connections can be ordered. */
enum class PackageFileOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PackageFileOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class PackageOrderInput(
    val direction: OrderDirection? = null,
    val field: PackageOrderField? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection?,
      args["field"] as PackageOrderField?
  )
}

/** Properties by which package connections can be ordered. */
enum class PackageOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PackageOrderField? {
      return values().find { it.label == label }
    }
  }
}





/** The possible types of a package. */
enum class PackageType(val label: String) {
      Debian("DEBIAN"),
      Docker("DOCKER"),
      Maven("MAVEN"),
      Npm("NPM"),
      Nuget("NUGET"),
      Pypi("PYPI"),
      Rubygems("RUBYGEMS");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PackageType? {
      return values().find { it.label == label }
    }
  }
}

data class PackageVersionFilesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: PackageFileOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { PackageFileOrderInput(it as Map<String, Any>) }
  )
}





data class PackageVersionOrderInput(
    val direction: OrderDirection? = null,
    val field: PackageVersionOrderField? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection?,
      args["field"] as PackageVersionOrderField?
  )
}

/** Properties by which package version connections can be ordered. */
enum class PackageVersionOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PackageVersionOrderField? {
      return values().find { it.label == label }
    }
  }
}









/** The possible types of patch statuses. */
enum class PatchStatus(val label: String) {
      Added("ADDED"),
      Changed("CHANGED"),
      Copied("COPIED"),
      Deleted("DELETED"),
      Modified("MODIFIED"),
      Renamed("RENAMED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PatchStatus? {
      return values().find { it.label == label }
    }
  }
}



data class PinEnvironmentInput(
    val clientMutationId: String? = null,
    val environmentId: Any,
    val pinned: Boolean
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["environmentId"] as Any,
      args["pinned"] as Boolean
  )
}



data class PinIssueInput(
    val clientMutationId: String? = null,
    val issueId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["issueId"] as Any
  )
}







/** Represents items that can be pinned to a profile page or dashboard. */
enum class PinnableItemType(val label: String) {
      Gist("GIST"),
      Issue("ISSUE"),
      Organization("ORGANIZATION"),
      Project("PROJECT"),
      PullRequest("PULL_REQUEST"),
      Repository("REPOSITORY"),
      Team("TEAM"),
      User("USER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PinnableItemType? {
      return values().find { it.label == label }
    }
  }
}







/** Preconfigured gradients that may be used to style discussions pinned within a repository. */
enum class PinnedDiscussionGradient(val label: String) {
      BlueMint("BLUE_MINT"),
      BluePurple("BLUE_PURPLE"),
      PinkBlue("PINK_BLUE"),
      PurpleCoral("PURPLE_CORAL"),
      RedOrange("RED_ORANGE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PinnedDiscussionGradient? {
      return values().find { it.label == label }
    }
  }
}

/** Preconfigured background patterns that may be used to style discussions pinned within a repository. */
enum class PinnedDiscussionPattern(val label: String) {
      ChevronUp("CHEVRON_UP"),
      Dot("DOT"),
      DotFill("DOT_FILL"),
      HeartFill("HEART_FILL"),
      Plus("PLUS"),
      Zap("ZAP");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PinnedDiscussionPattern? {
      return values().find { it.label == label }
    }
  }
}







data class PinnedEnvironmentOrderInput(
    val direction: OrderDirection,
    val field: PinnedEnvironmentOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as PinnedEnvironmentOrderField
  )
}

/** Properties by which pinned environments connections can be ordered */
enum class PinnedEnvironmentOrderField(val label: String) {
      Position("POSITION");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PinnedEnvironmentOrderField? {
      return values().find { it.label == label }
    }
  }
}













data class ProfileItemShowcaseItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

data class ProjectColumnsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class ProjectPendingCardsArgs(
    val after: String? = null,
    val archivedStates: Iterable<ProjectCardArchivedState>? = listOf(Iterable<ProjectCardArchivedState>.ARCHIVED, Iterable<ProjectCardArchivedState>.NOT_ARCHIVED),
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["archivedStates"] as Iterable<ProjectCardArchivedState>? ?: listOf(Iterable<ProjectCardArchivedState>.ARCHIVED, Iterable<ProjectCardArchivedState>.NOT_ARCHIVED),
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}



/** The possible archived states of a project card. */
enum class ProjectCardArchivedState(val label: String) {
      Archived("ARCHIVED"),
      NotArchived("NOT_ARCHIVED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectCardArchivedState? {
      return values().find { it.label == label }
    }
  }
}





data class ProjectCardImportInput(
    val number: Int,
    val repository: String
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int,
      args["repository"] as String
  )
}

/** Various content states of a ProjectCard */
enum class ProjectCardState(val label: String) {
      ContentOnly("CONTENT_ONLY"),
      NoteOnly("NOTE_ONLY"),
      Redacted("REDACTED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectCardState? {
      return values().find { it.label == label }
    }
  }
}

data class ProjectColumnCardsArgs(
    val after: String? = null,
    val archivedStates: Iterable<ProjectCardArchivedState>? = listOf(Iterable<ProjectCardArchivedState>.ARCHIVED, Iterable<ProjectCardArchivedState>.NOT_ARCHIVED),
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["archivedStates"] as Iterable<ProjectCardArchivedState>? ?: listOf(Iterable<ProjectCardArchivedState>.ARCHIVED, Iterable<ProjectCardArchivedState>.NOT_ARCHIVED),
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





data class ProjectColumnImportInput(
    val columnName: String,
    val issues: Iterable<ProjectCardImportInput>? = null,
    val position: Int
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["columnName"] as String,
      args["issues"]?.let { issues -> (issues as List<Map<String, Any>>).map { ProjectCardImportInput(it) } },
      args["position"] as Int
  )
}

/** The semantic purpose of the column - todo, in progress, or done. */
enum class ProjectColumnPurpose(val label: String) {
      Done("DONE"),
      InProgress("IN_PROGRESS"),
      Todo("TODO");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectColumnPurpose? {
      return values().find { it.label == label }
    }
  }
}





data class ProjectOrderInput(
    val direction: OrderDirection,
    val field: ProjectOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as ProjectOrderField
  )
}

/** Properties by which project connections can be ordered. */
enum class ProjectOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Name("NAME"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectOrderField? {
      return values().find { it.label == label }
    }
  }
}



/** State of the project; either 'open' or 'closed' */
enum class ProjectState(val label: String) {
      Closed("CLOSED"),
      Open("OPEN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectState? {
      return values().find { it.label == label }
    }
  }
}

/** GitHub-provided templates for Projects */
enum class ProjectTemplate(val label: String) {
      AutomatedKanbanV2("AUTOMATED_KANBAN_V2"),
      AutomatedReviewsKanban("AUTOMATED_REVIEWS_KANBAN"),
      BasicKanban("BASIC_KANBAN"),
      BugTriage("BUG_TRIAGE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectTemplate? {
      return values().find { it.label == label }
    }
  }
}

data class ProjectV2FieldArgs(
    val name: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String
  )
}
data class ProjectV2FieldsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2FieldOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2FieldOrderInput(it as Map<String, Any>) }
  )
}
data class ProjectV2ItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2ItemOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2ItemOrderInput(it as Map<String, Any>) }
  )
}
data class ProjectV2RepositoriesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: RepositoryOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryOrderInput(it as Map<String, Any>) }
  )
}
data class ProjectV2StatusUpdatesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2StatusOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2StatusOrderInput(it as Map<String, Any>) }
  )
}
data class ProjectV2TeamsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: TeamOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { TeamOrderInput(it as Map<String, Any>) }
  )
}
data class ProjectV2ViewArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class ProjectV2ViewsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2ViewOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2ViewOrderInput(it as Map<String, Any>) }
  )
}
data class ProjectV2WorkflowArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class ProjectV2WorkflowsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2WorkflowOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2WorkflowOrderInput(it as Map<String, Any>) }
  )
}





data class ProjectV2CollaboratorInput(
    val role: ProjectV2Roles,
    val teamId: Any? = null,
    val userId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["role"] as ProjectV2Roles,
      args["teamId"] as Any?,
      args["userId"] as Any?
  )
}



/** The type of a project field. */
enum class ProjectV2CustomFieldType(val label: String) {
      Date("DATE"),
      Iteration("ITERATION"),
      Number("NUMBER"),
      SingleSelect("SINGLE_SELECT"),
      Text("TEXT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2CustomFieldType? {
      return values().find { it.label == label }
    }
  }
}













data class ProjectV2FieldOrderInput(
    val direction: OrderDirection,
    val field: ProjectV2FieldOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as ProjectV2FieldOrderField
  )
}

/** Properties by which project v2 field connections can be ordered. */
enum class ProjectV2FieldOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Name("NAME"),
      Position("POSITION");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2FieldOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The type of a project field. */
enum class ProjectV2FieldType(val label: String) {
      Assignees("ASSIGNEES"),
      Date("DATE"),
      Iteration("ITERATION"),
      Labels("LABELS"),
      LinkedPullRequests("LINKED_PULL_REQUESTS"),
      Milestone("MILESTONE"),
      Number("NUMBER"),
      ParentIssue("PARENT_ISSUE"),
      Repository("REPOSITORY"),
      Reviewers("REVIEWERS"),
      SingleSelect("SINGLE_SELECT"),
      SubIssuesProgress("SUB_ISSUES_PROGRESS"),
      Text("TEXT"),
      Title("TITLE"),
      TrackedBy("TRACKED_BY"),
      Tracks("TRACKS");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2FieldType? {
      return values().find { it.label == label }
    }
  }
}

data class ProjectV2FieldValueInput(
    val date: any? = null,
    val iterationId: String? = null,
    val number: Float? = null,
    val singleSelectOptionId: String? = null,
    val text: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["date"] as any?,
      args["iterationId"] as String?,
      args["number"] as Float?,
      args["singleSelectOptionId"] as String?,
      args["text"] as String?
  )
}

data class ProjectV2FiltersInput(
    val state: ProjectV2State? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["state"] as ProjectV2State?
  )
}

data class ProjectV2ItemFieldValueByNameArgs(
    val name: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String
  )
}
data class ProjectV2ItemFieldValuesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2ItemFieldValueOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2ItemFieldValueOrderInput(it as Map<String, Any>) }
  )
}









data class ProjectV2ItemFieldLabelValueLabelsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





data class ProjectV2ItemFieldPullRequestValuePullRequestsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: PullRequestOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { PullRequestOrderInput(it as Map<String, Any>) }
  )
}



data class ProjectV2ItemFieldReviewerValueReviewersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





data class ProjectV2ItemFieldUserValueUsersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





data class ProjectV2ItemFieldValueOrderInput(
    val direction: OrderDirection,
    val field: ProjectV2ItemFieldValueOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as ProjectV2ItemFieldValueOrderField
  )
}

/** Properties by which project v2 item field value connections can be ordered. */
enum class ProjectV2ItemFieldValueOrderField(val label: String) {
      Position("POSITION");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2ItemFieldValueOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class ProjectV2ItemOrderInput(
    val direction: OrderDirection,
    val field: ProjectV2ItemOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as ProjectV2ItemOrderField
  )
}

/** Properties by which project v2 item connections can be ordered. */
enum class ProjectV2ItemOrderField(val label: String) {
      Position("POSITION");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2ItemOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The type of a project item. */
enum class ProjectV2ItemType(val label: String) {
      DraftIssue("DRAFT_ISSUE"),
      Issue("ISSUE"),
      PullRequest("PULL_REQUEST"),
      Redacted("REDACTED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2ItemType? {
      return values().find { it.label == label }
    }
  }
}

data class ProjectV2IterationInput(
    val duration: Int,
    val startDate: any,
    val title: String
) {
  constructor(args: Map<String, Any>) : this(
      args["duration"] as Int,
      args["startDate"] as any,
      args["title"] as String
  )
}





data class ProjectV2IterationFieldConfigurationInput(
    val duration: Int,
    val iterations: Iterable<ProjectV2IterationInput>,
    val startDate: any
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["duration"] as Int,
      args["iterations"]!!.let { iterations -> (iterations as List<Map<String, Any>>).map { ProjectV2IterationInput(it) } },
      args["startDate"] as any
  )
}



data class ProjectV2OrderInput(
    val direction: OrderDirection,
    val field: ProjectV2OrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as ProjectV2OrderField
  )
}

/** Properties by which projects can be ordered. */
enum class ProjectV2OrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Number("NUMBER"),
      Title("TITLE"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2OrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible roles of a collaborator on a project. */
enum class ProjectV2PermissionLevel(val label: String) {
      Admin("ADMIN"),
      Read("READ"),
      Write("WRITE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2PermissionLevel? {
      return values().find { it.label == label }
    }
  }
}

/** The possible roles of a collaborator on a project. */
enum class ProjectV2Roles(val label: String) {
      Admin("ADMIN"),
      None("NONE"),
      Reader("READER"),
      Writer("WRITER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2Roles? {
      return values().find { it.label == label }
    }
  }
}

data class ProjectV2SingleSelectFieldOptionsArgs(
    val names: Iterable<String>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["names"] as Iterable<String>?
  )
}



/** The display color of a single-select field option. */
enum class ProjectV2SingleSelectFieldOptionColor(val label: String) {
      Blue("BLUE"),
      Gray("GRAY"),
      Green("GREEN"),
      Orange("ORANGE"),
      Pink("PINK"),
      Purple("PURPLE"),
      Red("RED"),
      Yellow("YELLOW");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2SingleSelectFieldOptionColor? {
      return values().find { it.label == label }
    }
  }
}

data class ProjectV2SingleSelectFieldOptionInput(
    val color: ProjectV2SingleSelectFieldOptionColor,
    val description: String,
    val name: String
) {
  constructor(args: Map<String, Any>) : this(
      args["color"] as ProjectV2SingleSelectFieldOptionColor,
      args["description"] as String,
      args["name"] as String
  )
}













/** The possible states of a project v2. */
enum class ProjectV2State(val label: String) {
      Closed("CLOSED"),
      Open("OPEN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2State? {
      return values().find { it.label == label }
    }
  }
}

data class ProjectV2StatusOrderInput(
    val direction: OrderDirection,
    val field: ProjectV2StatusUpdateOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as ProjectV2StatusUpdateOrderField
  )
}







/** Properties by which project v2 status updates can be ordered. */
enum class ProjectV2StatusUpdateOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2StatusUpdateOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible statuses of a project v2. */
enum class ProjectV2StatusUpdateStatus(val label: String) {
      AtRisk("AT_RISK"),
      Complete("COMPLETE"),
      Inactive("INACTIVE"),
      OffTrack("OFF_TRACK"),
      OnTrack("ON_TRACK");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2StatusUpdateStatus? {
      return values().find { it.label == label }
    }
  }
}

data class ProjectV2ViewFieldsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2FieldOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2FieldOrderInput(it as Map<String, Any>) }
  )
}
data class ProjectV2ViewGroupByArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2FieldOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2FieldOrderInput(it as Map<String, Any>) }
  )
}
data class ProjectV2ViewGroupByFieldsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2FieldOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2FieldOrderInput(it as Map<String, Any>) }
  )
}
data class ProjectV2ViewSortByArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class ProjectV2ViewSortByFieldsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class ProjectV2ViewVerticalGroupByArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2FieldOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2FieldOrderInput(it as Map<String, Any>) }
  )
}
data class ProjectV2ViewVerticalGroupByFieldsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2FieldOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2FieldOrderInput(it as Map<String, Any>) }
  )
}
data class ProjectV2ViewVisibleFieldsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectV2FieldOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectV2FieldOrderInput(it as Map<String, Any>) }
  )
}





/** The layout of a project v2 view. */
enum class ProjectV2ViewLayout(val label: String) {
      BoardLayout("BOARD_LAYOUT"),
      RoadmapLayout("ROADMAP_LAYOUT"),
      TableLayout("TABLE_LAYOUT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2ViewLayout? {
      return values().find { it.label == label }
    }
  }
}

data class ProjectV2ViewOrderInput(
    val direction: OrderDirection,
    val field: ProjectV2ViewOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as ProjectV2ViewOrderField
  )
}

/** Properties by which project v2 view connections can be ordered. */
enum class ProjectV2ViewOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Name("NAME"),
      Position("POSITION");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2ViewOrderField? {
      return values().find { it.label == label }
    }
  }
}







data class ProjectV2WorkflowOrderInput(
    val direction: OrderDirection,
    val field: ProjectV2WorkflowsOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as ProjectV2WorkflowsOrderField
  )
}

/** Properties by which project workflows can be ordered. */
enum class ProjectV2WorkflowsOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Name("NAME"),
      Number("NUMBER"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ProjectV2WorkflowsOrderField? {
      return values().find { it.label == label }
    }
  }
}



data class PropertyTargetDefinitionInput(
    val name: String,
    val propertyValues: Iterable<String>,
    val source: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String,
      args["propertyValues"] as Iterable<String>,
      args["source"] as String?
  )
}







data class PublishSponsorsTierInput(
    val clientMutationId: String? = null,
    val tierId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["tierId"] as Any
  )
}



data class PullRequestAssigneesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class PullRequestClosingIssuesReferencesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: IssueOrderInput? = null,
    val userLinkedOnly: Boolean? = false
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueOrderInput(it as Map<String, Any>) },
      args["userLinkedOnly"] as Boolean? ?: false
  )
}
data class PullRequestCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: IssueCommentOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueCommentOrderInput(it as Map<String, Any>) }
  )
}
data class PullRequestCommitsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class PullRequestFilesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class PullRequestHovercardArgs(
    val includeNotificationContexts: Boolean? = true
) {
  constructor(args: Map<String, Any>) : this(
      args["includeNotificationContexts"] as Boolean? ?: true
  )
}
data class PullRequestLabelsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: LabelOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { LabelOrderInput(it as Map<String, Any>) }
  )
}
data class PullRequestLatestOpinionatedReviewsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val writersOnly: Boolean? = false
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["writersOnly"] as Boolean? ?: false
  )
}
data class PullRequestLatestReviewsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class PullRequestParticipantsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class PullRequestProjectCardsArgs(
    val after: String? = null,
    val archivedStates: Iterable<ProjectCardArchivedState>? = listOf(Iterable<ProjectCardArchivedState>.ARCHIVED, Iterable<ProjectCardArchivedState>.NOT_ARCHIVED),
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["archivedStates"] as Iterable<ProjectCardArchivedState>? ?: listOf(Iterable<ProjectCardArchivedState>.ARCHIVED, Iterable<ProjectCardArchivedState>.NOT_ARCHIVED),
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class PullRequestProjectItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val includeArchived: Boolean? = true,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["includeArchived"] as Boolean? ?: true,
      args["last"] as Int?
  )
}
data class PullRequestProjectV2Args(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class PullRequestProjectsV2Args(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val minPermissionLevel: ProjectV2PermissionLevel? = ProjectV2PermissionLevel.READ,
    val orderBy: ProjectV2OrderInput? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["minPermissionLevel"] as ProjectV2PermissionLevel? ?: ProjectV2PermissionLevel.READ,
      args["orderBy"]?.let { ProjectV2OrderInput(it as Map<String, Any>) },
      args["query"] as String?
  )
}
data class PullRequestReactionsArgs(
    val after: String? = null,
    val before: String? = null,
    val content: ReactionContent? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReactionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["content"] as ReactionContent?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReactionOrderInput(it as Map<String, Any>) }
  )
}
data class PullRequestReviewRequestsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class PullRequestReviewThreadsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class PullRequestReviewsArgs(
    val after: String? = null,
    val author: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val states: Iterable<PullRequestReviewState>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["author"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["states"] as Iterable<PullRequestReviewState>?
  )
}
data class PullRequestTimelineArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val since: any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["since"] as any?
  )
}
data class PullRequestTimelineItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val itemTypes: Iterable<PullRequestTimelineItemsItemType>? = null,
    val last: Int? = null,
    val since: any? = null,
    val skip: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["itemTypes"] as Iterable<PullRequestTimelineItemsItemType>?,
      args["last"] as Int?,
      args["since"] as any?,
      args["skip"] as Int?
  )
}
data class PullRequestUserContentEditsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class PullRequestViewerMergeBodyTextArgs(
    val mergeType: PullRequestMergeMethod? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["mergeType"] as PullRequestMergeMethod?
  )
}
data class PullRequestViewerMergeHeadlineTextArgs(
    val mergeType: PullRequestMergeMethod? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["mergeType"] as PullRequestMergeMethod?
  )
}

/** The possible methods for updating a pull request's head branch with the base branch. */
enum class PullRequestBranchUpdateMethod(val label: String) {
      Merge("MERGE"),
      Rebase("REBASE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PullRequestBranchUpdateMethod? {
      return values().find { it.label == label }
    }
  }
}









data class PullRequestCommitCommentThreadCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}







data class PullRequestContributionsByRepositoryContributionsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ContributionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ContributionOrderInput(it as Map<String, Any>) }
  )
}



/** Represents available types of methods to use when merging a pull request. */
enum class PullRequestMergeMethod(val label: String) {
      Merge("MERGE"),
      Rebase("REBASE"),
      Squash("SQUASH");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PullRequestMergeMethod? {
      return values().find { it.label == label }
    }
  }
}

data class PullRequestOrderInput(
    val direction: OrderDirection,
    val field: PullRequestOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as PullRequestOrderField
  )
}

/** Properties by which pull_requests connections can be ordered. */
enum class PullRequestOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PullRequestOrderField? {
      return values().find { it.label == label }
    }
  }
}



data class PullRequestParametersInput(
    val allowedMergeMethods: Iterable<String>? = null,
    val dismissStaleReviewsOnPush: Boolean,
    val requireCodeOwnerReview: Boolean,
    val requireLastPushApproval: Boolean,
    val requiredApprovingReviewCount: Int,
    val requiredReviewThreadResolution: Boolean
) {
  constructor(args: Map<String, Any>) : this(
      args["allowedMergeMethods"] as Iterable<String>?,
      args["dismissStaleReviewsOnPush"] as Boolean,
      args["requireCodeOwnerReview"] as Boolean,
      args["requireLastPushApproval"] as Boolean,
      args["requiredApprovingReviewCount"] as Int,
      args["requiredReviewThreadResolution"] as Boolean
  )
}

data class PullRequestReviewCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class PullRequestReviewOnBehalfOfArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class PullRequestReviewReactionsArgs(
    val after: String? = null,
    val before: String? = null,
    val content: ReactionContent? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReactionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["content"] as ReactionContent?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReactionOrderInput(it as Map<String, Any>) }
  )
}
data class PullRequestReviewUserContentEditsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

data class PullRequestReviewCommentReactionsArgs(
    val after: String? = null,
    val before: String? = null,
    val content: ReactionContent? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReactionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["content"] as ReactionContent?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReactionOrderInput(it as Map<String, Any>) }
  )
}
data class PullRequestReviewCommentUserContentEditsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





/** The possible states of a pull request review comment. */
enum class PullRequestReviewCommentState(val label: String) {
      Pending("PENDING"),
      Submitted("SUBMITTED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PullRequestReviewCommentState? {
      return values().find { it.label == label }
    }
  }
}



data class PullRequestReviewContributionsByRepositoryContributionsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ContributionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ContributionOrderInput(it as Map<String, Any>) }
  )
}

/** The review status of a pull request. */
enum class PullRequestReviewDecision(val label: String) {
      Approved("APPROVED"),
      ChangesRequested("CHANGES_REQUESTED"),
      ReviewRequired("REVIEW_REQUIRED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PullRequestReviewDecision? {
      return values().find { it.label == label }
    }
  }
}



/** The possible events to perform on a pull request review. */
enum class PullRequestReviewEvent(val label: String) {
      Approve("APPROVE"),
      Comment("COMMENT"),
      Dismiss("DISMISS"),
      RequestChanges("REQUEST_CHANGES");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PullRequestReviewEvent? {
      return values().find { it.label == label }
    }
  }
}

/** The possible states of a pull request review. */
enum class PullRequestReviewState(val label: String) {
      Approved("APPROVED"),
      ChangesRequested("CHANGES_REQUESTED"),
      Commented("COMMENTED"),
      Dismissed("DISMISSED"),
      Pending("PENDING");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PullRequestReviewState? {
      return values().find { it.label == label }
    }
  }
}

data class PullRequestReviewThreadCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val skip: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["skip"] as Int?
  )
}





/** The possible subject types of a pull request review comment. */
enum class PullRequestReviewThreadSubjectType(val label: String) {
      File("FILE"),
      Line("LINE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PullRequestReviewThreadSubjectType? {
      return values().find { it.label == label }
    }
  }
}



/** The possible states of a pull request. */
enum class PullRequestState(val label: String) {
      Closed("CLOSED"),
      Merged("MERGED"),
      Open("OPEN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PullRequestState? {
      return values().find { it.label == label }
    }
  }
}



data class PullRequestThreadCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val skip: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["skip"] as Int?
  )
}









/** The possible item types found in a timeline. */
enum class PullRequestTimelineItemsItemType(val label: String) {
      AddedToMergeQueueEvent("ADDED_TO_MERGE_QUEUE_EVENT"),
      AddedToProjectEvent("ADDED_TO_PROJECT_EVENT"),
      AssignedEvent("ASSIGNED_EVENT"),
      AutomaticBaseChangeFailedEvent("AUTOMATIC_BASE_CHANGE_FAILED_EVENT"),
      AutomaticBaseChangeSucceededEvent("AUTOMATIC_BASE_CHANGE_SUCCEEDED_EVENT"),
      AutoMergeDisabledEvent("AUTO_MERGE_DISABLED_EVENT"),
      AutoMergeEnabledEvent("AUTO_MERGE_ENABLED_EVENT"),
      AutoRebaseEnabledEvent("AUTO_REBASE_ENABLED_EVENT"),
      AutoSquashEnabledEvent("AUTO_SQUASH_ENABLED_EVENT"),
      BaseRefChangedEvent("BASE_REF_CHANGED_EVENT"),
      BaseRefDeletedEvent("BASE_REF_DELETED_EVENT"),
      BaseRefForcePushedEvent("BASE_REF_FORCE_PUSHED_EVENT"),
      ClosedEvent("CLOSED_EVENT"),
      CommentDeletedEvent("COMMENT_DELETED_EVENT"),
      ConnectedEvent("CONNECTED_EVENT"),
      ConvertedNoteToIssueEvent("CONVERTED_NOTE_TO_ISSUE_EVENT"),
      ConvertedToDiscussionEvent("CONVERTED_TO_DISCUSSION_EVENT"),
      ConvertToDraftEvent("CONVERT_TO_DRAFT_EVENT"),
      CrossReferencedEvent("CROSS_REFERENCED_EVENT"),
      DemilestonedEvent("DEMILESTONED_EVENT"),
      DeployedEvent("DEPLOYED_EVENT"),
      DeploymentEnvironmentChangedEvent("DEPLOYMENT_ENVIRONMENT_CHANGED_EVENT"),
      DisconnectedEvent("DISCONNECTED_EVENT"),
      HeadRefDeletedEvent("HEAD_REF_DELETED_EVENT"),
      HeadRefForcePushedEvent("HEAD_REF_FORCE_PUSHED_EVENT"),
      HeadRefRestoredEvent("HEAD_REF_RESTORED_EVENT"),
      IssueComment("ISSUE_COMMENT"),
      LabeledEvent("LABELED_EVENT"),
      LockedEvent("LOCKED_EVENT"),
      MarkedAsDuplicateEvent("MARKED_AS_DUPLICATE_EVENT"),
      MentionedEvent("MENTIONED_EVENT"),
      MergedEvent("MERGED_EVENT"),
      MilestonedEvent("MILESTONED_EVENT"),
      MovedColumnsInProjectEvent("MOVED_COLUMNS_IN_PROJECT_EVENT"),
      ParentIssueAddedEvent("PARENT_ISSUE_ADDED_EVENT"),
      ParentIssueRemovedEvent("PARENT_ISSUE_REMOVED_EVENT"),
      PinnedEvent("PINNED_EVENT"),
      PullRequestCommit("PULL_REQUEST_COMMIT"),
      PullRequestCommitCommentThread("PULL_REQUEST_COMMIT_COMMENT_THREAD"),
      PullRequestReview("PULL_REQUEST_REVIEW"),
      PullRequestReviewThread("PULL_REQUEST_REVIEW_THREAD"),
      PullRequestRevisionMarker("PULL_REQUEST_REVISION_MARKER"),
      ReadyForReviewEvent("READY_FOR_REVIEW_EVENT"),
      ReferencedEvent("REFERENCED_EVENT"),
      RemovedFromMergeQueueEvent("REMOVED_FROM_MERGE_QUEUE_EVENT"),
      RemovedFromProjectEvent("REMOVED_FROM_PROJECT_EVENT"),
      RenamedTitleEvent("RENAMED_TITLE_EVENT"),
      ReopenedEvent("REOPENED_EVENT"),
      ReviewDismissedEvent("REVIEW_DISMISSED_EVENT"),
      ReviewRequestedEvent("REVIEW_REQUESTED_EVENT"),
      ReviewRequestRemovedEvent("REVIEW_REQUEST_REMOVED_EVENT"),
      SubscribedEvent("SUBSCRIBED_EVENT"),
      SubIssueAddedEvent("SUB_ISSUE_ADDED_EVENT"),
      SubIssueRemovedEvent("SUB_ISSUE_REMOVED_EVENT"),
      TransferredEvent("TRANSFERRED_EVENT"),
      UnassignedEvent("UNASSIGNED_EVENT"),
      UnlabeledEvent("UNLABELED_EVENT"),
      UnlockedEvent("UNLOCKED_EVENT"),
      UnmarkedAsDuplicateEvent("UNMARKED_AS_DUPLICATE_EVENT"),
      UnpinnedEvent("UNPINNED_EVENT"),
      UnsubscribedEvent("UNSUBSCRIBED_EVENT"),
      UserBlockedEvent("USER_BLOCKED_EVENT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PullRequestTimelineItemsItemType? {
      return values().find { it.label == label }
    }
  }
}

/** The possible target states when updating a pull request. */
enum class PullRequestUpdateState(val label: String) {
      Closed("CLOSED"),
      Open("OPEN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): PullRequestUpdateState? {
      return values().find { it.label == label }
    }
  }
}









data class QueryCodeOfConductArgs(
    val key: String
) {
  constructor(args: Map<String, Any>) : this(
      args["key"] as String
  )
}
data class QueryEnterpriseArgs(
    val invitationToken: String? = null,
    val slug: String
) {
  constructor(args: Map<String, Any>) : this(
      args["invitationToken"] as String?,
      args["slug"] as String
  )
}
data class QueryEnterpriseAdministratorInvitationArgs(
    val enterpriseSlug: String,
    val role: EnterpriseAdministratorRole,
    val userLogin: String
) {
  constructor(args: Map<String, Any>) : this(
      args["enterpriseSlug"] as String,
      args["role"] as EnterpriseAdministratorRole,
      args["userLogin"] as String
  )
}
data class QueryEnterpriseAdministratorInvitationByTokenArgs(
    val invitationToken: String
) {
  constructor(args: Map<String, Any>) : this(
      args["invitationToken"] as String
  )
}
data class QueryEnterpriseMemberInvitationArgs(
    val enterpriseSlug: String,
    val userLogin: String
) {
  constructor(args: Map<String, Any>) : this(
      args["enterpriseSlug"] as String,
      args["userLogin"] as String
  )
}
data class QueryEnterpriseMemberInvitationByTokenArgs(
    val invitationToken: String
) {
  constructor(args: Map<String, Any>) : this(
      args["invitationToken"] as String
  )
}
data class QueryLicenseArgs(
    val key: String
) {
  constructor(args: Map<String, Any>) : this(
      args["key"] as String
  )
}
data class QueryMarketplaceCategoriesArgs(
    val excludeEmpty: Boolean? = null,
    val excludeSubcategories: Boolean? = null,
    val includeCategories: Iterable<String>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["excludeEmpty"] as Boolean?,
      args["excludeSubcategories"] as Boolean?,
      args["includeCategories"] as Iterable<String>?
  )
}
data class QueryMarketplaceCategoryArgs(
    val slug: String,
    val useTopicAliases: Boolean? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["slug"] as String,
      args["useTopicAliases"] as Boolean?
  )
}
data class QueryMarketplaceListingArgs(
    val slug: String
) {
  constructor(args: Map<String, Any>) : this(
      args["slug"] as String
  )
}
data class QueryMarketplaceListingsArgs(
    val adminId: Any? = null,
    val after: String? = null,
    val allStates: Boolean? = null,
    val before: String? = null,
    val categorySlug: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val organizationId: Any? = null,
    val primaryCategoryOnly: Boolean? = false,
    val slugs: Iterable<String>? = null,
    val useTopicAliases: Boolean? = null,
    val viewerCanAdmin: Boolean? = null,
    val withFreeTrialsOnly: Boolean? = false
) {
  constructor(args: Map<String, Any>) : this(
      args["adminId"] as Any?,
      args["after"] as String?,
      args["allStates"] as Boolean?,
      args["before"] as String?,
      args["categorySlug"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["organizationId"] as Any?,
      args["primaryCategoryOnly"] as Boolean? ?: false,
      args["slugs"] as Iterable<String>?,
      args["useTopicAliases"] as Boolean?,
      args["viewerCanAdmin"] as Boolean?,
      args["withFreeTrialsOnly"] as Boolean? ?: false
  )
}
data class QueryNodeArgs(
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["id"] as Any
  )
}
data class QueryNodesArgs(
    val ids: Iterable<Any>
) {
  constructor(args: Map<String, Any>) : this(
      args["ids"] as Iterable<Any>
  )
}
data class QueryOrganizationArgs(
    val login: String
) {
  constructor(args: Map<String, Any>) : this(
      args["login"] as String
  )
}
data class QueryRateLimitArgs(
    val dryRun: Boolean? = false
) {
  constructor(args: Map<String, Any>) : this(
      args["dryRun"] as Boolean? ?: false
  )
}
data class QueryRepositoryArgs(
    val followRenames: Boolean? = true,
    val name: String,
    val owner: String
) {
  constructor(args: Map<String, Any>) : this(
      args["followRenames"] as Boolean? ?: true,
      args["name"] as String,
      args["owner"] as String
  )
}
data class QueryRepositoryOwnerArgs(
    val login: String
) {
  constructor(args: Map<String, Any>) : this(
      args["login"] as String
  )
}
data class QueryResourceArgs(
    val url: any
) {
  constructor(args: Map<String, Any>) : this(
      args["url"] as any
  )
}
data class QuerySearchArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val query: String,
    val type: SearchType
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["query"] as String,
      args["type"] as SearchType
  )
}
data class QuerySecurityAdvisoriesArgs(
    val after: String? = null,
    val before: String? = null,
    val classifications: Iterable<SecurityAdvisoryClassification>? = null,
    val epssPercentage: Float? = null,
    val epssPercentile: Float? = null,
    val first: Int? = null,
    val identifier: SecurityAdvisoryIdentifierFilterInput? = null,
    val last: Int? = null,
    val orderBy: SecurityAdvisoryOrderInput? = null,
    val publishedSince: any? = null,
    val updatedSince: any? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["classifications"] as Iterable<SecurityAdvisoryClassification>?,
      args["epssPercentage"] as Float?,
      args["epssPercentile"] as Float?,
      args["first"] as Int?,
      args["identifier"]?.let { SecurityAdvisoryIdentifierFilterInput(it as Map<String, Any>) },
      args["last"] as Int?,
      args["orderBy"]?.let { SecurityAdvisoryOrderInput(it as Map<String, Any>) },
      args["publishedSince"] as any?,
      args["updatedSince"] as any?
  )
}
data class QuerySecurityAdvisoryArgs(
    val ghsaId: String
) {
  constructor(args: Map<String, Any>) : this(
      args["ghsaId"] as String
  )
}
data class QuerySecurityVulnerabilitiesArgs(
    val after: String? = null,
    val before: String? = null,
    val classifications: Iterable<SecurityAdvisoryClassification>? = null,
    val ecosystem: SecurityAdvisoryEcosystem? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: SecurityVulnerabilityOrderInput? = null,
    val package: String? = null,
    val severities: Iterable<SecurityAdvisorySeverity>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["classifications"] as Iterable<SecurityAdvisoryClassification>?,
      args["ecosystem"] as SecurityAdvisoryEcosystem?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { SecurityVulnerabilityOrderInput(it as Map<String, Any>) },
      args["package"] as String?,
      args["severities"] as Iterable<SecurityAdvisorySeverity>?
  )
}
data class QuerySponsorablesArgs(
    val after: String? = null,
    val before: String? = null,
    val dependencyEcosystem: SecurityAdvisoryEcosystem? = null,
    val ecosystem: DependencyGraphEcosystem? = null,
    val first: Int? = null,
    val last: Int? = null,
    val onlyDependencies: Boolean? = false,
    val orderBy: SponsorableOrderInput? = null,
    val orgLoginForDependencies: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["dependencyEcosystem"] as SecurityAdvisoryEcosystem?,
      args["ecosystem"] as DependencyGraphEcosystem?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["onlyDependencies"] as Boolean? ?: false,
      args["orderBy"]?.let { SponsorableOrderInput(it as Map<String, Any>) },
      args["orgLoginForDependencies"] as String?
  )
}
data class QueryTopicArgs(
    val name: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String
  )
}
data class QueryUserArgs(
    val login: String
) {
  constructor(args: Map<String, Any>) : this(
      args["login"] as String
  )
}











/** Emojis that can be attached to Issues, Pull Requests and Comments. */
enum class ReactionContent(val label: String) {
      Confused("CONFUSED"),
      Eyes("EYES"),
      Heart("HEART"),
      Hooray("HOORAY"),
      Laugh("LAUGH"),
      Rocket("ROCKET"),
      ThumbsDown("THUMBS_DOWN"),
      ThumbsUp("THUMBS_UP");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ReactionContent? {
      return values().find { it.label == label }
    }
  }
}



data class ReactionGroupReactorsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class ReactionGroupUsersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

data class ReactionOrderInput(
    val direction: OrderDirection,
    val field: ReactionOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as ReactionOrderField
  )
}

/** A list of fields that reactions can be ordered by. */
enum class ReactionOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ReactionOrderField? {
      return values().find { it.label == label }
    }
  }
}







data class RefAssociatedPullRequestsArgs(
    val after: String? = null,
    val baseRefName: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val headRefName: String? = null,
    val labels: Iterable<String>? = null,
    val last: Int? = null,
    val orderBy: IssueOrderInput? = null,
    val states: Iterable<PullRequestState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["baseRefName"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["headRefName"] as String?,
      args["labels"] as Iterable<String>?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueOrderInput(it as Map<String, Any>) },
      args["states"] as Iterable<PullRequestState>?
  )
}
data class RefCompareArgs(
    val headRef: String
) {
  constructor(args: Map<String, Any>) : this(
      args["headRef"] as String
  )
}
data class RefRulesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: RepositoryRuleOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryRuleOrderInput(it as Map<String, Any>) }
  )
}







data class RefNameConditionTargetInput(
    val exclude: Iterable<String>,
    val include: Iterable<String>
) {
  constructor(args: Map<String, Any>) : this(
      args["exclude"] as Iterable<String>,
      args["include"] as Iterable<String>
  )
}

data class RefOrderInput(
    val direction: OrderDirection,
    val field: RefOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as RefOrderField
  )
}

/** Properties by which ref connections can be ordered. */
enum class RefOrderField(val label: String) {
      Alphabetical("ALPHABETICAL"),
      TagCommitDate("TAG_COMMIT_DATE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RefOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class RefUpdateInput(
    val afterOid: any,
    val beforeOid: any? = null,
    val force: Boolean? = false,
    val name: any
) {
  constructor(args: Map<String, Any>) : this(
      args["afterOid"] as any,
      args["beforeOid"] as any?,
      args["force"] as Boolean? ?: false,
      args["name"] as any
  )
}





data class RegenerateEnterpriseIdentityProviderRecoveryCodesInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any
  )
}



data class RegenerateVerifiableDomainTokenInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class RejectDeploymentsInput(
    val clientMutationId: String? = null,
    val comment: String? = """""".trimIndent(),
    val environmentIds: Iterable<Any>,
    val workflowRunId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["comment"] as String? ?: """""".trimIndent(),
      args["environmentIds"] as Iterable<Any>,
      args["workflowRunId"] as Any
  )
}



data class ReleaseMentionsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class ReleaseReactionsArgs(
    val after: String? = null,
    val before: String? = null,
    val content: ReactionContent? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReactionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["content"] as ReactionContent?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReactionOrderInput(it as Map<String, Any>) }
  )
}
data class ReleaseReleaseAssetsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val name: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["name"] as String?
  )
}
data class ReleaseShortDescriptionHtmlArgs(
    val limit: Int? = 200
) {
  constructor(args: Map<String, Any>) : this(
      args["limit"] as Int? ?: 200
  )
}











data class ReleaseOrderInput(
    val direction: OrderDirection,
    val field: ReleaseOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as ReleaseOrderField
  )
}

/** Properties by which release connections can be ordered. */
enum class ReleaseOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Name("NAME");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ReleaseOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class RemoveAssigneesFromAssignableInput(
    val assignableId: Any,
    val assigneeIds: Iterable<Any>,
    val clientMutationId: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["assignableId"] as Any,
      args["assigneeIds"] as Iterable<Any>,
      args["clientMutationId"] as String?
  )
}



data class RemoveEnterpriseAdminInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val login: String
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["login"] as String
  )
}



data class RemoveEnterpriseIdentityProviderInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any
  )
}



data class RemoveEnterpriseMemberInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val userId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["userId"] as Any
  )
}



data class RemoveEnterpriseOrganizationInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val organizationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["organizationId"] as Any
  )
}



data class RemoveEnterpriseSupportEntitlementInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val login: String
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["login"] as String
  )
}



data class RemoveLabelsFromLabelableInput(
    val clientMutationId: String? = null,
    val labelIds: Iterable<Any>,
    val labelableId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["labelIds"] as Iterable<Any>,
      args["labelableId"] as Any
  )
}



data class RemoveOutsideCollaboratorInput(
    val clientMutationId: String? = null,
    val organizationId: Any,
    val userId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["organizationId"] as Any,
      args["userId"] as Any
  )
}



data class RemoveReactionInput(
    val clientMutationId: String? = null,
    val content: ReactionContent,
    val subjectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["content"] as ReactionContent,
      args["subjectId"] as Any
  )
}



data class RemoveStarInput(
    val clientMutationId: String? = null,
    val starrableId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["starrableId"] as Any
  )
}



data class RemoveSubIssueInput(
    val clientMutationId: String? = null,
    val issueId: Any,
    val subIssueId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["issueId"] as Any,
      args["subIssueId"] as Any
  )
}



data class RemoveUpvoteInput(
    val clientMutationId: String? = null,
    val subjectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["subjectId"] as Any
  )
}









data class ReopenDiscussionInput(
    val clientMutationId: String? = null,
    val discussionId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["discussionId"] as Any
  )
}



data class ReopenIssueInput(
    val clientMutationId: String? = null,
    val issueId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["issueId"] as Any
  )
}



data class ReopenPullRequestInput(
    val clientMutationId: String? = null,
    val pullRequestId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["pullRequestId"] as Any
  )
}





data class ReorderEnvironmentInput(
    val clientMutationId: String? = null,
    val environmentId: Any,
    val position: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["environmentId"] as Any,
      args["position"] as Int
  )
}





/** The privacy of a repository */
enum class RepoAccessAuditEntryVisibility(val label: String) {
      Internal("INTERNAL"),
      Private("PRIVATE"),
      Public("PUBLIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepoAccessAuditEntryVisibility? {
      return values().find { it.label == label }
    }
  }
}



/** The privacy of a repository */
enum class RepoAddMemberAuditEntryVisibility(val label: String) {
      Internal("INTERNAL"),
      Private("PRIVATE"),
      Public("PUBLIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepoAddMemberAuditEntryVisibility? {
      return values().find { it.label == label }
    }
  }
}





/** The privacy of a repository */
enum class RepoArchivedAuditEntryVisibility(val label: String) {
      Internal("INTERNAL"),
      Private("PRIVATE"),
      Public("PUBLIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepoArchivedAuditEntryVisibility? {
      return values().find { it.label == label }
    }
  }
}



/** The merge options available for pull requests to this repository. */
enum class RepoChangeMergeSettingAuditEntryMergeType(val label: String) {
      Merge("MERGE"),
      Rebase("REBASE"),
      Squash("SQUASH");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepoChangeMergeSettingAuditEntryMergeType? {
      return values().find { it.label == label }
    }
  }
}























/** The privacy of a repository */
enum class RepoCreateAuditEntryVisibility(val label: String) {
      Internal("INTERNAL"),
      Private("PRIVATE"),
      Public("PUBLIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepoCreateAuditEntryVisibility? {
      return values().find { it.label == label }
    }
  }
}



/** The privacy of a repository */
enum class RepoDestroyAuditEntryVisibility(val label: String) {
      Internal("INTERNAL"),
      Private("PRIVATE"),
      Public("PUBLIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepoDestroyAuditEntryVisibility? {
      return values().find { it.label == label }
    }
  }
}



/** The privacy of a repository */
enum class RepoRemoveMemberAuditEntryVisibility(val label: String) {
      Internal("INTERNAL"),
      Private("PRIVATE"),
      Public("PUBLIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepoRemoveMemberAuditEntryVisibility? {
      return values().find { it.label == label }
    }
  }
}



/** The reasons a piece of content can be reported or minimized. */
enum class ReportedContentClassifiers(val label: String) {
      Abuse("ABUSE"),
      Duplicate("DUPLICATE"),
      OffTopic("OFF_TOPIC"),
      Outdated("OUTDATED"),
      Resolved("RESOLVED"),
      Spam("SPAM");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ReportedContentClassifiers? {
      return values().find { it.label == label }
    }
  }
}

data class RepositoryBranchProtectionRulesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class RepositoryCodeownersArgs(
    val refName: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["refName"] as String?
  )
}
data class RepositoryCollaboratorsArgs(
    val affiliation: CollaboratorAffiliation? = null,
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val login: String? = null,
    val query: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["affiliation"] as CollaboratorAffiliation?,
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["login"] as String?,
      args["query"] as String?
  )
}
data class RepositoryCommitCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class RepositoryDependencyGraphManifestsArgs(
    val after: String? = null,
    val before: String? = null,
    val dependenciesAfter: String? = null,
    val dependenciesFirst: Int? = null,
    val first: Int? = null,
    val last: Int? = null,
    val withDependencies: Boolean? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["dependenciesAfter"] as String?,
      args["dependenciesFirst"] as Int?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["withDependencies"] as Boolean?
  )
}
data class RepositoryDeployKeysArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class RepositoryDeploymentsArgs(
    val after: String? = null,
    val before: String? = null,
    val environments: Iterable<String>? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: DeploymentOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["environments"] as Iterable<String>?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { DeploymentOrderInput(it as Map<String, Any>) }
  )
}
data class RepositoryDiscussionArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class RepositoryDiscussionCategoriesArgs(
    val after: String? = null,
    val before: String? = null,
    val filterByAssignable: Boolean? = false,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["filterByAssignable"] as Boolean? ?: false,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class RepositoryDiscussionCategoryArgs(
    val slug: String
) {
  constructor(args: Map<String, Any>) : this(
      args["slug"] as String
  )
}
data class RepositoryDiscussionsArgs(
    val after: String? = null,
    val answered: Boolean? = null,
    val before: String? = null,
    val categoryId: Any? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: DiscussionOrderInput? = null,
    val states: Iterable<DiscussionState>? = listOf()
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["answered"] as Boolean?,
      args["before"] as String?,
      args["categoryId"] as Any?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { DiscussionOrderInput(it as Map<String, Any>) },
      args["states"] as Iterable<DiscussionState>? ?: listOf()
  )
}
data class RepositoryEnvironmentArgs(
    val name: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String
  )
}
data class RepositoryEnvironmentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val names: Iterable<String>? = listOf(),
    val orderBy: EnvironmentsInput? = null,
    val pinnedEnvironmentFilter: EnvironmentPinnedFilterField? = EnvironmentPinnedFilterField.ALL
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["names"] as Iterable<String>? ?: listOf(),
      args["orderBy"]?.let { EnvironmentsInput(it as Map<String, Any>) },
      args["pinnedEnvironmentFilter"] as EnvironmentPinnedFilterField? ?: EnvironmentPinnedFilterField.ALL
  )
}
data class RepositoryForksArgs(
    val affiliations: Iterable<RepositoryAffiliation>? = null,
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val hasIssuesEnabled: Boolean? = null,
    val isLocked: Boolean? = null,
    val last: Int? = null,
    val orderBy: RepositoryOrderInput? = null,
    val ownerAffiliations: Iterable<RepositoryAffiliation>? = listOf(Iterable<RepositoryAffiliation>.OWNER, Iterable<RepositoryAffiliation>.COLLABORATOR),
    val privacy: RepositoryPrivacy? = null,
    val visibility: RepositoryVisibility? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["affiliations"] as Iterable<RepositoryAffiliation>?,
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["hasIssuesEnabled"] as Boolean?,
      args["isLocked"] as Boolean?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryOrderInput(it as Map<String, Any>) },
      args["ownerAffiliations"] as Iterable<RepositoryAffiliation>? ?: listOf(Iterable<RepositoryAffiliation>.OWNER, Iterable<RepositoryAffiliation>.COLLABORATOR),
      args["privacy"] as RepositoryPrivacy?,
      args["visibility"] as RepositoryVisibility?
  )
}
data class RepositoryIssueArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class RepositoryIssueOrPullRequestArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class RepositoryIssuesArgs(
    val after: String? = null,
    val before: String? = null,
    val filterBy: IssueFiltersInput? = null,
    val first: Int? = null,
    val labels: Iterable<String>? = null,
    val last: Int? = null,
    val orderBy: IssueOrderInput? = null,
    val states: Iterable<IssueState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["filterBy"]?.let { IssueFiltersInput(it as Map<String, Any>) },
      args["first"] as Int?,
      args["labels"] as Iterable<String>?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueOrderInput(it as Map<String, Any>) },
      args["states"] as Iterable<IssueState>?
  )
}
data class RepositoryLabelArgs(
    val name: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String
  )
}
data class RepositoryLabelsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: LabelOrderInput? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { LabelOrderInput(it as Map<String, Any>) },
      args["query"] as String?
  )
}
data class RepositoryLanguagesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: LanguageOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { LanguageOrderInput(it as Map<String, Any>) }
  )
}
data class RepositoryMentionableUsersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val query: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["query"] as String?
  )
}
data class RepositoryMergeQueueArgs(
    val branch: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["branch"] as String?
  )
}
data class RepositoryMilestoneArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class RepositoryMilestonesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: MilestoneOrderInput? = null,
    val query: String? = null,
    val states: Iterable<MilestoneState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { MilestoneOrderInput(it as Map<String, Any>) },
      args["query"] as String?,
      args["states"] as Iterable<MilestoneState>?
  )
}
data class RepositoryObjectArgs(
    val expression: String? = null,
    val oid: any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["expression"] as String?,
      args["oid"] as any?
  )
}
data class RepositoryPackagesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val names: Iterable<String>? = null,
    val orderBy: PackageOrderInput? = null,
    val packageType: PackageType? = null,
    val repositoryId: Any? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["names"] as Iterable<String>?,
      args["orderBy"]?.let { PackageOrderInput(it as Map<String, Any>) },
      args["packageType"] as PackageType?,
      args["repositoryId"] as Any?
  )
}
data class RepositoryPinnedDiscussionsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class RepositoryPinnedEnvironmentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: PinnedEnvironmentOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { PinnedEnvironmentOrderInput(it as Map<String, Any>) }
  )
}
data class RepositoryPinnedIssuesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class RepositoryProjectArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class RepositoryProjectV2Args(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class RepositoryProjectsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectOrderInput? = null,
    val search: String? = null,
    val states: Iterable<ProjectState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectOrderInput(it as Map<String, Any>) },
      args["search"] as String?,
      args["states"] as Iterable<ProjectState>?
  )
}
data class RepositoryProjectsV2Args(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val minPermissionLevel: ProjectV2PermissionLevel? = ProjectV2PermissionLevel.READ,
    val orderBy: ProjectV2OrderInput? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["minPermissionLevel"] as ProjectV2PermissionLevel? ?: ProjectV2PermissionLevel.READ,
      args["orderBy"]?.let { ProjectV2OrderInput(it as Map<String, Any>) },
      args["query"] as String?
  )
}
data class RepositoryPullRequestArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class RepositoryPullRequestsArgs(
    val after: String? = null,
    val baseRefName: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val headRefName: String? = null,
    val labels: Iterable<String>? = null,
    val last: Int? = null,
    val orderBy: IssueOrderInput? = null,
    val states: Iterable<PullRequestState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["baseRefName"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["headRefName"] as String?,
      args["labels"] as Iterable<String>?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueOrderInput(it as Map<String, Any>) },
      args["states"] as Iterable<PullRequestState>?
  )
}
data class RepositoryRecentProjectsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class RepositoryRefArgs(
    val qualifiedName: String
) {
  constructor(args: Map<String, Any>) : this(
      args["qualifiedName"] as String
  )
}
data class RepositoryRefsArgs(
    val after: String? = null,
    val before: String? = null,
    val direction: OrderDirection? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: RefOrderInput? = null,
    val query: String? = null,
    val refPrefix: String
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["direction"] as OrderDirection?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { RefOrderInput(it as Map<String, Any>) },
      args["query"] as String?,
      args["refPrefix"] as String
  )
}
data class RepositoryReleaseArgs(
    val tagName: String
) {
  constructor(args: Map<String, Any>) : this(
      args["tagName"] as String
  )
}
data class RepositoryReleasesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReleaseOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReleaseOrderInput(it as Map<String, Any>) }
  )
}
data class RepositoryRepositoryTopicsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class RepositoryRulesetArgs(
    val databaseId: Int,
    val includeParents: Boolean? = true
) {
  constructor(args: Map<String, Any>) : this(
      args["databaseId"] as Int,
      args["includeParents"] as Boolean? ?: true
  )
}
data class RepositoryRulesetsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val includeParents: Boolean? = true,
    val last: Int? = null,
    val targets: Iterable<RepositoryRulesetTarget>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["includeParents"] as Boolean? ?: true,
      args["last"] as Int?,
      args["targets"] as Iterable<RepositoryRulesetTarget>?
  )
}
data class RepositoryShortDescriptionHtmlArgs(
    val limit: Int? = 200
) {
  constructor(args: Map<String, Any>) : this(
      args["limit"] as Int? ?: 200
  )
}
data class RepositoryStargazersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: StarOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { StarOrderInput(it as Map<String, Any>) }
  )
}
data class RepositorySubmodulesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class RepositoryVulnerabilityAlertArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class RepositoryVulnerabilityAlertsArgs(
    val after: String? = null,
    val before: String? = null,
    val dependencyScopes: Iterable<RepositoryVulnerabilityAlertDependencyScope>? = null,
    val first: Int? = null,
    val last: Int? = null,
    val states: Iterable<RepositoryVulnerabilityAlertState>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["dependencyScopes"] as Iterable<RepositoryVulnerabilityAlertDependencyScope>?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["states"] as Iterable<RepositoryVulnerabilityAlertState>?
  )
}
data class RepositoryWatchersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

/** The affiliation of a user to a repository */
enum class RepositoryAffiliation(val label: String) {
      Collaborator("COLLABORATOR"),
      OrganizationMember("ORGANIZATION_MEMBER"),
      Owner("OWNER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryAffiliation? {
      return values().find { it.label == label }
    }
  }
}













/** The reason a repository is listed as 'contributed'. */
enum class RepositoryContributionType(val label: String) {
      Commit("COMMIT"),
      Issue("ISSUE"),
      PullRequest("PULL_REQUEST"),
      PullRequestReview("PULL_REQUEST_REVIEW"),
      Repository("REPOSITORY");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryContributionType? {
      return values().find { it.label == label }
    }
  }
}





data class RepositoryIdConditionTargetInput(
    val repositoryIds: Iterable<Any>
) {
  constructor(args: Map<String, Any>) : this(
      args["repositoryIds"] as Iterable<Any>
  )
}



/** A repository interaction limit. */
enum class RepositoryInteractionLimit(val label: String) {
      CollaboratorsOnly("COLLABORATORS_ONLY"),
      ContributorsOnly("CONTRIBUTORS_ONLY"),
      ExistingUsers("EXISTING_USERS"),
      NoLimit("NO_LIMIT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryInteractionLimit? {
      return values().find { it.label == label }
    }
  }
}

/** The length for a repository interaction limit to be enabled for. */
enum class RepositoryInteractionLimitExpiry(val label: String) {
      OneDay("ONE_DAY"),
      OneMonth("ONE_MONTH"),
      OneWeek("ONE_WEEK"),
      SixMonths("SIX_MONTHS"),
      ThreeDays("THREE_DAYS");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryInteractionLimitExpiry? {
      return values().find { it.label == label }
    }
  }
}

/** Indicates where an interaction limit is configured. */
enum class RepositoryInteractionLimitOrigin(val label: String) {
      Organization("ORGANIZATION"),
      Repository("REPOSITORY"),
      User("USER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryInteractionLimitOrigin? {
      return values().find { it.label == label }
    }
  }
}







data class RepositoryInvitationOrderInput(
    val direction: OrderDirection,
    val field: RepositoryInvitationOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as RepositoryInvitationOrderField
  )
}

/** Properties by which repository invitation connections can be ordered. */
enum class RepositoryInvitationOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryInvitationOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible reasons a given repository could be in a locked state. */
enum class RepositoryLockReason(val label: String) {
      Billing("BILLING"),
      Migrating("MIGRATING"),
      Moving("MOVING"),
      Rename("RENAME"),
      TradeRestriction("TRADE_RESTRICTION"),
      TransferringOwnership("TRANSFERRING_OWNERSHIP");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryLockReason? {
      return values().find { it.label == label }
    }
  }
}







data class RepositoryMigrationOrderInput(
    val direction: RepositoryMigrationOrderDirection,
    val field: RepositoryMigrationOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as RepositoryMigrationOrderDirection,
      args["field"] as RepositoryMigrationOrderField
  )
}

/** Possible directions in which to order a list of repository migrations when provided an `orderBy` argument. */
enum class RepositoryMigrationOrderDirection(val label: String) {
      Asc("ASC"),
      Desc("DESC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryMigrationOrderDirection? {
      return values().find { it.label == label }
    }
  }
}

/** Properties by which repository migrations can be ordered. */
enum class RepositoryMigrationOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryMigrationOrderField? {
      return values().find { it.label == label }
    }
  }
}



data class RepositoryNameConditionTargetInput(
    val exclude: Iterable<String>,
    val include: Iterable<String>,
    val protected: Boolean? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["exclude"] as Iterable<String>,
      args["include"] as Iterable<String>,
      args["protected"] as Boolean?
  )
}

data class RepositoryOrderInput(
    val direction: OrderDirection,
    val field: RepositoryOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as RepositoryOrderField
  )
}

/** Properties by which repository connections can be ordered. */
enum class RepositoryOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Name("NAME"),
      PushedAt("PUSHED_AT"),
      Stargazers("STARGAZERS"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The access level to a repository */
enum class RepositoryPermission(val label: String) {
      Admin("ADMIN"),
      Maintain("MAINTAIN"),
      Read("READ"),
      Triage("TRIAGE"),
      Write("WRITE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryPermission? {
      return values().find { it.label == label }
    }
  }
}



/** The privacy of a repository */
enum class RepositoryPrivacy(val label: String) {
      Private("PRIVATE"),
      Public("PUBLIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryPrivacy? {
      return values().find { it.label == label }
    }
  }
}



data class RepositoryPropertyConditionTargetInput(
    val exclude: Iterable<PropertyTargetDefinitionInput>,
    val include: Iterable<PropertyTargetDefinitionInput>
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["exclude"]!!.let { exclude -> (exclude as List<Map<String, Any>>).map { PropertyTargetDefinitionInput(it) } },
      args["include"]!!.let { include -> (include as List<Map<String, Any>>).map { PropertyTargetDefinitionInput(it) } }
  )
}





data class RepositoryRuleConditionsInput(
    val refName: RefNameConditionTargetInput? = null,
    val repositoryId: RepositoryIdConditionTargetInput? = null,
    val repositoryName: RepositoryNameConditionTargetInput? = null,
    val repositoryProperty: RepositoryPropertyConditionTargetInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["refName"]?.let { RefNameConditionTargetInput(it as Map<String, Any>) },
      args["repositoryId"]?.let { RepositoryIdConditionTargetInput(it as Map<String, Any>) },
      args["repositoryName"]?.let { RepositoryNameConditionTargetInput(it as Map<String, Any>) },
      args["repositoryProperty"]?.let { RepositoryPropertyConditionTargetInput(it as Map<String, Any>) }
  )
}





data class RepositoryRuleInput(
    val id: Any? = null,
    val parameters: RuleParametersInput? = null,
    val type: RepositoryRuleType
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["id"] as Any?,
      args["parameters"]?.let { RuleParametersInput(it as Map<String, Any>) },
      args["type"] as RepositoryRuleType
  )
}

data class RepositoryRuleOrderInput(
    val direction: OrderDirection,
    val field: RepositoryRuleOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as RepositoryRuleOrderField
  )
}

/** Properties by which repository rule connections can be ordered. */
enum class RepositoryRuleOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Type("TYPE"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryRuleOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The rule types supported in rulesets */
enum class RepositoryRuleType(val label: String) {
      Authorization("AUTHORIZATION"),
      BranchNamePattern("BRANCH_NAME_PATTERN"),
      CodeScanning("CODE_SCANNING"),
      CommitterEmailPattern("COMMITTER_EMAIL_PATTERN"),
      CommitAuthorEmailPattern("COMMIT_AUTHOR_EMAIL_PATTERN"),
      CommitMessagePattern("COMMIT_MESSAGE_PATTERN"),
      Creation("CREATION"),
      Deletion("DELETION"),
      FileExtensionRestriction("FILE_EXTENSION_RESTRICTION"),
      FilePathRestriction("FILE_PATH_RESTRICTION"),
      LockBranch("LOCK_BRANCH"),
      MaxFilePathLength("MAX_FILE_PATH_LENGTH"),
      MaxFileSize("MAX_FILE_SIZE"),
      MaxRefUpdates("MAX_REF_UPDATES"),
      MergeQueue("MERGE_QUEUE"),
      MergeQueueLockedRef("MERGE_QUEUE_LOCKED_REF"),
      NonFastForward("NON_FAST_FORWARD"),
      PullRequest("PULL_REQUEST"),
      RequiredDeployments("REQUIRED_DEPLOYMENTS"),
      RequiredLinearHistory("REQUIRED_LINEAR_HISTORY"),
      RequiredReviewThreadResolution("REQUIRED_REVIEW_THREAD_RESOLUTION"),
      RequiredSignatures("REQUIRED_SIGNATURES"),
      RequiredStatusChecks("REQUIRED_STATUS_CHECKS"),
      RequiredWorkflowStatusChecks("REQUIRED_WORKFLOW_STATUS_CHECKS"),
      SecretScanning("SECRET_SCANNING"),
      Tag("TAG"),
      TagNamePattern("TAG_NAME_PATTERN"),
      Update("UPDATE"),
      Workflows("WORKFLOWS"),
      WorkflowUpdates("WORKFLOW_UPDATES");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryRuleType? {
      return values().find { it.label == label }
    }
  }
}

data class RepositoryRulesetBypassActorsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class RepositoryRulesetRulesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val type: RepositoryRuleType? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["type"] as RepositoryRuleType?
  )
}



/** The bypass mode for a specific actor on a ruleset. */
enum class RepositoryRulesetBypassActorBypassMode(val label: String) {
      Always("ALWAYS"),
      PullRequest("PULL_REQUEST");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryRulesetBypassActorBypassMode? {
      return values().find { it.label == label }
    }
  }
}





data class RepositoryRulesetBypassActorInput(
    val actorId: Any? = null,
    val bypassMode: RepositoryRulesetBypassActorBypassMode,
    val deployKey: Boolean? = null,
    val enterpriseOwner: Boolean? = null,
    val organizationAdmin: Boolean? = null,
    val repositoryRoleDatabaseId: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["actorId"] as Any?,
      args["bypassMode"] as RepositoryRulesetBypassActorBypassMode,
      args["deployKey"] as Boolean?,
      args["enterpriseOwner"] as Boolean?,
      args["organizationAdmin"] as Boolean?,
      args["repositoryRoleDatabaseId"] as Int?
  )
}





/** The targets supported for rulesets. */
enum class RepositoryRulesetTarget(val label: String) {
      Branch("BRANCH"),
      Push("PUSH"),
      Repository("REPOSITORY"),
      Tag("TAG");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryRulesetTarget? {
      return values().find { it.label == label }
    }
  }
}







/** The repository's visibility level. */
enum class RepositoryVisibility(val label: String) {
      Internal("INTERNAL"),
      Private("PRIVATE"),
      Public("PUBLIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryVisibility? {
      return values().find { it.label == label }
    }
  }
}









/** The possible scopes of an alert's dependency. */
enum class RepositoryVulnerabilityAlertDependencyScope(val label: String) {
      Development("DEVELOPMENT"),
      Runtime("RUNTIME");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryVulnerabilityAlertDependencyScope? {
      return values().find { it.label == label }
    }
  }
}



/** The possible states of an alert */
enum class RepositoryVulnerabilityAlertState(val label: String) {
      AutoDismissed("AUTO_DISMISSED"),
      Dismissed("DISMISSED"),
      Fixed("FIXED"),
      Open("OPEN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RepositoryVulnerabilityAlertState? {
      return values().find { it.label == label }
    }
  }
}

data class ReprioritizeSubIssueInput(
    val afterId: Any? = null,
    val beforeId: Any? = null,
    val clientMutationId: String? = null,
    val issueId: Any,
    val subIssueId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["afterId"] as Any?,
      args["beforeId"] as Any?,
      args["clientMutationId"] as String?,
      args["issueId"] as Any,
      args["subIssueId"] as Any
  )
}



data class RequestReviewsInput(
    val clientMutationId: String? = null,
    val pullRequestId: Any,
    val teamIds: Iterable<Any>? = null,
    val union: Boolean? = false,
    val userIds: Iterable<Any>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["pullRequestId"] as Any,
      args["teamIds"] as Iterable<Any>?,
      args["union"] as Boolean? ?: false,
      args["userIds"] as Iterable<Any>?
  )
}



/** The possible states that can be requested when creating a check run. */
enum class RequestableCheckStatusState(val label: String) {
      Completed("COMPLETED"),
      InProgress("IN_PROGRESS"),
      Pending("PENDING"),
      Queued("QUEUED"),
      Waiting("WAITING");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RequestableCheckStatusState? {
      return values().find { it.label == label }
    }
  }
}







data class RequiredDeploymentsParametersInput(
    val requiredDeploymentEnvironments: Iterable<String>
) {
  constructor(args: Map<String, Any>) : this(
      args["requiredDeploymentEnvironments"] as Iterable<String>
  )
}



data class RequiredStatusCheckInput(
    val appId: Any? = null,
    val context: String
) {
  constructor(args: Map<String, Any>) : this(
      args["appId"] as Any?,
      args["context"] as String
  )
}



data class RequiredStatusChecksParametersInput(
    val doNotEnforceOnCreate: Boolean? = null,
    val requiredStatusChecks: Iterable<StatusCheckConfigurationInput>,
    val strictRequiredStatusChecksPolicy: Boolean
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["doNotEnforceOnCreate"] as Boolean?,
      args["requiredStatusChecks"]!!.let { requiredStatusChecks -> (requiredStatusChecks as List<Map<String, Any>>).map { StatusCheckConfigurationInput(it) } },
      args["strictRequiredStatusChecksPolicy"] as Boolean
  )
}

data class RerequestCheckSuiteInput(
    val checkSuiteId: Any,
    val clientMutationId: String? = null,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["checkSuiteId"] as Any,
      args["clientMutationId"] as String?,
      args["repositoryId"] as Any
  )
}



data class ResolveReviewThreadInput(
    val clientMutationId: String? = null,
    val threadId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["threadId"] as Any
  )
}





data class RetireSponsorsTierInput(
    val clientMutationId: String? = null,
    val tierId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["tierId"] as Any
  )
}



data class RevertPullRequestInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val draft: Boolean? = false,
    val pullRequestId: Any,
    val title: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["draft"] as Boolean? ?: false,
      args["pullRequestId"] as Any,
      args["title"] as String?
  )
}























data class RevokeEnterpriseOrganizationsMigratorRoleInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val login: String
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["login"] as String
  )
}

data class RevokeEnterpriseOrganizationsMigratorRolePayloadOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

data class RevokeMigratorRoleInput(
    val actor: String,
    val actorType: ActorType,
    val clientMutationId: String? = null,
    val organizationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["actor"] as String,
      args["actorType"] as ActorType,
      args["clientMutationId"] as String?,
      args["organizationId"] as Any
  )
}



/** Possible roles a user may have in relation to an organization. */
enum class RoleInOrganization(val label: String) {
      DirectMember("DIRECT_MEMBER"),
      Owner("OWNER"),
      Unaffiliated("UNAFFILIATED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RoleInOrganization? {
      return values().find { it.label == label }
    }
  }
}

/** The level of enforcement for a rule or ruleset. */
enum class RuleEnforcement(val label: String) {
      Active("ACTIVE"),
      Disabled("DISABLED"),
      Evaluate("EVALUATE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): RuleEnforcement? {
      return values().find { it.label == label }
    }
  }
}

data class RuleParametersInput(
    val branchNamePattern: BranchNamePatternParametersInput? = null,
    val codeScanning: CodeScanningParametersInput? = null,
    val commitAuthorEmailPattern: CommitAuthorEmailPatternParametersInput? = null,
    val commitMessagePattern: CommitMessagePatternParametersInput? = null,
    val committerEmailPattern: CommitterEmailPatternParametersInput? = null,
    val fileExtensionRestriction: FileExtensionRestrictionParametersInput? = null,
    val filePathRestriction: FilePathRestrictionParametersInput? = null,
    val maxFilePathLength: MaxFilePathLengthParametersInput? = null,
    val maxFileSize: MaxFileSizeParametersInput? = null,
    val mergeQueue: MergeQueueParametersInput? = null,
    val pullRequest: PullRequestParametersInput? = null,
    val requiredDeployments: RequiredDeploymentsParametersInput? = null,
    val requiredStatusChecks: RequiredStatusChecksParametersInput? = null,
    val tagNamePattern: TagNamePatternParametersInput? = null,
    val update: UpdateParametersInput? = null,
    val workflows: WorkflowsParametersInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["branchNamePattern"]?.let { BranchNamePatternParametersInput(it as Map<String, Any>) },
      args["codeScanning"]?.let { CodeScanningParametersInput(it as Map<String, Any>) },
      args["commitAuthorEmailPattern"]?.let { CommitAuthorEmailPatternParametersInput(it as Map<String, Any>) },
      args["commitMessagePattern"]?.let { CommitMessagePatternParametersInput(it as Map<String, Any>) },
      args["committerEmailPattern"]?.let { CommitterEmailPatternParametersInput(it as Map<String, Any>) },
      args["fileExtensionRestriction"]?.let { FileExtensionRestrictionParametersInput(it as Map<String, Any>) },
      args["filePathRestriction"]?.let { FilePathRestrictionParametersInput(it as Map<String, Any>) },
      args["maxFilePathLength"]?.let { MaxFilePathLengthParametersInput(it as Map<String, Any>) },
      args["maxFileSize"]?.let { MaxFileSizeParametersInput(it as Map<String, Any>) },
      args["mergeQueue"]?.let { MergeQueueParametersInput(it as Map<String, Any>) },
      args["pullRequest"]?.let { PullRequestParametersInput(it as Map<String, Any>) },
      args["requiredDeployments"]?.let { RequiredDeploymentsParametersInput(it as Map<String, Any>) },
      args["requiredStatusChecks"]?.let { RequiredStatusChecksParametersInput(it as Map<String, Any>) },
      args["tagNamePattern"]?.let { TagNamePatternParametersInput(it as Map<String, Any>) },
      args["update"]?.let { UpdateParametersInput(it as Map<String, Any>) },
      args["workflows"]?.let { WorkflowsParametersInput(it as Map<String, Any>) }
  )
}

/** The possible digest algorithms used to sign SAML requests for an identity provider. */
enum class SamlDigestAlgorithm(val label: String) {
      Sha1("SHA1"),
      Sha256("SHA256"),
      Sha384("SHA384"),
      Sha512("SHA512");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SamlDigestAlgorithm? {
      return values().find { it.label == label }
    }
  }
}

/** The possible signature algorithms used to sign SAML requests for a Identity Provider. */
enum class SamlSignatureAlgorithm(val label: String) {
      RsaSha1("RSA_SHA1"),
      RsaSha256("RSA_SHA256"),
      RsaSha384("RSA_SHA384"),
      RsaSha512("RSA_SHA512");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SamlSignatureAlgorithm? {
      return values().find { it.label == label }
    }
  }
}







data class SavedReplyOrderInput(
    val direction: OrderDirection,
    val field: SavedReplyOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as SavedReplyOrderField
  )
}

/** Properties by which saved reply connections can be ordered. */
enum class SavedReplyOrderField(val label: String) {
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SavedReplyOrderField? {
      return values().find { it.label == label }
    }
  }
}





/** Represents the individual results of a search. */
enum class SearchType(val label: String) {
      Discussion("DISCUSSION"),
      Issue("ISSUE"),
      Repository("REPOSITORY"),
      User("USER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SearchType? {
      return values().find { it.label == label }
    }
  }
}

data class SecurityAdvisoryCwesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class SecurityAdvisoryVulnerabilitiesArgs(
    val after: String? = null,
    val before: String? = null,
    val classifications: Iterable<SecurityAdvisoryClassification>? = null,
    val ecosystem: SecurityAdvisoryEcosystem? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: SecurityVulnerabilityOrderInput? = null,
    val package: String? = null,
    val severities: Iterable<SecurityAdvisorySeverity>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["classifications"] as Iterable<SecurityAdvisoryClassification>?,
      args["ecosystem"] as SecurityAdvisoryEcosystem?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { SecurityVulnerabilityOrderInput(it as Map<String, Any>) },
      args["package"] as String?,
      args["severities"] as Iterable<SecurityAdvisorySeverity>?
  )
}

/** Classification of the advisory. */
enum class SecurityAdvisoryClassification(val label: String) {
      General("GENERAL"),
      Malware("MALWARE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SecurityAdvisoryClassification? {
      return values().find { it.label == label }
    }
  }
}



/** The possible ecosystems of a security vulnerability's package. */
enum class SecurityAdvisoryEcosystem(val label: String) {
      Actions("ACTIONS"),
      Composer("COMPOSER"),
      Erlang("ERLANG"),
      Go("GO"),
      Maven("MAVEN"),
      Npm("NPM"),
      Nuget("NUGET"),
      Pip("PIP"),
      Pub("PUB"),
      Rubygems("RUBYGEMS"),
      Rust("RUST"),
      Swift("SWIFT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SecurityAdvisoryEcosystem? {
      return values().find { it.label == label }
    }
  }
}





data class SecurityAdvisoryIdentifierFilterInput(
    val type: SecurityAdvisoryIdentifierType,
    val value: String
) {
  constructor(args: Map<String, Any>) : this(
      args["type"] as SecurityAdvisoryIdentifierType,
      args["value"] as String
  )
}

/** Identifier formats available for advisories. */
enum class SecurityAdvisoryIdentifierType(val label: String) {
      Cve("CVE"),
      Ghsa("GHSA");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SecurityAdvisoryIdentifierType? {
      return values().find { it.label == label }
    }
  }
}

data class SecurityAdvisoryOrderInput(
    val direction: OrderDirection,
    val field: SecurityAdvisoryOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as SecurityAdvisoryOrderField
  )
}

/** Properties by which security advisory connections can be ordered. */
enum class SecurityAdvisoryOrderField(val label: String) {
      EpssPercentage("EPSS_PERCENTAGE"),
      EpssPercentile("EPSS_PERCENTILE"),
      PublishedAt("PUBLISHED_AT"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SecurityAdvisoryOrderField? {
      return values().find { it.label == label }
    }
  }
}







/** Severity of the vulnerability. */
enum class SecurityAdvisorySeverity(val label: String) {
      Critical("CRITICAL"),
      High("HIGH"),
      Low("LOW"),
      Moderate("MODERATE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SecurityAdvisorySeverity? {
      return values().find { it.label == label }
    }
  }
}







data class SecurityVulnerabilityOrderInput(
    val direction: OrderDirection,
    val field: SecurityVulnerabilityOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as SecurityVulnerabilityOrderField
  )
}

/** Properties by which security vulnerability connections can be ordered. */
enum class SecurityVulnerabilityOrderField(val label: String) {
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SecurityVulnerabilityOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class SetEnterpriseIdentityProviderInput(
    val clientMutationId: String? = null,
    val digestMethod: SamlDigestAlgorithm,
    val enterpriseId: Any,
    val idpCertificate: String,
    val issuer: String? = null,
    val signatureMethod: SamlSignatureAlgorithm,
    val ssoUrl: any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["digestMethod"] as SamlDigestAlgorithm,
      args["enterpriseId"] as Any,
      args["idpCertificate"] as String,
      args["issuer"] as String?,
      args["signatureMethod"] as SamlSignatureAlgorithm,
      args["ssoUrl"] as any
  )
}



data class SetOrganizationInteractionLimitInput(
    val clientMutationId: String? = null,
    val expiry: RepositoryInteractionLimitExpiry? = null,
    val limit: RepositoryInteractionLimit,
    val organizationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["expiry"] as RepositoryInteractionLimitExpiry?,
      args["limit"] as RepositoryInteractionLimit,
      args["organizationId"] as Any
  )
}



data class SetRepositoryInteractionLimitInput(
    val clientMutationId: String? = null,
    val expiry: RepositoryInteractionLimitExpiry? = null,
    val limit: RepositoryInteractionLimit,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["expiry"] as RepositoryInteractionLimitExpiry?,
      args["limit"] as RepositoryInteractionLimit,
      args["repositoryId"] as Any
  )
}



data class SetUserInteractionLimitInput(
    val clientMutationId: String? = null,
    val expiry: RepositoryInteractionLimitExpiry? = null,
    val limit: RepositoryInteractionLimit,
    val userId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["expiry"] as RepositoryInteractionLimitExpiry?,
      args["limit"] as RepositoryInteractionLimit,
      args["userId"] as Any
  )
}











/** Software or company that hosts social media accounts. */
enum class SocialAccountProvider(val label: String) {
      Bluesky("BLUESKY"),
      Facebook("FACEBOOK"),
      Generic("GENERIC"),
      Hometown("HOMETOWN"),
      Instagram("INSTAGRAM"),
      Linkedin("LINKEDIN"),
      Mastodon("MASTODON"),
      Npm("NPM"),
      Reddit("REDDIT"),
      Twitch("TWITCH"),
      Twitter("TWITTER"),
      Youtube("YOUTUBE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SocialAccountProvider? {
      return values().find { it.label == label }
    }
  }
}







data class SponsorAndLifetimeValueOrderInput(
    val direction: OrderDirection,
    val field: SponsorAndLifetimeValueOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as SponsorAndLifetimeValueOrderField
  )
}

/** Properties by which sponsor and lifetime value connections can be ordered. */
enum class SponsorAndLifetimeValueOrderField(val label: String) {
      LifetimeValue("LIFETIME_VALUE"),
      SponsorLogin("SPONSOR_LOGIN"),
      SponsorRelevance("SPONSOR_RELEVANCE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorAndLifetimeValueOrderField? {
      return values().find { it.label == label }
    }
  }
}





data class SponsorOrderInput(
    val direction: OrderDirection,
    val field: SponsorOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as SponsorOrderField
  )
}

/** Properties by which sponsor connections can be ordered. */
enum class SponsorOrderField(val label: String) {
      Login("LOGIN"),
      Relevance("RELEVANCE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorOrderField? {
      return values().find { it.label == label }
    }
  }
}





data class SponsorableOrderInput(
    val direction: OrderDirection,
    val field: SponsorableOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as SponsorableOrderField
  )
}

/** Properties by which sponsorable connections can be ordered. */
enum class SponsorableOrderField(val label: String) {
      Login("LOGIN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorableOrderField? {
      return values().find { it.label == label }
    }
  }
}



/** The possible actions that GitHub Sponsors activities can represent. */
enum class SponsorsActivityAction(val label: String) {
      CancelledSponsorship("CANCELLED_SPONSORSHIP"),
      NewSponsorship("NEW_SPONSORSHIP"),
      PendingChange("PENDING_CHANGE"),
      Refund("REFUND"),
      SponsorMatchDisabled("SPONSOR_MATCH_DISABLED"),
      TierChange("TIER_CHANGE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorsActivityAction? {
      return values().find { it.label == label }
    }
  }
}





data class SponsorsActivityOrderInput(
    val direction: OrderDirection,
    val field: SponsorsActivityOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as SponsorsActivityOrderField
  )
}

/** Properties by which GitHub Sponsors activity connections can be ordered. */
enum class SponsorsActivityOrderField(val label: String) {
      Timestamp("TIMESTAMP");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorsActivityOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible time periods for which Sponsors activities can be requested. */
enum class SponsorsActivityPeriod(val label: String) {
      All("ALL"),
      Day("DAY"),
      Month("MONTH"),
      Week("WEEK");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorsActivityPeriod? {
      return values().find { it.label == label }
    }
  }
}

/** Represents countries or regions for billing and residence for a GitHub Sponsors profile. */
enum class SponsorsCountryOrRegionCode(val label: String) {
      Ad("AD"),
      Ae("AE"),
      Af("AF"),
      Ag("AG"),
      Ai("AI"),
      Al("AL"),
      Am("AM"),
      Ao("AO"),
      Aq("AQ"),
      Ar("AR"),
      As("AS"),
      At("AT"),
      Au("AU"),
      Aw("AW"),
      Ax("AX"),
      Az("AZ"),
      Ba("BA"),
      Bb("BB"),
      Bd("BD"),
      Be("BE"),
      Bf("BF"),
      Bg("BG"),
      Bh("BH"),
      Bi("BI"),
      Bj("BJ"),
      Bl("BL"),
      Bm("BM"),
      Bn("BN"),
      Bo("BO"),
      Bq("BQ"),
      Br("BR"),
      Bs("BS"),
      Bt("BT"),
      Bv("BV"),
      Bw("BW"),
      By("BY"),
      Bz("BZ"),
      Ca("CA"),
      Cc("CC"),
      Cd("CD"),
      Cf("CF"),
      Cg("CG"),
      Ch("CH"),
      Ci("CI"),
      Ck("CK"),
      Cl("CL"),
      Cm("CM"),
      Cn("CN"),
      Co("CO"),
      Cr("CR"),
      Cv("CV"),
      Cw("CW"),
      Cx("CX"),
      Cy("CY"),
      Cz("CZ"),
      De("DE"),
      Dj("DJ"),
      Dk("DK"),
      Dm("DM"),
      Do("DO"),
      Dz("DZ"),
      Ec("EC"),
      Ee("EE"),
      Eg("EG"),
      Eh("EH"),
      Er("ER"),
      Es("ES"),
      Et("ET"),
      Fi("FI"),
      Fj("FJ"),
      Fk("FK"),
      Fm("FM"),
      Fo("FO"),
      Fr("FR"),
      Ga("GA"),
      Gb("GB"),
      Gd("GD"),
      Ge("GE"),
      Gf("GF"),
      Gg("GG"),
      Gh("GH"),
      Gi("GI"),
      Gl("GL"),
      Gm("GM"),
      Gn("GN"),
      Gp("GP"),
      Gq("GQ"),
      Gr("GR"),
      Gs("GS"),
      Gt("GT"),
      Gu("GU"),
      Gw("GW"),
      Gy("GY"),
      Hk("HK"),
      Hm("HM"),
      Hn("HN"),
      Hr("HR"),
      Ht("HT"),
      Hu("HU"),
      Id("ID"),
      Ie("IE"),
      Il("IL"),
      Im("IM"),
      In("IN"),
      Io("IO"),
      Iq("IQ"),
      Ir("IR"),
      Is("IS"),
      It("IT"),
      Je("JE"),
      Jm("JM"),
      Jo("JO"),
      Jp("JP"),
      Ke("KE"),
      Kg("KG"),
      Kh("KH"),
      Ki("KI"),
      Km("KM"),
      Kn("KN"),
      Kr("KR"),
      Kw("KW"),
      Ky("KY"),
      Kz("KZ"),
      La("LA"),
      Lb("LB"),
      Lc("LC"),
      Li("LI"),
      Lk("LK"),
      Lr("LR"),
      Ls("LS"),
      Lt("LT"),
      Lu("LU"),
      Lv("LV"),
      Ly("LY"),
      Ma("MA"),
      Mc("MC"),
      Md("MD"),
      Me("ME"),
      Mf("MF"),
      Mg("MG"),
      Mh("MH"),
      Mk("MK"),
      Ml("ML"),
      Mm("MM"),
      Mn("MN"),
      Mo("MO"),
      Mp("MP"),
      Mq("MQ"),
      Mr("MR"),
      Ms("MS"),
      Mt("MT"),
      Mu("MU"),
      Mv("MV"),
      Mw("MW"),
      Mx("MX"),
      My("MY"),
      Mz("MZ"),
      Na("NA"),
      Nc("NC"),
      Ne("NE"),
      Nf("NF"),
      Ng("NG"),
      Ni("NI"),
      Nl("NL"),
      No("NO"),
      Np("NP"),
      Nr("NR"),
      Nu("NU"),
      Nz("NZ"),
      Om("OM"),
      Pa("PA"),
      Pe("PE"),
      Pf("PF"),
      Pg("PG"),
      Ph("PH"),
      Pk("PK"),
      Pl("PL"),
      Pm("PM"),
      Pn("PN"),
      Pr("PR"),
      Ps("PS"),
      Pt("PT"),
      Pw("PW"),
      Py("PY"),
      Qa("QA"),
      Re("RE"),
      Ro("RO"),
      Rs("RS"),
      Ru("RU"),
      Rw("RW"),
      Sa("SA"),
      Sb("SB"),
      Sc("SC"),
      Sd("SD"),
      Se("SE"),
      Sg("SG"),
      Sh("SH"),
      Si("SI"),
      Sj("SJ"),
      Sk("SK"),
      Sl("SL"),
      Sm("SM"),
      Sn("SN"),
      So("SO"),
      Sr("SR"),
      Ss("SS"),
      St("ST"),
      Sv("SV"),
      Sx("SX"),
      Sz("SZ"),
      Tc("TC"),
      Td("TD"),
      Tf("TF"),
      Tg("TG"),
      Th("TH"),
      Tj("TJ"),
      Tk("TK"),
      Tl("TL"),
      Tm("TM"),
      Tn("TN"),
      To("TO"),
      Tr("TR"),
      Tt("TT"),
      Tv("TV"),
      Tw("TW"),
      Tz("TZ"),
      Ua("UA"),
      Ug("UG"),
      Um("UM"),
      Us("US"),
      Uy("UY"),
      Uz("UZ"),
      Va("VA"),
      Vc("VC"),
      Ve("VE"),
      Vg("VG"),
      Vi("VI"),
      Vn("VN"),
      Vu("VU"),
      Wf("WF"),
      Ws("WS"),
      Ye("YE"),
      Yt("YT"),
      Za("ZA"),
      Zm("ZM"),
      Zw("ZW");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorsCountryOrRegionCode? {
      return values().find { it.label == label }
    }
  }
}



/** The different kinds of goals a GitHub Sponsors member can have. */
enum class SponsorsGoalKind(val label: String) {
      MonthlySponsorshipAmount("MONTHLY_SPONSORSHIP_AMOUNT"),
      TotalSponsorsCount("TOTAL_SPONSORS_COUNT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorsGoalKind? {
      return values().find { it.label == label }
    }
  }
}

data class SponsorsListingFeaturedItemsArgs(
    val featureableTypes: Iterable<SponsorsListingFeaturedItemFeatureableType>? = listOf(Iterable<SponsorsListingFeaturedItemFeatureableType>.REPOSITORY, Iterable<SponsorsListingFeaturedItemFeatureableType>.USER)
) {
  constructor(args: Map<String, Any>) : this(
      args["featureableTypes"] as Iterable<SponsorsListingFeaturedItemFeatureableType>? ?: listOf(Iterable<SponsorsListingFeaturedItemFeatureableType>.REPOSITORY, Iterable<SponsorsListingFeaturedItemFeatureableType>.USER)
  )
}
data class SponsorsListingTiersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val includeUnpublished: Boolean? = false,
    val last: Int? = null,
    val orderBy: SponsorsTierOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["includeUnpublished"] as Boolean? ?: false,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorsTierOrderInput(it as Map<String, Any>) }
  )
}



/** The different kinds of records that can be featured on a GitHub Sponsors profile page. */
enum class SponsorsListingFeaturedItemFeatureableType(val label: String) {
      Repository("REPOSITORY"),
      User("USER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorsListingFeaturedItemFeatureableType? {
      return values().find { it.label == label }
    }
  }
}



data class SponsorsTierAdminInfoSponsorshipsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val includePrivate: Boolean? = false,
    val last: Int? = null,
    val orderBy: SponsorshipOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["includePrivate"] as Boolean? ?: false,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorshipOrderInput(it as Map<String, Any>) }
  )
}





data class SponsorsTierOrderInput(
    val direction: OrderDirection,
    val field: SponsorsTierOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as SponsorsTierOrderField
  )
}

/** Properties by which Sponsors tiers connections can be ordered. */
enum class SponsorsTierOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      MonthlyPriceInCents("MONTHLY_PRICE_IN_CENTS");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorsTierOrderField? {
      return values().find { it.label == label }
    }
  }
}













data class SponsorshipNewsletterOrderInput(
    val direction: OrderDirection,
    val field: SponsorshipNewsletterOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as SponsorshipNewsletterOrderField
  )
}

/** Properties by which sponsorship update connections can be ordered. */
enum class SponsorshipNewsletterOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorshipNewsletterOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class SponsorshipOrderInput(
    val direction: OrderDirection,
    val field: SponsorshipOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as SponsorshipOrderField
  )
}

/** Properties by which sponsorship connections can be ordered. */
enum class SponsorshipOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorshipOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** How payment was made for funding a GitHub Sponsors sponsorship. */
enum class SponsorshipPaymentSource(val label: String) {
      Github("GITHUB"),
      Patreon("PATREON");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorshipPaymentSource? {
      return values().find { it.label == label }
    }
  }
}

/** The privacy of a sponsorship */
enum class SponsorshipPrivacy(val label: String) {
      Private("PRIVATE"),
      Public("PUBLIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SponsorshipPrivacy? {
      return values().find { it.label == label }
    }
  }
}

/** The possible default commit messages for squash merges. */
enum class SquashMergeCommitMessage(val label: String) {
      Blank("BLANK"),
      CommitMessages("COMMIT_MESSAGES"),
      PrBody("PR_BODY");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SquashMergeCommitMessage? {
      return values().find { it.label == label }
    }
  }
}

/** The possible default commit titles for squash merges. */
enum class SquashMergeCommitTitle(val label: String) {
      CommitOrPrTitle("COMMIT_OR_PR_TITLE"),
      PrTitle("PR_TITLE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SquashMergeCommitTitle? {
      return values().find { it.label == label }
    }
  }
}



data class StarOrderInput(
    val direction: OrderDirection,
    val field: StarOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as StarOrderField
  )
}

/** Properties by which star connections can be ordered. */
enum class StarOrderField(val label: String) {
      StarredAt("STARRED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): StarOrderField? {
      return values().find { it.label == label }
    }
  }
}









data class StartOrganizationMigrationInput(
    val clientMutationId: String? = null,
    val sourceAccessToken: String,
    val sourceOrgUrl: any,
    val targetEnterpriseId: Any,
    val targetOrgName: String
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["sourceAccessToken"] as String,
      args["sourceOrgUrl"] as any,
      args["targetEnterpriseId"] as Any,
      args["targetOrgName"] as String
  )
}



data class StartRepositoryMigrationInput(
    val accessToken: String? = null,
    val clientMutationId: String? = null,
    val continueOnError: Boolean? = null,
    val gitArchiveUrl: String? = null,
    val githubPat: String? = null,
    val lockSource: Boolean? = null,
    val metadataArchiveUrl: String? = null,
    val ownerId: Any,
    val repositoryName: String,
    val skipReleases: Boolean? = null,
    val sourceId: Any,
    val sourceRepositoryUrl: any,
    val targetRepoVisibility: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["accessToken"] as String?,
      args["clientMutationId"] as String?,
      args["continueOnError"] as Boolean?,
      args["gitArchiveUrl"] as String?,
      args["githubPat"] as String?,
      args["lockSource"] as Boolean?,
      args["metadataArchiveUrl"] as String?,
      args["ownerId"] as Any,
      args["repositoryName"] as String,
      args["skipReleases"] as Boolean?,
      args["sourceId"] as Any,
      args["sourceRepositoryUrl"] as any,
      args["targetRepoVisibility"] as String?
  )
}



data class StatusCombinedContextsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class StatusContextArgs(
    val name: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String
  )
}



data class StatusCheckConfigurationInput(
    val context: String,
    val integrationId: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["context"] as String,
      args["integrationId"] as Int?
  )
}

data class StatusCheckRollupContextsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





data class StatusContextAvatarUrlArgs(
    val size: Int? = 40
) {
  constructor(args: Map<String, Any>) : this(
      args["size"] as Int? ?: 40
  )
}
data class StatusContextIsRequiredArgs(
    val pullRequestId: Any? = null,
    val pullRequestNumber: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["pullRequestId"] as Any?,
      args["pullRequestNumber"] as Int?
  )
}



/** The possible commit status states. */
enum class StatusState(val label: String) {
      Error("ERROR"),
      Expected("EXPECTED"),
      Failure("FAILURE"),
      Pending("PENDING"),
      Success("SUCCESS");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): StatusState? {
      return values().find { it.label == label }
    }
  }
}









data class SubmitPullRequestReviewInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val event: PullRequestReviewEvent,
    val pullRequestId: Any? = null,
    val pullRequestReviewId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["event"] as PullRequestReviewEvent,
      args["pullRequestId"] as Any?,
      args["pullRequestReviewId"] as Any?
  )
}











/** The possible states of a subscription. */
enum class SubscriptionState(val label: String) {
      Ignored("IGNORED"),
      Subscribed("SUBSCRIBED"),
      Unsubscribed("UNSUBSCRIBED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): SubscriptionState? {
      return values().find { it.label == label }
    }
  }
}







data class TagNamePatternParametersInput(
    val name: String? = null,
    val negate: Boolean? = null,
    val operator: String,
    val pattern: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String?,
      args["negate"] as Boolean?,
      args["operator"] as String,
      args["pattern"] as String
  )
}

data class TeamAncestorsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class TeamAvatarUrlArgs(
    val size: Int? = 400
) {
  constructor(args: Map<String, Any>) : this(
      args["size"] as Int? ?: 400
  )
}
data class TeamChildTeamsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val immediateOnly: Boolean? = true,
    val last: Int? = null,
    val orderBy: TeamOrderInput? = null,
    val userLogins: Iterable<String>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["immediateOnly"] as Boolean? ?: true,
      args["last"] as Int?,
      args["orderBy"]?.let { TeamOrderInput(it as Map<String, Any>) },
      args["userLogins"] as Iterable<String>?
  )
}
data class TeamDiscussionArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class TeamDiscussionsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val isPinned: Boolean? = null,
    val last: Int? = null,
    val orderBy: TeamDiscussionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["isPinned"] as Boolean?,
      args["last"] as Int?,
      args["orderBy"]?.let { TeamDiscussionOrderInput(it as Map<String, Any>) }
  )
}
data class TeamInvitationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class TeamMemberStatusesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: UserStatusOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { UserStatusOrderInput(it as Map<String, Any>) }
  )
}
data class TeamMembersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val membership: TeamMembershipType? = TeamMembershipType.ALL,
    val orderBy: TeamMemberOrderInput? = null,
    val query: String? = null,
    val role: TeamMemberRole? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["membership"] as TeamMembershipType? ?: TeamMembershipType.ALL,
      args["orderBy"]?.let { TeamMemberOrderInput(it as Map<String, Any>) },
      args["query"] as String?,
      args["role"] as TeamMemberRole?
  )
}
data class TeamProjectV2Args(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class TeamProjectsV2Args(
    val after: String? = null,
    val before: String? = null,
    val filterBy: ProjectV2FiltersInput? = null,
    val first: Int? = null,
    val last: Int? = null,
    val minPermissionLevel: ProjectV2PermissionLevel? = ProjectV2PermissionLevel.READ,
    val orderBy: ProjectV2OrderInput? = null,
    val query: String? = """""".trimIndent()
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["filterBy"]?.let { ProjectV2FiltersInput(it as Map<String, Any>) },
      args["first"] as Int?,
      args["last"] as Int?,
      args["minPermissionLevel"] as ProjectV2PermissionLevel? ?: ProjectV2PermissionLevel.READ,
      args["orderBy"]?.let { ProjectV2OrderInput(it as Map<String, Any>) },
      args["query"] as String? ?: """""".trimIndent()
  )
}
data class TeamRepositoriesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: TeamRepositoryOrderInput? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { TeamRepositoryOrderInput(it as Map<String, Any>) },
      args["query"] as String?
  )
}









data class TeamDiscussionCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val fromComment: Int? = null,
    val last: Int? = null,
    val orderBy: TeamDiscussionCommentOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["fromComment"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { TeamDiscussionCommentOrderInput(it as Map<String, Any>) }
  )
}
data class TeamDiscussionReactionsArgs(
    val after: String? = null,
    val before: String? = null,
    val content: ReactionContent? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReactionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["content"] as ReactionContent?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReactionOrderInput(it as Map<String, Any>) }
  )
}
data class TeamDiscussionUserContentEditsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

data class TeamDiscussionCommentReactionsArgs(
    val after: String? = null,
    val before: String? = null,
    val content: ReactionContent? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ReactionOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["content"] as ReactionContent?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ReactionOrderInput(it as Map<String, Any>) }
  )
}
data class TeamDiscussionCommentUserContentEditsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}





data class TeamDiscussionCommentOrderInput(
    val direction: OrderDirection,
    val field: TeamDiscussionCommentOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as TeamDiscussionCommentOrderField
  )
}

/** Properties by which team discussion comment connections can be ordered. */
enum class TeamDiscussionCommentOrderField(val label: String) {
      Number("NUMBER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TeamDiscussionCommentOrderField? {
      return values().find { it.label == label }
    }
  }
}





data class TeamDiscussionOrderInput(
    val direction: OrderDirection,
    val field: TeamDiscussionOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as TeamDiscussionOrderField
  )
}

/** Properties by which team discussion connections can be ordered. */
enum class TeamDiscussionOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TeamDiscussionOrderField? {
      return values().find { it.label == label }
    }
  }
}







data class TeamMemberOrderInput(
    val direction: OrderDirection,
    val field: TeamMemberOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as TeamMemberOrderField
  )
}

/** Properties by which team member connections can be ordered. */
enum class TeamMemberOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Login("LOGIN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TeamMemberOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible team member roles; either 'maintainer' or 'member'. */
enum class TeamMemberRole(val label: String) {
      Maintainer("MAINTAINER"),
      Member("MEMBER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TeamMemberRole? {
      return values().find { it.label == label }
    }
  }
}

/** Defines which types of team members are included in the returned list. Can be one of IMMEDIATE, CHILD_TEAM or ALL. */
enum class TeamMembershipType(val label: String) {
      All("ALL"),
      ChildTeam("CHILD_TEAM"),
      Immediate("IMMEDIATE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TeamMembershipType? {
      return values().find { it.label == label }
    }
  }
}

/** The possible team notification values. */
enum class TeamNotificationSetting(val label: String) {
      NotificationsDisabled("NOTIFICATIONS_DISABLED"),
      NotificationsEnabled("NOTIFICATIONS_ENABLED");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TeamNotificationSetting? {
      return values().find { it.label == label }
    }
  }
}

data class TeamOrderInput(
    val direction: OrderDirection,
    val field: TeamOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as TeamOrderField
  )
}

/** Properties by which team connections can be ordered. */
enum class TeamOrderField(val label: String) {
      Name("NAME");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TeamOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible team privacy values. */
enum class TeamPrivacy(val label: String) {
      Secret("SECRET"),
      Visible("VISIBLE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TeamPrivacy? {
      return values().find { it.label == label }
    }
  }
}









data class TeamRepositoryOrderInput(
    val direction: OrderDirection,
    val field: TeamRepositoryOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as TeamRepositoryOrderField
  )
}

/** Properties by which team repository connections can be ordered. */
enum class TeamRepositoryOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Name("NAME"),
      Permission("PERMISSION"),
      PushedAt("PUSHED_AT"),
      Stargazers("STARGAZERS"),
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TeamRepositoryOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible team review assignment algorithms */
enum class TeamReviewAssignmentAlgorithm(val label: String) {
      LoadBalance("LOAD_BALANCE"),
      RoundRobin("ROUND_ROBIN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TeamReviewAssignmentAlgorithm? {
      return values().find { it.label == label }
    }
  }
}

/** The role of a user on a team. */
enum class TeamRole(val label: String) {
      Admin("ADMIN"),
      Member("MEMBER");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TeamRole? {
      return values().find { it.label == label }
    }
  }
}





/** The possible states of a thread subscription form action */
enum class ThreadSubscriptionFormAction(val label: String) {
      None("NONE"),
      Subscribe("SUBSCRIBE"),
      Unsubscribe("UNSUBSCRIBE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ThreadSubscriptionFormAction? {
      return values().find { it.label == label }
    }
  }
}

/** The possible states of a subscription. */
enum class ThreadSubscriptionState(val label: String) {
      Disabled("DISABLED"),
      IgnoringList("IGNORING_LIST"),
      IgnoringThread("IGNORING_THREAD"),
      None("NONE"),
      SubscribedToList("SUBSCRIBED_TO_LIST"),
      SubscribedToThread("SUBSCRIBED_TO_THREAD"),
      SubscribedToThreadEvents("SUBSCRIBED_TO_THREAD_EVENTS"),
      SubscribedToThreadType("SUBSCRIBED_TO_THREAD_TYPE"),
      Unavailable("UNAVAILABLE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): ThreadSubscriptionState? {
      return values().find { it.label == label }
    }
  }
}

data class TopicRelatedTopicsArgs(
    val first: Int? = 3
) {
  constructor(args: Map<String, Any>) : this(
      args["first"] as Int? ?: 3
  )
}
data class TopicRepositoriesArgs(
    val affiliations: Iterable<RepositoryAffiliation>? = null,
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val hasIssuesEnabled: Boolean? = null,
    val isLocked: Boolean? = null,
    val last: Int? = null,
    val orderBy: RepositoryOrderInput? = null,
    val ownerAffiliations: Iterable<RepositoryAffiliation>? = listOf(Iterable<RepositoryAffiliation>.OWNER, Iterable<RepositoryAffiliation>.COLLABORATOR),
    val privacy: RepositoryPrivacy? = null,
    val sponsorableOnly: Boolean? = false,
    val visibility: RepositoryVisibility? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["affiliations"] as Iterable<RepositoryAffiliation>?,
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["hasIssuesEnabled"] as Boolean?,
      args["isLocked"] as Boolean?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryOrderInput(it as Map<String, Any>) },
      args["ownerAffiliations"] as Iterable<RepositoryAffiliation>? ?: listOf(Iterable<RepositoryAffiliation>.OWNER, Iterable<RepositoryAffiliation>.COLLABORATOR),
      args["privacy"] as RepositoryPrivacy?,
      args["sponsorableOnly"] as Boolean? ?: false,
      args["visibility"] as RepositoryVisibility?
  )
}
data class TopicStargazersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: StarOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { StarOrderInput(it as Map<String, Any>) }
  )
}

/** Reason that the suggested topic is declined. */
enum class TopicSuggestionDeclineReason(val label: String) {
      NotRelevant("NOT_RELEVANT"),
      PersonalPreference("PERSONAL_PREFERENCE"),
      TooGeneral("TOO_GENERAL"),
      TooSpecific("TOO_SPECIFIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TopicSuggestionDeclineReason? {
      return values().find { it.label == label }
    }
  }
}

/** The possible states of a tracked issue. */
enum class TrackedIssueStates(val label: String) {
      Closed("CLOSED"),
      Open("OPEN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TrackedIssueStates? {
      return values().find { it.label == label }
    }
  }
}

data class TransferEnterpriseOrganizationInput(
    val clientMutationId: String? = null,
    val destinationEnterpriseId: Any,
    val organizationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["destinationEnterpriseId"] as Any,
      args["organizationId"] as Any
  )
}



data class TransferIssueInput(
    val clientMutationId: String? = null,
    val createLabelsIfMissing: Boolean? = false,
    val issueId: Any,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["createLabelsIfMissing"] as Boolean? ?: false,
      args["issueId"] as Any,
      args["repositoryId"] as Any
  )
}









/** Filters by whether or not 2FA is enabled and if the method configured is considered secure or insecure. */
enum class TwoFactorCredentialSecurityType(val label: String) {
      Disabled("DISABLED"),
      Insecure("INSECURE"),
      Secure("SECURE");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): TwoFactorCredentialSecurityType? {
      return values().find { it.label == label }
    }
  }
}

data class UnarchiveProjectV2ItemInput(
    val clientMutationId: String? = null,
    val itemId: Any,
    val projectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["itemId"] as Any,
      args["projectId"] as Any
  )
}



data class UnarchiveRepositoryInput(
    val clientMutationId: String? = null,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["repositoryId"] as Any
  )
}





data class UnfollowOrganizationInput(
    val clientMutationId: String? = null,
    val organizationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["organizationId"] as Any
  )
}



data class UnfollowUserInput(
    val clientMutationId: String? = null,
    val userId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["userId"] as Any
  )
}







data class UnlinkProjectV2FromRepositoryInput(
    val clientMutationId: String? = null,
    val projectId: Any,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["projectId"] as Any,
      args["repositoryId"] as Any
  )
}



data class UnlinkProjectV2FromTeamInput(
    val clientMutationId: String? = null,
    val projectId: Any,
    val teamId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["projectId"] as Any,
      args["teamId"] as Any
  )
}



data class UnlinkRepositoryFromProjectInput(
    val clientMutationId: String? = null,
    val projectId: Any,
    val repositoryId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["projectId"] as Any,
      args["repositoryId"] as Any
  )
}



data class UnlockLockableInput(
    val clientMutationId: String? = null,
    val lockableId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["lockableId"] as Any
  )
}





data class UnmarkDiscussionCommentAsAnswerInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class UnmarkFileAsViewedInput(
    val clientMutationId: String? = null,
    val path: String,
    val pullRequestId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["path"] as String,
      args["pullRequestId"] as Any
  )
}



data class UnmarkIssueAsDuplicateInput(
    val canonicalId: Any,
    val clientMutationId: String? = null,
    val duplicateId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["canonicalId"] as Any,
      args["clientMutationId"] as String?,
      args["duplicateId"] as Any
  )
}



data class UnmarkProjectV2AsTemplateInput(
    val clientMutationId: String? = null,
    val projectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["projectId"] as Any
  )
}





data class UnminimizeCommentInput(
    val clientMutationId: String? = null,
    val subjectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["subjectId"] as Any
  )
}



data class UnpinIssueInput(
    val clientMutationId: String? = null,
    val issueId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["issueId"] as Any
  )
}





data class UnresolveReviewThreadInput(
    val clientMutationId: String? = null,
    val threadId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["threadId"] as Any
  )
}





data class UpdateBranchProtectionRuleInput(
    val allowsDeletions: Boolean? = null,
    val allowsForcePushes: Boolean? = null,
    val blocksCreations: Boolean? = null,
    val branchProtectionRuleId: Any,
    val bypassForcePushActorIds: Iterable<Any>? = null,
    val bypassPullRequestActorIds: Iterable<Any>? = null,
    val clientMutationId: String? = null,
    val dismissesStaleReviews: Boolean? = null,
    val isAdminEnforced: Boolean? = null,
    val lockAllowsFetchAndMerge: Boolean? = null,
    val lockBranch: Boolean? = null,
    val pattern: String? = null,
    val pushActorIds: Iterable<Any>? = null,
    val requireLastPushApproval: Boolean? = null,
    val requiredApprovingReviewCount: Int? = null,
    val requiredDeploymentEnvironments: Iterable<String>? = null,
    val requiredStatusCheckContexts: Iterable<String>? = null,
    val requiredStatusChecks: Iterable<RequiredStatusCheckInput>? = null,
    val requiresApprovingReviews: Boolean? = null,
    val requiresCodeOwnerReviews: Boolean? = null,
    val requiresCommitSignatures: Boolean? = null,
    val requiresConversationResolution: Boolean? = null,
    val requiresDeployments: Boolean? = null,
    val requiresLinearHistory: Boolean? = null,
    val requiresStatusChecks: Boolean? = null,
    val requiresStrictStatusChecks: Boolean? = null,
    val restrictsPushes: Boolean? = null,
    val restrictsReviewDismissals: Boolean? = null,
    val reviewDismissalActorIds: Iterable<Any>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["allowsDeletions"] as Boolean?,
      args["allowsForcePushes"] as Boolean?,
      args["blocksCreations"] as Boolean?,
      args["branchProtectionRuleId"] as Any,
      args["bypassForcePushActorIds"] as Iterable<Any>?,
      args["bypassPullRequestActorIds"] as Iterable<Any>?,
      args["clientMutationId"] as String?,
      args["dismissesStaleReviews"] as Boolean?,
      args["isAdminEnforced"] as Boolean?,
      args["lockAllowsFetchAndMerge"] as Boolean?,
      args["lockBranch"] as Boolean?,
      args["pattern"] as String?,
      args["pushActorIds"] as Iterable<Any>?,
      args["requireLastPushApproval"] as Boolean?,
      args["requiredApprovingReviewCount"] as Int?,
      args["requiredDeploymentEnvironments"] as Iterable<String>?,
      args["requiredStatusCheckContexts"] as Iterable<String>?,
      args["requiredStatusChecks"]?.let { requiredStatusChecks -> (requiredStatusChecks as List<Map<String, Any>>).map { RequiredStatusCheckInput(it) } },
      args["requiresApprovingReviews"] as Boolean?,
      args["requiresCodeOwnerReviews"] as Boolean?,
      args["requiresCommitSignatures"] as Boolean?,
      args["requiresConversationResolution"] as Boolean?,
      args["requiresDeployments"] as Boolean?,
      args["requiresLinearHistory"] as Boolean?,
      args["requiresStatusChecks"] as Boolean?,
      args["requiresStrictStatusChecks"] as Boolean?,
      args["restrictsPushes"] as Boolean?,
      args["restrictsReviewDismissals"] as Boolean?,
      args["reviewDismissalActorIds"] as Iterable<Any>?
  )
}



data class UpdateCheckRunInput(
    val actions: Iterable<CheckRunActionInput>? = null,
    val checkRunId: Any,
    val clientMutationId: String? = null,
    val completedAt: any? = null,
    val conclusion: CheckConclusionState? = null,
    val detailsUrl: any? = null,
    val externalId: String? = null,
    val name: String? = null,
    val output: CheckRunOutputInput? = null,
    val repositoryId: Any,
    val startedAt: any? = null,
    val status: RequestableCheckStatusState? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["actions"]?.let { actions -> (actions as List<Map<String, Any>>).map { CheckRunActionInput(it) } },
      args["checkRunId"] as Any,
      args["clientMutationId"] as String?,
      args["completedAt"] as any?,
      args["conclusion"] as CheckConclusionState?,
      args["detailsUrl"] as any?,
      args["externalId"] as String?,
      args["name"] as String?,
      args["output"]?.let { CheckRunOutputInput(it as Map<String, Any>) },
      args["repositoryId"] as Any,
      args["startedAt"] as any?,
      args["status"] as RequestableCheckStatusState?
  )
}



data class UpdateCheckSuitePreferencesInput(
    val autoTriggerPreferences: Iterable<CheckSuiteAutoTriggerPreferenceInput>,
    val clientMutationId: String? = null,
    val repositoryId: Any
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["autoTriggerPreferences"]!!.let { autoTriggerPreferences -> (autoTriggerPreferences as List<Map<String, Any>>).map { CheckSuiteAutoTriggerPreferenceInput(it) } },
      args["clientMutationId"] as String?,
      args["repositoryId"] as Any
  )
}



data class UpdateDiscussionCommentInput(
    val body: String,
    val clientMutationId: String? = null,
    val commentId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["clientMutationId"] as String?,
      args["commentId"] as Any
  )
}



data class UpdateDiscussionInput(
    val body: String? = null,
    val categoryId: Any? = null,
    val clientMutationId: String? = null,
    val discussionId: Any,
    val title: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["categoryId"] as Any?,
      args["clientMutationId"] as String?,
      args["discussionId"] as Any,
      args["title"] as String?
  )
}



data class UpdateEnterpriseAdministratorRoleInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val login: String,
    val role: EnterpriseAdministratorRole
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["login"] as String,
      args["role"] as EnterpriseAdministratorRole
  )
}



data class UpdateEnterpriseAllowPrivateRepositoryForkingSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val policyValue: EnterpriseAllowPrivateRepositoryForkingPolicyValue? = null,
    val settingValue: EnterpriseEnabledDisabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["policyValue"] as EnterpriseAllowPrivateRepositoryForkingPolicyValue?,
      args["settingValue"] as EnterpriseEnabledDisabledSettingValue
  )
}



data class UpdateEnterpriseDefaultRepositoryPermissionSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseDefaultRepositoryPermissionSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseDefaultRepositoryPermissionSettingValue
  )
}



data class UpdateEnterpriseDeployKeySettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseEnabledDisabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseEnabledDisabledSettingValue
  )
}



data class UpdateEnterpriseMembersCanChangeRepositoryVisibilitySettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseEnabledDisabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseEnabledDisabledSettingValue
  )
}



data class UpdateEnterpriseMembersCanCreateRepositoriesSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val membersCanCreateInternalRepositories: Boolean? = null,
    val membersCanCreatePrivateRepositories: Boolean? = null,
    val membersCanCreatePublicRepositories: Boolean? = null,
    val membersCanCreateRepositoriesPolicyEnabled: Boolean? = null,
    val settingValue: EnterpriseMembersCanCreateRepositoriesSettingValue? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["membersCanCreateInternalRepositories"] as Boolean?,
      args["membersCanCreatePrivateRepositories"] as Boolean?,
      args["membersCanCreatePublicRepositories"] as Boolean?,
      args["membersCanCreateRepositoriesPolicyEnabled"] as Boolean?,
      args["settingValue"] as EnterpriseMembersCanCreateRepositoriesSettingValue?
  )
}



data class UpdateEnterpriseMembersCanDeleteIssuesSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseEnabledDisabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseEnabledDisabledSettingValue
  )
}



data class UpdateEnterpriseMembersCanDeleteRepositoriesSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseEnabledDisabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseEnabledDisabledSettingValue
  )
}



data class UpdateEnterpriseMembersCanInviteCollaboratorsSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseEnabledDisabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseEnabledDisabledSettingValue
  )
}



data class UpdateEnterpriseMembersCanMakePurchasesSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseMembersCanMakePurchasesSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseMembersCanMakePurchasesSettingValue
  )
}



data class UpdateEnterpriseMembersCanUpdateProtectedBranchesSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseEnabledDisabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseEnabledDisabledSettingValue
  )
}



data class UpdateEnterpriseMembersCanViewDependencyInsightsSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseEnabledDisabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseEnabledDisabledSettingValue
  )
}



data class UpdateEnterpriseOrganizationProjectsSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseEnabledDisabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseEnabledDisabledSettingValue
  )
}



data class UpdateEnterpriseOwnerOrganizationRoleInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val organizationId: Any,
    val organizationRole: RoleInOrganization
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["organizationId"] as Any,
      args["organizationRole"] as RoleInOrganization
  )
}



data class UpdateEnterpriseProfileInput(
    val clientMutationId: String? = null,
    val description: String? = null,
    val enterpriseId: Any,
    val location: String? = null,
    val name: String? = null,
    val websiteUrl: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["description"] as String?,
      args["enterpriseId"] as Any,
      args["location"] as String?,
      args["name"] as String?,
      args["websiteUrl"] as String?
  )
}



data class UpdateEnterpriseRepositoryProjectsSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseEnabledDisabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseEnabledDisabledSettingValue
  )
}



data class UpdateEnterpriseTeamDiscussionsSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseEnabledDisabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseEnabledDisabledSettingValue
  )
}



data class UpdateEnterpriseTwoFactorAuthenticationDisallowedMethodsSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseDisallowedMethodsSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseDisallowedMethodsSettingValue
  )
}



data class UpdateEnterpriseTwoFactorAuthenticationRequiredSettingInput(
    val clientMutationId: String? = null,
    val enterpriseId: Any,
    val settingValue: EnterpriseEnabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enterpriseId"] as Any,
      args["settingValue"] as EnterpriseEnabledSettingValue
  )
}



data class UpdateEnvironmentInput(
    val clientMutationId: String? = null,
    val environmentId: Any,
    val preventSelfReview: Boolean? = null,
    val reviewers: Iterable<Any>? = null,
    val waitTimer: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["environmentId"] as Any,
      args["preventSelfReview"] as Boolean?,
      args["reviewers"] as Iterable<Any>?,
      args["waitTimer"] as Int?
  )
}



data class UpdateIpAllowListEnabledSettingInput(
    val clientMutationId: String? = null,
    val ownerId: Any,
    val settingValue: IpAllowListEnabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["ownerId"] as Any,
      args["settingValue"] as IpAllowListEnabledSettingValue
  )
}



data class UpdateIpAllowListEntryInput(
    val allowListValue: String,
    val clientMutationId: String? = null,
    val ipAllowListEntryId: Any,
    val isActive: Boolean,
    val name: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["allowListValue"] as String,
      args["clientMutationId"] as String?,
      args["ipAllowListEntryId"] as Any,
      args["isActive"] as Boolean,
      args["name"] as String?
  )
}



data class UpdateIpAllowListForInstalledAppsEnabledSettingInput(
    val clientMutationId: String? = null,
    val ownerId: Any,
    val settingValue: IpAllowListForInstalledAppsEnabledSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["ownerId"] as Any,
      args["settingValue"] as IpAllowListForInstalledAppsEnabledSettingValue
  )
}



data class UpdateIssueCommentInput(
    val body: String,
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class UpdateIssueInput(
    val assigneeIds: Iterable<Any>? = null,
    val body: String? = null,
    val clientMutationId: String? = null,
    val id: Any,
    val labelIds: Iterable<Any>? = null,
    val milestoneId: Any? = null,
    val projectIds: Iterable<Any>? = null,
    val state: IssueState? = null,
    val title: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["assigneeIds"] as Iterable<Any>?,
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["id"] as Any,
      args["labelIds"] as Iterable<Any>?,
      args["milestoneId"] as Any?,
      args["projectIds"] as Iterable<Any>?,
      args["state"] as IssueState?,
      args["title"] as String?
  )
}



data class UpdateLabelInput(
    val clientMutationId: String? = null,
    val color: String? = null,
    val description: String? = null,
    val id: Any,
    val name: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["color"] as String?,
      args["description"] as String?,
      args["id"] as Any,
      args["name"] as String?
  )
}



data class UpdateNotificationRestrictionSettingInput(
    val clientMutationId: String? = null,
    val ownerId: Any,
    val settingValue: NotificationRestrictionSettingValue
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["ownerId"] as Any,
      args["settingValue"] as NotificationRestrictionSettingValue
  )
}



data class UpdateOrganizationAllowPrivateRepositoryForkingSettingInput(
    val clientMutationId: String? = null,
    val forkingEnabled: Boolean,
    val organizationId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["forkingEnabled"] as Boolean,
      args["organizationId"] as Any
  )
}



data class UpdateOrganizationWebCommitSignoffSettingInput(
    val clientMutationId: String? = null,
    val organizationId: Any,
    val webCommitSignoffRequired: Boolean
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["organizationId"] as Any,
      args["webCommitSignoffRequired"] as Boolean
  )
}





data class UpdateParametersInput(
    val updateAllowsFetchAndMerge: Boolean
) {
  constructor(args: Map<String, Any>) : this(
      args["updateAllowsFetchAndMerge"] as Boolean
  )
}

data class UpdatePatreonSponsorabilityInput(
    val clientMutationId: String? = null,
    val enablePatreonSponsorships: Boolean,
    val sponsorableLogin: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["enablePatreonSponsorships"] as Boolean,
      args["sponsorableLogin"] as String?
  )
}



data class UpdateProjectCardInput(
    val clientMutationId: String? = null,
    val isArchived: Boolean? = null,
    val note: String? = null,
    val projectCardId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["isArchived"] as Boolean?,
      args["note"] as String?,
      args["projectCardId"] as Any
  )
}



data class UpdateProjectColumnInput(
    val clientMutationId: String? = null,
    val name: String,
    val projectColumnId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["name"] as String,
      args["projectColumnId"] as Any
  )
}



data class UpdateProjectInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val name: String? = null,
    val projectId: Any,
    val public: Boolean? = null,
    val state: ProjectState? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["name"] as String?,
      args["projectId"] as Any,
      args["public"] as Boolean?,
      args["state"] as ProjectState?
  )
}



data class UpdateProjectV2CollaboratorsInput(
    val clientMutationId: String? = null,
    val collaborators: Iterable<ProjectV2CollaboratorInput>,
    val projectId: Any
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["collaborators"]!!.let { collaborators -> (collaborators as List<Map<String, Any>>).map { ProjectV2CollaboratorInput(it) } },
      args["projectId"] as Any
  )
}

data class UpdateProjectV2CollaboratorsPayloadCollaboratorsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}

data class UpdateProjectV2DraftIssueInput(
    val assigneeIds: Iterable<Any>? = null,
    val body: String? = null,
    val clientMutationId: String? = null,
    val draftIssueId: Any,
    val title: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["assigneeIds"] as Iterable<Any>?,
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["draftIssueId"] as Any,
      args["title"] as String?
  )
}



data class UpdateProjectV2FieldInput(
    val clientMutationId: String? = null,
    val fieldId: Any,
    val iterationConfiguration: ProjectV2IterationFieldConfigurationInput? = null,
    val name: String? = null,
    val singleSelectOptions: Iterable<ProjectV2SingleSelectFieldOptionInput>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["fieldId"] as Any,
      args["iterationConfiguration"]?.let { ProjectV2IterationFieldConfigurationInput(it as Map<String, Any>) },
      args["name"] as String?,
      args["singleSelectOptions"]?.let { singleSelectOptions -> (singleSelectOptions as List<Map<String, Any>>).map { ProjectV2SingleSelectFieldOptionInput(it) } }
  )
}



data class UpdateProjectV2Input(
    val clientMutationId: String? = null,
    val closed: Boolean? = null,
    val projectId: Any,
    val public: Boolean? = null,
    val readme: String? = null,
    val shortDescription: String? = null,
    val title: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["closed"] as Boolean?,
      args["projectId"] as Any,
      args["public"] as Boolean?,
      args["readme"] as String?,
      args["shortDescription"] as String?,
      args["title"] as String?
  )
}

data class UpdateProjectV2ItemFieldValueInput(
    val clientMutationId: String? = null,
    val fieldId: Any,
    val itemId: Any,
    val projectId: Any,
    val value: ProjectV2FieldValueInput
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["fieldId"] as Any,
      args["itemId"] as Any,
      args["projectId"] as Any,
      ProjectV2FieldValueInput(args["value"] as Map<String, Any>)
  )
}



data class UpdateProjectV2ItemPositionInput(
    val afterId: Any? = null,
    val clientMutationId: String? = null,
    val itemId: Any,
    val projectId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["afterId"] as Any?,
      args["clientMutationId"] as String?,
      args["itemId"] as Any,
      args["projectId"] as Any
  )
}

data class UpdateProjectV2ItemPositionPayloadItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}



data class UpdateProjectV2StatusUpdateInput(
    val body: String? = null,
    val clientMutationId: String? = null,
    val startDate: any? = null,
    val status: ProjectV2StatusUpdateStatus? = null,
    val statusUpdateId: Any,
    val targetDate: any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["startDate"] as any?,
      args["status"] as ProjectV2StatusUpdateStatus?,
      args["statusUpdateId"] as Any,
      args["targetDate"] as any?
  )
}



data class UpdatePullRequestBranchInput(
    val clientMutationId: String? = null,
    val expectedHeadOid: any? = null,
    val pullRequestId: Any,
    val updateMethod: PullRequestBranchUpdateMethod? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["expectedHeadOid"] as any?,
      args["pullRequestId"] as Any,
      args["updateMethod"] as PullRequestBranchUpdateMethod?
  )
}



data class UpdatePullRequestInput(
    val assigneeIds: Iterable<Any>? = null,
    val baseRefName: String? = null,
    val body: String? = null,
    val clientMutationId: String? = null,
    val labelIds: Iterable<Any>? = null,
    val maintainerCanModify: Boolean? = null,
    val milestoneId: Any? = null,
    val projectIds: Iterable<Any>? = null,
    val pullRequestId: Any,
    val state: PullRequestUpdateState? = null,
    val title: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["assigneeIds"] as Iterable<Any>?,
      args["baseRefName"] as String?,
      args["body"] as String?,
      args["clientMutationId"] as String?,
      args["labelIds"] as Iterable<Any>?,
      args["maintainerCanModify"] as Boolean?,
      args["milestoneId"] as Any?,
      args["projectIds"] as Iterable<Any>?,
      args["pullRequestId"] as Any,
      args["state"] as PullRequestUpdateState?,
      args["title"] as String?
  )
}



data class UpdatePullRequestReviewCommentInput(
    val body: String,
    val clientMutationId: String? = null,
    val pullRequestReviewCommentId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["clientMutationId"] as String?,
      args["pullRequestReviewCommentId"] as Any
  )
}



data class UpdatePullRequestReviewInput(
    val body: String,
    val clientMutationId: String? = null,
    val pullRequestReviewId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["clientMutationId"] as String?,
      args["pullRequestReviewId"] as Any
  )
}



data class UpdateRefInput(
    val clientMutationId: String? = null,
    val force: Boolean? = false,
    val oid: any,
    val refId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["force"] as Boolean? ?: false,
      args["oid"] as any,
      args["refId"] as Any
  )
}



data class UpdateRefsInput(
    val clientMutationId: String? = null,
    val refUpdates: Iterable<RefUpdateInput>,
    val repositoryId: Any
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["refUpdates"]!!.let { refUpdates -> (refUpdates as List<Map<String, Any>>).map { RefUpdateInput(it) } },
      args["repositoryId"] as Any
  )
}



data class UpdateRepositoryInput(
    val clientMutationId: String? = null,
    val description: String? = null,
    val hasDiscussionsEnabled: Boolean? = null,
    val hasIssuesEnabled: Boolean? = null,
    val hasProjectsEnabled: Boolean? = null,
    val hasSponsorshipsEnabled: Boolean? = null,
    val hasWikiEnabled: Boolean? = null,
    val homepageUrl: any? = null,
    val name: String? = null,
    val repositoryId: Any,
    val template: Boolean? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["description"] as String?,
      args["hasDiscussionsEnabled"] as Boolean?,
      args["hasIssuesEnabled"] as Boolean?,
      args["hasProjectsEnabled"] as Boolean?,
      args["hasSponsorshipsEnabled"] as Boolean?,
      args["hasWikiEnabled"] as Boolean?,
      args["homepageUrl"] as any?,
      args["name"] as String?,
      args["repositoryId"] as Any,
      args["template"] as Boolean?
  )
}



data class UpdateRepositoryRulesetInput(
    val bypassActors: Iterable<RepositoryRulesetBypassActorInput>? = null,
    val clientMutationId: String? = null,
    val conditions: RepositoryRuleConditionsInput? = null,
    val enforcement: RuleEnforcement? = null,
    val name: String? = null,
    val repositoryRulesetId: Any,
    val rules: Iterable<RepositoryRuleInput>? = null,
    val target: RepositoryRulesetTarget? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["bypassActors"]?.let { bypassActors -> (bypassActors as List<Map<String, Any>>).map { RepositoryRulesetBypassActorInput(it) } },
      args["clientMutationId"] as String?,
      args["conditions"]?.let { RepositoryRuleConditionsInput(it as Map<String, Any>) },
      args["enforcement"] as RuleEnforcement?,
      args["name"] as String?,
      args["repositoryRulesetId"] as Any,
      args["rules"]?.let { rules -> (rules as List<Map<String, Any>>).map { RepositoryRuleInput(it) } },
      args["target"] as RepositoryRulesetTarget?
  )
}



data class UpdateRepositoryWebCommitSignoffSettingInput(
    val clientMutationId: String? = null,
    val repositoryId: Any,
    val webCommitSignoffRequired: Boolean
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["repositoryId"] as Any,
      args["webCommitSignoffRequired"] as Boolean
  )
}



data class UpdateSponsorshipPreferencesInput(
    val clientMutationId: String? = null,
    val privacyLevel: SponsorshipPrivacy? = SponsorshipPrivacy.PUBLIC,
    val receiveEmails: Boolean? = true,
    val sponsorId: Any? = null,
    val sponsorLogin: String? = null,
    val sponsorableId: Any? = null,
    val sponsorableLogin: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["privacyLevel"] as SponsorshipPrivacy? ?: SponsorshipPrivacy.PUBLIC,
      args["receiveEmails"] as Boolean? ?: true,
      args["sponsorId"] as Any?,
      args["sponsorLogin"] as String?,
      args["sponsorableId"] as Any?,
      args["sponsorableLogin"] as String?
  )
}



data class UpdateSubscriptionInput(
    val clientMutationId: String? = null,
    val state: SubscriptionState,
    val subscribableId: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["state"] as SubscriptionState,
      args["subscribableId"] as Any
  )
}



data class UpdateTeamDiscussionCommentInput(
    val body: String,
    val bodyVersion: String? = null,
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String,
      args["bodyVersion"] as String?,
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}



data class UpdateTeamDiscussionInput(
    val body: String? = null,
    val bodyVersion: String? = null,
    val clientMutationId: String? = null,
    val id: Any,
    val pinned: Boolean? = null,
    val title: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["body"] as String?,
      args["bodyVersion"] as String?,
      args["clientMutationId"] as String?,
      args["id"] as Any,
      args["pinned"] as Boolean?,
      args["title"] as String?
  )
}



data class UpdateTeamReviewAssignmentInput(
    val algorithm: TeamReviewAssignmentAlgorithm? = TeamReviewAssignmentAlgorithm.ROUND_ROBIN,
    val clientMutationId: String? = null,
    val countMembersAlreadyRequested: Boolean? = true,
    val enabled: Boolean,
    val excludedTeamMemberIds: Iterable<Any>? = null,
    val id: Any,
    val includeChildTeamMembers: Boolean? = true,
    val notifyTeam: Boolean? = true,
    val removeTeamRequest: Boolean? = true,
    val teamMemberCount: Int? = 1
) {
  constructor(args: Map<String, Any>) : this(
      args["algorithm"] as TeamReviewAssignmentAlgorithm? ?: TeamReviewAssignmentAlgorithm.ROUND_ROBIN,
      args["clientMutationId"] as String?,
      args["countMembersAlreadyRequested"] as Boolean? ?: true,
      args["enabled"] as Boolean,
      args["excludedTeamMemberIds"] as Iterable<Any>?,
      args["id"] as Any,
      args["includeChildTeamMembers"] as Boolean? ?: true,
      args["notifyTeam"] as Boolean? ?: true,
      args["removeTeamRequest"] as Boolean? ?: true,
      args["teamMemberCount"] as Int? ?: 1
  )
}



data class UpdateTeamsRepositoryInput(
    val clientMutationId: String? = null,
    val permission: RepositoryPermission,
    val repositoryId: Any,
    val teamIds: Iterable<Any>
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["permission"] as RepositoryPermission,
      args["repositoryId"] as Any,
      args["teamIds"] as Iterable<Any>
  )
}



data class UpdateTopicsInput(
    val clientMutationId: String? = null,
    val repositoryId: Any,
    val topicNames: Iterable<String>
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["repositoryId"] as Any,
      args["topicNames"] as Iterable<String>
  )
}



data class UpdateUserListInput(
    val clientMutationId: String? = null,
    val description: String? = null,
    val isPrivate: Boolean? = null,
    val listId: Any,
    val name: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["description"] as String?,
      args["isPrivate"] as Boolean?,
      args["listId"] as Any,
      args["name"] as String?
  )
}



data class UpdateUserListsForItemInput(
    val clientMutationId: String? = null,
    val itemId: Any,
    val listIds: Iterable<Any>,
    val suggestedListIds: Iterable<Any>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["itemId"] as Any,
      args["listIds"] as Iterable<Any>,
      args["suggestedListIds"] as Iterable<Any>?
  )
}



data class UserAnyPinnableItemsArgs(
    val type: PinnableItemType? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["type"] as PinnableItemType?
  )
}
data class UserAvatarUrlArgs(
    val size: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["size"] as Int?
  )
}
data class UserCanReceiveOrganizationEmailsWhenNotificationsRestrictedArgs(
    val login: String
) {
  constructor(args: Map<String, Any>) : this(
      args["login"] as String
  )
}
data class UserCommitCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class UserContributionsCollectionArgs(
    val from: any? = null,
    val organizationID: Any? = null,
    val to: any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["from"] as any?,
      args["organizationID"] as Any?,
      args["to"] as any?
  )
}
data class UserEnterprisesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val membershipType: EnterpriseMembershipType? = EnterpriseMembershipType.ALL,
    val orderBy: EnterpriseOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["membershipType"] as EnterpriseMembershipType? ?: EnterpriseMembershipType.ALL,
      args["orderBy"]?.let { EnterpriseOrderInput(it as Map<String, Any>) }
  )
}
data class UserFollowersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class UserFollowingArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class UserGistArgs(
    val name: String
) {
  constructor(args: Map<String, Any>) : this(
      args["name"] as String
  )
}
data class UserGistCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class UserGistsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: GistOrderInput? = null,
    val privacy: GistPrivacy? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { GistOrderInput(it as Map<String, Any>) },
      args["privacy"] as GistPrivacy?
  )
}
data class UserHovercardArgs(
    val primarySubjectId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["primarySubjectId"] as Any?
  )
}
data class UserIsSponsoredByArgs(
    val accountLogin: String
) {
  constructor(args: Map<String, Any>) : this(
      args["accountLogin"] as String
  )
}
data class UserIssueCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: IssueCommentOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueCommentOrderInput(it as Map<String, Any>) }
  )
}
data class UserIssuesArgs(
    val after: String? = null,
    val before: String? = null,
    val filterBy: IssueFiltersInput? = null,
    val first: Int? = null,
    val labels: Iterable<String>? = null,
    val last: Int? = null,
    val orderBy: IssueOrderInput? = null,
    val states: Iterable<IssueState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["filterBy"]?.let { IssueFiltersInput(it as Map<String, Any>) },
      args["first"] as Int?,
      args["labels"] as Iterable<String>?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueOrderInput(it as Map<String, Any>) },
      args["states"] as Iterable<IssueState>?
  )
}
data class UserLifetimeReceivedSponsorshipValuesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: SponsorAndLifetimeValueOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorAndLifetimeValueOrderInput(it as Map<String, Any>) }
  )
}
data class UserListsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class UserOrganizationArgs(
    val login: String
) {
  constructor(args: Map<String, Any>) : this(
      args["login"] as String
  )
}
data class UserOrganizationVerifiedDomainEmailsArgs(
    val login: String
) {
  constructor(args: Map<String, Any>) : this(
      args["login"] as String
  )
}
data class UserOrganizationsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: OrganizationOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { OrganizationOrderInput(it as Map<String, Any>) }
  )
}
data class UserPackagesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val names: Iterable<String>? = null,
    val orderBy: PackageOrderInput? = null,
    val packageType: PackageType? = null,
    val repositoryId: Any? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["names"] as Iterable<String>?,
      args["orderBy"]?.let { PackageOrderInput(it as Map<String, Any>) },
      args["packageType"] as PackageType?,
      args["repositoryId"] as Any?
  )
}
data class UserPinnableItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val types: Iterable<PinnableItemType>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["types"] as Iterable<PinnableItemType>?
  )
}
data class UserPinnedItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val types: Iterable<PinnableItemType>? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["types"] as Iterable<PinnableItemType>?
  )
}
data class UserProjectArgs(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class UserProjectV2Args(
    val number: Int
) {
  constructor(args: Map<String, Any>) : this(
      args["number"] as Int
  )
}
data class UserProjectsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: ProjectOrderInput? = null,
    val search: String? = null,
    val states: Iterable<ProjectState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { ProjectOrderInput(it as Map<String, Any>) },
      args["search"] as String?,
      args["states"] as Iterable<ProjectState>?
  )
}
data class UserProjectsV2Args(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val minPermissionLevel: ProjectV2PermissionLevel? = ProjectV2PermissionLevel.READ,
    val orderBy: ProjectV2OrderInput? = null,
    val query: String? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["minPermissionLevel"] as ProjectV2PermissionLevel? ?: ProjectV2PermissionLevel.READ,
      args["orderBy"]?.let { ProjectV2OrderInput(it as Map<String, Any>) },
      args["query"] as String?
  )
}
data class UserPublicKeysArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class UserPullRequestsArgs(
    val after: String? = null,
    val baseRefName: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val headRefName: String? = null,
    val labels: Iterable<String>? = null,
    val last: Int? = null,
    val orderBy: IssueOrderInput? = null,
    val states: Iterable<PullRequestState>? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["baseRefName"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["headRefName"] as String?,
      args["labels"] as Iterable<String>?,
      args["last"] as Int?,
      args["orderBy"]?.let { IssueOrderInput(it as Map<String, Any>) },
      args["states"] as Iterable<PullRequestState>?
  )
}
data class UserRecentProjectsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class UserRepositoriesArgs(
    val affiliations: Iterable<RepositoryAffiliation>? = null,
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val hasIssuesEnabled: Boolean? = null,
    val isArchived: Boolean? = null,
    val isFork: Boolean? = null,
    val isLocked: Boolean? = null,
    val last: Int? = null,
    val orderBy: RepositoryOrderInput? = null,
    val ownerAffiliations: Iterable<RepositoryAffiliation>? = listOf(Iterable<RepositoryAffiliation>.OWNER, Iterable<RepositoryAffiliation>.COLLABORATOR),
    val privacy: RepositoryPrivacy? = null,
    val visibility: RepositoryVisibility? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["affiliations"] as Iterable<RepositoryAffiliation>?,
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["hasIssuesEnabled"] as Boolean?,
      args["isArchived"] as Boolean?,
      args["isFork"] as Boolean?,
      args["isLocked"] as Boolean?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryOrderInput(it as Map<String, Any>) },
      args["ownerAffiliations"] as Iterable<RepositoryAffiliation>? ?: listOf(Iterable<RepositoryAffiliation>.OWNER, Iterable<RepositoryAffiliation>.COLLABORATOR),
      args["privacy"] as RepositoryPrivacy?,
      args["visibility"] as RepositoryVisibility?
  )
}
data class UserRepositoriesContributedToArgs(
    val after: String? = null,
    val before: String? = null,
    val contributionTypes: Iterable<RepositoryContributionType>? = null,
    val first: Int? = null,
    val hasIssues: Boolean? = null,
    val includeUserRepositories: Boolean? = null,
    val isLocked: Boolean? = null,
    val last: Int? = null,
    val orderBy: RepositoryOrderInput? = null,
    val privacy: RepositoryPrivacy? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["contributionTypes"] as Iterable<RepositoryContributionType>?,
      args["first"] as Int?,
      args["hasIssues"] as Boolean?,
      args["includeUserRepositories"] as Boolean?,
      args["isLocked"] as Boolean?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryOrderInput(it as Map<String, Any>) },
      args["privacy"] as RepositoryPrivacy?
  )
}
data class UserRepositoryArgs(
    val followRenames: Boolean? = true,
    val name: String
) {
  constructor(args: Map<String, Any>) : this(
      args["followRenames"] as Boolean? ?: true,
      args["name"] as String
  )
}
data class UserRepositoryDiscussionCommentsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val onlyAnswers: Boolean? = false,
    val repositoryId: Any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["onlyAnswers"] as Boolean? ?: false,
      args["repositoryId"] as Any?
  )
}
data class UserRepositoryDiscussionsArgs(
    val after: String? = null,
    val answered: Boolean? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: DiscussionOrderInput? = null,
    val repositoryId: Any? = null,
    val states: Iterable<DiscussionState>? = listOf()
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["answered"] as Boolean?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { DiscussionOrderInput(it as Map<String, Any>) },
      args["repositoryId"] as Any?,
      args["states"] as Iterable<DiscussionState>? ?: listOf()
  )
}
data class UserSavedRepliesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: SavedReplyOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { SavedReplyOrderInput(it as Map<String, Any>) }
  )
}
data class UserSocialAccountsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class UserSponsoringArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: SponsorOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorOrderInput(it as Map<String, Any>) }
  )
}
data class UserSponsorsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: SponsorOrderInput? = null,
    val tierId: Any? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorOrderInput(it as Map<String, Any>) },
      args["tierId"] as Any?
  )
}
data class UserSponsorsActivitiesArgs(
    val actions: Iterable<SponsorsActivityAction>? = listOf(),
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val includeAsSponsor: Boolean? = false,
    val includePrivate: Boolean? = true,
    val last: Int? = null,
    val orderBy: SponsorsActivityOrderInput? = null,
    val period: SponsorsActivityPeriod? = SponsorsActivityPeriod.MONTH,
    val since: any? = null,
    val until: any? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["actions"] as Iterable<SponsorsActivityAction>? ?: listOf(),
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["includeAsSponsor"] as Boolean? ?: false,
      args["includePrivate"] as Boolean? ?: true,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorsActivityOrderInput(it as Map<String, Any>) },
      args["period"] as SponsorsActivityPeriod? ?: SponsorsActivityPeriod.MONTH,
      args["since"] as any?,
      args["until"] as any?
  )
}
data class UserSponsorshipForViewerAsSponsorArgs(
    val activeOnly: Boolean? = true
) {
  constructor(args: Map<String, Any>) : this(
      args["activeOnly"] as Boolean? ?: true
  )
}
data class UserSponsorshipForViewerAsSponsorableArgs(
    val activeOnly: Boolean? = true
) {
  constructor(args: Map<String, Any>) : this(
      args["activeOnly"] as Boolean? ?: true
  )
}
data class UserSponsorshipNewslettersArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: SponsorshipNewsletterOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorshipNewsletterOrderInput(it as Map<String, Any>) }
  )
}
data class UserSponsorshipsAsMaintainerArgs(
    val activeOnly: Boolean? = true,
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val includePrivate: Boolean? = false,
    val last: Int? = null,
    val orderBy: SponsorshipOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["activeOnly"] as Boolean? ?: true,
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["includePrivate"] as Boolean? ?: false,
      args["last"] as Int?,
      args["orderBy"]?.let { SponsorshipOrderInput(it as Map<String, Any>) }
  )
}
data class UserSponsorshipsAsSponsorArgs(
    val activeOnly: Boolean? = true,
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val maintainerLogins: Iterable<String>? = null,
    val orderBy: SponsorshipOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["activeOnly"] as Boolean? ?: true,
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["maintainerLogins"] as Iterable<String>?,
      args["orderBy"]?.let { SponsorshipOrderInput(it as Map<String, Any>) }
  )
}
data class UserStarredRepositoriesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: StarOrderInput? = null,
    val ownedByViewer: Boolean? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { StarOrderInput(it as Map<String, Any>) },
      args["ownedByViewer"] as Boolean?
  )
}
data class UserTopRepositoriesArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: RepositoryOrderInput,
    val since: any? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      RepositoryOrderInput(args["orderBy"] as Map<String, Any>),
      args["since"] as any?
  )
}
data class UserTotalSponsorshipAmountAsSponsorInCentsArgs(
    val since: any? = null,
    val sponsorableLogins: Iterable<String>? = listOf(),
    val until: any? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["since"] as any?,
      args["sponsorableLogins"] as Iterable<String>? ?: listOf(),
      args["until"] as any?
  )
}
data class UserWatchingArgs(
    val affiliations: Iterable<RepositoryAffiliation>? = null,
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val hasIssuesEnabled: Boolean? = null,
    val isLocked: Boolean? = null,
    val last: Int? = null,
    val orderBy: RepositoryOrderInput? = null,
    val ownerAffiliations: Iterable<RepositoryAffiliation>? = listOf(Iterable<RepositoryAffiliation>.OWNER, Iterable<RepositoryAffiliation>.COLLABORATOR),
    val privacy: RepositoryPrivacy? = null,
    val visibility: RepositoryVisibility? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["affiliations"] as Iterable<RepositoryAffiliation>?,
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["hasIssuesEnabled"] as Boolean?,
      args["isLocked"] as Boolean?,
      args["last"] as Int?,
      args["orderBy"]?.let { RepositoryOrderInput(it as Map<String, Any>) },
      args["ownerAffiliations"] as Iterable<RepositoryAffiliation>? ?: listOf(Iterable<RepositoryAffiliation>.OWNER, Iterable<RepositoryAffiliation>.COLLABORATOR),
      args["privacy"] as RepositoryPrivacy?,
      args["visibility"] as RepositoryVisibility?
  )
}

/** The possible durations that a user can be blocked for. */
enum class UserBlockDuration(val label: String) {
      OneDay("ONE_DAY"),
      OneMonth("ONE_MONTH"),
      OneWeek("ONE_WEEK"),
      Permanent("PERMANENT"),
      ThreeDays("THREE_DAYS");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): UserBlockDuration? {
      return values().find { it.label == label }
    }
  }
}















data class UserListItemsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}























data class UserStatusOrderInput(
    val direction: OrderDirection,
    val field: UserStatusOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as UserStatusOrderField
  )
}

/** Properties by which user status connections can be ordered. */
enum class UserStatusOrderField(val label: String) {
      UpdatedAt("UPDATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): UserStatusOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** Whether a user being viewed contains public or private information. */
enum class UserViewType(val label: String) {
      Private("PRIVATE"),
      Public("PUBLIC");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): UserViewType? {
      return values().find { it.label == label }
    }
  }
}







data class VerifiableDomainOrderInput(
    val direction: OrderDirection,
    val field: VerifiableDomainOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as VerifiableDomainOrderField
  )
}

/** Properties by which verifiable domain connections can be ordered. */
enum class VerifiableDomainOrderField(val label: String) {
      CreatedAt("CREATED_AT"),
      Domain("DOMAIN");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): VerifiableDomainOrderField? {
      return values().find { it.label == label }
    }
  }
}

data class VerifyVerifiableDomainInput(
    val clientMutationId: String? = null,
    val id: Any
) {
  constructor(args: Map<String, Any>) : this(
      args["clientMutationId"] as String?,
      args["id"] as Any
  )
}





data class WorkflowRunsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null,
    val orderBy: WorkflowRunOrderInput? = null
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?,
      args["orderBy"]?.let { WorkflowRunOrderInput(it as Map<String, Any>) }
  )
}



data class WorkflowFileReferenceInput(
    val path: String,
    val ref: String? = null,
    val repositoryId: Int,
    val sha: String? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["path"] as String,
      args["ref"] as String?,
      args["repositoryId"] as Int,
      args["sha"] as String?
  )
}

data class WorkflowRunDeploymentReviewsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}
data class WorkflowRunPendingDeploymentRequestsArgs(
    val after: String? = null,
    val before: String? = null,
    val first: Int? = null,
    val last: Int? = null
) {
  constructor(args: Map<String, Any>) : this(
      args["after"] as String?,
      args["before"] as String?,
      args["first"] as Int?,
      args["last"] as Int?
  )
}







data class WorkflowRunOrderInput(
    val direction: OrderDirection,
    val field: WorkflowRunOrderField
) {
  constructor(args: Map<String, Any>) : this(
      args["direction"] as OrderDirection,
      args["field"] as WorkflowRunOrderField
  )
}

/** Properties by which workflow run connections can be ordered. */
enum class WorkflowRunOrderField(val label: String) {
      CreatedAt("CREATED_AT");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): WorkflowRunOrderField? {
      return values().find { it.label == label }
    }
  }
}

/** The possible states for a workflow. */
enum class WorkflowState(val label: String) {
      Active("ACTIVE"),
      Deleted("DELETED"),
      DisabledFork("DISABLED_FORK"),
      DisabledInactivity("DISABLED_INACTIVITY"),
      DisabledManually("DISABLED_MANUALLY");
        
  companion object {
    @JvmStatic
    fun valueOfLabel(label: String): WorkflowState? {
      return values().find { it.label == label }
    }
  }
}



data class WorkflowsParametersInput(
    val doNotEnforceOnCreate: Boolean? = null,
    val workflows: Iterable<WorkflowFileReferenceInput>
) {
  @Suppress("UNCHECKED_CAST")
  constructor(args: Map<String, Any>) : this(
      args["doNotEnforceOnCreate"] as Boolean?,
      args["workflows"]!!.let { workflows -> (workflows as List<Map<String, Any>>).map { WorkflowFileReferenceInput(it) } }
  )
}