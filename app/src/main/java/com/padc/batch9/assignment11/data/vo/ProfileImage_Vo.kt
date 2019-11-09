package com.padc.batch9.assignment11.data.vo

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class ProfileImage_Vo (

    @SerializedName("small")
    @ColumnInfo(name = "small")
    var small: String,

    @SerializedName("medium")
    @ColumnInfo(name = "medium")
    var medium: String,

    @SerializedName("large")
    @ColumnInfo(name = "large")
    var large: String
){
}