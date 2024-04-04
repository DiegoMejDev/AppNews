package com.raven.home.data.remote.entities

data class NewsResponse(
    val status: String,
    val copyright: String,
    val num_results: Int,
    val results: List<NewItemResponse>
)