package br.com.hacksmiles.ui

import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.hacksmiles.R

interface BindableAdapter<T> {
    fun setData(data: List<T>)
}

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: List<T>) {
    if (recyclerView.adapter is BindableAdapter<*>) {
        (recyclerView.adapter as BindableAdapter<T>).setData(data)
    }
}

@BindingAdapter("srcResInt")
fun <T> AppCompatImageView.setSourceResInt(@DrawableRes image: Int) {
    ContextCompat.getDrawable(context, image)?.run {
        setImageDrawable(this)
    }
}

@BindingAdapter("srcRes")
fun <T> AppCompatImageView.setSrcResource(image: String) {
    val res = when (image) {
        "Nova Iorque" -> R.drawable.nova_york
        "Himalaia" -> R.drawable.himalaia
        "riodejaneiro" -> R.drawable.corcovado
        "Miami" -> R.drawable.miami
        "Toronto" -> R.drawable.toronto
        "drakensberg" -> R.drawable.drakensberg
        "Porto de Galinhas" -> R.drawable.porto_de_galinhas
        else -> R.drawable.sem_imagem
    }
    ContextCompat.getDrawable(this.context, res).run {
        setImageDrawable(this)
    }
}

