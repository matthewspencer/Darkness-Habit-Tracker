package com.android.darknesshabittracker.features_character.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.darknesshabittracker.R
import com.android.darknesshabittracker.features_character.domain.Charachter
import com.android.darknesshabittracker.ui.theme.PurpleGrey40

@Composable
fun HpStatusBar(
    modifier: Modifier,
    charachter: Charachter
) {
    Box(modifier = modifier) {
        Column {

            Box(modifier = modifier
                .padding(start = 40.dp)
                .fillMaxWidth()
                .height(32.dp)
                .background(PurpleGrey40)) {

                Box(modifier = modifier
                    .fillMaxWidth(charachter.currHp / charachter.maxHp.toFloat())
                    .height(32.dp)
                    .background(Color.Red)) {
                    
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(modifier = modifier.padding(8.dp), painter = painterResource(id = R.drawable.add), contentDescription = "")
                Text(text = "${charachter.currHp} / ${charachter.maxHp}")
            }
        }
    }
}

@Preview
@Composable
fun HpStatusBarPreview() {
    HpStatusBar(modifier = Modifier, Charachter("John", 34, 50, 123))
}

fun hpValueCheck(hpValue: Int, maxHpValue: Int) = if (hpValue <= maxHpValue) hpValue else maxHpValue