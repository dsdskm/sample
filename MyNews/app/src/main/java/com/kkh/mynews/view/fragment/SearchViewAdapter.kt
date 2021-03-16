package com.kkh.mynews.view.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cursoradapter.widget.CursorAdapter
import com.kkh.mynews.R
import com.kkh.mynews.common.Constant
import com.kkh.mynews.databinding.ListBlogItemLayoutBinding
import com.kkh.mynews.databinding.ListSearchviewItemLayoutBinding

@SuppressLint("LongLogTag")
class SearchViewAdapter(context: Context?, c: Cursor?, autoRequery: Boolean) :
    CursorAdapter(context, c, autoRequery) {

    companion object{
        const val TAG = Constant.TAG_PREFIX + "SearchViewAdapter"
    }
    init {

    }


    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        val binding =
            ListSearchviewItemLayoutBinding.inflate(
                LayoutInflater.from(parent!!.context),
                parent,
                false
            )
        return binding.root
    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
        val word = cursor!!.getString(cursor.getColumnIndexOrThrow("word"))
        Log.d(TAG,"bindView word $word")
        view!!.findViewById<TextView>(R.id.word).text = word

    }
}