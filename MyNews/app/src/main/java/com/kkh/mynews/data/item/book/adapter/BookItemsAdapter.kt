package com.kkh.mynews.data.item.book.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.os.CountDownTimer
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.kkh.mynews.common.Constant
import com.kkh.mynews.common.Util
import com.kkh.mynews.data.item.book.model.BookItemsModel
import com.kkh.mynews.databinding.ListBookItemLayoutBinding

/*

PagedList
더 많은 데이터가 필요하면 기존 PagedList 객체로 페이징

 */
@SuppressLint("LongLogTag")
class BookItemsAdapter(r: RequestManager) :
    PagedListAdapter<BookItemsModel, BookItemsAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {

    private var mList: List<BookItemsModel> = ArrayList<BookItemsModel>()
    private val mRequestManager: RequestManager = r

    private var count = 0
    var counter: CountDownTimer? = null

    init {
        Log.d(TAG, "counter start")
        if (counter == null) {
            counter = object : CountDownTimer(30 * 1000 * 10, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    Log.d(TAG, "onTick count $count")
                    count++
                    notifyDataSetChanged()
                }

                override fun onFinish() {
                    TODO("Not yet implemented")
                }

            }
            (counter as CountDownTimer).start()
        } else {
            counter!!.cancel()
            counter!!.start()
            counter = null
        }

    }

    class ViewHolder(b: ListBookItemLayoutBinding) : RecyclerView.ViewHolder(b.root) {
        var binding: ListBookItemLayoutBinding = b
    }

    companion object {
        const val TAG = Constant.TAG_PREFIX + "BookItemsAdapter"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BookItemsModel>() {
            override fun areItemsTheSame(
                oldItem: BookItemsModel,
                newItem: BookItemsModel
            ): Boolean {
                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(
                oldItem: BookItemsModel,
                newItem: BookItemsModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun setList(list: List<BookItemsModel>) {
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
            ListBookItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("LongLogTag")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder position $position")
        val data = mList[position] ?: return
        val v = holder.binding
        v.title.text = Html.fromHtml(data.title, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.author.text = Html.fromHtml(data.author, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.price.text = Html.fromHtml(data.price.toString(), Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.discount.text =
            Html.fromHtml(data.discount.toString(), Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.publisher.text = Html.fromHtml(data.publisher, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.description.text = Html.fromHtml(data.description, Html.FROM_HTML_OPTION_USE_CSS_COLORS)
        v.cardView.setOnClickListener {
            Util.openUrl(data.link)
        }
        v.timer.text = (9000 - count).toString() + " 초 남았습니다."

    }
}
