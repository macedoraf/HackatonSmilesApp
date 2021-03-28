package br.com.hacksmiles.ui.thridscreen

import androidx.lifecycle.MutableLiveData
import br.com.hacksmiles.R

class ThirdFromViewState {
    val destinies = MutableLiveData<List<DestinyCardUI>>()


    data class DestinyCardUI(
        val title: String,
        val moneyValue: String,
        val smilesValue: String,
        val resImage: Int
    ) {
        class Builder {
            var title: String = "Viagem Teste"
            var moneyValue: String = "R$100,00"
            var smilesValue: String = "5.000 milhas"
            var resImage: Int = R.drawable.sem_imagem

            fun build(): DestinyCardUI = DestinyCardUI(title, moneyValue, smilesValue, resImage)
        }
    }
}