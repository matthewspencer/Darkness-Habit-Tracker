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
import com.android.darknesshabittracker.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    var visibility by remember { mutableStateOf(false) }
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
            modifier = modifier.fillMaxSize())

        Column(modifier = modifier.padding(paddingValues)) {
            Fields(
                visibility = visibility,
                modifier = modifier.padding(8.dp)
            )

            Spacer(modifier = modifier.padding(32.dp))

            Options(
                visibility = visibility,
                modifier = modifier
            )
        }
    }

    LaunchedEffect(Unit) {
        visibility = !visibility
    }
}

@Composable
private fun Fields(
    visibility: Boolean,
    modifier: Modifier,
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column() {
        UserNameTextField(visibility = visibility ) {

        }

        EmailTextField(visibility = visibility) {
            email = it
        }

        PasswordTextField(visibility = visibility) {
            password = it
        }

        ConfirmPasswordTextField(visibility = visibility) {

        }
    }
}

@Composable
private fun UserNameTextField(
    visibility: Boolean,
    onValueChanged: (String) -> Unit
) {
    AnimatedVisibility(
        visible = visibility,
        enter = fadeIn(animationSpec = tween(500))
    ) {
        TextField(
            value = "Username",
            onValueChange = onValueChanged,
            modifier = Modifier
                .fillMaxWidth(),
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.user_name), contentDescription = "Username icon" ) },
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.Transparent)
        )
    }
}

@Composable
private fun EmailTextField(
    visibility: Boolean,
    onValueChanged: (String) -> Unit
) {
    AnimatedVisibility(
        visible = visibility,
        enter = fadeIn(animationSpec = tween(1000))
    ) {
        TextField(
            value = "Email address",
            onValueChange = onValueChanged,
            modifier = Modifier
                .fillMaxWidth(),
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.user_email), contentDescription = "Email icon" ) },
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.Transparent)
        )
    }
}

@Composable
private fun PasswordTextField(
    visibility: Boolean,
    onValueChanged: (String) -> Unit
) {
    AnimatedVisibility(
        visible = visibility,
        enter = fadeIn(animationSpec = tween(1500))
    ) {
        TextField(
            value = "Password",
            onValueChange = onValueChanged,
            modifier = Modifier
                .fillMaxWidth(),
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.user_password), contentDescription = "Password icon" ) },
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.Transparent)
        )
    }
}

@Composable
private fun ConfirmPasswordTextField(
    visibility: Boolean,
    onValueChanged: (String) -> Unit
) {
    AnimatedVisibility(
        visible = visibility,
        enter = fadeIn(animationSpec = tween(2000))
    ) {
        TextField(
            value = "Confirm password",
            onValueChange = onValueChanged,
            modifier = Modifier
                .fillMaxWidth(),
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.user_password), contentDescription = "Password confirmation icon" ) },
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.Transparent)
        )
    }
}



@Composable
private fun Options(
    visibility: Boolean,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn(animationSpec = tween(2500))
        ) {
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = CutCornerShape(80.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Register")
            }
        }

        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn(animationSpec = tween(3000))
        ) {
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = CutCornerShape(80.dp),
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Sign up with Google")
            }
        }

        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn(animationSpec = tween(3500))
        ) {
            Text(
                text = "Forgot Password",
                modifier = Modifier
                    .clickable { }
                    .padding(top = 16.dp),
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen() {
    }
}

/*private fun loginUser(context: Context, email: String, password: String) {
    val auth = FirebaseAuth.getInstance()

    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
}*/

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

