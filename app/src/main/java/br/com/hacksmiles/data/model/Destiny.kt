package br.com.hacksmiles.data.model

import androidx.annotation.DrawableRes
import br.com.hacksmiles.R
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Destiny(
    @SerializedName("titulo") val title: String,
    @SerializedName("valor_reais") val moneyValue: String,
    @SerializedName("valor_milhas") val smilesValue: String,
    @SerializedName("pacotes") val packages: List<DestinyPackage>,
    @SerializedName("requerimentos") val requirements: List<Requirement>,
    @SerializedName("imagem") val image: String
) : Serializable