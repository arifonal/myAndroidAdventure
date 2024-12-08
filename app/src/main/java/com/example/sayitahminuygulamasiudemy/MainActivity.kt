package com.example.sayitahminuygulamasiudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sayitahminuygulamasiudemy.ui.theme.SayiTahminUygulamasiUdemyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayiTahminUygulamasiUdemyTheme {
                Surface {
                    SayfaGecisleri()
                }
            }
        }
    }
}


@Composable
fun SayfaGecisleri() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa") {
        composable("anasayfa") {
            AnaSayfa(navController = navController)
        }
        composable("tahmin_ekrani") {
            TahminEkrani(navController = navController)
        }
        composable("sonuc_ekrani/{sonuc}", arguments = listOf(
            navArgument("sonuc") { type = NavType.BoolType }
        )) {
            val sonuc = it.arguments?.getBoolean("sonuc")!!
            SonucEkrani(sonuc = sonuc)
        }
    }
}


@Composable
fun AnaSayfa(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding), // padding burada kullanıldı
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Tahmin Oyunu", fontSize = 36.sp)
            Image(
                painter = painterResource(id = R.drawable.zar_resim),
                contentDescription = ""
            )
            Button(onClick = {
                navController.navigate("tahmin_ekrani")
            }, modifier = Modifier.size(250.dp, 50.dp)) {
                Text(text = "OYUNA BAŞLA")
            }
        }
    }
}


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        SayiTahminUygulamasiUdemyTheme {

        }
    }

