package br.senai.sp.jandira.consumo_api.service

import br.senai.sp.jandira.consumo_api.model.Cep
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun buscarCep(cep: String, onComplete: (String) -> Unit): String {

    val call = RetrofitFactory()
        .retrofitService()
        .getCep(cep)

    var result = ""

    call.enqueue(object: Callback<Cep> {
        override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
            result = response.body()!!.logradouro ?: "Não encontrado"
            onComplete.invoke(result)
        }

        override fun onFailure(call: Call<Cep>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
    return result
}