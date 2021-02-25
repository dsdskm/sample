package com.kkh.mynews.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import com.kkh.mynews.R
import com.kkh.mynews.model.NewsModel
import com.kkh.mynews.network.WebService
import com.kkh.mynews.viewmodel.NewsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment : Fragment() {
    companion object {
        const val TAG = "[KKH]NewsFragment"
        fun newInstance() = NewsFragment()
    }

    private val webService = WebService.create()

    private val newsViewModel: NewsViewModel by viewModels(
        factoryProducer = { SavedStateViewModelFactory(requireActivity().application, this) }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)

        newsViewModel.news.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onChanged")
        })
    }

    private fun initView(view: View) {
        val searchView = view.findViewById<SearchView>(R.id.searchView)
        val searchBtn = view.findViewById<Button>(R.id.searchBtn)
        val clearBtn = view.findViewById<Button>(R.id.clearBtn)

        clearBtn.setOnClickListener {
            searchView.setQuery("", false)
        }
        searchBtn.setOnClickListener {
            Thread {
                requestNews(searchView.query.toString())
            }.start()

        }
    }

    fun requestNews(query: String) = webService.getSearchNews(query).enqueue(object :
        Callback<NewsModel> {
        override fun onFailure(call: Call<NewsModel>, t: Throwable) {
            Log.d(NewsFragment.TAG, "onFailure")
        }

        override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
            Log.d(NewsFragment.TAG, "onResponse $response")
            Log.d(NewsFragment.TAG, "onResponse body ${response.body().toString()}")
        }

    })

}