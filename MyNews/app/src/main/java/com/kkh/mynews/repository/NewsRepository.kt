package com.kkh.mynews.repository

import android.util.Log
import com.kkh.mynews.model.NewsModel
import com.kkh.mynews.network.WebService
import com.kkh.mynews.view.NewsFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    private val webService = WebService.create()

    suspend fun requestNews(query: String) = webService.getSearchNews(query).enqueue(object :
        Callback<NewsModel> {
        override fun onFailure(call: Call<NewsModel>, t: Throwable) {
            Log.d(NewsFragment.TAG, "onFailure")
        }

        override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
            Log.d(NewsFragment.TAG, "onResponse $response")
        }

    })
}