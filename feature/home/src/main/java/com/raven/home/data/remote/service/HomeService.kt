package com.raven.home.data.remote.service

import com.raven.home.data.remote.entities.NewItemResponse
import com.raven.home.data.remote.entities.NewsResponse
import retrofit2.http.GET

interface HomeService {

    //TODO("Correctly apply the Path and its answers. The API Key is provided in your PDF document")

    @GET("svc/mostpopular/v2/emailed/7.json?api-key=1ba7zCe4ZfH0Ox4Jt8tqOVzbfkdHrjJ4")
    suspend fun getNews(): NewsResponse
}
