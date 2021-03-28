package br.com.hacksmiles.data.model

import br.com.hacksmiles.data.model.response.DestiniesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AppService {
    @GET(value = "destinos")
    fun getDestinies(@Query(value = "preferencia") preference: String): Call<DestiniesResponse>
}