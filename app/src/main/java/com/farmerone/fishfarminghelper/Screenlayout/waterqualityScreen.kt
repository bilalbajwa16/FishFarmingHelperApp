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
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.textfield
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.toolbar
import com.farmerone.fishfarminghelper.Utils.fishparameters
import com.farmerone.fishfarminghelper.Utils.waterQualityModel
import com.google.gson.Gson



@Composable
fun waterfun(navController: NavHostController,imgid:Int,title:String) {
    val context = (LocalContext.current as? Activity)

    Column(     Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()) )

    {
        toolbar(title_value = title, contextval = context)
        image(imgid)


        waterlayout(navController)




    }
}

@Composable
fun waterlayout(navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {


            headings(title = "Dissolved Oxygen ")

         var dolevel= textfield(title = "Enter DO")

            headings(title = "PH level")

        var phlevel= textfield(title = "Enter PH")


           Buttones(){
               if(dolevel.isNotEmpty()&&phlevel.isNotEmpty()){
               val ob= waterQualityModel(dolevel.toDouble(),phlevel.toDouble())
               val convertJsonString = Gson().toJson(ob)


  //             navController.navigate("Report")
//

                   navController.navigate("reportwater/$convertJsonString")
               }
            //   report(navController = navController,nofishes,avgwgt)
           }
    }}