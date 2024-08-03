package com.farmerone.fishfarminghelper.Screenlayout

import android.annotation.SuppressLint
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.farmerone.fishfarminghelper.R


@Composable
fun Privacypolicyes(content: @Composable () -> Unit, modifier: Modifier) {
    AndroidView(
        modifier = modifier,
        factory = {
            val scrollView = ScrollView(it)
            val layout = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            scrollView.layoutParams = layout
            scrollView.isVerticalFadingEdgeEnabled = true
            scrollView.isScrollbarFadingEnabled = false
            scrollView.addView(ComposeView(it).apply {
                setContent {
                    content()
                }
            })
            val linearLayout = LinearLayout(it)
            linearLayout.orientation = LinearLayout.VERTICAL
            linearLayout.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            linearLayout.addView(scrollView)
            linearLayout
        }
    )
}

@SuppressLint("SuspiciousIndentation")
@Preview(showSystemUi = true)
@Composable
fun PrivacyPolicyss() {
    Privacypolicyes(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        content = {
    Box( modifier = Modifier
        )  {
        Text(text ="**Privacy Policy**\n" +
                "              \n" +
                "\"This privacy policy applies to the Fish Farming Helper (hereby referred to as \\\"App\\\") for mobile devices that was created by Fishing Expert NAME (hereby referred to as \\\"Service Provider\\\") as a Free service. This service is intended for use \\\"AS IS\\\".\n" +
                "              \n" +
                "**Information Collection and Use**\n" +
                "\"The Application does not collects information when you download and use it. The Application does not gather precise information about the location of your mobile device. The Application does not collects your device's location.\n" +
                "              \n" +
                "              \n" +
                "**Opt-Out Rights**\n" +
                "\n" +
                "You can stop all functions of the application easily by uninstalling the application. You may use the standard uninstalling procedure as may be available as part of your mobile device or via the mobile application marketplace or network.\n" +
                "\n" +
                "**Data Retention Policy**\n" +
                "\n" +
                "The Service Provider does not collect any of user data or information from the application. If you still have any queries related to it , please contact them at farmerone1236@gmail.com and they will respond in a reasonable time.\n" +
                "              \n" +
                "**Children**\n" +
                "\n" +
                "The Service Provider does not use the Application to knowingly solicit data from or market to children under the age of 13.The Application does not address anyone under the age of 13\\\\. The Service Provider does not knowingly collect personal identifiable information from children under 13 years of age. In the case the Service Provider discover that a child under 13 has provided personal information, the Service Provider will immediately delete this from their servers. If you are a parent or guardian and you are aware that your child has provided us with personal information, please contact the Service Provider (farmerone1236@gmail.com) so that they will be able to take the necessary actions.    \n" +
                "\n" +
                "**Changes**\n" +
                "\n" +
                "This Privacy Policy may be updated from time to time for any reason. The Service Provider will notify you of any changes to the Privacy Policy by updating this page with the new Privacy Policy. You are advised to consult this Privacy Policy regularly for any changes, as continued use is deemed approval of all changes.\n" +
                "This privacy policy is effective as of 2024-08-03.\n" +
                "              \n" +
                "              \n" +
                "\"**Your Consent**\n" +
                "\n" +
                "By using the Application, you are consenting to the processing of your information as set forth in this Privacy Policy now and as amended by us.\n" +
                "              \n" +
                "**Contact Us**\n" +
                "              If you have any questions regarding privacy while using the Application, or have questions about the practices, please contact the Service Provider via email at  'farmerone1236@gmail.com'.\n"
                      ,

            modifier = Modifier.padding(20.dp,20.dp),
        color= colorResource(id = R.color.text_colores))
   }})



        }

