package com.padc.batch9.assignment11.persistence.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.batch9.assignment11.data.vo.Links_Vo

class LinkrTypeConverter {
    @TypeConverter
    fun toString(list: Links_Vo):String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toJson(jsonStr:String): Links_Vo {
        val typeToken = object : TypeToken<Links_Vo>(){}.type
        return Gson().fromJson(jsonStr, typeToken)
    }
}