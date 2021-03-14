package com.kkh.mynews.data.item.location.adapter

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
import com.kkh.mynews.data.item.location.model.LocationItemsModel
import com.kkh.mynews.databinding.ListLocalItemLayoutBinding

/*

PagedList
더 많은 데이터가 필요하면 기존 PagedList 객체로 페이징

 */
@SuppressLint("LongLogTag")
class LocalItemsAdapter() :
    PagedListAdapter<LocationItemsModel, LocalItemsAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {
    private var mList: List<LocationItemsModel> = ArrayList<LocationItemsModel>()

    class ViewHolder(b: ListLocalItemLayoutBinding) : RecyclerView.ViewHolder(b.root) {
        var binding: ListLocalItemLayoutBinding = b

    }

    companion object {
        const val TAG = Constant.TAG_PREFIX + "LocalItemsAdapter"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<LocationItemsModel>() {
            override fun areItemsTheSame(
                oldItem: LocationItemsModel,
                newItem: LocationItemsModel
            ): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(
                oldItem: LocationItemsModel,
                newItem: LocationItemsModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun setList(list: List<LocationItemsModel>) {
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
            ListLocalItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        v.telephone.text = Html.fromHtml(data.telephone, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.address.text = Html.fromHtml(data.address, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.roadAddress.text = Html.fromHtml(data.roadAddress, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
    }

}