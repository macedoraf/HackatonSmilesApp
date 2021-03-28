package br.com.hacksmiles.ui.firstscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.hacksmiles.ui.climate.ClimateItem
import java.util.stream.Stream

class FirstFormViewState {
    val title: LiveData<String> = MutableLiveData()

    val howManyList = listOf<String>("1", "2", "3")
    val climates = MutableLiveData<List<ClimateItem>>()

    var selectedClimate: String = ""
    var birthdayDate: String = ""
    var name: String = ""
    var howMany: Int = 0
}