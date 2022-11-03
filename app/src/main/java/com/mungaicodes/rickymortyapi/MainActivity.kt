package com.mungaicodes.rickymortyapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mungaicodes.rickymortyapi.ui.theme.RickyMortyApiTheme
import com.mungaicodes.rickymortyapi.util.navigation.RickAndMortyNavGraph
import com.mungaicodes.rickymortyapi.util.navigation.RickyAndMortyNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickyMortyApiTheme {
                val navController = rememberNavController()
                val navigationActions = remember(navController) {
                    RickyAndMortyNavigation(navController)
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RickAndMortyNavGraph(
                        navController = navController,
                        navigateToHome = navigationActions.navigateToHome,
                        navigateToDetail = navigationActions.navigateToDetail
                    )
                }
            }
        }
    }
}


//    AsyncImage(
//        model = ImageRequest.Builder(context = LocalContext.current)
//            .data()
//            .crossfade(true)
//            .build(),
//        contentDescription = null,
//        contentScale = ContentScale.Crop
//    )

