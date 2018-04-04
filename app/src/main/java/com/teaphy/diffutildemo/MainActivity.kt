package com.teaphy.diffutildemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.teaphy.diffutildemo.adapter.DiffListAdapter

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        initView()

        setListener()

    }

    private fun initData() {

    }

    private fun initView() {


    }

    private fun setListener() {
        btnDiff.setOnClickListener({
            startActivity<DiffActivity>()
        })

        btnAld.setOnClickListener({
            startActivity<AsyncListDifferActivity>()
        })

        btnLa.setOnClickListener({
            startActivity<ListAdapterActivity>()
        })

        btnSl.setOnClickListener({
            startActivity<SortedListActivity>()
        })
    }


}
