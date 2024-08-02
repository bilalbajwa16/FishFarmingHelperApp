package com.farmerone.fishfarminghelper.Screenlayout

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farmerone.fishfarminghelper.CategoryActivity
import com.farmerone.fishfarminghelper.R
import com.farmerone.fishfarminghelper.Utils.list

@SuppressLint("PrivateResource")
val fishItems = listOf(
    list("Feed\nCalculator", R.drawable.fishfood),
    list("Water\nQuality", R.drawable.waterquality),
    list(  "Pesticide\nQuantity", R.drawable.pesticides),
    list(  "Productivity\nCalculator ", R.drawable.productivity),
    list(  "Stock\nDensity", R.drawable.stock_density),
    list(  "Production\nCosting", R.drawable.fishcosting)

)

@Composable
fun Menufunction(){
    val contexts= LocalContext.current
    Column {
        fist_list(datalist = fishItems, context =contexts)
    }

}

@Composable
fun fist_list(datalist: List<list>, context: Context) {

    Text(
        text = "Choose\n your Category",
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
        modifier = Modifier.padding(24.dp,24.dp,0.dp,0.dp)
    )
    
    LazyVerticalGrid(
        contentPadding = PaddingValues(8.dp),
        columns = GridCells.Fixed(2)){
        
        items(datalist) { data ->
            card_item(data.text, data.img,context) } }
}


@SuppressLint("SuspiciousIndentation")
@Composable
fun card_item(valuetitle:String, imagevalue: Int,context: Context){

    Column {
        Card(

            modifier = Modifier
                .padding(24.dp)
                .height(intrinsicSize = IntrinsicSize.Max),
            border = BorderStroke(2.dp, colorResource(id = R.color.lightblue)),

            colors = CardDefaults.cardColors(
                colorResource(id = R.color.colorcard)
            ) ,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 15.dp,),
        ) {
            Column(modifier = Modifier
                .padding(6.dp)
                .clickable {

                         val intent = Intent(context, CategoryActivity::class.java)
                         intent.putExtra("val", valuetitle)
                         intent.flags =   Intent.FLAG_ACTIVITY_NEW_TASK
                         context.startActivity(intent)


                },
                verticalArrangement =    Arrangement.aligned(Alignment.CenterVertically)){
                Column(modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max)) {

                    Image(
                        modifier = Modifier
                            .padding(25.dp, 20.dp, 25.dp, 0.dp),
//                        colorFilter = ColorFilter.tint(color = colorResource(id = R.color.shape_color)),

                        painter = painterResource(id = imagevalue),
                        contentDescription = "",
                        alignment = Alignment.Center,
                    )

                    Text(text = valuetitle,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.toolbarcolor),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(5.dp, 0.dp, 0.dp, 15.dp)
                            .align(Alignment.CenterHorizontally))
                }





            }
        }

    }
}