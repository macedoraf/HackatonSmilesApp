package br.com.hacksmiles.ui.firstscreen

import androidx.lifecycle.ViewModel
import br.com.hacksmiles.R
import br.com.hacksmiles.ui.climate.ClimateItem

class FirstFromViewModel : ViewModel() {
    val viewState = FirstFormViewState()

    fun fetchData() {
        viewState.climates.value = listOf<ClimateItem>(
            ClimateItem(image = R.drawable.img_calor),
            ClimateItem(image = R.drawable.img_frio)
        )
    }
}