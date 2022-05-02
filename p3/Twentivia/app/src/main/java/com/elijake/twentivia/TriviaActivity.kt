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
import com.elijake.twentivia.model.Question
import com.elijake.twentivia.network.TriviaAPI

private const val TAG = "TriviaActivity"

class TriviaActivity : AppCompatActivity() {

    var questionCount = 0;
    var score = 0;
    private lateinit var theTimer: CountDownTimer
    private lateinit var triviaQuestions: List<Question>
    var loading = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_questions)

        Thread {
            // network calls need to be done in threads
            triviaQuestions = TriviaAPI.getTrivia("https://the-trivia-api.com/api/questions?limit=20")
            loading = false
        }.start()

        while(loading) { }

        val backButton = findViewById<ImageView>(R.id.imageView2);

        val answerA = findViewById<Button>(R.id.answerA);
        val answerB = findViewById<Button>(R.id.answerB);
        val answerC = findViewById<Button>(R.id.answerC);
        val answerD = findViewById<Button>(R.id.answerD);

        val answers = listOf(answerA, answerB, answerC, answerD)

        for (button in answers) {
            button.setOnClickListener {
                theTimer.cancel()
                findViewById<TextView>(R.id.grade).isVisible = true
                if (button.text == triviaQuestions[questionCount].getCorrectAnswer()){
                    findViewById<TextView>(R.id.grade).setTextColor(Color.rgb(0,250,0))
                    findViewById<TextView>(R.id.grade).text = "That's correct!!"
                    findViewById<TextView>(R.id.score).text = "${++score}/${triviaQuestions.size}"
                } else {
                    findViewById<TextView>(R.id.grade).setTextColor(Color.rgb(250,0,0))
                    findViewById<TextView>(R.id.grade).text = "The correct answer was '${triviaQuestions[questionCount].getCorrectAnswer()}'!!"
                }
                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        questionCount++
                        setQuestion(triviaQuestions[questionCount])
                    },
                    3000 //value in miliseconds
                )
            }
        }

        backButton.setOnClickListener {
            theTimer.cancel()
            val intent: Intent = Intent(this, Category::class.java);
            startActivity(intent)
        }

        findViewById<TextView>(R.id.score).text = "${score}/${triviaQuestions.size}"
        setQuestion(triviaQuestions[questionCount])
    }

    fun setQuestion(question : Question) {
        findViewById<TextView>(R.id.grade).isVisible = false
        if (questionCount < triviaQuestions.size) {
            findViewById<TextView>(R.id.main_question).text = question.getQuestion()
            setAnswers(triviaQuestions[questionCount].getShuffledAnswers())
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
        theTimer = object : CountDownTimer(11000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                findViewById<TextView>(R.id.timer).text = "Time remaining: ${millisUntilFinished / 1000}"
            }
            override fun onFinish() {
                findViewById<TextView>(R.id.grade).isVisible = true
                findViewById<TextView>(R.id.grade).setTextColor(Color.rgb(250, 0, 0))
                findViewById<TextView>(R.id.grade).text = "You ran out of time!!"
                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        questionCount++
                        setQuestion(triviaQuestions[questionCount])
                    },
                    3000 //value in miliseconds
                )
            }
        }.start()
    }
}


// Notes for further work:
// - occasional timer bug where questions 'skip' or timer 'looses time'/'keeps running'
// - after all questions answered, app crashes
// - no initial "3, 2, 1, go!" for trivia begin, so questions start when user isn't ready
// - button for next question?
//      - button allows user to pace each question? ruins the intensity of fast paced trivia...