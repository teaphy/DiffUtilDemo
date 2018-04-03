package com.teaphy.diffutildemo.adapter

import android.os.Bundle
import android.support.v7.recyclerview.extensions.AsyncListDiffer
import android.support.v7.widget.RecyclerView
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
class AsyncListDifferAdapter : RecyclerView.Adapter<DiffViewHolder>() {

    val mAld = AsyncListDiffer<DiffBean>(this, DiffItemCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_diff, parent, false)

        return DiffViewHolder(view)
    }

    override fun getItemCount(): Int {
       return mAld.currentList.size
    }

    override fun onBindViewHolder(holder: DiffViewHolder, position: Int) {

        val diffBean: DiffBean = mAld.currentList[position]

        holder.tvName.text = diffBean.name
        holder.tvDesc.text = diffBean.desc
    }

    fun submitList(list: List<DiffBean>?) {
        mAld.submitList(list)
    }
}