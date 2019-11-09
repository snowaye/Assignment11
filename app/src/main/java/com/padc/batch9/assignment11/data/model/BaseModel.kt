package com.padc.batch9.assignment11.data.model

import android.content.Context
import com.padc.batch9.assignment11.network.dataagent.*
import com.padc.batch9.assignment11.persistence.PhotoDatabase

abstract class BaseModel {
//    protected val dataAgent:PhotoDataAgent = PhotoDataAgentImpl
//    protected val detailAgent:PhotoDetailDataAgent = PhotoDetailDataAgentImpl
//    protected val searchAgent:SearchDataAgent = SearchDataAgentImpl
    protected val dataAgent = DataAgentImpl

    protected lateinit var database: PhotoDatabase

    fun initDatabase(context: Context){
        database = PhotoDatabase.getInstance(context)
    }
}