package com.example.navappdrawerpractice.presentation

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Divider
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navappdrawerpractice.navigation.AppNavGraph
import com.example.navappdrawerpractice.navigation.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedDrawerExample(
    drawerState: DrawerState,
    navController: NavHostController
){
    val context = LocalContext.current
    val scope = rememberCoroutineScope() // trigger open close drawer
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    //val state = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        gesturesEnabled = true,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxWidth(0.8f),
                ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.2f),
                    contentAlignment = Alignment.Center,

                ){
                    Text(
                        text ="Hi, Mike",
                        modifier = Modifier.padding(16.dp),
                        fontSize = 40.sp
                    )
                }

                HorizontalDivider(
                    color = MaterialTheme.colorScheme.primary,
                    thickness = 2.dp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom=16.dp)
                        .clip(RoundedCornerShape(1.dp))
                )


                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = {Text("Home")},
                    selected = currentRoute == Screen.Home.route,
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color(0xFFB3E5FC),   // your highlight color
                        unselectedContainerColor = Color.Transparent
                    ),
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate(Screen.Home.route)
                        Toast.makeText(context,"Home Clicked", Toast.LENGTH_SHORT).show()
                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Home") },
                    label = {Text("Profile")},
                    selected = currentRoute == Screen.Profile.route,
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color(0xFFB3E5FC),   // your highlight color
                        unselectedContainerColor = Color.Transparent
                    ),
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate(Screen.Profile.route)
                        Toast.makeText(context,"Profile Clicked", Toast.LENGTH_SHORT).show()

                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "Home") },
                    label = {Text("Settings")},
                    selected = currentRoute == Screen.Settings.route,
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color(0xFFB3E5FC),   // your highlight color
                        unselectedContainerColor = Color.Transparent
                    ),
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate(Screen.Settings.route)
                        Toast.makeText(context,"Settings Clicked", Toast.LENGTH_SHORT).show()

                    }
                )
                NavigationDrawerItem(
                    icon = { Icon(Icons.Filled.Info, contentDescription = "Home") },
                    label = {Text("About")},
                    selected = currentRoute == Screen.About.route,
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color(0xFFB3E5FC),   // your highlight color
                        unselectedContainerColor = Color.Transparent
                    ),
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate(Screen.About.route)
                        Toast.makeText(context,"About Clicked", Toast.LENGTH_SHORT).show()

                    }
                )
            }
        }
    ) {
        // add top app bar
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {Text("My App")},
                    navigationIcon = {
                        IconButton(
                            onClick = {scope.launch { drawerState.open() }}
                        ) {
                            Icon(
                                modifier = Modifier.size(50.dp),
                                imageVector = Icons.Outlined.Menu,
                                contentDescription = "Open Drawer"
                            )
                        }
                    }
                )
            }
        ) { padding ->
//            // Main content behind the Nav drawer
            AppNavGraph(navController = navController, padding = padding)

        }



    }
}


@Preview(showBackground = true)
@Composable
fun DetailedDrawerExamplePreview(){
    val state = rememberDrawerState(initialValue = DrawerValue.Open )
    val navController = rememberNavController()
    DetailedDrawerExample(
        drawerState = state,
        navController = navController)
}