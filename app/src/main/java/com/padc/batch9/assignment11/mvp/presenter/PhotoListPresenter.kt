package com.padc.batch9.assignment11.mvp.presenter

import android.util.Log
import androidx.lifecycle.Observer
import com.padc.batch9.assignment11.data.model.AppDataModelImpl
import com.padc.batch9.assignment11.data.vo.PhotoListVo
import com.padc.batch9.assignment11.delegate.PhotoListDelegate
import com.padc.batch9.assignment11.mvp.view.PhotoListView
import com.padc.padckotlin.activities.BaseActivity

class PhotoListPresenter:BasePresenter<PhotoListView>(), PhotoListDelegate {

    override fun onTapPhotoListItemView(photo: PhotoListVo) {
        mView.navigateToDetail(photo)
    }

    fun onUIReady(activity:BaseActivity) {
        var model = AppDataModelImpl
        model.getAllPhotos {
            mView.displayError(it)
        }.observe(activity, Observer{
            Log.i("PhotoListPresenter", "list="+it.size)
            mView.displayPhotoList(it)
        })
    }

    fun onEditTextChange(query:String, activity: BaseActivity) {
        mView.showProgress()
        Log.i("onEditTxtChange", "presenter="+query)
        val searchViewModel = AppDataModelImpl
        searchViewModel.getAllSearchResultPhotos(query) {
            mView.displayError(it)
        }.observe(activity, Observer {
            Log.i("onEditTextChange", "search result:"+it.size)
            mView.displaySearchResult(it) })
        mView.hideProgress()
    }
}