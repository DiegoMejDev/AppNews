package com.raven.home.domain

import com.raven.home.data.remote.entities.NewItemResponse
import kotlinx.coroutines.flow.Flow

interface HomeDataSource {

    suspend fun getNews(): Flow<List<NewItemResponse>>
}
