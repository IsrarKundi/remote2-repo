package com.example.littlelemonlogin


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonLoginTheme {
                LoginScreen()

            }
        }
    }
}
@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var username = rememberSaveable { mutableStateOf("") }
    val realUsername = "israr"
    var password = rememberSaveable { mutableStateOf("") }
    val realPassword = "Israrikundi123"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Add padding around the Column
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.littlelemonlogo),
            contentDescription = "logo image"
        )
        Spacer(modifier = Modifier.height(16.dp)) // Add space between the Image and the TextFields
        TextField(
            value = username.value,
            onValueChange = { newValue ->
                username.value = newValue
            },
            label = { Text(text = "Username") },
            modifier = Modifier
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp)), // Set background color and shape
            textStyle = LocalTextStyle.current.copy(color = Color.Blue) // Set text color
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password.value,
            onValueChange = { newValue ->
                password.value = newValue

            },
            label = { Text(text = "Password") },
            modifier = Modifier
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp)), // Set background color and shape
            textStyle = LocalTextStyle.current.copy(color = Color.Red) // Set text color
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            if (username.value == realUsername && password.value == realPassword){

                Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context, "Login Failed", Toast.LENGTH_LONG).show()
            }
        },
            modifier = Modifier
                .width(302.dp)
                .padding(8.dp)
                .background(Color.Blue, shape = RoundedCornerShape(8.dp)), // Set background color and shape
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue,
                contentColor = Color.White)) {

            Text(text = "Login")
        }

    }


}


@Preview
@Composable
fun LoginScreenPreview() {
    LittleLemonLoginTheme {
        LoginScreen()
    }
}