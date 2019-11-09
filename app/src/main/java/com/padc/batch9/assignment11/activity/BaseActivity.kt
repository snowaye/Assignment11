package com.padc.padckotlin.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padc.batch9.assignment11.data.model.AppDataModel
import com.padc.batch9.assignment11.data.model.AppDataModelImpl

abstract class BaseActivity: AppCompatActivity() {
    protected lateinit var model: AppDataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = AppDataModelImpl
    }
}