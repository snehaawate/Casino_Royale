/**----------------------------------------------------------------------
||
||  Class HomeActivity
||
||         Author:  Shreyas Khandekar
||
||        Purpose:  This class is a representation of the HomeActivity
||                  which is the casino lounge.
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
||                      private fun playCraps()
||                      private fun playWar()
||                      private fun playBaccarat()
||
++-----------------------------------------------------------------------*/



package com.example.casinoroyale

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    /**---------------------------------------------------------------------
    |  Function onCreate
    |
    |  Purpose: This function is what is run when this activity is started.
    |           It is analogous to the main function in a simple Kotlin
    |           Program.
    |           It sets the onClickListener for the game buttons.
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
        setContentView(R.layout.activity_home)

        val crapsButton: Button = findViewById(R.id.crapsButton)
        crapsButton.setOnClickListener {
            playCraps()
        }

        val warButton: Button = findViewById(R.id.warButton)
        warButton.setOnClickListener {
            playCasinoWar()
        }

        val baccaratButton: Button = findViewById(R.id.baccaratButton)
        baccaratButton.setOnClickListener {
            playBaccarat()
        }
    }
    /**---------------------------------------------------------------------
    |  Function playCraps
    |
    |  Purpose: This function is what is run when the user clicks the craps
    |           button. It is the gatekeeper for the Craps Game.
    |
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Parameters: None
    |
    |  Returns:  Unit
     *-------------------------------------------------------------------*/
    private fun playCraps() {
        val intent = Intent(this, CrapsActivity::class.java)
        startActivity(intent)
    }

    /**---------------------------------------------------------------------
    |  Function playCraps
    |
    |  Purpose: This function is what is run when the user clicks the craps
    |           button. It is the gatekeeper for the Craps Game.
    |
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Parameters: None
    |
    |  Returns:  Unit
     *-------------------------------------------------------------------*/
    private fun playCasinoWar() {
        TODO("Not yet implemented")
    }


    /**---------------------------------------------------------------------
    |  Function playCraps
    |
    |  Purpose: This function is what is run when the user clicks the craps
    |           button. It is the gatekeeper for the Craps Game.
    |
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Parameters: None
    |
    |  Returns:  Unit
     *-------------------------------------------------------------------*/
    private fun playBaccarat() {
        TODO("Not yet implemented")
    }

}