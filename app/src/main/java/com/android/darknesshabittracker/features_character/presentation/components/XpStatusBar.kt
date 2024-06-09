package com.android.darknesshabittracker.features_character.presentation.components

import android.content.res.Configuration
import android.health.connect.datatypes.Device
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.android.darknesshabittracker.R
import com.android.darknesshabittracker.features_character.domain.Charachter
import com.android.darknesshabittracker.ui.theme.PurpleGrey40

val dummyCharacter2 = Charachter(
    "John",
    34,
    50,
    3,
    62,
    100
)

@Composable
fun XpStatusBar(
    modifier: Modifier,
    charachter: Charachter
) {
    val innerBarShape = RoundedCornerShape(
        topStart = 12.dp,
        topEnd = 12.dp,
        bottomStart = 12.dp,
        bottomEnd = 12.dp
    )

    val topBarShape = RoundedCornerShape(
        topStart = 12.dp,
        topEnd = 0.dp,
        bottomStart = 12.dp,
        bottomEnd = 0.dp
    )





    Box(modifier = modifier) {
        Column {

            Box(modifier = modifier
                .padding(start = 40.dp)
                .fillMaxWidth()
                .clip(innerBarShape)
                .height(32.dp)
                .background(PurpleGrey40)
                ) {

                Box(modifier = modifier
                    .fillMaxWidth(charachter.currXp / charachter.lvlUpXp.toFloat())
                    .height(32.dp)
                    .clip(topBarShape)
                    .background(Color.Red)

                    ) {

                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(modifier = modifier.padding(8.dp), painter = painterResource(id = R.drawable.add), contentDescription = "")

                Text(text = "${charachter.currXp} / ${charachter.lvlUpXp}")

                Spacer(modifier = modifier.weight(1f))

                Text(
                    modifier = modifier.padding(end = 8.dp),
                    text = "Experience"
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun XpStatusBarPreview() {
    XpStatusBar(modifier = Modifier, dummyCharacter2)
}