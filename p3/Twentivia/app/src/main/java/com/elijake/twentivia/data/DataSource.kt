package com.elijake.twentivia.data

import com.elijake.twentivia.model.TriviaQuestion

object DataSource{
    val triviaQuestions: List<TriviaQuestion> = listOf(
        TriviaQuestion(
            "In which book does 'The Hatter' appear?",
            "Through the Looking-Glass",
            listOf("Mio, My Son", "Jonathan Strange & Mr Norrell", "The Stand")
        ),

        TriviaQuestion(
            "Question 2",
            "Correct Answer",
            listOf("Incorrect Answer 1", "Incorrect Answer 2", "Incorrect Answer 3")
        ),

        TriviaQuestion(
            "Question 3",
            "Correct Answer",
            listOf("Incorrect Answer 1", "Incorrect Answer 2", "Incorrect Answer 3")
        ),

        TriviaQuestion(
            "Question 4",
            "Correct Answer",
            listOf("Incorrect Answer 1", "Incorrect Answer 2", "Incorrect Answer 3")
        ),

        TriviaQuestion(
            "Question 5",
            "Correct Answer",
            listOf("Incorrect Answer 1", "Incorrect Answer 2", "Incorrect Answer 3")
        ),
    )
}