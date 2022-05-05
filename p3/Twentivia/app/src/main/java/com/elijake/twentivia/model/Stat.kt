package com.elijake.twentivia.model

data class Stat (
    private val _subject: String,
    private var _totalQuestionsAnswered: Int,
    private var _totalQuestionsAnsweredCorrectly: Int) {

    fun getSubject(): String {
        return _subject
    }

    fun getTotalQuestionsAnswered(): Int {
        return _totalQuestionsAnswered
    }

    fun getPercentageCorrect(): Int {
        return _totalQuestionsAnsweredCorrectly/_totalQuestionsAnswered
    }

    fun incrementTotalQuestionsAnswered() {
        _totalQuestionsAnswered++
    }

    fun incrementTotalQuestionsAnsweredCorrectly() {
        _totalQuestionsAnsweredCorrectly++
    }
}