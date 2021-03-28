package br.com.hacksmiles.data

import br.com.hacksmiles.R
import br.com.hacksmiles.ui.thridscreen.ThirdFromViewState

var nome = "Rafael"
class Repository {

    fun fetchDestinies(): List<ThirdFromViewState.DestinyCardUI> {
        return listOf<ThirdFromViewState.DestinyCardUI>(
            ThirdFromViewState.DestinyCardUI.Builder().build(),
            ThirdFromViewState.DestinyCardUI.Builder().build(),
            ThirdFromViewState.DestinyCardUI.Builder().build(),
            ThirdFromViewState.DestinyCardUI.Builder().build()
        )
    }

    private fun provideResource(destiny: String): Int {
        return when (destiny) {
            "himalaia" -> R.drawable.himalaia
            "riodejaneiro" -> R.drawable.corcovado
            "miami" -> R.drawable.miami
            "toronto" -> R.drawable.toronto
            "drakensberg" -> R.drawable.drakensberg
            "portogalinhas" -> R.drawable.porto_de_galinhas
            else -> R.drawable.sem_imagem
        }
    }
}