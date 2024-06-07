package com.android.darknesshabittracker.authentication.presentation

import android.content.Context
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
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
import com.android.darknesshabittracker.authentication.domain.Authentication
import com.android.darknesshabittracker.authentication.domain.RegistrationData

private const val TAG = "RegistrationScreen"
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    context: Context,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    var visibility by remember { mutableStateOf(false) }

    val authentication = Authentication()

    Scaffold(
        topBar = {
                 TopAppBar(
                     title = { Text(text = "Introduce yourself", color = Color.Black) },
                     navigationIcon = { IconButton(onClick = onBackClick) {
                         Icon(Icons.Outlined.ArrowBack, "")
                     }},
                     colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
                 )
        }
    ) { paddingValues ->

        Log.d(TAG, "Scaffold: updated")

        Image(
            painter = painterResource(id = R.drawable.dark2),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize())

        Column(modifier = modifier.padding(paddingValues)) {
            Log.d(TAG, "Column: updated ")

            var regData by remember {
                mutableStateOf(RegistrationData("", "", "", ""))
            }

            Fields(
                visibility = visibility,
                modifier = modifier.padding(8.dp),
                userNameValue = regData.userName,
                emailValue = regData.email,
                passwordValue = regData.password,
                confirmPasswordValue = regData.confirmPassword,
                onUserNameChanged = { userName -> regData = regData.copy(userName = userName) },
                onEmailChanged = { email -> regData = regData.copy(email = email) },
                onPasswordChanged = { password -> regData = regData.copy(password = password) },
                onPasswordConfirmChanged = { password -> regData = regData.copy(confirmPassword = password)},

            )

            Spacer(modifier = modifier.padding(32.dp))

            OptionButtons(
                visibility = visibility,
                onRegisterClick = {
                    authentication.registration(regData.email, regData.password, context)
                    Log.d(TAG, "RegistrationScreen: Clicked ")
                                  },
                onSignUpWithGoogleClicked = { /*TODO*/ },
                onForgotPasswordClicked = { }
            )
        }
    }

    LaunchedEffect(Unit) {
        visibility = !visibility
    }
}

@Composable
private fun Fields(
    modifier: Modifier,
    visibility: Boolean,
    onUserNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onPasswordConfirmChanged: (String) -> Unit,
    userNameValue: String,
    emailValue: String,
    passwordValue: String,
    confirmPasswordValue: String
) {



    Column(modifier.padding(horizontal = 8.dp)) {
        CustomTextField(
            value = userNameValue,
            onValueChanged = onUserNameChanged,
            placeholder = { Text(text = "Username") },
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.user_name), contentDescription = "Username icon" ) },
            visibility = visibility,
            animDuration = 1000
        )
        
        CustomTextField(
            value = emailValue,
            onValueChanged = onEmailChanged,
            placeholder = { Text(text = "Email address") },
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.user_email), contentDescription = "User email" ) },
            visibility = visibility,
            animDuration = 1500
        )
        
        CustomTextField(
            value = passwordValue,
            onValueChanged = onPasswordChanged,
            placeholder = { Text(text = "Password") },
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.user_password), contentDescription = "User password" ) },
            visibility = visibility,
            animDuration = 2000
        )
        
        CustomTextField(
            value = confirmPasswordValue,
            onValueChanged = onPasswordConfirmChanged,
            placeholder = { Text(text = "Confirm password") },
            trailingIcon = { Icon(painter = painterResource(id = R.drawable.user_password), contentDescription = "User password confirmation" ) },
            visibility = visibility,
            animDuration = 2500
        )
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    placeholder: @Composable () -> Unit,
    trailingIcon: @Composable () -> Unit,
    visibility: Boolean,
    animDuration: Int
) {
    AnimatedVisibility(
        visible = visibility,
        enter = fadeIn(animationSpec = tween(durationMillis = animDuration))
        ) {
        TextField(
            value = value,
            onValueChange = onValueChanged,
            placeholder = placeholder,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = trailingIcon,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.Red
            )
        )
    }
}

@Composable
private fun OptionButtons(
    visibility: Boolean,
    onRegisterClick: () -> Unit,
    onSignUpWithGoogleClicked: () -> Unit,
    onForgotPasswordClicked: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn(animationSpec = tween(3000))
        ) {
            Button(onClick = onRegisterClick,
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = CutCornerShape(80.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Register")
            }
        }

        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn(animationSpec = tween(3500))
        ) {
            Button(onClick = onSignUpWithGoogleClicked,
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = CutCornerShape(80.dp),
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Sign up with Google")
            }
        }

        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn(animationSpec = tween(4000))
        ) {
            Button(
                onClick = onForgotPasswordClicked,
                modifier = Modifier
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Text(text = "Forgot Password")
            }
        }
    }
}

@Preview
@Composable
fun RegistrationScreenPreview() {
    /*RegistrationScreen() {
    }*/
}