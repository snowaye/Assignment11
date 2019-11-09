package com.padc.batch9.assignment11.data.vo

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.google.gson.annotations.SerializedName


data class SponsorshipVo(

    @SerializedName("impression_urls")
    @ColumnInfo(name = "impression_urls")
    var impressionUrls: List<String>,

    @SerializedName("impressions_id")
    @ColumnInfo(name = "impressions_id")
    var impressionsId: String,

    @SerializedName("tagline")
    @ColumnInfo(name = "tagline")
    var tagline: String,

    @SerializedName("sponsor")
    @ColumnInfo(name = "sponsor")
    var sponsor: SponsorVo
) {
}