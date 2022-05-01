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
            "Question 2",
            "Correct Answer",
            listOf("Incorrect Answer 1", "Incorrect Answer 2", "Incorrect Answer 3")
        ),

        Question(
            "Question 3",
            "Correct Answer",
            listOf("Incorrect Answer 1", "Incorrect Answer 2", "Incorrect Answer 3")
        ),

        Question(
            "Question 4",
            "Correct Answer",
            listOf("Incorrect Answer 1", "Incorrect Answer 2", "Incorrect Answer 3")
        ),

        Question(
            "Question 5",
            "Correct Answer",
            listOf("Incorrect Answer 1", "Incorrect Answer 2", "Incorrect Answer 3")
        ),
    )
}