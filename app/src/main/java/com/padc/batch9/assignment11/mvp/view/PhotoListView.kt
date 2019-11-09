package com.padc.batch9.assignment11.mvp.view

import com.padc.batch9.assignment11.data.vo.PhotoListVo

interface PhotoListView:BaseView {

    fun showProgress()

    fun hideProgress()

    fun displayPhotoList(list:List<PhotoListVo>)

    fun displayError(message:String)

    fun navigateToDetail(vo:PhotoListVo)

    fun displaySearchResult(lis:List<PhotoListVo>)
}