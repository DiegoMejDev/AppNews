package com.raven.home.data.di

import com.raven.home.data.HomeRepository
import com.raven.home.data.mapper.NewMapperHome
import com.raven.home.data.mapper.NewMapperHomeImpl
import com.raven.home.data.remote.HomeRemoteDataSource
import com.raven.home.data.remote.HomeRemoteDataSourceImpl
import com.raven.home.domain.HomeDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeDataModule {

    @Binds
    abstract fun bindHomeRepository(repository: HomeRepository): HomeDataSource

    @Binds
    abstract fun bindHomeRemoteDataSource(repository: HomeRemoteDataSourceImpl) : HomeRemoteDataSource

    @Binds
    abstract fun bindHomeMapperSource(mapper: NewMapperHomeImpl) : NewMapperHome
}