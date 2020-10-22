package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result on the screen.
 */
class MainActivity : AppCompatActivity() {
    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)
        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener {
            diceRoll()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun diceRoll() {
        // Create new Dice object with 6 sides and roll it
        val rollDice1 = Dice(6)
        val digit1 = rollDice1.roll()

        val rollDice2 = Dice(6)
        val digit2 = rollDice2.roll()

        // Update the screen with the dice roll
        val digitRolled: TextView = findViewById(R.id.digitText)
        val digitText = "$digit1\t\t\t$digit2"
        digitRolled.text =  digitText
    }
}

/**
 * Dice with a fixed number of sides.
 */
class Dice(val numSide: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numSide).random()
    }
}