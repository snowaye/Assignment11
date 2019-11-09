package com.padc.batch9.assignment11.delegate

import com.padc.batch9.assignment11.data.vo.PhotoListVo

interface PhotoListDelegate {
    fun onTapPhotoListItemView(photo:PhotoListVo)
}