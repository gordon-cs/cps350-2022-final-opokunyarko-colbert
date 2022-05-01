package com.elijake.twentivia.model

/**
 * A data class to represent the information presented in a question
 */
data class Question(
    // might not even need it tbh, it creates an object type to make a list of question types (see Dogglers app)
    // do they need to be private?
    val question: String,
    val category: String,
    val difficulty: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>
)
