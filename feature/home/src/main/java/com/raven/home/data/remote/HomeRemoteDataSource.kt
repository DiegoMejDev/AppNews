package com.raven.home.data.remote

import com.raven.home.data.remote.entities.NewsResponse
import kotlinx.coroutines.flow.Flow

interface HomeRemoteDataSource {

    suspend fun getNews(): Flow<NewsResponse>
}