package com.example.mymoviesjoseborges;


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mymoviesjoseborges.ui.theme.screen.main.MainScreen
import com.example.mymoviesjoseborges.ui.theme.screen.main.detail.DetailScreen

class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "main") {
        composable("main") {
        MainScreen(navController)
        }

        composable(
        route = "detail/{mediaId}",
        arguments = listOf(navArgument("mediaId"){
        type = NavType.IntType
        })
        ) { bakcStackEntry ->
        val id = bakcStackEntry.arguments?.getInt("mediaId")
        requireNotNull(id)
        DetailScreen(id)
        }
        }
        }
        }
        }