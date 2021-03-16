package com.kkh.mynews.data.viewmodel

import android.database.Cursor
import androidx.lifecycle.*
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.kkh.mynews.data.ContentsRepository
import com.kkh.mynews.data.item.keyword.model.KeywordModel
import com.kkh.mynews.data.item.blog.model.BlogItemsModel
import com.kkh.mynews.data.item.book.model.BookItemsModel
import com.kkh.mynews.data.item.cafe.model.CafeItemsModel
import com.kkh.mynews.data.item.dict.model.DictItemsModel
import com.kkh.mynews.data.item.image.model.ImageItemsModel
import com.kkh.mynews.data.item.know.model.KnowItemsModel
import com.kkh.mynews.data.item.location.model.LocationItemsModel
import com.kkh.mynews.data.item.location.model.LocationModel
import com.kkh.mynews.data.item.movie.dao.MovieItemsDao
import com.kkh.mynews.data.item.movie.model.MovieItemsModel
import com.kkh.mynews.data.item.news.model.NewsItemsModel
import com.kkh.mynews.data.item.refer.model.ReferItemsModel
import com.kkh.mynews.data.item.search.model.SearchModel
import com.kkh.mynews.data.item.shopping.model.ShoppingItemsModel
import com.kkh.mynews.data.item.web.model.WebItemsModel

// SavedStateHandle을 사용하면 ViewModel에서 관련 액티비티/프래그먼트 저장된 상태와 인수에 액세스할 수 있습니다.
class ContentsViewModel() : ViewModel() {

    private val contentsRepository: ContentsRepository = ContentsRepository()
    val newsItemsPaged:LiveData<PagedList<NewsItemsModel>> = contentsRepository.mNewsItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val shoppingItemsPaged:LiveData<PagedList<ShoppingItemsModel>> = contentsRepository.mShoppingItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val blogItemsPaged:LiveData<PagedList<BlogItemsModel>> = contentsRepository.mBlogItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val bookItemsPaged:LiveData<PagedList<BookItemsModel>> = contentsRepository.mBookItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val imageItemsPaged:LiveData<PagedList<ImageItemsModel>> = contentsRepository.mImageItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val movieItemsPaged:LiveData<PagedList<MovieItemsModel>> = contentsRepository.mMovieItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val dictItemsPaged:LiveData<PagedList<DictItemsModel>> = contentsRepository.mDictItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val cafeItemsPaged:LiveData<PagedList<CafeItemsModel>> = contentsRepository.mCafeItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val knowItemsPaged:LiveData<PagedList<KnowItemsModel>> = contentsRepository.mKnowItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val localItemsPaged:LiveData<PagedList<LocationItemsModel>> = contentsRepository.mLocationItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val webItemsPaged:LiveData<PagedList<WebItemsModel>> = contentsRepository.mWebDao.loadPagedList().toLiveData(pageSize = 3)
    val referItemsPaged:LiveData<PagedList<ReferItemsModel>> = contentsRepository.mReferItemsDao.loadPagedList().toLiveData(pageSize = 3)
//    val searchItemsPaged:LiveData<PagedList<SearchModel>> = contentsRepository.mSearchDao.loadPagedList().toLiveData(pageSize = 3)


    val keyword = contentsRepository.mKeywordDao.load().asLiveData()


    fun request(query:String){
        contentsRepository.requestShopping(query,"sim")
        contentsRepository.requestNews(query)
        contentsRepository.requestBlog(query,"sim")
        contentsRepository.requestBook(query,"sim")
        contentsRepository.requestImage(query,"sim","all")
        contentsRepository.requestMovie(query)
        contentsRepository.requestDict(query)
        contentsRepository.requestCafe(query)
        contentsRepository.requestKnow(query)
        contentsRepository.requestLocal(query)
        contentsRepository.requestWeb(query)
        contentsRepository.requestRefer(query)
    }

    fun insertKeyword(data: KeywordModel) {
        contentsRepository.insertKeyword(data)
    }
    fun insertKeywordList(list: List<KeywordModel>) {
        contentsRepository.insertKeywordList(list)
    }
    fun deleteKeyword(keyword:String){
        contentsRepository.deleteKeyword(keyword)
    }
    fun deleteKeywordAll(){
        contentsRepository.deleteKeywordAll()
    }
    fun deleteAll(){
        contentsRepository.deleteAll()
    }

    fun insertSearchWord(data: SearchModel) {
        contentsRepository.insertSearchModel(data)
    }

    fun getSearchWordList(): Cursor {
        return contentsRepository.getSearchWordList()
    }

}