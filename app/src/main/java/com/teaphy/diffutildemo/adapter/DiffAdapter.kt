package com.teaphy.diffutildemo.adapter

import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teaphy.diffutildemo.R
import com.teaphy.diffutildemo.bean.DiffBean
import com.teaphy.diffutildemo.callback.DiffCallback
import com.teaphy.diffutildemo.global.KEY_DESC
import com.teaphy.diffutildemo.viewholder.DiffViewHolder

/**
 * @desc
 * @author Tiany
 * @date  2018/3/26 0026
 */
class DiffAdapter : RecyclerView.Adapter<DiffViewHolder>() {


    val mList: MutableList<DiffBean> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_diff, parent, false)

        return DiffViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: DiffViewHolder, position: Int, payloads: MutableList<Any>) {
        // 如果payload为null，Adapter必须运行完整绑定
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
        } else {
            val bundle = payloads[0] as Bundle
            holder.tvDesc.text = bundle.getString(KEY_DESC)
        }
    }

    override fun onBindViewHolder(holder: DiffViewHolder, position: Int) {

        val diffBean: DiffBean = mList[position]

        holder.tvName.text = diffBean.name
        holder.tvDesc.text = diffBean.desc
    }

    fun setData(list: List<DiffBean>) {

        //利用DiffUtil.calculateDiff()方法，传入一个规则DiffUtil.Callback对象，和是否检测移动item的 boolean变量，得到DiffUtil.DiffResult 的对象
        val result: DiffUtil.DiffResult = DiffUtil.calculateDiff(DiffCallback(mList, list), true)

        //利用DiffUtil.DiffResult对象的dispatchUpdatesTo（）方法，传入RecyclerView的Adapter，轻松成为文艺青年
        result.dispatchUpdatesTo(this)
        // 更新数据集，必须放在dispatchUpdatesTo之后，否则getChangePayload()将无效
        // 因为Adapter的数据集已是新数据集
        mList.clear()
        mList.addAll(list)
    }

}