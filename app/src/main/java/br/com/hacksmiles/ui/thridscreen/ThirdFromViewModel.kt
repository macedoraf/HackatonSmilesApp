package br.com.hacksmiles.ui.thridscreen

import br.com.hacksmiles.data.Repository

class ThirdFromViewModel(private val repository: Repository) {
    val viewState = ThirdFromViewState()
    fun fetchData() {
        //Usar coroutines
        viewState.destinies.value = repository.fetchDestinies()

    }
}