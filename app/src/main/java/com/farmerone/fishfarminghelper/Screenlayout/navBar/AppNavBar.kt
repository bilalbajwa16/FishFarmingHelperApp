package com.farmerone.fishfarminghelper.Screenlayout.navBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.farmerone.fishfarminghelper.R
import com.farmerone.fishfarminghelper.Screenlayout.Menufunction
import com.farmerone.fishfarminghelper.Screenlayout.PrivacyPolicyss
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navigationController: NavHostController = rememberNavController(),
    coroutineScopevar: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {

    val currentNavBackStackEntry by navigationController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: AllDestinations.HOME_VAL
    val navigationAction = remember(navigationController) {
        AppNavigationActions(navigationController)
    }

    ModalNavigationDrawer(
        drawerContent = {
        ApplicationDrawer(
            route = currentRoute,
            navigateToHomes = { navigationAction.navigateToHomes() },
            navigateToPrivacyPolice = { navigationAction.navigateToPrivacyPolice() },
            closeDrawer = { coroutineScopevar.launch { drawerState.close() } },
            modifier = Modifier
        )
    }, drawerState = drawerState) {
        Scaffold(
             topBar = {
                TopAppBar(title = { Text(text = currentRoute,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                    ,color= colorResource(id = R.color.text_colores)
                    ) },
                    modifier = Modifier.fillMaxWidth(),
                    navigationIcon = { IconButton(onClick = {
                        coroutineScopevar.launch { drawerState.open() }
                    }, content = {
                        Icon(
                            imageVector = Icons.Default.Menu, 
                            tint = colorResource(id = R.color.text_colores), contentDescription = "Menu Home icon",
                        )
                    })
                    },

                    )
            }, modifier = Modifier
        ) {
            NavHost(
                navController = navigationController, startDestination = AllDestinations.HOME_VAL, modifier = modifier.padding(it)
            ) {

                composable(AllDestinations.HOME_VAL) {
             Menufunction()
                }

                composable(AllDestinations.PRIVACY_POLICY) {
                  PrivacyPolicyss()
                }


            }
        }
    }
}