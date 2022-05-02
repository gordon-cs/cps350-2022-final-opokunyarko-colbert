package com.elijake.twentivia

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.elijake.twentivia.data.DataSource
import com.elijake.twentivia.model.TriviaQuestion
import kotlinx.coroutines.NonCancellable.cancel

class TriviaActivity : AppCompatActivity() {

    var questionCount = 0;
    var score = 0;
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_questions)

        /* Thread {
            // network calls need to be done in threads
            TriviaAPI.getTrivia("https://the-trivia-api.com/api/questions?limit=20")
        }.start() */

        val backButton = findViewById<ImageView>(R.id.imageView2);

        val answerA = findViewById<Button>(R.id.answerA);
        val answerB = findViewById<Button>(R.id.answerB);
        val answerC = findViewById<Button>(R.id.answerC);
        val answerD = findViewById<Button>(R.id.answerD);

        val answers = listOf(answerA, answerB, answerC, answerD)

        for (button in answers) {
            button.setOnClickListener {
                timer.cancel()
                findViewById<TextView>(R.id.grade).isVisible = true
                if (button.text == DataSource.triviaQuestions[questionCount].correctAnswer) {
                    findViewById<TextView>(R.id.grade).setTextColor(Color.rgb(0,250,0))
                    findViewById<TextView>(R.id.grade).text = "Thats Correct!!"
                    score++
                } else {
                    findViewById<TextView>(R.id.grade).setTextColor(Color.rgb(250,0,0))
                    findViewById<TextView>(R.id.grade).text = "Thats Incorrect!!"
                }
                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        questionCount++
                        setQuestion(DataSource.triviaQuestions[questionCount])
                    },
                    2000 //value in miliseconds
                )
            }
        }

        backButton.setOnClickListener {
            timer.cancel()
            val intent: Intent = Intent(this, Category::class.java);
            startActivity(intent)
        }

        findViewById<TextView>(R.id.score).text = "${score}/${DataSource.triviaQuestions.size}"
        setQuestion(DataSource.triviaQuestions[questionCount])
    }

    fun setQuestion(question : TriviaQuestion) {
        findViewById<TextView>(R.id.grade).isVisible = false
        findViewById<TextView>(R.id.score).text = "${score}/${DataSource.triviaQuestions.size}"
        if (questionCount < 5) {
            findViewById<TextView>(R.id.main_question).text = question.question
            setAnswers(DataSource.triviaQuestions[questionCount].shuffledAnswers)
        } else {
            findViewById<TextView>(R.id.main_question).text = "All done"
        }
        newTimer()
    }

    fun setAnswers(answers : List<String>) {
        findViewById<Button>(R.id.answerA).text = answers[0]
        findViewById<Button>(R.id.answerB).text = answers[1]
        findViewById<Button>(R.id.answerC).text = answers[2]
        findViewById<Button>(R.id.answerD).text = answers[3]
    }

    fun newTimer() {
        timer = object : CountDownTimer(11000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                findViewById<TextView>(R.id.timer).text = "Time remaining: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                findViewById<TextView>(R.id.grade).isVisible = true
                findViewById<TextView>(R.id.grade).setTextColor(Color.rgb(250, 0, 0))
                findViewById<TextView>(R.id.grade).text = "You ran out of time!!"
                questionCount++
                setQuestion(DataSource.triviaQuestions[questionCount])

            }
        }.start()
    }
}