package com.mvvm.jetpack.viewmodel

import androidx.lifecycle.ViewModel
import com.mvvm.jetpack.repository.UserRepository


class MvvmViewModel : ViewModel() {
    private val userName = "zhanghuadong"
    fun getUser() = UserRepository.getUser(userName)
    fun refresh() = UserRepository.refresh(userName)
}
