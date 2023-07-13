package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier.fillMaxSize()) {
    var pageCounter by remember { mutableStateOf(1) }

    when (pageCounter) {
        1 -> ArtImageTitleAndButtons(
            drawableResourceId = R.drawable.jeff_cons_art,
            contentDescriptionResourceId = null,
            titleStringResourceId = R.string.rabbit,
            artistStringResourceId = R.string.jeff_koons,
            yearReleaseStringResourceId = R.string.Year_release_rabit,)
        2 -> ArtImageTitleAndButtons(
            drawableResourceId = R.drawable.dali_art,
            contentDescriptionResourceId = null,
            titleStringResourceId = R.string.the_persistence_of_memory,
            artistStringResourceId = R.string.salvador_dal,
            yearReleaseStringResourceId = R.string.Year_release_the_persistence_of_memory,)
        3 -> ArtImageTitleAndButtons(
            drawableResourceId = R.drawable.louise_jos_phine_art,
            contentDescriptionResourceId = null,
            titleStringResourceId = R.string.maman,
            artistStringResourceId = R.string.louise_josephine,
            yearReleaseStringResourceId = R.string.Year_relealse_maman,)
        else -> ArtImageTitleAndButtons(
            drawableResourceId = R.drawable.mondayleftme,
            contentDescriptionResourceId = null,
            titleStringResourceId = R.string.monday_left_me_broken,
            artistStringResourceId = R.string.avicii,
            yearReleaseStringResourceId = R.string.Year_release_monday_left_me_broken,)
    }

    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(bottom = 20.dp)
    ) {
        Button(
            onClick = { if(pageCounter > 1 ) pageCounter -- },
            modifier = Modifier
                .weight(1f)
                .padding(20.dp)
        ) {
            Text(text = stringResource(id = R.string.previous))
        }
        Button(
            onClick = { if(pageCounter < 4)pageCounter ++ },
            modifier = Modifier
                .weight(1f)
                .padding(20.dp)

        ) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}

@Composable
fun ArtImageTitleAndButtons(
    @DrawableRes drawableResourceId: Int,
    @StringRes contentDescriptionResourceId: Int?,
    @StringRes titleStringResourceId: Int,
    @StringRes artistStringResourceId: Int,
    @StringRes yearReleaseStringResourceId: Int,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = drawableResourceId),
            contentDescription = if(contentDescriptionResourceId != null) stringResource(id = contentDescriptionResourceId) else null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(20.dp)
                .border(border = BorderStroke(2.dp, Color.Gray), shape = RectangleShape)
                .height(300.dp)
                .width(350.dp)
                .shadow(elevation = 4.dp, shape = RectangleShape)
                )
        Card(modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp)) {
            Text(
                text = stringResource(id = titleStringResourceId),
                fontSize = 32.sp,
                fontWeight = FontWeight.Light,
            )
            Row() {
                Text(
                    text = stringResource(id = artistStringResourceId),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    )
                Text(
                    text = " (${stringResource(id = yearReleaseStringResourceId)})",
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 16.sp,
                )
            }
        }
    }
}


