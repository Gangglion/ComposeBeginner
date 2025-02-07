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
import com.glion.composebeginner.chapter1.Chapter1Main
import com.glion.composebeginner.chapter1.RunPart
import com.glion.composebeginner.ui.theme.ComposeBeginnerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 화면에 보일 챕터를 선택합니다.
        RunChapper.setChapter(Chapter.Chapter1)

        setContent {
            ComposeBeginnerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when(RunChapper.running) {
                        Chapter.Chapter1 -> {
                            Chapter1Main.RunChapter1(part = RunPart.HappyBirthdayCard)
                        }
                        else -> { // Default
                            Greeting(
                                name = "Android",
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
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
    RunChapper.setChapter(Chapter.Chapter1)

    ComposeBeginnerTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            when(RunChapper.running) {
                Chapter.Chapter1 -> {
                    Chapter1Main.RunChapter1(part = RunPart.HappyBirthdayCard)
                }
                else -> { // Default
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}