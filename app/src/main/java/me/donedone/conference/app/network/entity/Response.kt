package me.donedone.conference.app.network.entity

import com.google.gson.annotations.SerializedName
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class Response(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("pageSize")
	val pageSize: String? = null,

	@field:SerializedName("page")
	val page: String? = null,

	@field:SerializedName("rows")
	val rows: List<RowsItem?>? = null
)

@Serializable
data class HostOrganization(

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("profileImage")
	val profileImage: String? = null,

	@field:SerializedName("organizationId")
	val organizationId: Int? = null,

	@field:SerializedName("bannerImage")
	val bannerImage: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: Instant? = null,

	@field:SerializedName("deletedAt")
	val deletedAt: Instant? = null,

	@field:SerializedName("useHeaderImage")
	val useHeaderImage: Boolean? = null,

	@field:SerializedName("detailedDescription")
	val detailedDescription: String? = null,

	@field:SerializedName("headerImage")
	val headerImage: String? = null,

	@field:SerializedName("mainColor")
	val mainColor: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("since")
	val since: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: Instant? = null
)

@Serializable
data class RowsItem(

	@field:SerializedName("hostUserId")
	val hostUserId: Int? = null,

	@field:SerializedName("metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("tickets")
	val tickets: List<TicketsItem?>? = null,

	@field:SerializedName("endDate")
	val endDate: Instant? = null,

	@field:SerializedName("externalLink")
	val externalLink: String? = null,

	@field:SerializedName("hostUser")
	val hostUser: String? = null,

	@field:SerializedName("eventSignature")
	val eventSignature: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("isOnline")
	val isOnline: Boolean? = null,

	@field:SerializedName("hostOrganization")
	val hostOrganization: HostOrganization? = null,

	@field:SerializedName("refundDueDate")
	val refundDueDate: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: Instant? = null,

	@field:SerializedName("hostOrganizationId")
	val hostOrganizationId: Int? = null,

	@field:SerializedName("contactNumber")
	val contactNumber: String? = null,

	@field:SerializedName("tag")
	val tag: String? = null,

	@field:SerializedName("isSubscriptionEvent")
	val isSubscriptionEvent: Boolean? = null,

	@field:SerializedName("surveyRequired")
	val surveyRequired: Boolean? = null,

	@field:SerializedName("publishCount")
	val publishCount: Int? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: Instant? = null,

	@field:SerializedName("eventId")
	val eventId: Int? = null,

	@field:SerializedName("disclosure")
	val disclosure: Disclosure? = null,

	@field:SerializedName("charge")
	val charge: Boolean? = null,

	@field:SerializedName("publishedAt")
	val publishedAt: Instant? = null,

	@field:SerializedName("contactEmail")
	val contactEmail: String? = null,

	@field:SerializedName("isEmailReserved")
	val isEmailReserved: Boolean? = null,

	@field:SerializedName("published")
	val published: Boolean? = null,

	@field:SerializedName("external")
	val external: Boolean? = null,

	@field:SerializedName("deletedAt")
	val deletedAt: Instant? = null,

	@field:SerializedName("isHostPicked")
	val isHostPicked: Boolean? = null,

	@field:SerializedName("limitWaiters")
	val limitWaiters: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("online")
	val online: String? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("surveyBeforePayment")
	val surveyBeforePayment: Boolean? = null,

	@field:SerializedName("startDate")
	val startDate: Instant? = null
)

@Serializable
data class Metadata(

	@field:SerializedName("bannerImage")
	val bannerImage: String? = null,

	@field:SerializedName("contents")
	val contents: String? = null,

	@field:SerializedName("coverImage")
	val coverImage: String? = null
)

@Serializable
data class TicketsItem(

	@field:SerializedName("eventId")
	val eventId: Int? = null,

	@field:SerializedName("quantity")
	val quantity: Int? = null,

	@field:SerializedName("hideRemains")
	val hideRemains: Boolean? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("saleEndDate")
	val saleEndDate: Instant? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("saleStartDate")
	val saleStartDate: Instant? = null,

	@field:SerializedName("useSurvey")
	val useSurvey: Boolean? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("refundDueDate")
	val refundDueDate: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: Instant? = null,

	@field:SerializedName("deletedAt")
	val deletedAt: Instant? = null,

	@field:SerializedName("limitPerUser")
	val limitPerUser: Int? = null,

	@field:SerializedName("surveyNotice")
	val surveyNotice: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("registable")
	val registable: Boolean? = null,

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("ticketId")
	val ticketId: Int? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: Instant? = null
)

@Serializable
data class Location(

	@field:SerializedName("eventId")
	val eventId: Int? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("locationId")
	val locationId: Int? = null,

	@field:SerializedName("countryCode")
	val countryCode: String? = null,

	@field:SerializedName("postalCode")
	val postalCode: String? = null,

	@field:SerializedName("latitude")
	val latitude: Float? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("longitude")
	val longitude: Float? = null
)

@Serializable
data class Disclosure(

	@field:SerializedName("scope")
	val scope: String? = null,

	@field:SerializedName("obscuredLink")
	val obscuredLink: String? = null
)
