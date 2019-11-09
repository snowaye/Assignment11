package com.padc.batch9.assignment11.network.dataagent

import com.padc.batch9.assignment11.data.vo.PhotoDetailVo
import com.padc.batch9.assignment11.data.vo.PhotoListVo
import com.padc.batch9.assignment11.util.EM_NULL_PHOTO_DETAIL_LIST_RESPONSE
import com.padc.batch9.assignment11.util.EM_NULL_PHOTO_LIST_RESPONSE
import com.padc.batch9.assignment11.util.EM_NULL_SEARCH_LIST_RESPONSE
import io.reactivex.Observable

object DataAgentImpl:BaseDataAgent(), DataAgent {

    override fun getPhotosObservable(): Observable<List<PhotoListVo>> {
        return photoApi.getAllPhotosObservable()
            .flatMap<List<PhotoListVo>>{

                //val data = it.data
                if (it ==null) {
                    Observable.error(RuntimeException(EM_NULL_PHOTO_LIST_RESPONSE))
                }
                else {
                    Observable.just(it)
                }
            }
    }

    override fun getPhotoDetailObservable(id: String): Observable<List<PhotoDetailVo>> {
        return photoApi.getPhotoDetailObserbable(id=id)
            .flatMap {
                if (it==null) {
                    Observable.error(java.lang.RuntimeException(EM_NULL_PHOTO_DETAIL_LIST_RESPONSE))
                }
                else {
                    Observable.just(it)
                }

            }
    }

    override fun searchPhoto(query: String): Observable<List<PhotoListVo>> {
        return photoApi.searchPhoto(query=query)
            .flatMap {
                if (it==null) {
                    Observable.error(java.lang.RuntimeException(EM_NULL_SEARCH_LIST_RESPONSE))
                }
                else {
                    Observable.just(it)
                }
            }
    }
}