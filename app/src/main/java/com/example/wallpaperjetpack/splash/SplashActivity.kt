package com.example.wallpaperjetpack.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wallpaperjetpack.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreenView(navController: NavController) {
    var isCardVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(2000)
        isCardVisible = true
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight,
            painter = painterResource(id = R.drawable.splash_image),
            contentDescription = "Splash Image"
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            if (isCardVisible) { // Show card when isCardVisible is true
                CardSlide(navController)
            }
        }
    }
}
@Composable
fun CardSlide(navController: NavController) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        shape = CardDefaults.elevatedShape,

        ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.black_fade)),
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.White,
                    text = "Transform Your Screen with\n  Amazing Wallpapers!"
                )
                Spacer(modifier = Modifier.height(40.dp))
                FilledTonalButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.white)
                    ),
                    modifier = Modifier.size(200.dp, 50.dp),
                    onClick = { navController.navigate("home") }
                ) {
                    Text(
                        fontSize = 22.sp,
                        color = Color.Black,
                        text = "Continue"
                    )
                }
            }
        }
    }
}


//    @Preview(showBackground = true)
//    @Composable
//    fun SplashPreview() {
//        WallpaperJetpackTheme {
//            SplashScreenView(navController=Na)
//        }
//    }
