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
            val money = (300..2000).random()

            var title: String = "Viagem Teste"
            var moneyValue: String = money.convertToMoneyString()
            var smilesValue: String = (money*30).convertToMiles()
            var resImage: Int = R.drawable.sem_imagem

            fun build(): DestinyCardUI = DestinyCardUI(title, moneyValue, smilesValue, resImage)
        }
    }
}

private fun Int.convertToMiles(): String {
    return "$this milhas"
}

private fun Int.convertToMoneyString(): String {
    return "R$ $this"
}
