package com.padc.batch9.assignment11.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.batch9.assignment11.data.vo.PhotoDetailVo
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
abstract class PhotoDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPhotoDetails(photos:List<PhotoDetailVo>): Single<LongArray>

    @Query("SELECT * FROM photo ")
    abstract fun getAllPhotoDetails(): LiveData<List<PhotoDetailVo>>

    @Query("SELECT * FROM photo WHERE id=:id")
    abstract fun getPhotoDetailById(id:String): LiveData<PhotoDetailVo>

    @Query("select * from photo")
    abstract fun getAllPhotoDetailsMaybe(): Maybe<List<PhotoDetailVo>>
}