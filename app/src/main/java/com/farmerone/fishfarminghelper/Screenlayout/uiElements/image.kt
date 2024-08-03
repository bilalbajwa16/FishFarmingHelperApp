package com.farmerone.fishfarminghelper.Screenlayout.uiElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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