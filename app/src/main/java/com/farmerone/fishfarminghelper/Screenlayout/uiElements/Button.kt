package com.farmerone.fishfarminghelper.Screenlayout.uiElements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.farmerone.fishfarminghelper.R

@Composable
fun Buttones(onClick: () -> Unit ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp, 24.dp, 24.dp),
    ) {
        Button(modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.toolbarcolor)
            ),
            onClick = {onClick()
                // Log.e("bag", "FilledButtonExample: ",value)
                //click(selectedText,value)
            }) {
            Text(text="Calculate",color= colorResource(id = R.color.white))
        }
    }}

