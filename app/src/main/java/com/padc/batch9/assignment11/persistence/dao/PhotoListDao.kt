package com.padc.batch9.assignment11.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.padc.batch9.assignment11.data.vo.PhotoDetailVo
import com.padc.batch9.assignment11.data.vo.PhotoListVo
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
abstract class PhotoListDao {
    @Insert(onConflict = REPLACE)
    abstract fun insertPhotos(photos:List<PhotoListVo>): Single<LongArray>

    @Query("SELECT * FROM photo ")
    abstract fun getAllPhotos(): LiveData<List<PhotoListVo>>

    @Query("SELECT * FROM photo WHERE id=:id")
    abstract fun getPhotoById(id:String):LiveData<PhotoListVo>

    @Query("select * from photo")
    abstract fun getAllPhotosMaybe(): Maybe<List<PhotoListVo>>

}