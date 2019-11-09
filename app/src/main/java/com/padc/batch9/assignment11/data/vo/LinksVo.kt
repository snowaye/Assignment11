package com.padc.batch9.assignment11.data.vo


import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class LinksVo (
    @SerializedName("self")
    @ColumnInfo(name = "self")
    var self:String,

    @SerializedName("html")
    @ColumnInfo(name = "html")
    var html:String,

    @SerializedName("download")
    @ColumnInfo(name = "download")
    var download:String,

    @SerializedName("download_location")
    @ColumnInfo(name = "download_location")
    var downloadLocation:String
) {
}