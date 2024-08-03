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
import com.farmerone.fishfarminghelper.Utils.fishpesticide
import com.farmerone.fishfarminghelper.Utils.fishproduction
import com.farmerone.fishfarminghelper.Utils.fishproductivity
import com.google.gson.Gson



@Composable
fun pesticidefunction(navController: NavHostController,imgid:Int,title:String) {
    val context = (LocalContext.current as? Activity)

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) )

    {
        toolbar(title_value = title, contextval = context)
        image(imgid)


        pesticidelayout(navController)




    }
}

@Composable
fun pesticidelayout(navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {


            headings(title = "Volume of Water")

            var v= textfield(title = "Enter Volume")

            headings(title = "Concentration Recommended")

           var c= textfield(title = "Enter Concentration")




        Buttones(){
               if(v.isNotEmpty()&&c.isNotEmpty()){

                   val ob=    fishpesticide(v.toDouble(),c.toDouble())
               val convertJsonString = Gson().toJson(ob)


//               navController.navigate("Report")


                   navController.navigate("pesticidereport/$convertJsonString")
               }
            //   report(navController = navController,nofishes,avgwgt)
           }
    }}