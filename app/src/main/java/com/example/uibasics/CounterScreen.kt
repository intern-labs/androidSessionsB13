package com.example.uibasics

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CounterScreen : AppCompatActivity() {

    private var counter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.counter_screen)

        // Finding views
        val incrementButton: Button = findViewById(R.id.increment_button)
        val decrementButton: Button = findViewById(R.id.decrement_button)
        val counterMessage: TextView = findViewById(R.id.counter_message)
        // Find generic message
        val counterString: String = resources.getString(R.string.counter_count_message)
        // Set click listener on buttons
        incrementButton.setOnClickListener {
            counter++
            counterMessage.text = counterString.plus(counter.toString())
        }
        decrementButton.setOnClickListener {
            counter--
            counterMessage.text = counterString.plus(counter.toString())
        }

        // Open new screen
        val nextScreen: Button = findViewById(R.id.next_screen)
        nextScreen.setOnClickListener {
            val intent: Intent = Intent(this, ListScreen::class.java)
            intent.putExtra("COUNTER_MESSAGE", counterMessage.text)
            startActivity(intent)
        }
    }
}

