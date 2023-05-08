package com.example.moneytransfer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moneytransfer.ui.theme.MoneyTransferTheme

class passwordpage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyTransferTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    CreatePassword()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CreatePassword() {
    @Composable
    fun Bullet(isValid: Boolean, text: String) {

    }

    @Composable
    fun Icon1(icon: ImageVector, contentDescription: Nothing?) {

    }

    @Composable
    fun Icon2(imageVector: ImageVector, contentDescription: String) {

    }

    fun Button(onClick: () -> Unit, enabled: Boolean, modifier: Modifier) {

    }
    MoneyTransferTheme {
        CreatePassword()
        @Composable
        fun PasswordCreatePage(onBackPressed: () -> Unit) {
            var password by remember { mutableStateOf("") }

            val isPasswordValid = remember {
                mutableStateOf(false)
            }

            val passwordValidator = remember {
                Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}\$")
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(horizontal = 20.dp, vertical = 40.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBackPressed) {
                        Icon2(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                    Text(
                        text = "Let's set up your password ",
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .weight(1f),
                        style = MaterialTheme.typography.h5
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Enter password") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation(),
                    trailingIcon = {
                        val icon =
                            if (password.isNotEmpty()) Icons.Default.Lock else Icons.Default.Lock
                        IconButton(onClick = {
                            isPasswordValid.value = false
                            password = ""
                        }) {
                            Icon1(icon, contentDescription = null)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(if (isPasswordValid.value) 0.5f else 1.0f)
                )
                Text(
                    text = "Password must include:",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(top = 20.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Bullet(
                        isValid = passwordValidator.matches(password),
                        text = "At least 8 characters"
                    )
                    Bullet(
                        isValid = password.any { it.isUpperCase() },
                        text = "One uppercase letter"
                    )
                    Bullet(
                        isValid = password.any { it.isLowerCase() },
                        text = "One lowercase letter"
                    )
                    Bullet(isValid = password.any { it.isDigit() }, text = "One number")
                    Bullet(
                        isValid = password.any { it.isWhitespace() || !it.isLetterOrDigit() },
                        text = "One special character"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))

                Button(
                    
                    onClick = { /* Handle password submit*/ },
                    enabled = password.length >= 8 &&
                            password.any { it.isUpperCase() } &&
                            password.any { it.isLowerCase() } &&
                            password.any { it.isDigit() } &&
                            password.any { !it.isLetterOrDigit() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 32.dp)
                ) 
                    Text(text = "Continue")
                }
            }
            }
            }

    



