package com.padc.batch9.assignment11.mvp.view

import com.padc.batch9.assignment11.data.vo.PhotoDetailVo
import com.padc.batch9.assignment11.data.vo.PhotoListVo

interface PhotoDetailView: BaseView {

    fun displayUserInfo(detail:PhotoListVo)

    fun displayDetailPhotoLisst(list:List<PhotoDetailVo>)

    fun displayError(message:String)

    fun navigateBack()
}