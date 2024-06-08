package com.mvvm.jetpack.repository


import android.util.Log
import androidx.lifecycle.LiveData
import com.mvvm.jetpack.App
import com.mvvm.jetpack.bean.User
import com.mvvm.jetpack.dao.UserDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread


object UserRepository {
    private var userDao: UserDao = AppDatabase.getDatabase(App.context).userDao()

    fun getUser(name: String): LiveData<User> {
        refresh(name)
        return userDao.getUserByName(name)
    }

    fun refresh(name: String) {
        RetrofitClient.getApi()?.getUser(name)?.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.body() != null) {
                    insertUser(response.body()!!)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("UserRepository", "onFailure$t")
            }

        })
    }

    fun insertUser(user: User) {
        thread {
            userDao.insertUser(user)
        }
    }
}
