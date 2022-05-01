package com.elijake.twentivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trivia_fragment)
    }
}