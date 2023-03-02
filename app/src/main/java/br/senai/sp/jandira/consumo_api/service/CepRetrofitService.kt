package br.senai.sp.jandira.consumo_api.service

import br.senai.sp.jandira.consumo_api.model.Cep
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepRetrofitService {

    //https://viacep.com.br/ws/06600025/json/
    @GET("{cep}/json/")
    fun getCep(@Path("cep") cep: String): Call<Cep>

    //https://viacep.com.br/ws/SP/Jandira/Silva/json/
    @GET("{estado}/{cidade}/{logradouro}/json/")
    fun getCeps(
        @Path("estado") estado: String,
        @Path("cidade") cidade: String,
        @Path("logradouro") logradouro: String
    ): Call<List<Cep>>


}