/**=============================================================================
|   Assignment:  Project Part 3
|       Author:  Shreyas Khandekar (example@email.arizona.edu)
|
|       Course:  Cs372 (Computing Paradigms), Fall 2020
|   Instructor:  Lester I. McCann
|     Due Date:  December 7th 2020, at the beginning of class
|
|     Language:  Kotlin (Android Studio)
|     Packages:  Android JetPack, Material Design, Gradle
|  Compile/Run:  Use android studio to run the gradle script to build and run the project
|                right from android studio. Alternatively, you could use the gradle build
|                from the command line but it is not recommended. You need an android device
|                or simulator to run this app.
|         Note:  I have also submitted a compiled .apk file called CasinoRoyale.apk so you too can
|                run my app and you don't need kotlin or any of the other dependencies for it.
|
| Website location: To find the required document please visit:
|                  http://u.arizona.edu/~example/Kotlin/
|
+-----------------------------------------------------------------------------
|
|  Description:  This app is a simple virtual casino for all the people who have not been
|                  able to get their gambling fix during this pandemic. It has three simple games
|                  1) Craps, 2) Casino War, and 3) Baccarat
|                   You can use an android device to run the app and play these games.
|
|
|   Features Not Included: Currently only Craps is working. you cannot play the other two games
|
|   Known Bugs:  None
|
 *===========================================================================*/


package com.example.casinoroyale
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**----------------------------------------------------------------------
||
||  Class MainActivity
||
||         Author:  Sneha A
||
||        Purpose:  This class is a representation of the MainActivity
||                  which is the welcome screen.
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
||                      private fun transitionToHome()
||
++-----------------------------------------------------------------------*/

class MainActivity : AppCompatActivity() {

    /**---------------------------------------------------------------------
    |  Function onCreate
    |
    |  Purpose: This function is what is run when this activity is started.
    |           It is analogous to the main function in a simple Kotlin
    |           Program.
    |           It sets the onClickListener for the enter button.
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
        setContentView(R.layout.activity_welcome)
//        Timer().schedule(10000){
//            transitionToHome()
//        }
        val enterButton: Button = findViewById(R.id.enterButton)
        enterButton.setOnClickListener {
            transitionToHome()
        }

    }
    /**---------------------------------------------------------------------
    |  Function transitionToHome
    |
    |  Purpose: This function is what is run when the user clicks the enter
    |           button. It is the gatekeeper for the casino "lounge".
    |           This casino has no money involved so it's okay if you're not 21
    |           (or 18 or whatever the law is the state or country you are in).
    |
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Parameters: None
    |
    |  Returns:  Unit
     *-------------------------------------------------------------------*/
    private fun transitionToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}