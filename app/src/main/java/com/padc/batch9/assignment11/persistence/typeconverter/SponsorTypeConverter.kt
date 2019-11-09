package com.padc.batch9.assignment11.persistence.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.batch9.assignment11.data.vo.SponsorVo

class SponsorTypeConverter {
    @TypeConverter
    fun toString(list: SponsorVo):String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toJson(jsonStr:String): SponsorVo {
        val typeToken = object : TypeToken<SponsorVo>(){}.type
        return Gson().fromJson(jsonStr, typeToken)
    }
}