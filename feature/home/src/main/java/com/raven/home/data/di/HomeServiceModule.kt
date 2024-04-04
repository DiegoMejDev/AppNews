package com.raven.home.data.di

import com.raven.home.data.remote.service.HomeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object HomeServiceModule {

    @Provides
    fun provideHomeService(retrofit: Retrofit) : HomeService{
        return retrofit.create(HomeService::class.java)
    }
}