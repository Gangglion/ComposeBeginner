package com.glion.composebeginner.chapter2

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.glion.composebeginner.ui.theme.ComposeBeginnerTheme

@Composable
fun DiceRollerApp(modifier: Modifier) {
    DiceWithButtonAndImage(modifier.wrapContentSize(Alignment.Center))
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun PreviewDiceRollerApp() {
    ComposeBeginnerTheme {
        DiceRollerApp(modifier = Modifier.fillMaxSize())
    }
}