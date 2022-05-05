package com.elijake.twentivia.model

import java.util.*

data class Question(
    private val _question: String,
    private val _correctAnswer: String,
    private val _incorrectAnswers: List<String>
) {
    fun getQuestion(): String {
        return _question
    }

    fun getCorrectAnswer(): String {
        return _correctAnswer
    }

    /**Get 4 possible answers to a trivia question in a random order
     *
     * @return List<String> answers - a list of possible answers
    </String> */
    fun getShuffledAnswers(): List<String> {
        val answers: MutableList<String> = ArrayList()
        answers.addAll(_incorrectAnswers)
        answers.add(_correctAnswer)
        answers.shuffle()
        return answers
    }
}

