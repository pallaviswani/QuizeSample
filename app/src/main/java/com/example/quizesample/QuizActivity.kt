package com.example.quizesample

import android.annotation.TargetApi
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.quizesample.model.QuizeQuestions
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz.*
var index : Int = -1
var score : Int = 0
var marks : Int = 0

class QuizActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        setValues()
        qNumber.text = (index+1).toString()+"/"+10
        btnNextQuestion.setOnClickListener {
            if (isValid()) {
                setValues()
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    fun setValues() {
        val questions: ArrayList<QuizeQuestions> = arrayListOf(
            QuizeQuestions(
                ContextCompat.getDrawable(this, R.drawable.sparrow),
                "Sparrow",
                "crow",
                "Maina",
                "Pigeon",
                1
            ),
            QuizeQuestions(
                ContextCompat.getDrawable(this, R.drawable.goose),
                "Peacock",
                "dove",
                "Goose",
                "Turkey",
                3
            ),
            QuizeQuestions(
                ContextCompat.getDrawable(this, R.drawable.crow),
                "crow",
                "goose",
                "Maina",
                "Pigeon",
                1
            ),
            QuizeQuestions(
                ContextCompat.getDrawable(this, R.drawable.chicken),
                "Dove",
                "Turkey",
                "Chicken",
                "Peacock",
                3
            ),
            QuizeQuestions(
                ContextCompat.getDrawable(this, R.drawable.parrot),
                "Chicken",
                "Parrot",
                "Sparrow",
                "Crow",
                2
            ),
            QuizeQuestions(
                ContextCompat.getDrawable(this, R.drawable.peacock),
                "Crow",
                "Peackock",
                "Turkey",
                "Dove",
                2
            ),
            QuizeQuestions(
                ContextCompat.getDrawable(this, R.drawable.dove),
                "Turkey",
                "Dove",
                "Crow",
                "Goose",
                2
            ),
            QuizeQuestions(
                ContextCompat.getDrawable(this, R.drawable.turkey),
                "Sparrow",
                "Parrot",
                "Turkey",
                "Dove",
                3
            ),
            QuizeQuestions(
                ContextCompat.getDrawable(this, R.drawable.sparrow),
                "Sparrow",
                "crow",
                "Maina",
                "Pigeon",
                1
            ),
            QuizeQuestions(
                ContextCompat.getDrawable(this, R.drawable.goose),
                "Peacock",
                "dove",
                "Goose",
                "Turkey",
                3
            )
        )

        val selected = options.checkedRadioButtonId
//        if (selected == -1) {
//            Toast.makeText(this, "Select option", Toast.LENGTH_SHORT).show()
//        }
        if (index < 10) {
            when (selected) {
                radioOptionOne.id -> {
                    if (questions[index].answer == 1)
                        score = score + 1
                }
                radioOptionTwo.id -> {
                    if (questions[index].answer == 2)
                        score = score + 1
                }
                radioOptionThree.id -> {
                    if (questions[index].answer == 3)
                        score = score + 1
                }
                radioOptionFour.id -> {
                    if (questions[index].answer == 4)
                        score = score + 1
                }
            }
            index++
            if (index < 10) {
                qNumber.text = (index+1).toString()+"/"+10
                qimg.background = questions[index].img
                radioOptionOne.text = questions[index].optionOne
                radioOptionTwo.text = questions[index].optionTwo
                radioOptionThree.text = questions[index].optionThree
                radioOptionFour.text = questions[index].optionFour
                options.clearCheck()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
//                val msg = "Your score is : " + score
//                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun isValid(): Boolean{
        val selected = options.checkedRadioButtonId
        if (selected == -1) {
            Toast.makeText(this, "Select option", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}