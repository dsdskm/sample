package com.kkh.mynews.data.item.movie.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.kkh.mynews.common.Constant
import com.kkh.mynews.common.Util
import com.kkh.mynews.data.item.movie.model.MovieItemsModel
import com.kkh.mynews.databinding.ListMovieItemLayoutBinding

/*

PagedList
더 많은 데이터가 필요하면 기존 PagedList 객체로 페이징

 */
@SuppressLint("LongLogTag")
class MovieItemsAdapter(r: RequestManager) :
    PagedListAdapter<MovieItemsModel, MovieItemsAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {
    private val mRequestManager: RequestManager = r
    private var mList: List<MovieItemsModel> = ArrayList<MovieItemsModel>()

    class ViewHolder(b: ListMovieItemLayoutBinding) : RecyclerView.ViewHolder(b.root) {
        var binding: ListMovieItemLayoutBinding = b

    }

    companion object {
        const val TAG = Constant.TAG_PREFIX + "MovieItemsAdapter"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieItemsModel>() {
            override fun areItemsTheSame(
                oldItem: MovieItemsModel,
                newItem: MovieItemsModel
            ): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(
                oldItem: MovieItemsModel,
                newItem: MovieItemsModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun setList(list: List<MovieItemsModel>) {
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
    ): ViewHolder {
        Log.d(TAG, "onCreateViewHolder")
        val binding =
            ListMovieItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(
            binding
        )
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("LongLogTag")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder position $position")
        val data = mList[position] ?: return
        val v = holder.binding
        v.cardView.setOnClickListener {
            Util.openUrl(data.link)
        }
        v.title.text = Html.fromHtml(data.title, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        mRequestManager.load(data.image).into(v.image)
        v.subtitle.text = Html.fromHtml(data.subtitle, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.pubDate.text = Html.fromHtml(data.pubDate, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.director.text = Html.fromHtml(data.director, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.actor.text = Html.fromHtml(data.actor, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.userRating.text = Html.fromHtml(data.userRating.toString(), Html.FROM_HTML_OPTION_USE_CSS_COLORS)
    }

}