package com.padc.batch9.assignment11.data.vo

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Links_Vo (

    @SerializedName("self")
    @Expose
    @ColumnInfo(name = "self")
    var self: String,

    @SerializedName("html")
    @Expose
    @ColumnInfo(name = "html")
    var html: String,

    @SerializedName("photos")
    @Expose
    @ColumnInfo(name = "photos")
    var photos: String,

    @SerializedName("likes")
    @Expose
    @ColumnInfo(name = "likes")
    var likes: String,

    @SerializedName("portfolio")
    @Expose
    @ColumnInfo(name = "portfolio")
    var portfolio: String,

    @SerializedName("following")
    @Expose
    @ColumnInfo(name = "following")
    var following: String,

    @SerializedName("followers")
    @Expose
    @ColumnInfo(name = "followers")
    var followers: String
    ) {
}