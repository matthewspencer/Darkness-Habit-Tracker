package com.android.darknesshabittracker.authentication.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.darknesshabittracker.R

@Composable
fun OptionButtons(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(painter = painterResource(
            id = R.drawable.dark),
            contentDescription = "Fantasy background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .offset(y = ((-80).dp))
            ) {
                var triggerButton by remember {
                    mutableStateOf(false)
                }
                // Animated "register" button
                AnimatedVisibility(
                    visible = triggerButton,
                    enter = slideInHorizontally(animationSpec = tween(1000)) { -630}
                    ) {
                    Button(
                        modifier = Modifier.padding(64.dp),
                        onClick = onClick,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        shape = CutCornerShape(78.dp)
                    ) {
                        Text(
                            text = "REGISTER",
                            color = Color.White
                        )
                    }
                }
                // Animated "Login" button
                AnimatedVisibility(
                    visible = triggerButton,
                    enter = slideInHorizontally(animationSpec = tween(1000)) { 630 }
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        shape = AbsoluteCutCornerShape(45.dp)
                    ) {
                        Text(text = "LOGIN")
                    }
                }

                LaunchedEffect(Unit) {
                    triggerButton = !triggerButton
                }


            }

        }
    }


}

@Preview
@Composable
fun OptionsPreview() {
    OptionButtons() {
    }
}