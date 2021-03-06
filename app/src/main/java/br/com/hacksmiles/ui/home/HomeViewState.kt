package br.com.hacksmiles.ui.home

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import br.com.hacksmiles.R

class HomeViewState {
    val plannedTrips = MutableLiveData<List<TripProgressItem>>()

    data class TripProgressItem(
        val title: String,
        val resImage: Int,
        val progress: Int,
        val progressFormatted: String,
        val valueMoney:String,
        val stillMissingDescription: String
    ){
        class Builder{
            var title: String = "Porto de Galhinas - 3 de Julho de 2021"
            var resImage: Int = R.drawable.img_calor
            var progress: Int = 66
            var progressFormatted: String = progress.convertToPercentage()
            var valueMoney: String = 1200.0F.convertToMilesString()
            var stillMissingDescription: String = "- Passaporte\n- Máscara"

            fun build(): TripProgressItem = TripProgressItem(title, resImage, progress, progressFormatted, valueMoney, stillMissingDescription)
        }
    }
}

private fun Int.convertToPercentage(): String {
    return "Progresso: $this%"
}

private fun Float.convertToMoneyString(): String {
    return "R$ $this"
}
private fun Float.convertToMilesString(): String {
    return "$this milhas"
}