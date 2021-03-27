package br.com.hacksmiles.ui

import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

interface BindableAdapter<T> {
    fun setData(data: List<T>)
}

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: List<T>) {
    if (recyclerView.adapter is BindableAdapter<*>) {
        (recyclerView.adapter as BindableAdapter<T>).setData(data)
    }
}

@BindingAdapter("srcRes")
fun <T> AppCompatImageView.setSrcResource(@DrawableRes res: Int) {
    ContextCompat.getDrawable(this.context, res).run {
        setImageDrawable(this)
    }
}

