package com.kkh.mynews.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kkh.mynews.model.NewsModel

// SavedStateHandle을 사용하면 ViewModel에서 관련 액티비티/프래그먼트 저장된 상태와 인수에 액세스할 수 있습니다.
class NewsViewModel constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val news: LiveData<NewsModel> = MutableLiveData<NewsModel>()
}