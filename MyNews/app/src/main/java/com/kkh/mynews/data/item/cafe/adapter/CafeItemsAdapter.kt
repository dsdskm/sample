package com.kkh.mynews.data.item.cafe.adapter

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
import com.kkh.mynews.common.Constant
import com.kkh.mynews.common.Util
import com.kkh.mynews.data.item.cafe.model.CafeItemsModel
import com.kkh.mynews.databinding.ListCafeItemLayoutBinding

/*

PagedList
더 많은 데이터가 필요하면 기존 PagedList 객체로 페이징

 */
@SuppressLint("LongLogTag")
class CafeItemsAdapter() :
    PagedListAdapter<CafeItemsModel, CafeItemsAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {
    private var mList: List<CafeItemsModel> = ArrayList<CafeItemsModel>()

    class ViewHolder(b: ListCafeItemLayoutBinding) : RecyclerView.ViewHolder(b.root) {
        var binding: ListCafeItemLayoutBinding = b

    }

    companion object {
        const val TAG = Constant.TAG_PREFIX + "CafeItemsAdapter"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CafeItemsModel>() {
            override fun areItemsTheSame(
                oldItem: CafeItemsModel,
                newItem: CafeItemsModel
            ): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(
                oldItem: CafeItemsModel,
                newItem: CafeItemsModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun setList(list: List<CafeItemsModel>) {
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
            ListCafeItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        v.cafename.text = Html.fromHtml(data.cafename, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
    }

}