package br.com.hacksmiles.ui.firstscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.hacksmiles.ui.climate.ClimateItem

class FirstFormViewState {
    val title: LiveData<String> = MutableLiveData()
    val musicList = listOf<String>("Rock", "Samba", "Pagode")
    val howManyList = listOf<String>("1", "2", "3")

    val climates = MutableLiveData<List<ClimateItem>>()
}