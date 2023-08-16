package com.example.quizzapp5177

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class resultActivity : AppCompatActivity() {

    var userName : String?= null
    var score : String?= null
    var tvResult : TextView? = null
    var ivTrophy : ImageView? = null
    var tvPromptMessage : TextView?=null
    var tvName : TextView? = null
    var tvScore : TextView? = null
    var btnFinish : Button? = null
    val totalQuestions = Constants.getQuestions().size


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        userName = intent.getStringExtra(Constants.USER_NAME)
        score = intent.getStringExtra(Constants.SCORE)


        tvResult = findViewById(R.id.tvResult)
        ivTrophy = findViewById(R.id.ivTrophy)
        tvPromptMessage = findViewById(R.id.tvPromptMessage)
        tvName = findViewById(R.id.tvName)
        tvScore = findViewById(R.id.tvScore)
        btnFinish = findViewById(R.id.btnFinish)


        tvName?.setText(userName)
        tvScore?.text = "Your Score is $score out of $totalQuestions"


        if(score?.toInt()!! < totalQuestions.toInt() * 0.5) {
            tvPromptMessage?.setText("You can do better")
        } else if (score?.toInt()!! < totalQuestions.toInt() * 0.8) {
            tvPromptMessage?.setText("You did it very well")
        } else {
            tvPromptMessage?.setText("Congratulations, you did it perfect!")
        }


        btnFinish?.setOnClickListener(){
                finish()
        }
    }

}