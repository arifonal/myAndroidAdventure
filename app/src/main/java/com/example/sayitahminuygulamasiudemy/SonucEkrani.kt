package com.example.sayitahminuygulamasiudemy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding


@Composable
fun SonucEkrani(modifier: Modifier = Modifier, sonuc: Boolean) {
    Scaffold { innerPadding ->
        // Scaffold'ın içeriği ve padding kullanımı
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding), // innerPadding burada kullanıldı
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (sonuc) {
                Text(text = "KAZANDINIZ", fontSize = 36.sp)
                Image(painter = painterResource(id = R.drawable.mutlu_resim), contentDescription = "")
            } else {
                Text(text = "KAYBETTİNİZ", fontSize = 36.sp)
                Image(painter = painterResource(id = R.drawable.uzgun_resim), contentDescription = "")
            }
        }
    }
}
