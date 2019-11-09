package com.padc.batch9.assignment11.viewholder

import android.view.View
import coil.api.load
import com.padc.batch9.assignment11.data.vo.PhotoListVo
import com.padc.batch9.assignment11.delegate.PhotoListDelegate
import com.padc.padckotlin.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.listitem_photo.view.*

class PhotoViewHolder(itemView: View, delegate: PhotoListDelegate): BaseViewHolder<PhotoListVo>(itemView) {

    init {
        itemView.setOnClickListener {

            data?.let {
                delegate.onTapPhotoListItemView(it)
            }
        }
    }

    override fun bindData(data: PhotoListVo) {
        itemView.imgv_photo.load(data.urls.small) {
            crossfade(true)
            crossfade(2000)
        }
    }
}