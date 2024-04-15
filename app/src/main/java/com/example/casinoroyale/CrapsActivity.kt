/**----------------------------------------------------------------------
||
||  Class CrapsActivity
||
||         Author:  Sneha A
||
||        Purpose:  This class is a representation of the Crapsctivity
||                  which is the activity which plays the game of craps.
||                  Depends on Class Dice
||
||  Inherits From:  None
||
||     Interfaces:  None
|+-----------------------------------------------------------------------
||
||      Constants:  None
||
|+-----------------------------------------------------------------------
||
||   Constructors:  None
||
||  Class Methods:  None
||
||  Inst. Methods:      override fun onCreate(savedInstanceState: Bundle?)
||                      (Other methods are private)
||
++-----------------------------------------------------------------------*/
package com.example.casinoroyale

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.example.casinoroyale.R

class CrapsActivity : AppCompatActivity() {

    private var point = 0
    private var firstRoll = true

    /**---------------------------------------------------------------------
    |  Function onCreate
    |
    |  Purpose: This function is what is run when this activity is started.
    |           It is analogous to the main function in a simple Kotlin
    |           Program.
    |           It sets the onClickListener for the roll dice button.
    |
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Parameters:
    |      savesInstanceState -- the previous state of the activity
    |
    |  Returns:  Unit
     *-------------------------------------------------------------------*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_craps)
        roll2Dice(false)
        val rollButton: Button = findViewById(R.id.rollDiceButton)
        displayPoint("Not Set")

        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            playCraps()
        }
    }

    /**
     * Starts the game of craps it keeps track of the basic logic.
     * It hands over all the UI to other functions.
     */
    private fun playCraps() {
        val roll = roll2Dice(true)
        if (firstRoll) {
            firstRoll = false
            if (roll == 7) {
                winMsg()
            } else if (roll == 2 || roll == 3 || roll == 12) {
                loseMsg()
            } else {
                setAndDisplayPoint(roll)
                rollAgainMsg()
            }
        } else {
            when (roll) {
                7 -> {
                    loseMsg()
                }
                this.point -> {
                    winMsg()
                }
                else -> rollAgainMsg()
            }
        }
    }

    /**
     * It gives us a snackbar asking the player to roll again
     * Snackbar goes away after a while
     */
    private fun rollAgainMsg() {
        val contextView = findViewById<View>(R.id.rollDiceButton)

        Snackbar.make(contextView, R.string.roll_again, Snackbar.LENGTH_LONG)
            .show()
    }

    /**
     * It gives us the snackbar which gives us the lose message
     * and the option to play again
     * It disables the roll dice button.
     */
    private fun loseMsg() {
        // The view used to make the snackbar.
        // This should be contained within the view hierarchy you want to display the
        // snackbar. Generally it can be the view that was interacted with to trigger
        // the snackbar, such as a button that was clicked, or a card that was swiped.
        val contextView = findViewById<View>(R.id.rollDiceButton)
        contextView.isEnabled = false
        Snackbar.make(contextView, R.string.lose_string, Snackbar.LENGTH_INDEFINITE)
            .setAction(R.string.play_again) {
                resetGame()
            }
            .show()
    }

    /**
     * It gives us the snackbar which gives us the win message
     * and the option to play again
     * It disables the roll dice button.
     */
    private fun winMsg() {
        val contextView = findViewById<View>(R.id.rollDiceButton)
        contextView.isEnabled = false
        Snackbar.make(contextView, R.string.win_string, Snackbar.LENGTH_INDEFINITE)
            .setAction(R.string.play_again) {
                resetGame()
            }
            .show()
    }

    /**
     * It resets the whole game and re-enables the roll dice button.
     */
    private fun resetGame() {
        displayPoint("Not Set")
        this.point = 0
        this.firstRoll = true
        val contextView = findViewById<View>(R.id.rollDiceButton)
        contextView.isEnabled = true
    }

    /**
     * This function rolls the two dice on the screen and
     * handles the UI aspect as well.
     */
    private fun roll2Dice(setSum: Boolean): Int {
        val dice = Dice(6)
        var diceRoll = dice.roll()

        val dice1Image: ImageView = findViewById(R.id.dice1Image)
        var drawableResource = getDiceImage(diceRoll)
        dice1Image.setImageResource(drawableResource)
        var sum = diceRoll

        diceRoll = dice.roll()
        val dice2Image: ImageView = findViewById(R.id.dice2Image)
        drawableResource = getDiceImage(diceRoll)
        dice2Image.setImageResource(drawableResource)

        if (setSum) {
            sum += diceRoll
            val resultTextView: TextView = findViewById(R.id.diceSumTextView)
            resultTextView.text = sum.toString()
        }

        return sum
    }

    /**
     * Simple when statement to get the approriate dice image
     * to diplay based on the roll
     */
    private fun getDiceImage(diceRoll: Int): Int {
        return when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    /**
     * Simple sets and displays the point we pass as the argument
     */
    private fun setAndDisplayPoint(point: Int) {
        this.point = point
        displayPoint("$point")
    }

    /**
     * Displays the point on the screen
     */
    private fun displayPoint(point: String) {
        val pointText: TextView = findViewById(R.id.pointText)
        pointText.text = getString(R.string.the_point_is_s, point)
    }
}
/**----------------------------------------------------------------------
||
||  Class Dice
||
||         Author:  Sneha A
||
||        Purpose:  This class is a representation of Dice which can be
||                  rolled.
||
||  Inherits From:  None
||
||     Interfaces:  None
|+-----------------------------------------------------------------------
||
||      Constants:  None
||
|+-----------------------------------------------------------------------
||
||   Constructors:  Dice(private val numSides: Int)
||
||  Class Methods:  None
||
||  Inst. Methods:      fun roll():Int
||
++-----------------------------------------------------------------------*/
class Dice(private val numSides: Int) {
    /**---------------------------------------------------------------------
    |  Function roll
    |
    |  Purpose: This function simple gives us a random roll of the dice.
    |
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Parameters:None
    |
    |  Returns:  Rolll of the Dice
     *-------------------------------------------------------------------*/
    fun roll(): Int {
        return (1..numSides).random()
    }
}

