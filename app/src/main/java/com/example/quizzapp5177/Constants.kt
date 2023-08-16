package com.example.quizzapp5177

object Constants {
    val USER_NAME: String = "Username"
    val SCORE : String = "score"
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val Q1 = Question(
            questionText = "Which programming language is used by Android apps?",
            firstAnswer = "Python",
            secondAnswer = "Kotlin",
            thirdAnswer = "C",
            fourthAnswer = "Prolog",
            correctAnswer = "Kotlin"

        )
        questionList.add(Q1)
        val Q2 = Question(
            questionText = "Which companydeveloped the Android?",
            firstAnswer = "Apple",
            secondAnswer = "Amazon",
            thirdAnswer = "Microsoft",
            fourthAnswer = "Google",
            correctAnswer = "Google"

        )
        questionList.add(Q2)
        val Q3 = Question(
            questionText = "Which one is not a programming language?",
            firstAnswer = "Html",
            secondAnswer = "Http",
            thirdAnswer = "C",
            fourthAnswer = "Python",
            correctAnswer = "Http"

        )
        questionList.add(Q3)

        return questionList

    }
}