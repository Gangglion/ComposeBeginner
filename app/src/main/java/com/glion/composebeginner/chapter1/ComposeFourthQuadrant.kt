package com.glion.composebeginner.chapter1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glion.composebeginner.R
import com.glion.composebeginner.ui.theme.ComposeBeginnerTheme
import com.glion.composebeginner.ui.theme.Quadrant1
import com.glion.composebeginner.ui.theme.Quadrant2
import com.glion.composebeginner.ui.theme.Quadrant3
import com.glion.composebeginner.ui.theme.Quadrant4

@Composable
fun ComposeFourthQuadrant(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            QuadrantCard(
                title = stringResource(id = R.string.ch1_second_title),
                body = stringResource(id = R.string.ch1_second_body),
                bgColor = Quadrant2,
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = stringResource(id = R.string.ch1_first_title),
                body = stringResource(id = R.string.ch1_first_body),
                bgColor = Quadrant1,
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.weight(1f)
                .fillMaxHeight()
        ) {
            QuadrantCard(
                title = stringResource(id = R.string.ch1_third_title),
                body = stringResource(id = R.string.ch1_third_body),
                bgColor = Quadrant3,
                modifier = Modifier.weight(1f)
            )
            QuadrantCard(
                title = stringResource(id = R.string.ch1_fourth_title),
                body = stringResource(id = R.string.ch1_fourth_body),
                bgColor = Quadrant4,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantCard(
    title: String,
    body: String,
    bgColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview
@Composable
fun PreviewComposeFourthQuadrant() {
    ComposeBeginnerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ComposeFourthQuadrant()
        }
    }
}