package com.example.mangahunt.api

import com.example.mangahunt.constants.Constants
import com.example.mangahunt.models.Mangas
import com.example.mangahunt.models.MangasItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MALInterface {
    @GET("${Constants.BASE_URL}manga/top/all")
    @Headers(
        "X-RapidAPI-Key: ${Constants.API_KEY}",
        "X-RapidAPI-Host: ${Constants.HOST_KEY}"
    )
    suspend fun getTopManga(): Mangas

}