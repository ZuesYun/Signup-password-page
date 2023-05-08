@file:Suppress("UNUSED_EXPRESSION")

package com.example.moneytransfer

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneytransfer.ui.theme.MoneyTransferTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyTransferTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("<b></b>")
                }

                }
            }
        }
    }


@Preview(showBackground = true)


@RequiresApi(Build.VERSION_CODES.O)

@Composable
fun GreetingPreview() {
    MoneyTransferTheme {
        Greeting("")
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp)) {

    }
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { /* handle click */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(8.dp)
        ) {
            Icon(Icons.Filled.ArrowBack, "#1161f8")
        }
    }
    val bluegrass = Color(56, 81, 122)
    val configuration = LocalConfiguration.current
    Text(
        text = "Welcome to Remitbee! Let's set up your free account.",
        color = bluegrass,
        modifier = Modifier
            .padding(26.dp)
            .offset(y = with(LocalDensity.current) { (0.2f * configuration.screenHeightDp).toDp() })

    )
    var text by remember { mutableStateOf("") }


    var email by remember { mutableStateOf("") }
    fun makeText(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) {
        return Toast.makeText(context, message, duration).show()

    }

    fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return emailRegex.matches(email)
    }

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    TextField(
        value = email,
        onValueChange = { email = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = with(LocalDensity.current) { screenHeight * 0.3f })
            .padding(start = 32.dp, end = 32.dp)
            .background(Color.White),
        textStyle = MaterialTheme.typography.bodyLarge,
        label = {
            Text(
                "Enter your email address",
                style = TextStyle(fontSize = 17.sp, color = Color(56, 81, 122))
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = bluegrass,
            backgroundColor = Color.White,
            cursorColor = Color.Blue,
            focusedIndicatorColor = Color.Blue,
            unfocusedIndicatorColor = Color.Gray,
            disabledIndicatorColor = Color.LightGray,
            errorIndicatorColor = Color.Red,
            placeholderColor = Color.White
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
    )

    var checked by remember { mutableStateOf(false) }
    var codeInput by remember { mutableStateOf("") }
    val validCodes = listOf("1234", "5678", "9012")
    val customTextStyle = TextStyle(color = Color(56, 81, 122))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = screenHeight * 0.42f, end = 25.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 23.dp, end = 8.dp)
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Black,
                    checkmarkColor = Color.White
                )

            )
            if (checked) {
                null
            } else {
                Text(
                    text = "Have a referral code?",
                    color = Color(0xFF636680),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            if (checked) {
                Text(
                    text = "Enter referral code",
                    style = (TextStyle(fontSize = 17.sp, color = Color(56, 81, 122)))
                )
            }
        }
        if (checked) {
            TextField(
                value = codeInput,
                onValueChange = { codeInput = it },
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 32.dp, end = 32.dp),
                label = { Text("Referral Code", fontSize = 17.sp) },
                textStyle = TextStyle(color = Color.Black)

            )


        }
    }




    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Add your content here
        }

        BoxWithConstraints(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            val context = LocalContext.current

            Button(
                onClick = {
                    if (isValidEmail(email)) {
                        Toast.makeText(context, "Email Verified", Toast.LENGTH_SHORT).show()



                    } else (
                            Toast.makeText(context, "Invalid Email", Toast.LENGTH_SHORT).show()
                            )
                    val isValidCode = validCodes.contains(codeInput)
                    if (codeInput.isNotEmpty()) {
                        if (isValidCode) {
                            Toast.makeText(context, "Valid Code", Toast.LENGTH_SHORT).show()

                        } else {
                            Toast.makeText(context, "Invalid Code", Toast.LENGTH_SHORT).show()
                        }

                    }

                },
                modifier = Modifier
                    .padding(5.dp)
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(0.dp))
                    .padding(horizontal = 16.dp)
            ) {
                Text("Sign Up", color = Color.White)

            }
        }
    }



        }







