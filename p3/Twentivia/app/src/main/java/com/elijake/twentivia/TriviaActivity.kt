package com.elijake.twentivia

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.elijake.twentivia.model.Question
import com.elijake.twentivia.trivia.QuestionViewModel


/* NOTES:
    - should have an adapter for question objects (like Affirmations) and API call should call 20 at once with categories and difficulty

 */


class TriviaActivity : AppCompatActivity() {

    //

    private val model: QuestionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_questions)

        val questionObserver = Observer<Question> { newQuestion ->


        }

        val button = findViewById<ImageButton>(R.id.next_btn);

        button.setOnClickListener {
            // should reload view with next question and updated timer/questions answered
            //model.status.value = nextQuestion()
        }

        model.status.observe(this, questionObserver)

        // initial question
        //model.status.value = nextQuestion()
    }

    fun nextQuestion() {

    }

    fun updateScore() {

    }

    fun resetTimer() {

    }

    fun checkAnswer(answer: String) : Boolean { // how to wait for multiple buttons???
        if (answer == model.status.value?.correctAnswer) {
            return true
        }
        return false
    }

}