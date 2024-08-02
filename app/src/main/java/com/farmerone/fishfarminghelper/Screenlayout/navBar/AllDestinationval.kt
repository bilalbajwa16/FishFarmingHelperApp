package com.farmerone.fishfarminghelper.Screenlayout.navBar

import androidx.navigation.NavHostController
import com.farmerone.fishfarminghelper.Screenlayout.navBar.AllDestinations.ABOUT
import com.farmerone.fishfarminghelper.Screenlayout.navBar.AllDestinations.HOME_VAL
import com.farmerone.fishfarminghelper.Screenlayout.navBar.AllDestinations.PRIVACY_POLICY

object AllDestinations {
    const val PRIVACY_POLICY="Privacy Policy"
    const val HOME_VAL = "Fish Farming Helper"
    const val ABOUT = "About"

}

class AppNavigationActions(private val navController: NavHostController) {

    fun navigateToAbout() {
        navController.navigate(ABOUT) {
            popUpTo(ABOUT)
        }}

    fun navigateToHomes() {
        navController.navigate(HOME_VAL) {
            popUpTo(HOME_VAL)
        }

    }

    fun navigateToPrivacyPolice() {
        navController.navigate(PRIVACY_POLICY) {
            popUpTo(PRIVACY_POLICY)
        }}


}