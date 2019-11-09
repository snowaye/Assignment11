package com.padc.batch9.assignment11.viewholder

import android.view.View
import coil.api.load
import com.padc.batch9.assignment11.data.vo.PhotoDetailVo
import com.padc.padckotlin.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.listitem_photo.view.*

class PhotoDetailViewHolder(itemView: View): BaseViewHolder<PhotoDetailVo>(itemView) {


    override fun bindData(data: PhotoDetailVo) {
        itemView.imgv_photo.load(data.urls.small) {
            crossfade(true)
            crossfade(2000)
        }
    }
}