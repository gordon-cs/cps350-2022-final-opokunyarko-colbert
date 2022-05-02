package com.elijake.twentivia.data

import com.elijake.twentivia.model.Question

object DataSource{
    val triviaQuestions: List<Question> = listOf(
        Question(
            "In which book does 'The Hatter' appear?",
            "Through the Looking-Glass",
            listOf("Mio, My Son", "Jonathan Strange & Mr Norrell", "The Stand")
        ),

        Question(
            "What is the 13th letter in the alphabet?",
            "M",
            listOf("J", "Q", "L")
        ),

        Question(
            "What is the correct spelling of 'accommodate' (you'll never guess)?",
            "accommodate",
            listOf("accomodate", "acommodate", "occommodate")
        ),

        Question(
            "Which planet is the largest in our solar system?",
            "Jupiter",
            listOf("Earth", "Saturn", "Neptune")
        ),

        Question(
            "How many sides are their to an octagon?",
            "8",
            listOf("9", "5", "3")
        ),
    )
}