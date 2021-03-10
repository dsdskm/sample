package com.kkh.mynews.view.adapter

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
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.kkh.mynews.R
import com.kkh.mynews.common.Constant
import com.kkh.mynews.item.shopping.model.ShoppingItemsModel

@SuppressLint("LongLogTag")
class ShoppingItemsAdapter :
    PagedListAdapter<ShoppingItemsModel, ShoppingItemsAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mCardView: CardView = view.findViewById(R.id.card_view)
        val mTitle: TextView = view.findViewById(R.id.title)
        val mLprice: TextView = view.findViewById(R.id.lprice)
        val mHprice: TextView = view.findViewById(R.id.hprice)
        val mProductType: TextView = view.findViewById(R.id.productType)
        val mBrand: TextView = view.findViewById(R.id.brand)
        val mMaker: TextView = view.findViewById(R.id.maker)
        val mTime: TextView = view.findViewById(R.id.time)
        val mImage: ImageView = view.findViewById(R.id.image)
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
    private lateinit var mRequestManager:RequestManager
    private var mList: List<ShoppingItemsModel> = ArrayList<ShoppingItemsModel>()
    fun setList(list: List<ShoppingItemsModel>) {
        mList = list
        Log.d(TAG, "setList list ${mList.size}")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_shopping_item_layout, parent, false)
        mRequestManager = Glide.with(view.context)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder position $position")
        val data = mList[position]
        holder.mTitle.text = Html.fromHtml(data.title, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        holder.mLprice.text =
            Html.fromHtml(data.lprice.toString(), Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        holder.mHprice.text =
            Html.fromHtml(data.hprice.toString(), Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        holder.mProductType.text =
            Html.fromHtml(data.productType.toString(), Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        holder.mBrand.text = Html.fromHtml(data.brand, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        holder.mMaker.text = Html.fromHtml(data.maker, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        holder.mTime.text = "time"
        mRequestManager.load(data.image).into(holder.mImage)

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}