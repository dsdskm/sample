package com.kkh.mynews.viewmodel

import androidx.lifecycle.*
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.kkh.mynews.data.NewsRepository
import com.kkh.mynews.item.keyword.model.KeywordModel
import com.kkh.mynews.item.news.model.NewsItemsModel

// SavedStateHandle을 사용하면 ViewModel에서 관련 액티비티/프래그먼트 저장된 상태와 인수에 액세스할 수 있습니다.
class NewsViewModel() : ViewModel() {

    val newsRepository: NewsRepository = NewsRepository()
    val newsItemsPaged:LiveData<PagedList<NewsItemsModel>> = newsRepository.getNewsDao().loadPagedList().toLiveData(pageSize = 20)
    val keyword = newsRepository.getKeyword().asLiveData()

    fun requestNews(query: String) {
        newsRepository.requestNews(query)
    }

    fun insertKeywordList(list: List<KeywordModel>) {
        newsRepository.insertKeywordList(list)
    }

    fun insertKeywordList(data: KeywordModel) {
        newsRepository.insertKeyword(data)
    }

    fun deleteKeyword(keyword:String){
        newsRepository.deleteKeyword(keyword)
    }
    fun deleteNewsAll(){
        newsRepository.deleteNewsAll()
    }

}