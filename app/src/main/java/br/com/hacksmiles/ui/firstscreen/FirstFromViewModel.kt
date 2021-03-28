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

    fun validateForm(): Boolean {
        return viewState.howMany > 0
                && viewState.birthdayDate.isNotBlank()
                && viewState.name.isNotBlank()
                && viewState.selectedClimate.isNotBlank()
                || FORCE_GO_NEXT
    }
}