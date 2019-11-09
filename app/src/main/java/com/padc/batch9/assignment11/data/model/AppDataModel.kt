package com.padc.batch9.assignment11.data.model

import androidx.lifecycle.LiveData
import com.padc.batch9.assignment11.data.vo.PhotoDetailVo
import com.padc.batch9.assignment11.data.vo.PhotoListVo

interface AppDataModel {
    fun getAllPhotos(
        onFailure: (String) -> Unit): LiveData<List<PhotoListVo>>

    fun getPhotoById(id:String): LiveData<PhotoListVo>

    fun getAllPhotoDetails(id:String,
                           onFailure: (String) -> Unit): LiveData<List<PhotoDetailVo>>

    fun getPhotoDetailById(id:String): LiveData<PhotoDetailVo>

    fun getAllSearchResultPhotos(query:String,
                                 onFailure: (String) -> Unit): LiveData<List<PhotoListVo>>
}