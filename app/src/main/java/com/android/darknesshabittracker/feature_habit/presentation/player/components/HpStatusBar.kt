package com.android.darknesshabittracker.feature_habit.presentation.player.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.android.darknesshabittracker.R
import com.android.darknesshabittracker.ui.theme.PurpleGrey40

@Composable
fun HpStatusBar(modifier: Modifier) {
    Box(modifier = modifier) {
        Column {

            val hpValue = hpValueCheck(13, 50)
            val maxHpValue = 50
            Box(modifier = modifier
                .padding(start = 40.dp)
                .fillMaxWidth()
                .height(32.dp)
                .background(PurpleGrey40)) {

                Box(modifier = modifier
                    .fillMaxWidth(hpValue / maxHpValue.toFloat())
                    .height(32.dp)
                    .background(Color.Red)) {
                    
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(modifier = modifier.padding(8.dp), painter = painterResource(id = R.drawable.add), contentDescription = "")
                Text(text = "${hpValue} / ${maxHpValue}")
            }
        }
    }
}

@Preview
@Composable
fun HpStatusBarPreview() {
    HpStatusBar(modifier = Modifier)
}

fun hpValueCheck(hpValue: Int, maxHpValue: Int) = if (hpValue <= maxHpValue) hpValue else maxHpValue