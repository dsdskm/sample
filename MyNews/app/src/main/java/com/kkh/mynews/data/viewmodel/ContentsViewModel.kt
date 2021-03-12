package com.kkh.mynews.data.viewmodel

import androidx.lifecycle.*
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.kkh.mynews.data.ContentsRepository
import com.kkh.mynews.data.item.keyword.model.KeywordModel
import com.kkh.mynews.data.item.blog.model.BlogItemsModel
import com.kkh.mynews.data.item.book.model.BookItemsModel
import com.kkh.mynews.data.item.image.model.ImageItemsModel
import com.kkh.mynews.data.item.news.model.NewsItemsModel
import com.kkh.mynews.data.item.shopping.model.ShoppingItemsModel

// SavedStateHandle을 사용하면 ViewModel에서 관련 액티비티/프래그먼트 저장된 상태와 인수에 액세스할 수 있습니다.
class ContentsViewModel() : ViewModel() {

    private val contentsRepository: ContentsRepository = ContentsRepository()
    val newsItemsPaged:LiveData<PagedList<NewsItemsModel>> = contentsRepository.getNewsDao().loadPagedList().toLiveData(pageSize = 10)
    val shoppingItemsPaged:LiveData<PagedList<ShoppingItemsModel>> = contentsRepository.getShoppingDao().loadPagedList().toLiveData(pageSize = 10)
    val blogItemsPaged:LiveData<PagedList<BlogItemsModel>> = contentsRepository.getBlogDao().loadPagedList().toLiveData(pageSize = 10)
    val bookItemsPaged:LiveData<PagedList<BookItemsModel>> = contentsRepository.getBookDao().loadPagedList().toLiveData(pageSize = 10)
    val imageItemsPaged:LiveData<PagedList<ImageItemsModel>> = contentsRepository.getImageDao().loadPagedList().toLiveData(pageSize = 10)

    val keyword = contentsRepository.getKeyword().asLiveData()


    fun request(query:String){
        contentsRepository.requestShopping(query,"sim")
        contentsRepository.requestNews(query)
        contentsRepository.requestBlog(query,"sim")
        contentsRepository.requestBook(query,"sim")
        contentsRepository.requestImage(query,"sim","all")
    }

    fun insertKeywordList(list: List<KeywordModel>) {
        contentsRepository.insertKeywordList(list)
    }
    fun deleteKeyword(keyword:String){
        contentsRepository.deleteKeyword(keyword)
    }
    fun deleteAll(){
        contentsRepository.deleteAll()
    }

}