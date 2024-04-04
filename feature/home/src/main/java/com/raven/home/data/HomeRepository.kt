package com.raven.home.data

import com.raven.home.data.remote.HomeRemoteDataSource
import com.raven.home.data.remote.entities.NewItemResponse
import com.raven.home.domain.HomeDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val remote: HomeRemoteDataSource
) : HomeDataSource {

    override suspend fun getNews(): Flow<List<NewItemResponse>> {
    return remote.getNews().map { response ->
        response.results
    }
        }
}
