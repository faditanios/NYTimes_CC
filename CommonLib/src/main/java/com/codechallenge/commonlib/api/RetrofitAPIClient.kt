package com.codechallenge.commonlib.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAPIClient
{
    fun <T> buildService(service: Class<T>, url: String): T
    {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(service)
    }
}