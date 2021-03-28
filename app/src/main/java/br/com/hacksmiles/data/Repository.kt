package br.com.hacksmiles.data

import android.util.Log
import br.com.hacksmiles.data.model.AppService
import br.com.hacksmiles.data.model.Destiny

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
}