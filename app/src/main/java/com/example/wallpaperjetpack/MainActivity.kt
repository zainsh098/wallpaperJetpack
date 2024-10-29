package com.example.wallpaperjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wallpaperjetpack.splash.SplashScreenView
import com.example.wallpaperjetpack.ui.theme.WallpaperJetpackTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            WallpaperJetpackTheme {
                NavigationGraph()
            }
        }
    }

    @Composable
    fun NavigationGraph() {
        val navController = rememberNavController()
        var isSplashScreenAvailable by remember { mutableStateOf(true) }



        LaunchedEffect(Unit) {
            delay(2000)
//            isSplashScreenAvailable = false
//            navController.navigate("home")

        }

        NavHost(navController = navController, startDestination = "splash")
        {
            composable("splash")
            {
                SplashScreenView(navController = navController)
            }
//            composable("home")
//            {
//                HomeScreen()
//            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SplashPreview() {
        WallpaperJetpackTheme {
        }
    }
}