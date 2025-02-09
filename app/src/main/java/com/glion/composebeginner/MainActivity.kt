package com.glion.composebeginner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.glion.composebeginner.ui.theme.ComposeBeginnerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 화면에 보일 챕터를 선택합니다.
        RunSelector.setChapter(Chapter.Chapter1)
        // 챕터별 실행할 파트를 선택합니다.
        RunSelector.setPart(Chapter1Part.BusinessCard)
        setContent {
            ComposeBeginnerTheme {
                MainComposable()
            }
        }
    }
}

@Composable
fun MainComposable() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        if(RunSelector.runPart == null) {
            Greeting("ComposeBeginner", modifier = Modifier.padding(innerPadding))
        } else {
            RunSelector.DoRun()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewPractice() {
    // 화면에 보일 챕터를 선택합니다.
    RunSelector.setChapter(Chapter.Chapter1)
    // 챕터별 실행할 파트를 선택합니다.
    RunSelector.setPart(Chapter1Part.BusinessCard)

    ComposeBeginnerTheme {
        MainComposable()
    }
}