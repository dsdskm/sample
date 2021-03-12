package com.kkh.mynews.data.item.book.adapter

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
import com.kkh.mynews.data.item.image.model.ImageItemsModel
import com.kkh.mynews.databinding.ListImageItemLayoutBinding

/*

PagedList
더 많은 데이터가 필요하면 기존 PagedList 객체로 페이징

 */
@SuppressLint("LongLogTag")
class ImageItemsAdapter(r: RequestManager) :
    PagedListAdapter<ImageItemsModel, ImageItemsAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {

    private var mList: List<ImageItemsModel> = ArrayList<ImageItemsModel>()
    private val mRequestManager: RequestManager = r

    class ViewHolder(b: ListImageItemLayoutBinding) : RecyclerView.ViewHolder(b.root) {
        var binding: ListImageItemLayoutBinding = b

    }

    companion object {
        const val TAG = Constant.TAG_PREFIX + "BookItemsAdapter"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ImageItemsModel>() {
            override fun areItemsTheSame(
                oldItem: ImageItemsModel,
                newItem: ImageItemsModel
            ): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(
                oldItem: ImageItemsModel,
                newItem: ImageItemsModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun setList(list: List<ImageItemsModel>) {
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
            ListImageItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("LongLogTag")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder position $position")
        val data = mList[position] ?: return
        val v = holder.binding
        v.title.text = Html.fromHtml(data.title, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        mRequestManager.load(data.thumbnail).into(v.thumbnail)
    }

}