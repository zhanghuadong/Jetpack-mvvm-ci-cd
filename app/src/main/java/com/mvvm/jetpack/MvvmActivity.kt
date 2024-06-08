package com.mvvm.jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mvvm.jetpack.databinding.ActivityMvvmBinding
import com.mvvm.jetpack.viewmodel.MvvmViewModel

class MvvmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMvvmBinding>(this, R.layout.activity_mvvm)
        val viewModel = MvvmViewModel()
        viewModel.getUser().observe(this) {
            if (it != null) {
                binding.user = it
            }
        }
        binding.srlSwipeRefreshLayout.setOnRefreshListener {
            viewModel.refresh()
            binding.srlSwipeRefreshLayout.isRefreshing = false
        }

        binding.btnGo.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}
