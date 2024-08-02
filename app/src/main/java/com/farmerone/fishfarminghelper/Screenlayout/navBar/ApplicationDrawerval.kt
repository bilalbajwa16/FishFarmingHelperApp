package com.farmerone.fishfarminghelper.Screenlayout.navBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farmerone.fishfarminghelper.R


@Composable
fun ApplicationDrawer(
    route: String,
    modifier: Modifier = Modifier,
    navigateToAbout: () -> Unit = {},
    navigateToHomes: () -> Unit = {},
    navigateToPrivacyPolice: () -> Unit = {},
    closeDrawer: () -> Unit = {}
) {
    ModalDrawerSheet(modifier = Modifier.width(300.dp)) {
        DrawerHeader(modifier)
        NavigationDrawerItem(
            label = {
                Text(text ="Home",
                    color = colorResource(id = R.color.text_colores),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            selected = route == AllDestinations.HOME_VAL,
            onClick = {
                navigateToHomes()
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "home icon") },
            shape = MaterialTheme.shapes.small
        )

        NavigationDrawerItem(
            label = {
                Text(text ="Privacy Policy",// stringResource(id = R.string.home),
                    color = colorResource(id = R.color.text_colores),
                )
            },
            selected = route == AllDestinations.PRIVACY_POLICY,
            onClick = {
                navigateToPrivacyPolice()
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = " privacy policy icon") },
            shape = MaterialTheme.shapes.small
        )

        NavigationDrawerItem(
            label = {
                Text(text ="About",//
                    color = colorResource(id = R.color.text_colores),
                )
            },
            selected = route == AllDestinations.ABOUT,
            onClick = {
                navigateToAbout()
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Filled.Info, contentDescription = " privacy policy icon") },
            shape = MaterialTheme.shapes.small
        )


    }
}


@Composable
fun DrawerHeader(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
             .background(colorResource(id = R.color.toolbarcolor))
            .padding(10.dp)
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .clip(CircleShape)
                .padding(5.dp)
        )
        Spacer(modifier = Modifier//.padding(dimensionResource(id = R.dimen.spacer_padding)))
        )


    }
}

@Preview
@Composable
fun DrawerHeaderPreview() {
    ApplicationDrawer(modifier = Modifier, route = AllDestinations.HOME_VAL)
}