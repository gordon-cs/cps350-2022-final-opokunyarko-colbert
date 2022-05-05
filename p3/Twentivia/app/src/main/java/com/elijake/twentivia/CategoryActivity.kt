package com.elijake.twentivia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.elijake.twentivia.network.TriviaAPI
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


private const val TAG = "CategoryActivity"

private lateinit var categories: List<String>
private lateinit var selectedCategories: MutableList<String>

var loading = true

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        supportActionBar?.hide();

        Thread {
            // network calls need to be done in threads
            categories = TriviaAPI.getCategories()
            loading = false
            Log.d(TAG, "Categories received")
        }.start()

        while (loading) { }

        val chipGroup = findViewById<ChipGroup>(R.id.chipGroup)
        val listOfCategoryButtons: MutableList<Chip?> = MutableList(categories.size) { null }

        for (i in categories.indices) {
            listOfCategoryButtons[i] = this.layoutInflater.inflate(R.layout.category_chip, chipGroup, false) as Chip
            listOfCategoryButtons[i]?.text = categories[i]
            chipGroup.addView(listOfCategoryButtons[i])
        }

        val startBtn: ImageButton = findViewById(R.id.startBtn);
        val backButton: ImageView = findViewById(R.id.imageView4);
        val statsBtn: TextView = findViewById(R.id.statsBtn);

        startBtn.setOnClickListener {
            val intent: Intent = Intent(this, TriviaActivity::class.java);
            intent.putExtra("selected_categories", getSelectedCategories(chipGroup));
            startActivity(intent);
        }

        backButton.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java);
            startActivity(intent)
        }

        statsBtn.setOnClickListener {
            val intent = Intent(this, Stats::class.java)
            startActivity(intent)
        }
    }

    private fun getSelectedCategories (chipGroup: ChipGroup): ArrayList<String> {
        val selectedCategories: ArrayList<String> = ArrayList()
        for (i in chipGroup.checkedChipIds) {
            selectedCategories.add(chipGroup.findViewById<Chip>(i).text as String)
        }
        return selectedCategories
    }
}
