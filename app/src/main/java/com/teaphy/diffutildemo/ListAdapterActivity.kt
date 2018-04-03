package com.teaphy.diffutildemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.util.Log
import com.teaphy.diffutildemo.adapter.DiffListAdapter
import com.teaphy.diffutildemo.bean.DiffBean

import kotlinx.android.synthetic.main.activity_list_adapter.*
import org.jetbrains.anko.toast

class ListAdapterActivity : AppCompatActivity() {

    private var mList = mutableListOf<DiffBean>()
    private val mAdapter: DiffListAdapter = DiffListAdapter()

    private var countRefresh = 1
    private var countUpdate = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_adapter)

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
            layoutManager = LinearLayoutManager(this@ListAdapterActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }
        val newList = mutableListOf<DiffBean>()
        newList.addAll(mList)
        mAdapter.submitList(newList)
    }

    private fun setListener() {

        btnAdd.setOnClickListener({
            when {
                TextUtils.isEmpty(editName.text) -> toast(editName.hint)
                TextUtils.isEmpty(editDesc.text) -> toast(editDesc.hint)
                else -> {
                    val bean = DiffBean(editName.text.toString(), editDesc.text.toString())
                    mList.add(bean)
                    Log.e("tea", "add: $mList")
                    val newList = mutableListOf<DiffBean>()
                    newList.addAll(mList)
                    Log.e("tea", "add - newList: $newList")
                    mAdapter.submitList(newList)
                }
            }
        })

        btnUpdate.setOnClickListener({

            Log.e("tea", "update")
            val bean = mList[0]
            val diffBean = DiffBean(bean.name, "这是${bean.name} -- $countUpdate")
            mList[0] = diffBean

            val newList = mutableListOf<DiffBean>()
            newList.addAll(mList)
            mAdapter.submitList(newList)

            countUpdate++

        })

        btnDelete.setOnClickListener({
            mList.removeAt(0)
            val newList = mutableListOf<DiffBean>()
            newList.addAll(mList)
            mAdapter.submitList(newList)
        })

        btnClear.setOnClickListener({

            // 当传递null时，AsyncListDiffer将清空数据
            mAdapter.submitList(null)
        })
    }
}
