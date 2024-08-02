package com.farmerone.fishfarminghelper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.farmerone.fishfarminghelper.Screenlayout.fishFeed_function
import com.farmerone.fishfarminghelper.Screenlayout.navBar.AppNavGraph
import com.farmerone.fishfarminghelper.ui.theme.FishFarmingHelperTheme

class CategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FishFarmingHelperTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FishFarmingHelperTheme {
                        fishFeed_function()
                    }
                }
            }
        }
    }
}



