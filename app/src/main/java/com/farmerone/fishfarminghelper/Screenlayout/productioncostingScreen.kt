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
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.Buttones
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.FishAgeToggle
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.headings
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.image
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.textfield
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.toolbar
import com.farmerone.fishfarminghelper.Utils.fishparameters
import com.farmerone.fishfarminghelper.Utils.fishproduction
import com.google.gson.Gson



@Composable
fun productionfunction(navController: NavHostController,imgid:Int,title:String) {
    val context = (LocalContext.current as? Activity)

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) )

    {
        toolbar(title_value = title, contextval = context)
        image(imgid)


        productionlayout(navController)




    }
}

@Composable
fun productionlayout(navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {


            headings(title = "Infrastructure")

            var infracost= textfield(title = "Enter Costing")

            headings(title = "Equipment")

           var equpcost= textfield(title = "Enter Costing")


        headings(title = "Depreciation")

        var depreciationcost= textfield(title = "Enter Depreciation")

        headings(title = "Feed")

        var feedcost= textfield(title = "Enter Costing")

        headings(title = "Labor")

        var laborcost= textfield(title = "Enter Costing")

        headings(title = "Utilities")

        var utilitiescost= textfield(title = "Enter Costing")


        Buttones(){
               if(depreciationcost.isNotEmpty()&&equpcost.isNotEmpty()&&infracost.isNotEmpty()&&utilitiescost.isNotEmpty()&&laborcost.isNotEmpty()&&feedcost.isNotEmpty()){

                   val ob=    fishproduction(infracost.toDouble(),equpcost.toDouble(),depreciationcost.toDouble(),feedcost.toDouble(),laborcost.toDouble(),utilitiescost.toDouble())
               val convertJsonString = Gson().toJson(ob)


//               navController.navigate("Report")


                   navController.navigate("productioncosting/$convertJsonString")
               }
            //   report(navController = navController,nofishes,avgwgt)
           }
    }}