package com.kkh.mynews.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kkh.mynews.R
import com.kkh.mynews.common.Constant
import com.kkh.mynews.item.contents.ContentsModel
import com.kkh.mynews.item.news.model.NewsItemsModel
import com.kkh.mynews.view.`interface`.IContentsEvent
import com.kkh.mynews.view.adapter.presenter.Presenter

class ContentsAdapter() : PagedListAdapter<ContentsModel, ContentsAdapter.ViewHolder>(
    DIFF_CALLBACK
) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mCardView: CardView = view.findViewById(R.id.card_view)
        val mTitle: TextView = view.findViewById(R.id.title)
        val mRecyclerView: RecyclerView = view.findViewById(R.id.rview)
    }

    companion object {
        const val TAG = Constant.TAG_PREFIX + "ContentsAdapter"
        const val VIEW_TYPE_NEWS = 0
        const val VIEW_TYPE_SHOPPING = 1
        const val VIEW_TYPE_IMAGE = 2

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
    private var mPresenter:Presenter= Presenter()
    private lateinit var mIContentsEvent:IContentsEvent
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        Log.d(TAG, "onCreateViewHolder")
        return ContentsAdapter.ViewHolder(view)
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
        mIContentsEvent.onBindItem(data)
        mPresenter.update(data,holder)
    }


    fun setList(list: java.util.ArrayList<ContentsModel>) {
        Log.d(TAG, "setList list ${list.size}")
        mList = list
        notifyDataSetChanged()
    }

    fun setEvent(event:IContentsEvent){
        mIContentsEvent = event
    }
}