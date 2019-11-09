package com.padc.batch9.assignment11.data.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.padc.batch9.assignment11.data.vo.PhotoDetailVo
import com.padc.batch9.assignment11.data.vo.PhotoListVo
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object AppDataModelImpl: BaseModel(), AppDataModel{

    override fun getAllPhotos(onFailure: (String) -> Unit): LiveData<List<PhotoListVo>> {
        val databaseSingle = database.photoListDao().getAllPhotosMaybe().subscribeOn(
            Schedulers.io())
            .flatMap {     if (it.isEmpty()) Maybe.empty()
            else Maybe.just(it) }


        val networkObservable =  dataAgent.getPhotosObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                onFailure(it.localizedMessage)
                Log.e("PhotoImpl", it.localizedMessage)
            }
            .doOnNext { Log.i("PhotoImpl", "size==>"+it.size)  }

        Observable.concat(databaseSingle.toObservable(), networkObservable)
            .firstElement()
            //  .observeOn(AndroidSchedulers.mainThread())
            .flatMap <LongArray> {
                database.photoListDao().insertPhotos(it).subscribeOn(Schedulers.io()).toMaybe()
            }
            .subscribe(
                {

                    Log.i("PhotoImpl", "longArray="+it.count())
                },
                {
                    onFailure(it.localizedMessage)
                    Log.e("PhotoImpl", it.localizedMessage)
                }
            )

        return Transformations.distinctUntilChanged(
            database.photoListDao().getAllPhotos())

    }

    override fun getPhotoById(id: String): LiveData<PhotoListVo> {
        return Transformations.distinctUntilChanged(
            database.photoListDao().getPhotoById(id)
        )
    }

    override fun getAllPhotoDetails(
        id: String,
        onFailure: (String) -> Unit
    ): LiveData<List<PhotoDetailVo>> {
        val databaseSingle =
            database.photoDetailDao().getAllPhotoDetailsMaybe().subscribeOn(
                Schedulers.io())
                .flatMap {     if (it.isEmpty()) Maybe.empty()
                else Maybe.just(it) }


        val networkObservable =  dataAgent.getPhotoDetailObservable(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                onFailure(it.localizedMessage)
                Log.e("PhotoImpl", it.localizedMessage)
            }
            .doOnNext { Log.i("PhotoImpl", "size==>"+it.size)  }

        Observable.concat(databaseSingle.toObservable(), networkObservable)
            .firstElement()
            //  .observeOn(AndroidSchedulers.mainThread())
            .flatMap <LongArray> {
                database.photoDetailDao().insertPhotoDetails(it).subscribeOn(Schedulers.io()).toMaybe()
            }
            .subscribe(
                {

                    Log.i("PhotoImpl", "longArray="+it.count())
                },
                {
                    onFailure(it.localizedMessage)
                    Log.e("PhotoImpl", it.localizedMessage)
                }
            )

        return Transformations.distinctUntilChanged(
            database.photoDetailDao().getAllPhotoDetails())

    }

    override fun getPhotoDetailById(id: String): LiveData<PhotoDetailVo> {
        return Transformations.distinctUntilChanged(
            database.photoDetailDao().getPhotoDetailById(id)
        )
    }

    override fun getAllSearchResultPhotos(
        query: String,
        onFailure: (String) -> Unit
    ): LiveData<List<PhotoListVo>> {
        val databaseSingle = database.photoListDao().getAllPhotosMaybe().subscribeOn(
            Schedulers.io())
            .flatMap {     if (it.isEmpty()) Maybe.empty()
            else Maybe.just(it) }


        val networkObservable =  dataAgent.searchPhoto(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                onFailure(it.localizedMessage)
                Log.e("PhotoImpl", it.localizedMessage)
            }
            .doOnNext { Log.i("PhotoImpl", "size==>"+it.size)  }

        Observable.concat(databaseSingle.toObservable(), networkObservable)
            .firstElement()
            //  .observeOn(AndroidSchedulers.mainThread())
            .flatMap <LongArray> {
                database.photoListDao().insertPhotos(it).subscribeOn(Schedulers.io()).toMaybe()
            }
            .subscribe(
                {

                    Log.i("PhotoImpl", "longArray="+it.count())
                },
                {
                    onFailure(it.localizedMessage)
                    Log.e("PhotoImpl", it.localizedMessage)
                }
            )

        return Transformations.distinctUntilChanged(
            database.photoListDao().getAllPhotos())
    }

}