package br.com.hacksmiles.ui.firstscreen

import androidx.lifecycle.ViewModel
import br.com.hacksmiles.data.model.FormUserData


class FirstFromViewModel : ViewModel() {
    val viewState = FirstFormViewState()


    fun validateForm(): Pair<Boolean, FormUserData> {
        return Pair(
            viewState.howMany > 0
                    && viewState.birthdayDate.isNotBlank()
                    && viewState.name.isNotBlank()
                    && viewState.selectedClimate.isNotBlank()
                    || FORCE_GO_NEXT,
            FormUserData(
                viewState.name,
                viewState.birthdayDate,
                viewState.selectedClimate.toLowerCase(),
                viewState.howMany
            )
        )
    }
}