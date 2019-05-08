package com.example.quizesample.model

import android.graphics.drawable.Drawable
import android.media.Image

data class QuizeQuestions(
     val img : Drawable?,
     val optionOne : String,
     val optionTwo : String,
     val optionThree : String,
     val optionFour : String,
     val answer : Int
)