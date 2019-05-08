package com.example.quizesample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score.*
import java.time.Instant

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        val bundle : Bundle = intent.extras

        val marks: Int = bundle!!.getInt("score")

        txtscore.text = marks.toString()+"/"+10
    }
}