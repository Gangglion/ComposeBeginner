package com.glion.composebeginner.chapter1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glion.composebeginner.R
import com.glion.composebeginner.ui.theme.ComposeBeginnerTheme

@Composable
fun BirthdayGreetingWithImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.androidparty)
    Box{
        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop)
        BirthdayGreetingWithText(message, from)
    }
}
@Composable
fun BirthdayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = message, fontSize = 36.sp, modifier = Modifier.padding(top = 16.dp))
        Text(text = from, fontSize = 24.sp, modifier = Modifier
            .padding(top = 16.dp, end = 16.dp)
            .align(alignment = Alignment.End))
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    ComposeBeginnerTheme {
        BirthdayGreetingWithImage("Happy Birthday Han!", "- from Glion")
    }
}