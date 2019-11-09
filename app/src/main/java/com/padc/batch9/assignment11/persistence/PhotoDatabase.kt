package com.padc.batch9.assignment11.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.padc.batch9.assignment11.data.vo.PhotoDetailVo
import com.padc.batch9.assignment11.data.vo.PhotoListVo
import com.padc.batch9.assignment11.persistence.dao.PhotoDetailDao
import com.padc.batch9.assignment11.persistence.dao.PhotoListDao
import com.padc.batch9.assignment11.persistence.typeconverter.*
import com.padc.batch9.assignment11.util.PHOTO_DB

@Database(entities = arrayOf(PhotoListVo::class, PhotoDetailVo::class), version = 21, exportSchema = false)
@TypeConverters (UserTypeConverter::class, StringTypeConverter::class,
   ProfileImage_VoTypeConverter::class)
// SponsorTypeConverter::class, LinkrTypeConverter::class,
abstract class PhotoDatabase: RoomDatabase() {

    abstract fun photoListDao():PhotoListDao

    abstract fun photoDetailDao():PhotoDetailDao

    companion object {
        private var instance:PhotoDatabase?=null

        fun getInstance(context:Context):PhotoDatabase {
            if (instance==null) {
                instance = Room.databaseBuilder(context, PhotoDatabase::class.java, PHOTO_DB)
                   // .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build()
            }
            val db = instance!!
            return db
        }
    }
}