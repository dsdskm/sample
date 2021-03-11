package com.kkh.mynews.data.viewmodel

import androidx.lifecycle.*
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.kkh.mynews.data.ContentsRepository
import com.kkh.mynews.data.item.keyword.model.KeywordModel
import com.kkh.mynews.data.item.blog.model.BlogItemsModel
import com.kkh.mynews.data.item.news.model.NewsItemsModel
import com.kkh.mynews.data.item.shopping.model.ShoppingItemsModel

// SavedStateHandle을 사용하면 ViewModel에서 관련 액티비티/프래그먼트 저장된 상태와 인수에 액세스할 수 있습니다.
class ContentsViewModel() : ViewModel() {

    val contentsRepository: ContentsRepository = ContentsRepository()
    val newsItemsPaged:LiveData<PagedList<NewsItemsModel>> = contentsRepository.getNewsDao().loadPagedList().toLiveData(pageSize = 10)
    val shoppingItemsPaged:LiveData<PagedList<ShoppingItemsModel>> = contentsRepository.getShoppingDao().loadPagedList().toLiveData(pageSize = 10)
    val blogItemsPaged:LiveData<PagedList<BlogItemsModel>> = contentsRepository.getBlogDao().loadPagedList().toLiveData(pageSize = 10)
    val keyword = contentsRepository.getKeyword().asLiveData()



    fun requestNews(query: String) {
        contentsRepository.requestNews(query)
    }

    fun requestShopping(query: String) {
        contentsRepository.requestShopping(query,"sim")
    }

    fun requestBlog(query: String) {
        contentsRepository.requestBlog(query,"sim")
    }

    fun insertKeywordList(list: List<KeywordModel>) {
        contentsRepository.insertKeywordList(list)
    }

    fun insertKeywordList(data: KeywordModel) {
        contentsRepository.insertKeyword(data)
    }

    fun deleteKeyword(keyword:String){
        contentsRepository.deleteKeyword(keyword)
    }
    fun deleteAll(){
        contentsRepository.deleteAll()
    }

}