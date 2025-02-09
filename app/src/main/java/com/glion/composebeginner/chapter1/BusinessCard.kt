package com.glion.composebeginner.chapter1

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glion.composebeginner.R
import com.glion.composebeginner.ui.theme.BgBusinessCard
import com.glion.composebeginner.ui.theme.BusinessCardPrimary
import com.glion.composebeginner.ui.theme.ComposeBeginnerTheme
import com.glion.composebeginner.ui.theme.LogoBg

@Composable
fun BusinessCard(
    name: String = "Jennifer Doe",
    number: String = "+11 (123) 444 555 6666",
    mail: String = "jen.doe@android.com",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BgBusinessCard),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleSection(
            name = name,
            modifier = Modifier.weight(1f)
        )
        InfoSection(
            number = number,
            shareInfo = "@AndroidDev",
            mail = mail)
    }
}

@Composable
fun TitleSection(
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ch_1_android_logo),
            contentDescription = null,
            modifier = Modifier.background(LogoBg)
                .size(128.dp),
        )
        Text(
            text = name,
            fontSize = 36.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Text(
            text = "Android Developer Extraordinaire",
            color = BusinessCardPrimary,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun InfoSection(
    number: String,
    shareInfo: String,
    mail: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(bottom = 24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        InfoItem(R.drawable.ch_1_ic_call, number)
        InfoItem(R.drawable.ch_1_ic_share, shareInfo)
        InfoItem(R.drawable.ch_1_ic_mail, mail)
    }
}

@Composable
fun InfoItem(
    @DrawableRes imageRes: Int,
    content: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            colorFilter = ColorFilter.tint(BusinessCardPrimary)
        )
        Text(
            text = content,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewBusinessCard() {
    ComposeBeginnerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BusinessCard()
        }
    }
}

@Preview
@Composable
fun PreviewInfoItem() {
    InfoItem(imageRes = R.drawable.ch_1_ic_call, content = "010-1234-1234")
}