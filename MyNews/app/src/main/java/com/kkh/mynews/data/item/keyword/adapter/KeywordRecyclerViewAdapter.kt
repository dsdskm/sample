package com.kkh.mynews.data.item.keyword.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.kkh.mynews.R
import com.kkh.mynews.common.Constant
import com.kkh.mynews.data.item.keyword.model.KeywordModel
import com.kkh.mynews.data.item.shopping.adapter.ShoppingItemsAdapter
import com.kkh.mynews.data.viewmodel.ContentsViewModel
import com.kkh.mynews.databinding.ListKeywordItemLayoutBinding
import com.kkh.mynews.databinding.ListShoppingItemLayoutBinding

@SuppressLint("LongLogTag")
class KeywordRecyclerViewAdapter(viewmodel: ContentsViewModel) :
    RecyclerView.Adapter<KeywordRecyclerViewAdapter.ViewHolder>() {
    companion object {
        const val TAG = Constant.TAG_PREFIX + "KeywordRecyclerViewAdapter"
    }

    private var mList: List<KeywordModel> = ArrayList()
    private val mNewsViewModel = viewmodel;
    private var mCurrentViewType = -1

    class ViewHolder(b: ListKeywordItemLayoutBinding) : RecyclerView.ViewHolder(b.root) {
        var binding: ListKeywordItemLayoutBinding = b
    }

    fun setList(list: List<KeywordModel>) {
        mList = list
        notifyDataSetChanged()
    }

    fun selectPosition(viewType: Int) {
        Log.d(TAG, "selectPosition viewType $viewType")
        mCurrentViewType = viewType
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListKeywordItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    @SuppressLint("LongLogTag")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mList[position]
        Log.d(TAG, "mCurrentCategory $mCurrentViewType data.uid) : ${data.uid}")
        val v = holder.binding
        if (mCurrentViewType == data.uid) {
            v.cardView.setCardBackgroundColor(Color.GRAY)
            v.keyword.setTextColor(Color.DKGRAY)
        } else {
            v.cardView.setCardBackgroundColor(Color.DKGRAY)
            v.keyword.setTextColor(Color.GRAY)
        }


        v.cardView.setOnLongClickListener {
            mNewsViewModel.deleteKeyword(data.keyword)
            true
        }
        v.keyword.text = data.keyword
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}