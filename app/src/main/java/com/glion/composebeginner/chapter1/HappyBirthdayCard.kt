package com.glion.composebeginner.chapter1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glion.composebeginner.R
import com.glion.composebeginner.ui.theme.ComposeBeginnerTheme
import com.glion.composebeginner.utils.LogUtil
import com.glion.composebeginner.utils.noRippleClickable

//@Composable
//fun BirthdayGreetingWithImage(message: String, from: String, modifier: Modifier = Modifier){
//    val image = painterResource(id = R.drawable.androidparty)
//    Box{
//        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop)
//        BirthdayGreetingWithText(message, from)
//    }
//}
//@Composable
//fun BirthdayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier){
//    Column(
//        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        Text(text = message, fontSize = 36.sp, modifier = Modifier.padding(top = 16.dp))
//        Text(text = from, fontSize = 24.sp, modifier = Modifier
//            .padding(top = 16.dp, end = 16.dp)
//            .align(alignment = Alignment.End))
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun BirthdayCardPreview() {
//    ComposeBeginnerTheme {
//        BirthdayGreetingWithImage("Happy Birthday Han!", "- from Glion")
//    }
//}

@Composable
fun BirthdayCardText(
    to: String,
    from: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Happy\nBirthday\n$to!",
            textAlign = TextAlign.Center,
            fontSize = 90.sp,
            lineHeight = 100.sp,
            modifier = Modifier.noRippleClickable {
                LogUtil.d("텍스트 클릭")
            }
        )
        Text(
            text = "From $from",
            fontSize = 36.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
    }
}

@Composable
fun BirthdayCard(
    to: String,
    from: String,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Image(
            painter = painterResource(id = R.drawable.ch_1_androidparty),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f,
            modifier = modifier
        )
        BirthdayCardText(to = to, from = from, modifier = modifier)
    }
}

@Preview
@Composable
fun PreviewSimpleBirthdayCard() {
    ComposeBeginnerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BirthdayCard(to = "Sam", from = "Emma", modifier = Modifier.fillMaxSize())
        }
    }
}