package br.senai.sp.jandira.consumo_api

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.consumo_api.model.Cep
import br.senai.sp.jandira.consumo_api.service.RetrofitFactory
import br.senai.sp.jandira.consumo_api.service.buscarCep
import br.senai.sp.jandira.consumo_api.ui.theme.Consumo_APITheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Path

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Consumo_APITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    var textState by remember {
        mutableStateOf("")
    }
    var resultState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {


        OutlinedTextField(
            value = textState,
            onValueChange = { newValue ->
                textState = newValue
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(text = "Digite o CEP")
            }
        )
        Button(onClick = {

            resultState = buscarCep(textState) {
                resultState = it
            }

        }) {
            Text(text = "Buscar")
        }
        Text(text = resultState, modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Consumo_APITheme {
        Greeting()
    }
}