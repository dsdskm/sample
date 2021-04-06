package com.kkh.mynews.data.viewmodel

import android.database.Cursor
import androidx.hilt.lifecycle.ViewModelInject
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
import com.kkh.mynews.view.fragment.MainFragment
import dagger.Binds
import dagger.Module
import dagger.assisted.Assisted
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class ContentsViewModel @Inject constructor(
): ViewModel() {

    private val contentsRepository: ContentsRepository = ContentsRepository()
    val newsItemsPaged: LiveData<PagedList<NewsItemsModel>> =
        contentsRepository.mNewsItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val shoppingItemsPaged: LiveData<PagedList<ShoppingItemsModel>> =
        contentsRepository.mShoppingItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val blogItemsPaged: LiveData<PagedList<BlogItemsModel>> =
        contentsRepository.mBlogItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val bookItemsPaged: LiveData<PagedList<BookItemsModel>> =
        contentsRepository.mBookItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val imageItemsPaged: LiveData<PagedList<ImageItemsModel>> =
        contentsRepository.mImageItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val movieItemsPaged: LiveData<PagedList<MovieItemsModel>> =
        contentsRepository.mMovieItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val dictItemsPaged: LiveData<PagedList<DictItemsModel>> =
        contentsRepository.mDictItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val cafeItemsPaged: LiveData<PagedList<CafeItemsModel>> =
        contentsRepository.mCafeItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val knowItemsPaged: LiveData<PagedList<KnowItemsModel>> =
        contentsRepository.mKnowItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val localItemsPaged: LiveData<PagedList<LocationItemsModel>> =
        contentsRepository.mLocationItemsDao.loadPagedList().toLiveData(pageSize = 3)
    val webItemsPaged: LiveData<PagedList<WebItemsModel>> =
        contentsRepository.mWebDao.loadPagedList().toLiveData(pageSize = 3)
    val referItemsPaged: LiveData<PagedList<ReferItemsModel>> =
        contentsRepository.mReferItemsDao.loadPagedList().toLiveData(pageSize = 3)
//    val searchItemsPaged:LiveData<PagedList<SearchModel>> = contentsRepository.mSearchDao.loadPagedList().toLiveData(pageSize = 3)


    val keyword = contentsRepository.mKeywordDao.load().asLiveData()


    fun request(query: String) {
        contentsRepository.requestShopping(query, ContentsRepository.DEFAULT_RESULT)
        contentsRepository.requestNews(query, ContentsRepository.DEFAULT_RESULT)
        contentsRepository.requestBlog(query, ContentsRepository.DEFAULT_RESULT)
        contentsRepository.requestBook(query, ContentsRepository.DEFAULT_RESULT)
        contentsRepository.requestImage(query, ContentsRepository.DEFAULT_RESULT, "all")
        contentsRepository.requestMovie(query, ContentsRepository.DEFAULT_RESULT)
        contentsRepository.requestDict(query, ContentsRepository.DEFAULT_RESULT)
        contentsRepository.requestCafe(query, ContentsRepository.DEFAULT_RESULT)
        contentsRepository.requestKnow(query, ContentsRepository.DEFAULT_RESULT)
        contentsRepository.requestLocal(query, ContentsRepository.DEFAULT_RESULT)
        contentsRepository.requestWeb(query, ContentsRepository.DEFAULT_RESULT)
        contentsRepository.requestRefer(query, ContentsRepository.DEFAULT_RESULT)
    }

    fun requestRefer(query: String, count: Int) {
        contentsRepository.requestRefer(query, count);
    }

    fun requestWeb(query: String, count: Int) {
        contentsRepository.requestWeb(query, count);
    }

    fun requestLocal(query: String, count: Int) {
        contentsRepository.requestLocal(query, count);
    }

    fun requestKnow(query: String, count: Int) {
        contentsRepository.requestKnow(query, count);
    }

    fun requestCafe(query: String, count: Int) {
        contentsRepository.requestCafe(query, count);
    }

    fun requestDict(query: String, count: Int) {
        contentsRepository.requestDict(query, count);
    }

    fun requestMovie(query: String, count: Int) {
        contentsRepository.requestMovie(query, count);
    }

    fun requestNews(query: String, count: Int) {
        contentsRepository.requestNews(query, count);
    }

    fun requestShopping(query: String, count: Int) {
        contentsRepository.requestShopping(query, count);
    }

    fun requestBlog(query: String, count: Int) {
        contentsRepository.requestBlog(query, count);
    }

    fun requestBook(query: String, count: Int) {
        contentsRepository.requestBook(query, count);
    }

    fun requestImage(query: String, count: Int) {
        contentsRepository.requestImage(query, count, "all");
    }

    fun insertKeyword(data: KeywordModel) {
        contentsRepository.insertKeyword(data)
    }

    fun insertKeywordList(list: List<KeywordModel>) {
        contentsRepository.insertKeywordList(list)
    }

    fun deleteKeyword(keyword: String) {
        contentsRepository.deleteKeyword(keyword)
    }

    fun deleteKeywordAll() {
        contentsRepository.deleteKeywordAll()
    }

    fun deleteAll() {
        contentsRepository.deleteAll()
    }

    fun insertSearchWord(data: SearchModel) {
        contentsRepository.insertSearchModel(data)
    }

    fun getSearchWordList(): Cursor {
        return contentsRepository.getSearchWordList()
    }

}
