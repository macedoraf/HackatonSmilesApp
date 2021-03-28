package br.com.hacksmiles.ui.home

import br.com.hacksmiles.data.Repository

class HomeViewModel (private val repository: Repository){
    val viewState = HomeViewState()
    fun fetchData(){
        viewState.plannedTrips.value = repository.fetchHomeCards()
    }
}