package com.padc.batch9.assignment11.data.vo

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName


data class UrlsVo (

    @SerializedName("raw")
    @ColumnInfo(name = "raw")
    var raw: String,
    @SerializedName("full")
    @ColumnInfo(name = "full")
    var full: String,
    @SerializedName("regular")
    @ColumnInfo(name = "regular")
    var regular: String,
    @SerializedName("small")
    @ColumnInfo(name = "small")
    var small: String,
    @SerializedName("thumb")
    @ColumnInfo(name = "thumb")
    var thumb: String
){
}