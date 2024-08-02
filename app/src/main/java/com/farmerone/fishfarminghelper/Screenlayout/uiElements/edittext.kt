package com.farmerone.fishfarminghelper.Screenlayout.uiElements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farmerone.fishfarminghelper.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun textfield(title:String):String {
    val updatevalue = title.replace(":", "")

    var values by remember { mutableStateOf("") }

    Box(
        contentAlignment = Alignment. Center,
        modifier = Modifier
            .padding(24.dp, 0.dp, 24.dp)
            .fillMaxWidth()
    ) {

        Row(){
            TextField(
                modifier = Modifier
                    .padding(0.dp, 10.dp, 0.dp)
                    .weight(0.5f),
                shape = RoundedCornerShape(10.dp),

                value = values,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                   // backgroundColor = Color.LightGray,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                onValueChange = {
                        values= it
                },
                label = { Text("Enter Weight") },


                textStyle = TextStyle( fontSize =12.sp, color = colorResource(id = R.color.text_colores), fontWeight = FontWeight.Normal ),
            )
        }}
    return values
}
