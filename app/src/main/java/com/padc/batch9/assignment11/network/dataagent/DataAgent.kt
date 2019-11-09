package com.padc.batch9.assignment11.network.dataagent
import com.padc.batch9.assignment11.data.vo.PhotoDetailVo
import com.padc.batch9.assignment11.data.vo.PhotoListVo
import io.reactivex.Observable

interface DataAgent {
    fun getPhotosObservable(): Observable<List<PhotoListVo>>

    fun getPhotoDetailObservable(id:String): Observable<List<PhotoDetailVo>>

    fun searchPhoto(query:String):Observable<List<PhotoListVo>>
}