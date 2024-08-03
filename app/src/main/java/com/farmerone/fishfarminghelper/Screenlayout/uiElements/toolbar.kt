package com.farmerone.fishfarminghelper.Screenlayout.uiElements

import android.app.Activity
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.farmerone.fishfarminghelper.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun toolbar(title_value:String, contextval: Activity?){
    TopAppBar(

        title = {
            Text(
                text = title_value, fontSize = 16.sp,  color = colorResource(id = R.color.text_colores)
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                contextval?.finish()

            }) {
                Icon(
                    tint = colorResource(id = R.color.text_colores),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        },

        )
}
