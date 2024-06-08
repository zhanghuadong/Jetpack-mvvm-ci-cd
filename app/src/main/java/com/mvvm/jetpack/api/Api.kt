package com.mvvm.jetpack.api

import com.mvvm.jetpack.bean.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface Api {
    @GET("users/{userName}")
    fun getUser(@Path("userName") userName: String): Call<User>
}
