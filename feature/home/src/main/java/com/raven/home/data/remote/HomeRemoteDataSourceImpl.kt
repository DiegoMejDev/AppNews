package com.raven.home.data.remote

import com.raven.core.bases.BaseRemoteDataSource
import com.raven.home.data.remote.service.HomeService
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val service: HomeService
) : HomeRemoteDataSource, BaseRemoteDataSource() {
    override suspend fun getNews() =
        getResult { service.getNews() }

}
