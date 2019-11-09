package com.padc.batch9.assignment11.persistence.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.batch9.assignment11.data.vo.UserVo

class UserTypeConverter {
    @TypeConverter
    fun toString(list:UserVo):String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toJson(jsonStr:String):UserVo {
        val typeToken = object :TypeToken<UserVo>(){}.type
        return Gson().fromJson(jsonStr, typeToken)
    }
}