package com.teaphy.diffutildemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.teaphy.diffutildemo.adapter.StudentAdapter
import com.teaphy.diffutildemo.bean.StudentBean
import kotlinx.android.synthetic.main.activity_sorted_list.*

class SortedListActivity : AppCompatActivity() {

    private val mAdapter = StudentAdapter()

    private val mList = mutableListOf<StudentBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorted_list)

        initData()

        initView()

        setListener()

    }

    private fun initData() {

    }

    private fun initView() {
        rvSorted.apply {
            layoutManager = LinearLayoutManager(this@SortedListActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }

        initList()
    }

    private fun setListener() {
        btnNo.setOnClickListener({
            mAdapter.mCallback.setType(SortedType.NO)

            resetData()
        })

        btnNoReverse.setOnClickListener({
            mAdapter.mCallback.setType(SortedType.NO_REVERSE)

            resetData()
        })

        btnRank.setOnClickListener({
            mAdapter.mCallback.setType(SortedType.RANK)

            resetData()

        })

        btnRankReverse.setOnClickListener({
            mAdapter.mCallback.setType(SortedType.RANK_REVERSE)

            resetData()
        })

    }

    /**
     * @desc 重置数据
     * @author Tiany
     * @time 2018/4/4 0004 下午 3:46
     */
    private fun resetData() {
        with(mAdapter.mSortedList) {
            beginBatchedUpdates()
            clear()
            // 当SortedList清空数据时，Adapter必须调用notifyDataSetChanged
            // 否则报异常  java.lang.IndexOutOfBoundsException: Inconsistency detected.
            mAdapter.notifyDataSetChanged()
            addAll(mList)
            endBatchedUpdates()
        }
    }

    private fun initList() {

        // 当数据过大时，如果在主线程更新数据会造成ANR
        // 不要再主线程 处理大数据
        val length = 200
        mList.apply {
            for (i in 1..length) {
                if (i == 2 || i == 3) {
                    mList.add(StudentBean(2, "A - $i", length + 1 - i))
                } else {
                    mList.add(StudentBean(i, "A - $i", length + 1 - i))
                }

            }
        }

        mAdapter.mSortedList.beginBatchedUpdates()
        // mayModifyInput用于设置是否允许修改
        mAdapter.mSortedList.addAll(mList.toTypedArray(), false)
        mAdapter.mSortedList.endBatchedUpdates()
    }

    enum class SortedType {
        NO, NO_REVERSE, RANK, RANK_REVERSE
    }

}
