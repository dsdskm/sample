package com.kkh.mynews.data.item.movie.model

import com.kkh.mynews.data.item.movie.model.MovieItemsModel

data class MovieModel(
    var lastBuildDate: String = "",
    var items: List<MovieItemsModel>? = null
)
