package com.kkh.mynews.network

import com.kkh.mynews.data.item.shopping.model.ShoppingModel
import com.kkh.mynews.data.item.blog.model.BlogModel
import com.kkh.mynews.data.item.book.model.BookModel
import com.kkh.mynews.data.item.cafe.model.CafeModel
import com.kkh.mynews.data.item.dict.model.DictModel
import com.kkh.mynews.data.item.image.model.ImageModel
import com.kkh.mynews.data.item.know.model.KnowModel
import com.kkh.mynews.data.item.location.model.LocationModel
import com.kkh.mynews.data.item.movie.model.MovieItemsModel
import com.kkh.mynews.data.item.movie.model.MovieModel
import com.kkh.mynews.data.item.news.model.NewsModel
import com.kkh.mynews.data.item.refer.model.ReferModel
import com.kkh.mynews.data.item.web.model.WebModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    /*
    Naver Search URL : https://developers.naver.com/docs/search/news/

    curl "https://openapi.naver.com/v1/search/news.xml?query=%EC%A3%BC%EC%8B%9D&display=10&start=1&sort=sim" \
    -H "X-Naver-Client-Id: {1AgpA_xzaTOxYnH0Ok7X}" \
    -H "X-Naver-Client-Secret: {LGFq88WXXK}" -v

     */

    @GET("v1/search/blog.json")
    fun getBlog(
        @Query("query") query: String,
        @Query("display") display: Int,
        @Query("sort") sort: String
    ): Call<BlogModel>

    @GET("v1/search/shop.json")
    fun getShopping(
        @Query("query") query: String,
        @Query("display") display: Int,
        @Query("sort") sort: String
    ): Call<ShoppingModel>

    @GET("v1/search/news.json")
    fun getSearchNews(
        @Query("query") query: String,
        @Query("display") display: Int
    ): Call<NewsModel>

    @GET("v1/search/book.json")
    fun getSearchBook(
        @Query("query") query: String,
        @Query("display") display: Int,
        @Query("sort") sort: String
    ): Call<BookModel>

    @GET("v1/search/image.json")
    fun getImage(
        @Query("query") query: String,
        @Query("display") display: Int,
        @Query("sort") sort: String,
        @Query("filter") filter: String
    ): Call<ImageModel>

    @GET("v1/search/movie.json")
    fun getMovie(
        @Query("query") query: String,
        @Query("display") display: Int
    ): Call<MovieModel>

    @GET("v1/search/encyc.json")
    fun getDict(
        @Query("query") query: String,
        @Query("display") display: Int
    ): Call<DictModel>

    @GET("v1/search/cafearticle.json")
    fun getCafe(
        @Query("query") query: String,
        @Query("display") display: Int
    ): Call<CafeModel>

    @GET("v1/search/kin.json")
    fun getKnow(
        @Query("query") query: String,
        @Query("display") display: Int
    ): Call<KnowModel>

    @GET("v1/search/local.json")
    fun getLocal(
        @Query("query") query: String,
        @Query("display") display: Int
    ): Call<LocationModel>

    @GET("v1/search/webkr.json")
    fun getWeb(
        @Query("query") query: String,
        @Query("display") display: Int
    ): Call<WebModel>

    @GET("v1/search/doc.json")
    fun getRefer(
        @Query("query") query: String,
        @Query("display") display: Int
    ): Call<ReferModel>

    companion object {
        private const val BASE_URL_NAVER_API = "https://openapi.naver.com/"
        private const val CLIENT_ID = "1AgpA_xzaTOxYnH0Ok7X"
        private const val CLIENT_SECRET = "LGFq88WXXK"

        fun create(): WebService {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val headerInterceptor = Interceptor {
                val request = it.request()
                    .newBuilder()
                    .addHeader("X-Naver-Client-Id", CLIENT_ID)
                    .addHeader("X-Naver-Client-Secret", CLIENT_SECRET)
                    .build()
                return@Interceptor it.proceed(request)
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL_NAVER_API)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WebService::class.java)

        }

    }
}