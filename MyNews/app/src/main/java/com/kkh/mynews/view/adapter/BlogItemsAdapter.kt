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
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kkh.mynews.R
import com.kkh.mynews.common.Constant
import com.kkh.mynews.common.Util
import com.kkh.mynews.data.item.blog.model.BlogItemsModel

/*

PagedList
더 많은 데이터가 필요하면 기존 PagedList 객체로 페이징

 */
@SuppressLint("LongLogTag")
class BlogItemsAdapter() :
    PagedListAdapter<BlogItemsModel, BlogItemsAdapter.ViewHolder>(DIFF_CALLBACK) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mCardView: CardView = view.findViewById(R.id.card_view)
        val mTitleView: TextView = view.findViewById(R.id.title)
        val mContentView: TextView = view.findViewById(R.id.content)
        val mBloggerNameView: TextView = view.findViewById(R.id.bloggername)

    }

    companion object {
        const val TAG = Constant.TAG_PREFIX + "BlogItemsAdapter"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BlogItemsModel>() {
            override fun areItemsTheSame(
                oldItem: BlogItemsModel,
                newItem: BlogItemsModel
            ): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(
                oldItem: BlogItemsModel,
                newItem: BlogItemsModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    private var mList: List<BlogItemsModel> = ArrayList<BlogItemsModel>()


    fun setList(list: List<BlogItemsModel>) {
        mList = list
        Log.d(TAG, "setList list ${mList.size}")
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BlogItemsAdapter.ViewHolder {
        Log.d(TAG, "onCreateViewHolder")
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_blog_item_layout, parent, false)
        return BlogItemsAdapter.ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("LongLogTag")
    override fun onBindViewHolder(holder: BlogItemsAdapter.ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder position $position")
        val data = mList[position] ?: return
        holder.mCardView.setOnClickListener {
            Util.openUrl(data.bloggerlink)
        }
        holder.mTitleView.text = Html.fromHtml(data.title, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        holder.mContentView.text =
            Html.fromHtml(data.description, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        holder.mBloggerNameView.text = Html.fromHtml(data.bloggername, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
    }

}