package com.kkh.mynews.data.item.news.adapter

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
import com.kkh.mynews.data.item.dict.model.DictItemsModel
import com.kkh.mynews.databinding.ListDictItemLayoutBinding

/*

PagedList
더 많은 데이터가 필요하면 기존 PagedList 객체로 페이징

 */
@SuppressLint("LongLogTag")
class DictItemsAdapter(r: RequestManager) :
    PagedListAdapter<DictItemsModel, DictItemsAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {
    private var mList: List<DictItemsModel> = ArrayList<DictItemsModel>()
    private val mRequestManager: RequestManager = r
    class ViewHolder(b: ListDictItemLayoutBinding) : RecyclerView.ViewHolder(b.root) {
        var binding: ListDictItemLayoutBinding = b

    }

    companion object {
        const val TAG = Constant.TAG_PREFIX + "DictItemsAdapter"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DictItemsModel>() {
            override fun areItemsTheSame(
                oldItem: DictItemsModel,
                newItem: DictItemsModel
            ): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(
                oldItem: DictItemsModel,
                newItem: DictItemsModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun setList(list: List<DictItemsModel>) {
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
            ListDictItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        v.description.text =
            Html.fromHtml(data.description, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        mRequestManager.load(data.thumbnail).into(v.image)
    }

}