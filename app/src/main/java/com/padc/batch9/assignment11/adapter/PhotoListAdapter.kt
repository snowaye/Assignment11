package com.padc.batch9.assignment11.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padc.batch9.assignment11.R
import com.padc.batch9.assignment11.data.vo.PhotoListVo
import com.padc.batch9.assignment11.delegate.PhotoListDelegate
import com.padc.batch9.assignment11.viewholder.PhotoViewHolder
import com.padc.padckotlin.adapters.BaseAdapter

class PhotoListAdapter(private val delegate: PhotoListDelegate):BaseAdapter<PhotoViewHolder, PhotoListVo>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.listitem_photo,
            parent, false)
        return PhotoViewHolder(view, delegate)
    }
}