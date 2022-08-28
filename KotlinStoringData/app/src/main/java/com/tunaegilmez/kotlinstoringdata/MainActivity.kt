package com.tunaegilmez.kotlinstoringdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var ageFromPreferences : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("com.tunaegilmez.kotlinstoringdata",
            Context.MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("Age",-1)

        if (ageFromPreferences == -1){
            textView.text = "Your age"
        }else{
            textView.text = "Your age : " + ageFromPreferences
        }

    }

    fun save (view: View){

        //SharedPreferences

        val myAge = ageText.text.toString().toIntOrNull()
        if (myAge != null){
            textView.text = "Your Age : " + myAge
            sharedPreferences.edit().putInt("Age",myAge).apply()
        }
    }

    fun delete(view: View){

        ageFromPreferences = sharedPreferences.getInt("Age",0)
        if (ageFromPreferences != -1){
            sharedPreferences.edit().remove("Age").apply()
            textView.text = "Your age"
        }else{

        }

    }
}