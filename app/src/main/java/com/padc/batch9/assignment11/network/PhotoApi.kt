package com.padc.batch9.assignment11.network

import com.padc.batch9.assignment11.data.vo.PhotoDetailVo
import com.padc.batch9.assignment11.data.vo.PhotoListVo
import com.padc.batch9.assignment11.util.ACCESS_KEY
import com.padc.batch9.assignment11.util.GET_PHOTO_DETAIL
import com.padc.batch9.assignment11.util.GET_PHOTO_LIST
import com.padc.batch9.assignment11.util.GET_SEARCH_RESULT
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {


    @GET(GET_PHOTO_LIST)
    fun getAllPhotosObservable(@Query("client_id") clientId:String= ACCESS_KEY): Observable<List<PhotoListVo>>

    @GET(GET_PHOTO_DETAIL)
    fun getPhotoDetailObserbable(@Query("client_id") clientId: String= ACCESS_KEY,
        @Query("id") id:String):Observable<List<PhotoDetailVo>>

    @GET(GET_SEARCH_RESULT)
    fun searchPhoto(@Query("client_id") clientId: String= ACCESS_KEY,
                    @Query("query") query:String,
                    @Query("orientation") orientation:String="portrait"):Observable<List<PhotoListVo>>
}