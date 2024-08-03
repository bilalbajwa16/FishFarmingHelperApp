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
import com.farmerone.fishfarminghelper.Utils.fishproductivity
import com.google.gson.Gson



@Composable
fun densityfunction(navController: NavHostController,imgid:Int,title:String) {
    val context = (LocalContext.current as? Activity)

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) )

    {
        toolbar(title_value = title, contextval = context)
        image(imgid)


        densitylayout(navController)




    }
}

@Composable
fun densitylayout(navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {


            headings(title = "Total Number of Fish")

            var totalfish= textfield(title = "Enter fish no.")

            headings(title = "Volume (m³)")

           var volume= textfield(title = "Enter Volume")




        Buttones(){
               if(totalfish.isNotEmpty()&&volume.isNotEmpty()){

                   val ob=    fishproductivity(totalfish.toDouble(),volume.toDouble(),1.1)
               val convertJsonString = Gson().toJson(ob)


//               navController.navigate("Report")


                   navController.navigate("densityreport/$convertJsonString")
               }
            //   report(navController = navController,nofishes,avgwgt)
           }
    }}