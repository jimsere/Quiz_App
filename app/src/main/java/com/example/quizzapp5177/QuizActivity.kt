package com.example.quizzapp5177

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class QuizActivity : AppCompatActivity() {
    var currentQuestionIndex = 0
    var tvTotalQuestions: TextView? = null
    var tvQuestion: TextView? = null
    var btnFirstAnswer: Button? = null
    var btnSecondAnswer: Button? = null
    var btnThirdAnswer: Button? = null
    var btnFourthAnswer: Button? = null
    var answerButtonClicked = false
    var btnSubmit: Button? = null
    val totalQuestions = Constants.getQuestions().size
    var sbQuestionProgress: SeekBar? = null
    var tvQuestionProgress: TextView? = null
    val maxprogress = 3
    var answer: String?= null
    var score=0
    var userName:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        userName = intent.getStringExtra(Constants.USER_NAME)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        tvTotalQuestions = findViewById(R.id.tvTotalQuestions)
        tvQuestion = findViewById(R.id.tvQuestion)
        btnFirstAnswer = findViewById(R.id.btnFirstAnswer)
        btnSecondAnswer = findViewById(R.id.btnSecondAnswer)
        btnThirdAnswer = findViewById(R.id.btnThirdAnswer)
        btnFourthAnswer = findViewById(R.id.btnFourthAnswer)
        btnSubmit = findViewById(R.id.btnSubmit)
        sbQuestionProgress = findViewById(R.id.sbQuestionProgress)
        tvQuestionProgress = findViewById(R.id.tvQuestionProgress)




        tvTotalQuestions?.setText("Total questions : $totalQuestions")



        btnFirstAnswer?.setOnClickListener {
            onAnswerButtonClick(btnFirstAnswer)
        }

        btnSecondAnswer?.setOnClickListener {
            onAnswerButtonClick(btnSecondAnswer)
        }

        btnThirdAnswer?.setOnClickListener {
            onAnswerButtonClick(btnThirdAnswer)
        }

        btnFourthAnswer?.setOnClickListener {
            onAnswerButtonClick(btnFourthAnswer)
        }

        btnSubmit?.setOnClickListener {
            onSubmitButtonClick()
        }


        (sbQuestionProgress)?.max=maxprogress
        (tvQuestionProgress)?.text="$maxprogress"


        loadNewQuestion()


    }

    fun loadNewQuestion() {
        val questionText = Constants.getQuestions()[currentQuestionIndex].questionText
        tvQuestion?.setText(questionText)

        val firstAnswer = Constants.getQuestions()[currentQuestionIndex].firstAnswer
        btnFirstAnswer?.setText(firstAnswer)

        val secondAnswer = Constants.getQuestions()[currentQuestionIndex].secondAnswer
        btnSecondAnswer?.setText(secondAnswer)

        val thirdAnswer = Constants.getQuestions()[currentQuestionIndex].thirdAnswer
        btnThirdAnswer?.setText(thirdAnswer)

        val fourthAnswer = Constants.getQuestions()[currentQuestionIndex].fourthAnswer
        btnFourthAnswer?.setText(fourthAnswer)

        val progress=currentQuestionIndex+1
        sbQuestionProgress?.progress=progress
        tvQuestionProgress?.text="$progress/$maxprogress"

    }

    fun onAnswerButtonClick(btnAnswer: Button?) {
        initialiseButtons()
        answerButtonClicked = true
        btnAnswer?.setBackgroundColor(Color.MAGENTA)
        answer= btnAnswer?.text.toString()

    }

    fun initialiseButtons() {
        btnFirstAnswer?.setBackgroundColor(Color.WHITE)
        btnSecondAnswer?.setBackgroundColor(Color.WHITE)
        btnThirdAnswer?.setBackgroundColor(Color.WHITE)
        btnFourthAnswer?.setBackgroundColor(Color.WHITE)
    }


    fun onSubmitButtonClick() {

        if (!answerButtonClicked) {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
        } else {
            if (answer==Constants.getQuestions()[currentQuestionIndex].correctAnswer)
            {
                score++
            }
            answerButtonClicked = false
            initialiseButtons()
            currentQuestionIndex++
            if (currentQuestionIndex == totalQuestions) {
               // Toast.makeText(this, "Quiz Complete", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, resultActivity::class.java)
                intent.putExtra(Constants.USER_NAME, userName)
                intent.putExtra(Constants.SCORE, score?.toString())
                startActivity(intent)
                finish()

            } else {
                loadNewQuestion()
            }

        }
    }

}





