package br.com.hacksmiles.data.model

import com.google.gson.annotations.SerializedName


data class DestinyPackage(
    @SerializedName("titulo") val title: String,
    @SerializedName("imagem") val packageImage: String,
    @SerializedName("tipo_viagem") val typeTrip: TypeTrip,
    @SerializedName("descricao") val description: String,
    @SerializedName("valor_reais") val moneyValue: String,
    @SerializedName("valor_milhas") val milesValue: String,
    @SerializedName("stars") val stars: Float
)