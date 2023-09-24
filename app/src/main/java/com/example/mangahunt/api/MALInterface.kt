package com.example.mangahunt.api

import com.example.mangahunt.constants.Constants
import com.example.mangahunt.models.Mangas
import retrofit2.http.GET
import retrofit2.http.Headers

object HeaderContent {
    const val API_KEY = "X-RapidAPI-Key: ${Constants.API_KEY}"
    const val HOST_KEY = "X-RapidAPI-Host: ${Constants.HOST_KEY}"
}

interface MALInterface {
    @GET("${Constants.BASE_URL}manga/top/manga")
    @Headers("${HeaderContent.API_KEY}", "${HeaderContent.HOST_KEY}")
    suspend fun getTopManga(): Mangas

    @GET("${Constants.BASE_URL}manga/top/bypopularity")
    @Headers("${HeaderContent.API_KEY}", "${HeaderContent.HOST_KEY}")
    suspend fun getPopularManga(): Mangas

    @GET("${Constants.BASE_URL}manga/top/favorite")
    @Headers("${HeaderContent.API_KEY}", "${HeaderContent.HOST_KEY}")
    suspend fun getFavoriteManga(): Mangas
}