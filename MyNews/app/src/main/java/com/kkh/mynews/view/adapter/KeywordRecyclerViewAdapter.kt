package com.kkh.mynews.view.adapter

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
import com.kkh.mynews.item.keyword.model.KeywordModel
import com.kkh.mynews.viewmodel.NewsViewModel

class KeywordRecyclerViewAdapter(viewmodel: NewsViewModel) :
    RecyclerView.Adapter<KeywordRecyclerViewAdapter.ViewHolder>() {
    companion object {
        const val TAG = Constant.TAG_PREFIX + "KeywordRecyclerViewAdapter"
    }

    private var mList: List<KeywordModel> = ArrayList()
    private val mNewsViewModel = viewmodel;
    private var mCurrentQuery = "";

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mCardView: CardView = view.findViewById(R.id.card_view)
        val mKeywordView: TextView = view.findViewById(R.id.keyword)

    }

    fun setList(list: List<KeywordModel>) {
        mList = list
        notifyDataSetChanged()
    }

    fun selectPosition(query: String) {
        Log.d(TAG,"selectPosition query $query")
        mCurrentQuery = query
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_keyword_item_layout, parent, false)
        return ViewHolder(view)
    }


    @SuppressLint("LongLogTag")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mList[position]
        Log.d(TAG, "mCurrentQuery $mCurrentQuery keyword : ${data.keyword} position : $position")
        if (mCurrentQuery == data.keyword) {
            holder.mCardView.setCardBackgroundColor(Color.GRAY)
            holder.mKeywordView.setTextColor(Color.DKGRAY)
        } else {
            holder.mCardView.setCardBackgroundColor(Color.DKGRAY)
            holder.mKeywordView.setTextColor(Color.GRAY)
        }


        holder.mCardView.setOnClickListener {
            mNewsViewModel.requestNews(data.keyword)
            mCurrentQuery = data.keyword
            notifyDataSetChanged()
        }
        holder.mCardView.setOnLongClickListener {
            mNewsViewModel.deleteKeyword(data.keyword)
            true
        }
        holder.mKeywordView.text = data.keyword
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}