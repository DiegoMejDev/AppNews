package com.raven.home.domain.usecases

import com.raven.core.bases.BaseUseCase
import com.raven.home.data.remote.entities.NewItemResponse
import com.raven.home.domain.HomeDataSource
import com.raven.home.domain.entities.NewItem
import com.raven.home.domain.mapper.GetNewsMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val dataSource: HomeDataSource,
    private val mapper: GetNewsMapper // it was meanead to transfor from domain to UI
) : BaseUseCase<Unit, List<NewItemResponse>>() {
    override suspend fun execute(params: Unit): Flow<List<NewItemResponse>> {
        return dataSource.getNews()
    }
}
