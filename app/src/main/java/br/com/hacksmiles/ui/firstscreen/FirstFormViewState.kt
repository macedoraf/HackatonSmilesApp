package br.com.hacksmiles.ui.firstscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class FirstFormViewState {
    val title: LiveData<String> = MutableLiveData()
    val howManyList = listOf<String>("1", "2", "3", "4", "5", "6")
    var selectedClimate: String = ""
    var birthdayDate: String = ""
    var name: String = ""
    var howMany: Int = 0
}