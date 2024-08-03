package com.farmerone.fishfarminghelper.Screenlayout.uiElements

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.farmerone.fishfarminghelper.R

@Composable
fun textes(title:String) {
    Text(text =title,modifier=Modifier.padding(24.dp,10.dp), color = colorResource(id = R.color.text_colores) )
}