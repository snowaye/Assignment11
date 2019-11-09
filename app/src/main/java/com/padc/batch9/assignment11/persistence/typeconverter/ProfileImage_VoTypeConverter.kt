package com.padc.batch9.assignment11.persistence.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.batch9.assignment11.data.vo.Links_Vo
import com.padc.batch9.assignment11.data.vo.ProfileImage_Vo

class ProfileImage_VoTypeConverter {
    @TypeConverter
    fun toString(list: ProfileImage_Vo):String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toJson(jsonStr:String): ProfileImage_Vo {
        val typeToken = object : TypeToken<ProfileImage_Vo>(){}.type
        return Gson().fromJson(jsonStr, typeToken)
    }
}