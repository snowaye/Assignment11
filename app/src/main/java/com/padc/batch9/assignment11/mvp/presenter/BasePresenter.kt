package com.padc.batch9.assignment11.mvp.presenter

import androidx.lifecycle.ViewModel
import com.padc.batch9.assignment11.mvp.view.BaseView

abstract class BasePresenter<T: BaseView>:ViewModel() {
    protected lateinit var mView:T

    open fun initPresenter(view:T) {
        this.mView = view
    }
}