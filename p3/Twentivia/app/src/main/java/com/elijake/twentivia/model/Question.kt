package com.elijake.twentivia.model

/**
 * A data class to represent the information presented in a question
 */
data class Question(
    private val question: String,
    private val correctAnswer: String,
    private val incorrectAnswers: List<String>
)
