package br.com.hacksmiles.data.model.response

import br.com.hacksmiles.data.model.Destiny
import com.google.gson.annotations.SerializedName

class DestiniesResponse(@SerializedName("destinos") val destinies: List<Destiny>) {
}