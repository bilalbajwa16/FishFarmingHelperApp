package com.farmerone.fishfarminghelper.Screenlayout.uiElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.farmerone.fishfarminghelper.R


@Composable
fun FishAgeToggle():String{
    val options = listOf(
        "0-1",
        "1-3",
        "3-6",
        ">6",
    )
    var selectedOption by remember {
        mutableStateOf("")
    }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }

    Row(
        modifier = Modifier.fillMaxSize().padding(24.dp,0.dp),
    ) {
        options.forEach { text ->
            Row(
                modifier = Modifier
                    .padding(
                        all = 6.dp,
                    ),
            )
            {
            Card{
                Text(
                    text = text,
                    style = typography.bodyMedium.merge(),
                    color =  if (text == selectedOption) {
                        colorResource(id = R.color.white)
                    } else {
                        colorResource(id = R.color.text_colores)
                    },
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(
                                size = 8.dp,
                            ),
                        )
                        .clickable {
                            onSelectionChange(text)
                        }
                        .background(
                            if (text == selectedOption) {
                                colorResource(id = R.color.toolbarcolor)
                            } else {
                                colorResource(id = R.color.backgrey)
                            }
                        )
                        .padding(
                            vertical = 3.dp,
                            horizontal = 16.dp,
                        ),
                )
            }
        }
    }
}
return selectedOption.toString()
}
