package com.kkh.mynews.data.item.contents.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kkh.mynews.common.Constant
import com.kkh.mynews.data.item.contents.ContentsModel
import com.kkh.mynews.databinding.ListContentsItemLayoutBinding
import com.kkh.mynews.view.Presenter
import java.util.*
import kotlin.collections.ArrayList

class ContentsAdapter() : PagedListAdapter<ContentsModel, ContentsAdapter.ViewHolder>(
    DIFF_CALLBACK
) {

    class ViewHolder(b: ListContentsItemLayoutBinding) : RecyclerView.ViewHolder(b.root) {
        var binding: ListContentsItemLayoutBinding = b
    }

    companion object {
        const val TAG = Constant.TAG_PREFIX + "ContentsAdapter"

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ContentsModel>() {
            override fun areItemsTheSame(
                oldItem: ContentsModel,
                newItem: ContentsModel
            ): Boolean {
                return oldItem.viewType == newItem.viewType
            }

            override fun areContentsTheSame(
                oldItem: ContentsModel,
                newItem: ContentsModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    private var mList: List<ContentsModel> = ArrayList<ContentsModel>()
    private lateinit var mPresenter: Presenter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder")
        mPresenter = Presenter(parent.context)
        val binding =
            ListContentsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder")
        val data = mList[position]
        val v = holder.binding
        mPresenter.update(data, v)

    }


    fun setList(list: java.util.ArrayList<ContentsModel>) {
        Log.d(TAG, "setList list ${list.size}")
        Collections.sort(
            mList
        ) { o1, o2 -> o1.uid - o2.uid }

        mList = list
        notifyDataSetChanged()
    }

}