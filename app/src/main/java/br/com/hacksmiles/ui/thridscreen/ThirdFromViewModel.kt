package br.com.hacksmiles.ui.thridscreen

import br.com.hacksmiles.data.Repository
import kotlinx.coroutines.*

class ThirdFromViewModel(private val repository: Repository) {
    val viewState = ThirdFromViewState()
    fun fetchData(preference: String) {
        GlobalScope.launch() {
            val result = repository.fetchDestinies(preference)
            viewState.destinies.postValue(result)
        }
    }
}