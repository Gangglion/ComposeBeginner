package com.glion.composebeginner

enum class Chapter {
    Chapter1, Chapter2
}

/**
 * 실행할 챕터 지정. 이거에 따라서 theme 가 달라진다.
 */
object RunChapper {
    var running: Chapter = Chapter.Chapter1
        private set

    fun setChapter(chapter: Chapter) {
        running = chapter
    }
}