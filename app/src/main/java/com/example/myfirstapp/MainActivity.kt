package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    val cardDeck: MutableList<Int> = mutableListOf()
    var clickNum =0

    val a = IntegrateCardDeck(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        for (i in 0..52){
            cardDeck.add(i)
        }
        cardDeck.shuffle()

    }

    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun IntegrateCardDeck(card:Int):String{
        if(card==0) return "Joker"
        val cardNum = (card%13)+1
        val suitsNum = card%4
        var cardSuits:String =""
        when(suitsNum){
            0 -> {cardSuits = "スペード"}
            1 -> {cardSuits = "ダイヤ"}
            2 -> {cardSuits = "クローバー"}
            3 -> {cardSuits = "ハート"}
        }

        var returnString :String = cardSuits +cardNum.toString()
        return returnString
    }


    fun doRPS(view: View){
        var RPSText = findViewById<TextView>(R.id.RPSText)
        var RPSText2 = findViewById<TextView>(R.id.RPSText2)
        var RPSText3 = findViewById<TextView>(R.id.RPSText3)

        if(clickNum>cardDeck.size-1||clickNum+1>cardDeck.size-1||clickNum+2>cardDeck.size-1){//いずれは空白にしないとだめ
            clickNum = 0
        }
        RPSText.text=(IntegrateCardDeck(cardDeck[clickNum]))
        RPSText2.text=(IntegrateCardDeck(cardDeck[clickNum+1]))
        RPSText3.text=(IntegrateCardDeck(cardDeck[clickNum+2]))
        clickNum+=3

    }

}