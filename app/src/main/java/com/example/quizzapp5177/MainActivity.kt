package com.example.quizzapp5177

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    var btnStart: Button?= null
    var etName: EditText?=null



    val buttonStartClicked=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart=findViewById(R.id.btnStart)
        etName=findViewById(R.id.etName)
        btnStart?.setOnClickListener {
            StartButtonClicked(btnStart)
        }

    }

    fun StartButtonClicked(btnStart:Button?){
        Log.i("MainActivity","StartButtonClicked")
        if (etName?.text?.isEmpty() == true) {
            Toast.makeText(this, "Please select a name", Toast.LENGTH_SHORT).show() }
        else{
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra(Constants.USER_NAME, etName?.text.toString())
            startActivity(intent)
            finish()
        }
}



    }
