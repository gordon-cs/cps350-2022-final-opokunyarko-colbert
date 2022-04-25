package com.elijake.twentivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class Category : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        supportActionBar?.hide();

        val startBtn: ImageButton = findViewById(R.id.startBtn);
        val backButton: ImageView = findViewById(R.id.imageView4);

        startBtn.setOnClickListener {
            val intent: Intent = Intent(this, TriviaActivity::class.java);
            startActivity(intent);
        }

        backButton.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java);
            startActivity(intent)
        }
    }
}
