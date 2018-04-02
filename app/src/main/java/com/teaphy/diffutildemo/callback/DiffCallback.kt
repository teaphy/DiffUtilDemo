package com.teaphy.diffutildemo.callback

import android.os.Bundle
import android.support.v7.util.DiffUtil
import com.teaphy.diffutildemo.bean.DiffBean
import com.teaphy.diffutildemo.global.KEY_DESC

/**
 * @desc
 * @author Tiany
 * @date  2018/4/2 0002
 */

class DiffCallback(private val oldList: List<DiffBean>, private val newList: List<DiffBean>) : DiffUtil.Callback() {
    /**
     * 被DiffUtil调用，用来判断 两个对象是否是相同的Item。
     * 例如，如果你的Item有唯一的id字段，这个方法就 判断id是否相等，或者重写equals方法
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    /**
     * 老数据集size
     */
    override fun getOldListSize(): Int {
        return oldList.size
    }

    /**
     * 新数据集size
     */
    override fun getNewListSize(): Int {
        return newList.size
    }

    /**
     * 被DiffUtil调用，用来检查 两个item是否含有相同的数据
     * DiffUtil用返回的信息（true false）来检测当前item的内容是否发生了变化
     */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldBean = oldList[oldItemPosition]
        val newBean = newList[newItemPosition]

        if (oldBean.desc != newBean.desc) {
            return false
        }
        //  //默认两个data内容是相同的
        return true
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {

        val oldBean = oldList[oldItemPosition]
        val newBean = newList[newItemPosition]

        val bundle = Bundle()
        if (oldBean.desc != newBean.desc) {
            bundle.putString(KEY_DESC, "getChangePayLoad: " + newBean.desc)
        } else { // 如果没有数据变化，返回null
            return null
        }

        return bundle
    }
}