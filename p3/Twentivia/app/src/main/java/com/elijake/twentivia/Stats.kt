package com.elijake.twentivia

import UserStatSerializer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.elijake.twentivia.StatFeed
import com.example.apptitudetest.StatAdapter

val Context.userStatDataStore: DataStore<UserStat> by dataStore(
    fileName = "settings.pb",
    serializer = UserStatSerializer
)

class Stats : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
        supportActionBar?.hide();

        val allStat: ArrayList<StatFeed> = ArrayList();
        allStat.add(StatFeed("Highest Score", R.drawable.icon_15_trophy));
        allStat.add(StatFeed("Total Scores", R.drawable.group_25));
        allStat.add(StatFeed("Previous Score", R.drawable.iconfinder_12));
        allStat.add(StatFeed("Time Taken", R.drawable.group_24));

        val simpleGrid: GridView = findViewById<GridView>(R.id.simpleGridView);
        simpleGrid.adapter = StatAdapter(this, allStat);

        val nextBtn = findViewById<ImageButton>(R.id.next_btn);
        nextBtn.setOnClickListener {
            val intent: Intent = Intent(this, CategoryActivity::class.java);
            startActivity(intent)
        }


    }
}