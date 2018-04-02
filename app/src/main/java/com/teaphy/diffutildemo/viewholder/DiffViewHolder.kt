package com.teaphy.diffutildemo.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.teaphy.diffutildemo.R

/**
 * @desc
 * @author Tiany
 * @date  2018/4/2 0002
 */
class DiffViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    val tvDesc = itemView.findViewById<TextView>(R.id.tvDesc)
}