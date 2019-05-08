package com.example.quizesample

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.quizesample.model.QuizeQuestions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValues(count)
        questionNumber.text = (count+1).toString()+"/"+10

        btnNext.setOnClickListener {
            if (count < 9) {
                count = count + 1
                setValues(count)
               // questionNumber.text = (count+1).toString()+"/"+10
            }else{
                //btnNext.isClickable = false
                btnNext.text = "Finish"
                val intent = Intent(this, QuizActivity::class.java)
                startActivity(intent)
            }
        }
    }
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        fun setValues(cnt:Int) {
            txtquestion.text = "Identify the bird."
            questionNumber.text = (cnt+1).toString()+"/"+10
            val questions: ArrayList<QuizeQuestions> = arrayListOf(
                QuizeQuestions(ContextCompat.getDrawable(this, R.drawable.sparrow),"Sparrow","crow","Maina","Pigeon", 100),
                QuizeQuestions(ContextCompat.getDrawable(this, R.drawable.goose),"Peacock","dove","Goose","Turkey", 300),
                QuizeQuestions(ContextCompat.getDrawable(this, R.drawable.crow),"crow", "goose","Maina", "Pigeon", 100),
                QuizeQuestions(ContextCompat.getDrawable(this, R.drawable.chicken),"Dove","Turkey","Chicken","Peacock", 300),
                QuizeQuestions(ContextCompat.getDrawable(this, R.drawable.parrot),"Chicken","Parrot","Sparrow","Crow", 200),
                QuizeQuestions(ContextCompat.getDrawable(this, R.drawable.peacock), "Crow","Peackock","Turkey","Dove", 200),
                QuizeQuestions(ContextCompat.getDrawable(this, R.drawable.dove), "Turkey","Dove","Crow","Goose", 200),
                QuizeQuestions(ContextCompat.getDrawable(this, R.drawable.turkey), "Sparrow","Parrot","Turkey","Dove", 300),
                QuizeQuestions(ContextCompat.getDrawable(this, R.drawable.sparrow),"Sparrow","crow","Maina","Pigeon", 100),
                QuizeQuestions(ContextCompat.getDrawable(this, R.drawable.goose),"Peacock","dove","Goose","Turkey", 300)
            )
                birdImg.background = questions[cnt].img
                optionOne.text = questions[cnt].optionOne
                optionTwo.text = questions[cnt].optionTwo
                optionThree.text = questions[cnt].optionThree
                optionFour.text = questions[cnt].optionFour
        }
}
