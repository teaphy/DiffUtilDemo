package com.teaphy.diffutildemo.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.teaphy.diffutildemo.R
import kotlinx.android.synthetic.main.item_student.view.*

/**
 * @desc
 * @author Tiany
 * @date  2018/4/4 0004
 */
class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvNoValue = itemView.findViewById<TextView>(R.id.tvNoValue)
    val tvNameValue = itemView.findViewById<TextView>(R.id.tvNameValue)
    val tvRankValue = itemView.findViewById<TextView>(R.id.tvRankValue)
}