package com.mvvm.jetpack.repository

import com.mvvm.jetpack.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private const val BASE_URL = "https://api.github.com/"
    var retrofit: Retrofit

    init {
        retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getApi(): Api? {
        return retrofit.create(Api::class.java)
    }
}
