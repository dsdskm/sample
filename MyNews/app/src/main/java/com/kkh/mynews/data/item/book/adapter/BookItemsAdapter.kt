package com.kkh.mynews.data.item.book.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.os.CountDownTimer
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.google.common.collect.HashBasedTable
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

    lateinit var countArray: IntArray
    fun setList(list: List<BookItemsModel>) {
        mList = list
        Log.d(TAG, "setList list ${mList.size}")
        notifyDataSetChanged()
        countArray = IntArray(mList.size){-1}
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
        Log.d(TAG, "kkh onBindViewHolder $position ${countArray[position]}")
        if (countArray[position]==-1) {
            countArray[position] = 0
            v.timer.tag = position
            object : CountDownTimer(30 * 1000, 1000) {
                override fun onFinish() {
                    Log.d(TAG, "onFinish")
                }

                override fun onTick(millisUntilFinished: Long) {
                    countArray[position]+=1
                    Log.d(TAG, "kkh onTick $position ${countArray[position]} tag ${v.timer.tag}")
                    if(v.timer.tag == position) {
                        v.timer.setText("남은시간 ${10000 - countArray[position]}")
                    }

                }


            }.start()
        } else {


        }
    }

}