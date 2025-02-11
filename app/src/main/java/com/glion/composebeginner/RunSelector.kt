package com.glion.composebeginner

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.glion.composebeginner.chapter1.BirthdayCard
import com.glion.composebeginner.chapter1.BusinessCard
import com.glion.composebeginner.chapter1.ComposeFourthQuadrant
import com.glion.composebeginner.chapter1.ComposeHelper
import com.glion.composebeginner.chapter1.TaskManager
import com.glion.composebeginner.chapter2.DiceRollerApp

enum class Chapter {
    Chapter1, Chapter2
}

enum class Chapter1Part {
    HappyBirthdayCard, ComposeHelper, TaskManager, ComposeFourthQuadrant, BusinessCard
}

enum class Chapter2Part {
    DiceRoller
}

/**
 * 실행할 챕터 지정. 이거에 따라서 theme 가 달라진다.
 */
object RunSelector {
    var runChapter: Chapter = Chapter.Chapter1
        private set

    var runPart: Any? = null
        private set

    fun setChapter(chapter: Chapter) {
        runChapter = chapter
    }

    fun setPart(part: Any) {
        runPart = part
    }

    @Composable
    fun DoRun(
        modifier: Modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.navigationBars) // 시스템 네비게이션 바 만큼의 inset 지정
            .windowInsetsPadding(WindowInsets.statusBars) // 시스템 상태바 만큼의 inset 지정
    ) {
        when(runChapter) {
            Chapter.Chapter1 -> {
                RunChapter1(modifier = modifier)
            }
            Chapter.Chapter2 -> {
                RunChapter2(modifier = modifier)
            }
        }
    }

    @Composable
    fun RunChapter1(modifier: Modifier) {
        when(runPart) {
            Chapter1Part.HappyBirthdayCard -> {
                BirthdayCard("Han", "Glion", modifier)
            }
            Chapter1Part.ComposeHelper -> {
                ComposeHelper(modifier)
            }
            Chapter1Part.TaskManager -> {
                TaskManager(modifier)
            }
            Chapter1Part.ComposeFourthQuadrant -> {
                ComposeFourthQuadrant(modifier)
            }
            Chapter1Part.BusinessCard -> {
                BusinessCard(
                    name = "Gangglion",
                    number = "010-1234-1234",
                    mail = "gliondev@gmail.com",
                    modifier = modifier
                )
            }

        }
    }

    @Composable
    fun RunChapter2(modifier: Modifier) {
        when(runPart) {
            Chapter2Part.DiceRoller -> {
                DiceRollerApp(modifier)
            }
        }
    }
}