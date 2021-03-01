package com.kkh.mynews.view.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
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
import com.kkh.mynews.common.Util
import com.kkh.mynews.item.news.model.NewsItemsModel

class MainRecyclerViewAdapter : RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {
    companion object{
        const val TAG = Constant.TAG_PREFIX + "MainRecyclerViewAdapter"
    }
    private lateinit var mList: List<NewsItemsModel>

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mCardView: CardView = view.findViewById(R.id.card_view)
        val mTitleView: TextView = view.findViewById(R.id.title)
        val mContentView: TextView = view.findViewById(R.id.content)
        val mTimeView: TextView = view.findViewById(R.id.time)

    }

    fun setList(list: List<NewsItemsModel>) {
        mList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("LongLogTag")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mList[position]
        Log.d(TAG,"desc : ${data.description}")
        holder.mCardView.setOnClickListener {
            Util.openUrl(data.link)
        }
        holder.mTitleView.text = Html.fromHtml(data.title, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        holder.mContentView.text =
            Html.fromHtml(data.description, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        holder.mTimeView.text = Html.fromHtml(data.pubDate, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}