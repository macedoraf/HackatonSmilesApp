package br.com.hacksmiles.ui.firstscreen

import androidx.lifecycle.ViewModel


class FirstFromViewModel : ViewModel() {
    val viewState = FirstFormViewState()


    fun validateForm(): Boolean {
        return viewState.howMany > 0
                && viewState.birthdayDate.isNotBlank()
                && viewState.name.isNotBlank()
                && viewState.selectedClimate.isNotBlank()
                || FORCE_GO_NEXT
    }
}