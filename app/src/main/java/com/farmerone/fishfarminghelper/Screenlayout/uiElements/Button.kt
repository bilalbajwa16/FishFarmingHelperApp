package com.farmerone.fishfarminghelper.Screenlayout.uiElements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.farmerone.fishfarminghelper.R

@Composable
fun button(onClick: () -> Unit ) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp, 20.dp, 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.toolbarcolor)
            ),
          modifier =   Modifier.fillMaxWidth(),
            onClick = {
                onClick()

            }) {
            Text(text = "Submit", color = colorResource(id = R.color.white))
        }
    }
}
