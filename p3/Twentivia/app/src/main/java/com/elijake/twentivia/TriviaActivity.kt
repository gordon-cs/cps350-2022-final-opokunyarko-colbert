package com.elijake.twentivia

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


/* NOTES:
    - should have an adapter for question objects (like Affirmations) and API call should call 20 at once with categories and difficulty

 */


class TriviaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_questions)

        val button = findViewById<ImageButton>(R.id.next_btn);

        button.setOnClickListener {
            // should reload view with next question and updated timer/questions answered
            println("Elijah fixed this")
        }
    }
    /*
    fun get (): String {
        findViewById<TextView>(R.id.question).text = get("https://the-trivia-api.com/api/questions?limit=1");
    }*/
}