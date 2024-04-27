package com.android.darknesshabittracker.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.darknesshabittracker.R

data class RegistrationField(
    val label: String,
    val icon: Int
)

val fields = listOf(
    RegistrationField("Username", R.drawable.user_name),
    RegistrationField("Email address", R.drawable.user_email),
    RegistrationField("Password", R.drawable.user_password),
    RegistrationField("Confirm password", R.drawable.user_password)
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {

    Scaffold(
        topBar = {
                 TopAppBar(
                     title = { /*TODO*/ },
                     navigationIcon = { IconButton(onClick = onBackClick) {
                         Icon(Icons.Outlined.ArrowBack, "")
                     }},
                     colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
                 )
        }
    ) { paddingValues ->

        Image(
            painter = painterResource(id = R.drawable.dark2),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())

        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

            Fields(
                field = fields,
                modifier = Modifier.padding(8.dp)
            ) {}

            Spacer(modifier = Modifier.padding(32.dp))
            OptionsButtons(modifier = Modifier)
        }
    }
}

@Composable
private fun Fields(
    modifier: Modifier,
    field: List<RegistrationField>,
    onValueChanged: (String) -> Unit
) {

    Column() {
        var visibility by remember { mutableStateOf(false) }
        fields.forEachIndexed() { index, it ->
            val fadeInDuration = (index + 1) * 1000
            AnimatedVisibility(
                visible = visibility,
                enter = fadeIn(animationSpec = tween(fadeInDuration))
            ) {
                TextField(
                    value = "",
                    onValueChange = onValueChanged,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    placeholder = { Text(text = it.label)},
                    trailingIcon = { Icon(painter = painterResource(id = it.icon), contentDescription = "")},
                    colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.Transparent)
                )
            }
        }
        LaunchedEffect(Unit) {
            visibility = !visibility
        }
    }
}

@Composable
private fun OptionsButtons(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = CutCornerShape(80.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Register")
        }

        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = CutCornerShape(80.dp),
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Sign up with Google")
        }

        Text(
            text = "Forgot Password",
            modifier = Modifier
                .clickable { }
                .padding(top = 16.dp),
            color = Color.White
        )
    }

}

@Preview
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen() {

    }
}

/*@Preview
@Composable
fun FieldsPreview() {
    Fields(fields, {*//* TODO *//*})
}

@Preview
@Composable
fun OptionsButtonsPreview() {
    OptionsButtons()
}*/

