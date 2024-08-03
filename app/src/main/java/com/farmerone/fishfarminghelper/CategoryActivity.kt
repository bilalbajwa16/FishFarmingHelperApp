package com.farmerone.fishfarminghelper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.farmerone.fishfarminghelper.Screenlayout.densityfunction
import com.farmerone.fishfarminghelper.Screenlayout.densityreport
import com.farmerone.fishfarminghelper.Screenlayout.header_top
import com.farmerone.fishfarminghelper.Screenlayout.layout
import com.farmerone.fishfarminghelper.Screenlayout.pesticidefunction
import com.farmerone.fishfarminghelper.Screenlayout.pesticidereport
import com.farmerone.fishfarminghelper.Screenlayout.productionfunction
import com.farmerone.fishfarminghelper.Screenlayout.productionlayout
import com.farmerone.fishfarminghelper.Screenlayout.productionreport
import com.farmerone.fishfarminghelper.Screenlayout.productivityfunction
import com.farmerone.fishfarminghelper.Screenlayout.productivityreport
import com.farmerone.fishfarminghelper.Screenlayout.report
import com.farmerone.fishfarminghelper.Screenlayout.reportpesticide
import com.farmerone.fishfarminghelper.Screenlayout.reportproductivity
import com.farmerone.fishfarminghelper.Screenlayout.reportwater
import com.farmerone.fishfarminghelper.Screenlayout.waterfun
import com.farmerone.fishfarminghelper.Utils.fishparameters
import com.farmerone.fishfarminghelper.Utils.fishpesticide
import com.farmerone.fishfarminghelper.Utils.fishproduction
import com.farmerone.fishfarminghelper.Utils.fishproductivity
import com.farmerone.fishfarminghelper.Utils.waterQualityModel
import com.farmerone.fishfarminghelper.ui.theme.FishFarmingHelperTheme

class CategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FishFarmingHelperTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val title = intent.getStringExtra("val")
                    val navController = rememberNavController()



                    NavHost(
                        navController = navController,
                       startDestination = title!!
                    ) {
                        composable("Feed\n" +
                                "Calculator") {
                                header_top(navController = navController,R.drawable.fishfood,"Feed Calculator")
                            }
                        composable("Water\n" +
                                "Quality"){
                            waterfun(navController = navController, imgid =R.drawable.waterquality , title = "Water Quality")
                        }
                        composable("Production\n" +
                                "Costing"){
                            productionfunction(navController = navController, imgid = R.drawable.fishcosting, title="Production Costing")
                        }
                        composable("Pesticide\n" +
                                "Quantity"){
                            pesticidefunction(navController = navController, imgid = R.drawable.pesticides, title="Pesticide Quantity")
                        }
                        composable("Productivity\n" +
                                "Calculator "){
                            productionfunction(navController = navController, imgid = R.drawable.productivity, title="Productivity Calculator")
                        }
                        composable("Stock\n" +
                                "Density"){
                            densityfunction(navController = navController, imgid = R.drawable.stock_density, title="Stock Density")
                        }
                        composable("pesticidereport/{number}") { backStackEntry ->

                            reportpesticide(
                                navController = navController,
                                backStackEntry.arguments?.getString("number").toString()
                            )
                        }
                        composable("productivityreport/{number}") { backStackEntry ->

                            reportproductivity(
                                navController = navController,
                                backStackEntry.arguments?.getString("number").toString()
                            )
                        }
                        composable("report/{number}") { backStackEntry ->

                            reportproductivity(
                                navController = navController,
                                backStackEntry.arguments?.getString("number").toString()
                            )
                        }


                        composable("report/{number}") { backStackEntry ->

                            report(
                                navController = navController,
                                backStackEntry.arguments?.getString("number").toString()

                            )}

                        composable("densityreport/{number}") { backStackEntry ->

                            densityreport(
                                navController = navController,
                                backStackEntry.arguments?.getString("number").toString()
                            )}

                        composable("productioncosting/{number}") { backStackEntry ->

                            productionreport(
                                navController = navController,
                                backStackEntry.arguments?.getString("number").toString()

                            )}

                        composable("reportwater/{number}") { backStackEntry ->

                            reportwater(
                                navController = navController,
                                backStackEntry.arguments?.getString("number").toString()

                            )}

                        }


                    }}}

        }
    }

fun getbiomass(fishparameter: fishparameters):String{
    var biomass:Double=fishparameter.nooffish*fishparameter.avgfsh
    return biomass.toString()
}

fun getfeedperday(fishparameter: fishparameters):String{
   var rate= getpercentage(fishparameter.age.toString())
    var biomass= getbiomass(fishparameter).toDouble()
    var total=biomass*(rate/100)
    return total.toString()
}

fun getpercentage(value:String):Double{
    var values=0.0
    if(value.equals("0-1")){
        values=13.0
    }
    else if (value.equals("1-3")){
        values=7.0
    }
    else if (value.equals("3-6")){
        values=4.0
    }
    else if (value.equals(">6")){
        values=2.0
    }
    return values
}

fun waterquality(waterQualityModels: waterQualityModel):String{
    var value=""
    if(waterQualityModels.dolevel in 5.0..7.0 &&waterQualityModels.phlevel in 6.5..8.5){
       value=  "Water quality is satisfactory"
    }
    else{
        value="Water quality is not good!"
    }
    return value
}

fun productioncost(production:fishproduction): String {
    val total=production.feed+production.equip+
            production.infra+production.labor+
            production.utlities+production.depreciation
    return total.toString()
}
fun productivity(production:fishproductivity): String {

    val mult=production.volume*production.yearno
    val total=production.totalfish/mult
         return total.toString()+" kg/m3/year"
}
fun density(production:fishproductivity): String {

    val multv=production.totalfish/production.volume

    return multv.toString()
}
fun pesticide(production:fishpesticide): String {

    val t=production.c*production.v
    return t.toString()+" mg"
}