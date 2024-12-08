package com.example.sayitahminuygulamasiudemy

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import kotlin.random.Random
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding

@Composable
fun TahminEkrani(navController: NavController, modifier: Modifier = Modifier) {
    val tfTahmin = remember { mutableStateOf("") }
    val rasgeleSayi = remember { mutableStateOf(0) }
    val kalanHak = remember { mutableStateOf(5) }
    val yonlendirme = remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        rasgeleSayi.value = Random.nextInt(101)
        Log.e("rasgele sayi", rasgeleSayi.value.toString())
    }

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding), // padding burada kullanıldı
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Kalan Hak :${kalanHak.value}", fontSize = 36.sp, color = Color.Red)
            Text(text = "Yardım : ${yonlendirme.value}", fontSize = 24.sp)

            TextField(value = tfTahmin.value,
                onValueChange = { tfTahmin.value = it },
                label = { Text(text = "tahmin") })
            Button(onClick = {
                kalanHak.value = kalanHak.value - 1
                val tahmin = tfTahmin.value.toInt()

                if(rasgeleSayi.value == tahmin){
                    navController.navigate("sonuc_ekrani/true") {
                        popUpTo(route = "tahmin_ekrani") { inclusive = true }
                    }
                    return@Button
                }
                 if(rasgeleSayi.value < tahmin){
                    yonlendirme.value = "azalt"
                }
                 if(rasgeleSayi.value > tahmin){
                    yonlendirme.value = "arttır"

                }
                if(kalanHak.value == 0){
                    navController.navigate("sonuc_ekrani/false") {
                        popUpTo(route = "tahmin_ekrani") { inclusive = true }
                    }
                }
                tfTahmin.value = ""


            }, modifier = Modifier.size(250.dp, 50.dp)) {
                Text(text = "Tahmin Et")
            }
        }
    }
}
