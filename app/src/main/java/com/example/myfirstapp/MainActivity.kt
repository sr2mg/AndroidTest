package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun doRPS(view: View){
        var RPSText = findViewById<TextView>(R.id.RPSText)
        val RPSHand =(0..2).random()
        val ButtonTag =view.getTag()
        if(ButtonTag=="gu"){
            RPSText.setText("ぐー")
        }else if(ButtonTag=="choki"){
            RPSText.setText("ちょき")
        }else{
            RPSText.setText("ぱー")
        }
    }

}