package com.padc.batch9.assignment11.data.vo

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class UserVo (

    @SerializedName("id")
    @ColumnInfo(name="id")
    var id: String,
    @SerializedName("updated_at")
    @ColumnInfo(name="updated_at")
    var updatedAt: String,
    @SerializedName("username")
    @ColumnInfo(name="username")
    var username: String,
    @SerializedName("name")
    @ColumnInfo(name="name")
    var name: String,
    @SerializedName("first_name")
    @ColumnInfo(name = "first_name")
    var firstName: String,
    @SerializedName("last_name")
    @ColumnInfo(name = "last_name")
    var lastName: String,
    @SerializedName("twitter_username")
    @ColumnInfo(name="twitter_username")
    var twitterUsername: String,
    @SerializedName("portfolio_url")
    @ColumnInfo(name="portfolio_url")
    var portfolioUrl: String,
    @SerializedName("bio")
    @ColumnInfo(name = "bio")
    var bio: String,
    @SerializedName("location")
    @ColumnInfo(name = "location")
    var location: String,
//    @SerializedName("links")
//    @ColumnInfo(name = "links")
//    @Embedded(prefix = "uservo_link")
//    var links: Links_Vo,
    @SerializedName("profile_image")
    @ColumnInfo(name = "uservo_profile_image")
    @Embedded(prefix = "uservo_profile_image")
    var profileImage: ProfileImageVo,
    @SerializedName("instagram_username")
    @ColumnInfo(name = "instagram_username")
    var instagramUsername: String,
    @SerializedName("total_collections")
    @ColumnInfo(name = "total_collections")
    var totalCollections: Int = 0,
    @SerializedName("total_likes")
    @ColumnInfo(name = "total_likes")
    var totalLikes: Int = 0,
    @SerializedName("total_photos")
    @ColumnInfo(name="total_photos")
    var totalPhotos: Int = 0,
    @SerializedName("accepted_tos")
    @ColumnInfo(name = "accepted_tos")
    var acceptedTos: Boolean = false

){

}