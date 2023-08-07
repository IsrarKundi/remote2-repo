package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun topAppBar(scaffoldState: ScaffoldState? = null, scope: CoroutineScope? = null){
    Row(
        modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { scope?.launch { scaffoldState?.drawerState?.open() } }) {
            Image(painter = painterResource(id = R.drawable.hamburger_icon),
                contentDescription = "hamburger icon",
            Modifier.size(24.dp))
        }
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center

        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.lemonlogon_nobg),
                    contentDescription = "Litlle Lemon Logo",
                    Modifier.size(40.dp)
                )
                Text(
                    text = "Little Lemon",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp),
                    letterSpacing = 0.1.em // Adjust the value to your desired letter spacing
                )
            }
        }

        IconButton(onClick = {  }) {
            Image(
                painter = painterResource(id = R.drawable.cart_icon),
                contentDescription = "cart icon",
                Modifier.size(24.dp))
        }
    }
}

@Preview
@Composable
fun topAppBarPreview() {
    topAppBar()
}