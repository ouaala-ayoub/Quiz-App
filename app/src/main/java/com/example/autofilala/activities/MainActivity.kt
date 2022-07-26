package com.example.autofilala.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.autofilala.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        hideActionBar()
        binding.startButton.setOnClickListener{
            goToAppActivity()
        }

    }

    private fun hideActionBar(){supportActionBar?.hide()}
    private fun goToAppActivity(){
        val intent = Intent(this, AppActivity::class.java)
        startActivity(intent)
    }

}