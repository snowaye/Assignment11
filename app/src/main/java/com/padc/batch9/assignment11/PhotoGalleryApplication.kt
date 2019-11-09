package com.padc.batch9.assignment11

import android.app.Application
import com.padc.batch9.assignment11.data.model.AppDataModelImpl

class PhotoGalleryApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AppDataModelImpl.initDatabase(applicationContext)
    }
}