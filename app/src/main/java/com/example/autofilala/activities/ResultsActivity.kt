package com.example.autofilala.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.example.autofilala.adapters.ResultsAdapter
import com.example.autofilala.databinding.ActivityResultsBinding

class ResultsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultsBinding
    private var number: Int = 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityResultsBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        number = intent.getSerializableExtra("number") as Int
        score = intent.getSerializableExtra("result") as Int
        binding.resultsRv.adapter = ResultsAdapter(this,
            listOf(
                true,
                true,
                true,
                true,
                true,
                false,
                true,
                true,
                true,
                false,
                true,
                true,
                false,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                false,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                false,
                true,
                true,
             ),
            number
        )
        binding.resultsRv.layoutManager = GridLayoutManager(this, 5)
        binding.resultsRv.setHasFixedSize(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            androidx.appcompat.R.id.home -> {
                val intent = Intent(this, SeriesFragment::class.java)
                //change the value in the data base or api
                intent.putExtra("result", score)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}