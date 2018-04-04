package com.teaphy.diffutildemo.callback

import android.support.annotation.NonNull
import android.support.v7.util.SortedList
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.util.SortedListAdapterCallback
import com.teaphy.diffutildemo.SortedListActivity
import com.teaphy.diffutildemo.bean.StudentBean

/**
 * @desc
 * @author Tiany
 * @date  2018/4/4 0004
 */
class StudentCallback<R : RecyclerView.ViewHolder, T : RecyclerView.Adapter<R>>(@NonNull private val adapter: T) : SortedListAdapterCallback<StudentBean>(adapter) {

    // 默认按照学号排序
    private var sortedType = SortedListActivity.SortedType.RANK

    // 判断两个Item是否相同
    override fun areItemsTheSame(item1: StudentBean?, item2: StudentBean?): Boolean {
        return item1?.no == item2?.no
    }

    // 排序条件
    override fun compare(o1: StudentBean?, o2: StudentBean?): Int {
        return when (sortedType) {
            SortedListActivity.SortedType.NO -> o1!!.no - o2!!.no
            SortedListActivity.SortedType.NO_REVERSE -> o2!!.no - o1!!.no
            SortedListActivity.SortedType.RANK -> o1!!.rank - o2!!.rank
            SortedListActivity.SortedType.RANK_REVERSE -> o2!!.rank - o1!!.rank
        }
    }

    // 判断两个Item的内容是否相同
    override fun areContentsTheSame(oldItem: StudentBean?, newItem: StudentBean?): Boolean {
        return oldItem == newItem
    }

    // 设置排序类型
    fun setType(type: SortedListActivity.SortedType) {
        this.sortedType = type
    }

}