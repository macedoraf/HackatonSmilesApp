package br.com.hacksmiles.ui.thridscreen

import androidx.lifecycle.MutableLiveData
import br.com.hacksmiles.R
import br.com.hacksmiles.data.model.Destiny

class ThirdFromViewState {

    val destinies = MutableLiveData<List<Destiny>>().apply {
        value = listOf<Destiny>()
    }
}