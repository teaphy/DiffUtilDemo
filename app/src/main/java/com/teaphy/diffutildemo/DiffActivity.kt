package com.teaphy.diffutildemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.util.Log
import com.teaphy.diffutildemo.adapter.DiffAdapter
import com.teaphy.diffutildemo.bean.DiffBean
import org.jetbrains.anko.toast

import kotlinx.android.synthetic.main.activity_diff.*

class DiffActivity : AppCompatActivity() {

    private var mList = mutableListOf<DiffBean>()
    private val mAdapter: DiffAdapter = DiffAdapter()

    private var countRefresh = 1
    private var countUpdate = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff)

        initData()

        initView()

        setListener()

    }

    private fun initData() {
        mList.apply {
            add(DiffBean("A", "这是A"))
            add(DiffBean("B", "这是B"))
            add(DiffBean("C", "这是C"))
            add(DiffBean("D", "这是D"))
            add(DiffBean("E", "这是E"))
        }

    }

    private fun initView() {

        rvDiff.apply {
            layoutManager = LinearLayoutManager(this@DiffActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }

        mAdapter.setData(mList)
    }

    private fun setListener() {
        btnAdd.setOnClickListener({
            when {
                TextUtils.isEmpty(editName.text) -> toast(editName.hint)
                TextUtils.isEmpty(editDesc.text) -> toast(editDesc.hint)
                else -> {
                    val bean = DiffBean(editName.text.toString(), editDesc.text.toString())
                    mList.add(bean)
                    mAdapter.setData(mList)
                }
            }
        })

        btnUpdate.setOnClickListener({

            Log.e("tea", "update")
            val bean = mList[0]
            val diffBean = DiffBean(bean.name, "这是A -- $countUpdate")
            mList[0] = diffBean

            mAdapter.setData(mList)

            countUpdate++

            Log.e("tea", "mList: $mList")
        })

        btnDelete.setOnClickListener({
            mList.removeAt(0)
            mAdapter.setData(mList)
        })

        btnRefresh.setOnClickListener({
            val newList = mutableListOf<DiffBean>()
            newList.apply {
                add(DiffBean("A", "这是A--更新次数：$countRefresh"))
                add(DiffBean("B", "这是B--更新次数：$countRefresh"))
                add(DiffBean("C", "这是C--更新次数：$countRefresh"))
                add(DiffBean("D", "这是D--更新次数：$countRefresh"))
                add(DiffBean("E", "这是E--更新次数：$countRefresh"))
                countRefresh++
            }

            mAdapter.setData(newList)
        })

    }

}
