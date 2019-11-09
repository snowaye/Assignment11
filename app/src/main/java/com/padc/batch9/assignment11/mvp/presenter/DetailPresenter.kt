package com.padc.batch9.assignment11.mvp.presenter

import android.util.Log
import androidx.lifecycle.Observer
import com.padc.batch9.assignment11.data.model.AppDataModelImpl
import com.padc.batch9.assignment11.delegate.DetailDelegate
import com.padc.batch9.assignment11.mvp.view.PhotoDetailView
import com.padc.padckotlin.activities.BaseActivity

class DetailPresenter : BasePresenter<PhotoDetailView>(), DetailDelegate {

    override fun onTapNavigateBackButton() {
       mView.navigateBack()
    }

    fun onUIReady(activity: BaseActivity, id:String) {
        var mModel = AppDataModelImpl
        mModel.getPhotoById(id).observeForever {
            mView.displayUserInfo(it)
        }
        var model = AppDataModelImpl
        model.getAllPhotoDetails(id) {
            mView.displayError(it)
        }.observe(activity, Observer{
            Log.i("DetailPresenter", "list="+it.size)
            mView.displayDetailPhotoLisst(it)
        })
    }
}