package com.teaphy.diffutildemo.callback

import android.os.Bundle
import android.support.v7.util.DiffUtil
import com.teaphy.diffutildemo.bean.DiffBean
import com.teaphy.diffutildemo.global.KEY_DESC

/**
 * @desc
 * @author Tiany
 * @date  2018/4/3 0003
 */
class DiffItemCallback : DiffUtil.ItemCallback<DiffBean>() {

    override fun areItemsTheSame(oldItem: DiffBean?, newItem: DiffBean?): Boolean {
        return oldItem?.name == newItem?.name
    }

    override fun areContentsTheSame(oldItem: DiffBean?, newItem: DiffBean?): Boolean {

        if (oldItem?.desc != newItem?.desc) {
            return false
        }
        //  //默认两个data内容是相同的
        return true
    }
}