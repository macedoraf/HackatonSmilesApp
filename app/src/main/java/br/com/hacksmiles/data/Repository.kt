package br.com.hacksmiles.data

import android.util.Log
import br.com.hacksmiles.R
import br.com.hacksmiles.data.model.AppService
import br.com.hacksmiles.data.model.Destiny
import br.com.hacksmiles.ui.home.HomeViewState

var nome = "Rafael"

class Repository(private val service: AppService) {
    val fallback = listOf(
        Destiny(
            "Teste", "R$100,00", "100.000 miles", listOf(),
            listOf(), "himalaia"
        )
    )

    suspend fun fetchDestinies(preference: String): List<Destiny> {
        try {
            val response = service.getDestinies(preference).execute()
            return if (response.isSuccessful) {
                response.body()?.destinies ?: fallback
            } else {
                fallback
            }
        } catch (err: Exception) {
            Log.e("Parrse",err.toString())
            return fallback
        }
    }

    fun fetchHomeCards(): List<HomeViewState.TripProgressItem>{
        return listOf(HomeViewState.TripProgressItem(
            "Cancun - 25 de Março de 2022",
                R.drawable.porto_de_galinhas,
            66,
            "66%",
            "R$ 1800",
            "-Passaporte\n-Mascara"
        ))
    }
}