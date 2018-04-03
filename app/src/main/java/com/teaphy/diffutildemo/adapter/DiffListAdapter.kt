package com.teaphy.diffutildemo.adapter

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.recyclerview.extensions.ListAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teaphy.diffutildemo.R
import com.teaphy.diffutildemo.bean.DiffBean
import com.teaphy.diffutildemo.callback.DiffItemCallback
import com.teaphy.diffutildemo.viewholder.DiffViewHolder

/**
 * @desc
 * @author Tiany
 * @date  2018/4/3 0003
 */
class DiffListAdapter : ListAdapter<DiffBean, DiffViewHolder> {

    constructor() : this(DiffItemCallback())

    constructor(itemCallback: DiffItemCallback) : super(itemCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_diff, parent, false)

        return DiffViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiffViewHolder, position: Int) {

        val diffBean: DiffBean = getItem(position)

        holder.tvName.text = diffBean.name
        holder.tvDesc.text = diffBean.desc
    }
}