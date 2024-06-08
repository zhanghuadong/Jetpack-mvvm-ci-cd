package com.mvvm.jetpack.bindingAdapter

import android.text.TextUtils
import android.widget.ImageView
import com.squareup.picasso.Picasso
import androidx.databinding.BindingAdapter
import com.mvvm.jetpack.R

class BindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter(value = ["image", "defaultImageResource"], requireAll = false)
        fun setImage(imageView: ImageView, imageUrl: String?, imageResource: Int) {
            if (!TextUtils.isEmpty(imageUrl)) {
                Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView)
            } else {
                imageView.setImageResource(imageResource)
            }
        }
    }
}
