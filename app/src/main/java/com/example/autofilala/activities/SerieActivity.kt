package com.example.autofilala.activities

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.autofilala.R
import com.example.autofilala.modules.Seria
import com.example.autofilala.databinding.ActivitySerieBinding
import com.example.autofilala.modules.Question

const val TAG = "SerieActivity"
const val TIMER_VALUE = 45000L
const val TIMER_JUMP = 1000L
const val maxIndex = 3

class SerieActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySerieBinding
    private var currentIndex: Int = 0
    private val responseList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySerieBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val series = getTheQuestionsSet()
        choicesFunctionality()
        //runBlocking { setTheQuestions(listOf()) }
        setTheQuestions(listOf())
        Log.i(TAG, "onCreate: $responseList")
    }

    private fun getTheQuestionsSet(): Seria? {
        val id = intent.getSerializableExtra("serie_number") as Int
        return networkCall(id)
    }

    private fun networkCall(id: Int): Seria?{
        //do The network call and search for serie with id = id
        return null
    }

    private fun setTheQuestions(questionsList: List<Question>){

        //if (questionsList.isNullOrEmpty() || questionList.size < 40) return mutableListOf()

        setTheTitle()
        loopQuestions(questionsList)
    }

    private fun resetResponse() {
        binding.responses.text = ""
    }

    private fun setTheUi(question: Question) {
        val imageUri = getTheImage(question.imageRes)
        setTheImage(imageUri)
        //set The sound queue
    }

    private fun getTheImage(url: String): Uri{
        //to change
        val uri: Uri = Uri.EMPTY
        return uri
    }

    private fun setTheImage(imageUri: Uri){
        binding.serieImage.setImageURI(imageUri)
    }

    private fun setTheTitle(){
        val number = intent.getSerializableExtra("serie_title") as String
        binding.serieTitle.text = number
    }

    private fun choicesFunctionality(){

        val choiceRef = binding.responses

        binding.one.setOnClickListener {
            if(choiceRef.text.length == 4) return@setOnClickListener
            choiceRef.text = choiceRef.text.toString()+"1"
        }
        binding.two.setOnClickListener {
            if(choiceRef.text.length == 4) return@setOnClickListener
            choiceRef.text = choiceRef.text.toString()+"2"
        }
        binding.three.setOnClickListener {
            if(choiceRef.text.length == 4) return@setOnClickListener
            choiceRef.text = choiceRef.text.toString()+"3"
        }
        binding.four.setOnClickListener {
            if(choiceRef.text.length == 4) return@setOnClickListener
            choiceRef.text = choiceRef.text.toString()+"4"
        }
    }

    private fun correctionFunctionality(){
        binding.correct.setOnClickListener {
            resetResponse()
        }
    }

    private fun setTimer(listOfQuestion: List<Question>, position: Int): CountDownTimer {
        val timer = object : CountDownTimer(TIMER_VALUE, TIMER_JUMP) {

            override fun onTick(millisUntilFinished: Long) {
                binding.timeLeft.text = (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                //start again after finishing
                responseList.add(binding.responses.text.toString())

                if(currentIndex == maxIndex) {
                    //set The results activity and the alert dialog
                    val score = getTheScore(listOfQuestion)
                    showResultAlertDialog(score, R.layout.dialog_view)
                    Log.i(TAG, "onFinish: $responseList")
                    return
                }
                if (currentIndex < maxIndex) {
                    currentIndex++
                    start()
                }
                //setTheUi(listOfQuestion[currentIndex])
            }
        }
        return timer
    }

    private fun loopQuestions(questionsList: List<Question>){

        val responseList = mutableListOf<String>()
        val timer = setTimer(questionsList, currentIndex)

        //setTheUi(questionsList[currentIndex])
        timer.start()
        correctionFunctionality()
        binding.confirm.setOnClickListener {
            Log.i(TAG, "confirmClicked")
            responseList.add(binding.responses.text.toString())
            timer.cancel()
            timer.onFinish()
            resetResponse()
            Log.i(TAG, "$currentIndex")
        }
    }

    private fun showResultAlertDialog(result: Int, viewRes: Int){

        val view = LayoutInflater.from(applicationContext).inflate(viewRes, null)
        val textView = view.findViewById<TextView?>(R.id.result_view)
        textView.text = resources.getString(R.string._00_40, result)

        AlertDialog.Builder(this@SerieActivity)
            .setView(view)
            .setTitle("النتيجة")
            .setCancelable(false)
            .setPositiveButton("تصحيح", DialogInterface.OnClickListener {
                    _, _ ->
                val id = intent.getSerializableExtra("serie_number") as Int
                val intent = Intent(this.applicationContext, ResultsActivity::class.java)
                intent.putExtra("number", id)
                intent.putExtra("result", result)

                startActivity(intent)
            })
            .setNegativeButton("خروج", DialogInterface.OnClickListener{
                    _, _ ->
                val intent = Intent(this.applicationContext, SeriesFragment::class.java)
                intent.putExtra("result", result)

                startActivity(intent)
            })
            .show()
    }

    private fun getTheScore(questions: List<Question>): Int{
        var result = 0
//        for (position in 0..maxIndex){
//            if(questions[position].rightResponse == responseList[position]){
//                result++
//            }
//        }
        return result
    }
}