package com.elijake.twentivia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class TriviaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_questions)

        val button = findViewById<Button>(R.id.button);

        button.setOnClickListener {
            val intent = Intent(this, Stats::class.java)
            startActivity(intent)
        }
    }
}
