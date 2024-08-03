package com.farmerone.fishfarminghelper.Screenlayout

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.farmerone.fishfarminghelper.R
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.Buttones
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.FishAgeToggle
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.headings
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.image
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.textes
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.textfield
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.toolbar
import com.farmerone.fishfarminghelper.Utils.fishparameters
import com.farmerone.fishfarminghelper.Utils.fishproduction
import com.farmerone.fishfarminghelper.Utils.waterQualityModel
import com.farmerone.fishfarminghelper.getbiomass
import com.farmerone.fishfarminghelper.getfeedperday
import com.farmerone.fishfarminghelper.productioncost
import com.farmerone.fishfarminghelper.waterquality
import com.google.gson.Gson


@Composable
fun productionreport(navController: NavHostController, nofishes: String) {
    val context = (LocalContext.current as? Activity)
    val userObject = Gson().fromJson(nofishes,fishproduction::class.java)
    Column(
        Modifier

            .verticalScroll(rememberScrollState()))
    {
        toolbar(title_value = "Production Costing", contextval = context)
        image(R.drawable.fishcosting)

        productionreports( navController,  userObject)
    //    if(flag)
       // layout(navController)




    }
}

@Composable
fun productionreports(navController: NavHostController, fishproduction:fishproduction) {
    Column(Modifier.fillMaxSize()) {


        headings(title = "Total Cost of Production")

        textes(title = productioncost(fishproduction) )




    }}




