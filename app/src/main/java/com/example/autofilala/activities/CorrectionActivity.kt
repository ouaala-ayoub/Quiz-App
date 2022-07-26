package com.example.autofilala.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.autofilala.databinding.ActivityCorrectionBinding

class CorrectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCorrectionBinding
    private val correctAnswers: String = "1 2 3"
    private val correctionText: String = " Correction "

        //intent.getSerializableExtra("question_number") as Int

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCorrectionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val questionNumber = intent.getSerializableExtra("question_number") as Int
        setTheUi(questionNumber, correctAnswers, correctionText)
    }

    @SuppressLint("SetTextI18n")
    private fun setTheUi(questionNumber: Int, correctAnswers: String, correctionText: String) {
        binding.serieTitle.text = " سؤال رقم: $questionNumber "
        binding.rightAnswers.text = correctAnswers
        binding.correctionText.text = correctionText
    }
}