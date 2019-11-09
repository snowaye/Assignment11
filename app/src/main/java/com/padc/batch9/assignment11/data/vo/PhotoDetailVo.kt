package com.padc.batch9.assignment11.data.vo

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "detail")
data class PhotoDetailVo (

    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: String,

    @SerializedName("created_at")
    @Expose
    @ColumnInfo(name = "created_at")
    var createdAt: String,


    @SerializedName("updated_at")
    @Expose
    @ColumnInfo(name = "updated_at")
    var updatedAt: String?,


    @SerializedName("promoted_at")
    @Expose
    @ColumnInfo(name = "promoted_at")
    var promotedAt: String?,


    @SerializedName("width")
    @Expose
    @ColumnInfo(name = "width")
    var width: Int = 0,


    @SerializedName("height")
    @Expose
    @ColumnInfo(name = "height")
    var height: Int = 0,

    @SerializedName("color")
    @Expose
    @ColumnInfo(name = "color")
    var color: String,


    @SerializedName("description")
    @Expose
    @ColumnInfo(name = "description")
    var description: String?,


    @SerializedName("alt_description")
    @Expose
    @ColumnInfo(name = "alt_description")
    var altDescription: String?,

    @SerializedName("urls")
    @Expose
    @Embedded(prefix = "urls")
    var urls: UrlsVo,

//    @SerializedName("links")
//    @Expose
//    @Embedded(prefix = "links")
//    var links: LinksVo,

//    @SerializedName("categories")
//    @Expose
//    var categories: List<String>?,

    @SerializedName("likes")
    @Expose
    @ColumnInfo(name = "likes")
    var likes: Int = 0,

    @SerializedName("liked_by_user")
    @Expose
    @ColumnInfo(name = "liked_by_user")
    var likedByUser: Boolean = false,


//    @SerializedName("current_user_collections")
//    @Expose
//    var currentUserCollections: List<String>?,


    @SerializedName("user")
    var user: UserVo


//    @SerializedName("sponsorship")
//    @Embedded(prefix = "sponsorship")
//    var sponsorship: SponsorshipVo

) {

}