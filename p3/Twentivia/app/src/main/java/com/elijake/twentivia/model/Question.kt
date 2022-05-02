package com.elijake.twentivia.model

import java.util.*

data class Question(
    private val question: String,
    private val correctAnswer: String,
    private val incorrectAnswers: List<String>
) {
    fun getQuestion(): String {
        return question
    }

    fun getCorrectAnswer(): String {
        return correctAnswer
    }

    /**Get 4 possible answers to a trivia question in a random order
     *
     * @return List<String> answers - a list of possible answers
    </String> */
    fun getShuffledAnswers(): List<String> {
        val answers: MutableList<String> = ArrayList()
        answers.addAll(incorrectAnswers)
        answers.add(correctAnswer)
        answers.shuffle()
        return answers
    }
}

