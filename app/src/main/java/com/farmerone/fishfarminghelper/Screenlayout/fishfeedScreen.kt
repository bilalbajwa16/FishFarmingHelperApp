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
import com.google.gson.Gson



@Composable
fun header_top(navController: NavHostController,imgid:Int,title:String) {
    val context = (LocalContext.current as? Activity)

    Column(     Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()) )

    {
        toolbar(title_value = title, contextval = context)
        image(imgid)


        layout(navController)




    }
}

@Composable
fun layout(navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {


            headings(title = "Select fish age")

            var age=FishAgeToggle()

            headings(title = "Average Weight")

           var avgwght= textfield(title = "Enter Weight")


           headings(title = "No. of fishes")

          var  nofishes= textfield(title = "Enter Number")

           Buttones(){
               if(age.isNotEmpty()&&nofishes.isNotEmpty()&&avgwght.isNotEmpty()){
             val ob=    fishparameters(nofishes.toDouble(),avgwght.toDouble(),age.toString())
               val convertJsonString = Gson().toJson(ob)


//               navController.navigate("Report")


                   navController.navigate("report/$convertJsonString")
               }
            //   report(navController = navController,nofishes,avgwgt)
           }
    }}