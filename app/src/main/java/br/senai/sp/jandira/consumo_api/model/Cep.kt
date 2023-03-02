package br.senai.sp.jandira.consumo_api.model

import com.google.gson.annotations.SerializedName

data class Cep(
    var cep: String,
    var logradouro: String,
    var complemento: String,
    var bairro: String,
    //SerializedName = Usado para alterar o nome da variável, de localidade para cidade, por exemplo
    @SerializedName("localidade") var cidade: String,
    @SerializedName("uf") var estado: String
)
