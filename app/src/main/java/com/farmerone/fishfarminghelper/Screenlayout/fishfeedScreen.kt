package com.farmerone.fishfarminghelper.Screenlayout

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farmerone.fishfarminghelper.R
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.FishAgeToggle
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.button
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.textfield
import com.farmerone.fishfarminghelper.Screenlayout.uiElements.toolbar


@Preview(showBackground = true)
@Composable
fun fishFeed_function(){
    val context = (LocalContext.current as? Activity)

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()))
    {
        toolbar(title_value = "Feed Calculator", contextval = context)
        image(R.drawable.fishfood)

        layout()




    }
}

@Composable
fun headings(title:String){
    Text(
        text = title,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        modifier = Modifier.padding(24.dp,24.dp,0.dp,10.dp)
    )}




@Composable
fun layout(){
    Column(Modifier.fillMaxSize()) {


            headings(title = "Select fish age")

            var age=FishAgeToggle()

           headings(title = "Average fish Weight")

            var avgwgt= textfield(title = "")

           headings(title = "No. of fishes")

           var nofishes= textfield(title = "Enter Number")

           button(){

           }
    }}


@Composable
fun image(id:Int){

    Column(
        Modifier
            .fillMaxWidth()
            .padding(30.dp, 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,){
        Image(painter = painterResource(id =  id), contentDescription = "Fish Food Image",
            modifier = Modifier.size(160.dp),
            alignment = Alignment.Center
        )}
}


