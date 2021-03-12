package com.kkh.mynews.data.item.shopping.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.kkh.mynews.R
import com.kkh.mynews.common.Constant
import com.kkh.mynews.common.Util
import com.kkh.mynews.data.item.book.adapter.BookItemsAdapter
import com.kkh.mynews.data.item.shopping.model.ShoppingItemsModel
import com.kkh.mynews.databinding.ListBookItemLayoutBinding
import com.kkh.mynews.databinding.ListShoppingItemLayoutBinding

@SuppressLint("LongLogTag")
class ShoppingItemsAdapter(r: RequestManager) :
    PagedListAdapter<ShoppingItemsModel, ShoppingItemsAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {
    // TODO:의존성 주입
    private val mRequestManager: RequestManager = r
    private var mList: List<ShoppingItemsModel> = ArrayList<ShoppingItemsModel>()

    class ViewHolder(b: ListShoppingItemLayoutBinding) : RecyclerView.ViewHolder(b.root) {
        var binding: ListShoppingItemLayoutBinding = b
    }

    companion object {
        const val TAG = Constant.TAG_PREFIX + "ShoppingItemsAdapter"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ShoppingItemsModel>() {
            override fun areItemsTheSame(
                oldItem: ShoppingItemsModel,
                newItem: ShoppingItemsModel
            ): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(
                oldItem: ShoppingItemsModel,
                newItem: ShoppingItemsModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun setList(list: List<ShoppingItemsModel>) {
        mList = list
        Log.d(TAG, "setList list ${mList.size}")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListShoppingItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder position $position")
        val data = mList[position]
        val v = holder.binding
        v.cardView.setOnClickListener {
            Log.d(TAG,"link ${data.link}")
            Util.openUrl(data.link)
        }
        v.title.text = Html.fromHtml(data.title, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.lprice.text =String.format(holder.itemView.context.getString(R.string.shopping_lprice),data.lprice)
        v.hprice.text =String.format(holder.itemView.context.getString(R.string.shopping_hprice),data.hprice)
        v.productType.text =
            Html.fromHtml(data.productType.toString(), Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.brand.text = Html.fromHtml(data.brand, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.maker.text = Html.fromHtml(data.maker, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        mRequestManager.load(data.image).into(v.image)

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}