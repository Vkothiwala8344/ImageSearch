package com.example.imagesearch.repository.service

import com.example.imagesearch.model.Image
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // interface to get image data
    @GET(GET_IMAGES)
    fun getImages(
        @Query("keywords") keywords: String,
        @Query("format") format: String,
        @Query("numResult") numResult: Int
    ): Call<ArrayList<Image>>

    companion object {
        const val GET_IMAGES = "api/colors"
    }
}