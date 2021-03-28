package br.com.hacksmiles.data.model

import com.google.gson.annotations.SerializedName

data class Requirement(@SerializedName("descricao") val description: String) {
}