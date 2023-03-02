package br.senai.sp.jandira.consumo_api.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    val BASE_URL = "https://viacep.com.br/ws/"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitService(): CepRetrofitService{
        return retrofitFactory.create(CepRetrofitService::class.java)
    }
}