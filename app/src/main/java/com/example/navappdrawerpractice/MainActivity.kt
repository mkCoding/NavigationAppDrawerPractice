package com.example.navappdrawerpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.navappdrawerpractice.presentation.DetailedDrawerExample
import com.example.navappdrawerpractice.ui.theme.NavAppDrawerPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavAppDrawerPracticeTheme {
                val state = rememberDrawerState(initialValue = DrawerValue.Closed)
                    DetailedDrawerExample(
                        drawerState = state,
                        navController = rememberNavController()
                    )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavAppDrawerPracticeTheme {
        Greeting("Android")
    }
}