package com.example.littlelemon

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LowerPanel() {
    Column {
        WeeklySpecial()
        MenuDish()
    }
}


@Composable
fun WeeklySpecial() {
    Card(modifier = Modifier
        .fillMaxWidth()
        ) {
        Text(text = "Weekly Special",
            Modifier.padding(8.dp),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold)
    }
}


@Composable
fun MenuDish() {
   Card() {

       Row(modifier = Modifier
           .fillMaxWidth()
           .padding(8.dp)) {
           Column() {

               Text(text = "Greek Salad",
                   fontSize = 18.sp,
                   fontWeight = FontWeight.Bold,
               )

               Text(text = "The famous Greek salad of crispy lettuce, peppers, olives, our Chicago ...",
                   Modifier
                       .padding(top = 5.dp, bottom = 5.dp)
                       .fillMaxWidth(.75f),
                   fontSize = 18.sp,
                   color = Color.Gray)

               Text(text = "\$12.99",
                   fontSize = 18.sp,
                   color = Color.Gray,
                   fontWeight = FontWeight.Bold)
           }
           Image(painter = painterResource(id = R.drawable.greeksalad),
               contentDescription = "Greek Salad")
       }
   }
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview(){
    LowerPanel()
}
