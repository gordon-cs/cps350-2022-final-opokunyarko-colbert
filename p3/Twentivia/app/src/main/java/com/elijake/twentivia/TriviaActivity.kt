package com.elijake.twentivia

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.elijake.twentivia.network.TriviaAPI

class TriviaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_questions)

        val nextButton = findViewById<ImageButton>(R.id.next_btn);
        val backButton = findViewById<ImageView>(R.id.imageView2);

        nextButton.setOnClickListener {
            Thread {
                // network calls need to be done in threads
                TriviaAPI.getTrivia("https://the-trivia-api.com/api/questions?limit=20")
            }.start()
        }

        backButton.setOnClickListener {
            val intent: Intent = Intent(this, Category::class.java);
            startActivity(intent)
        }


    }
}