package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

/**
 * @author Matthew Palkowski
 */
class ManualSearchActivity : AppCompatActivity() {

    /*TODO Project Goals
     * -Connect to the following APIs
     *      -EPA flood data
     *      -Other natural disaster style data
     *      -Crime data
     *      -Address validation
     * -Ability to save addresses to favorites
     */

    /*TODO Requirements (8pts total needed)
    *  !DONE! Use of SharedPreferences for data persistence (Save EULA -- save addresses) 1pt
    *  Use of an Android service that requires permissions (gps to grab current loc.) 1pt
    *  !DONE! Use of three or more Activities (3 activities see Activities) 1 pt
    *  Use of Async tasks (TBD) 1 pt
    *  !Done! Use of RecyclerView with custom adapter and layout (addresses) 1pt
    *  Use ViewModel (use fragments and view model within results) 1pt
    *  Use of SQLite database or Room Database or Remote Database Firebase (Maybe download FEMA data) 2 pt
    *  Use of a RESTful HTTP API (API calls) 2 pt
    *  Use Broadcast Receiver services 2 pt (Subscribe to changes in WIFI state - needs to be assigned dynamically - only check status when app is running)
    */

    /* FIXME APIs to Connect to
    *   (Air Quality) https://openaq.org/#/countries/US
    *   ----------
    */

    /*FIXME - MISC
     *  Need to fix padding on the TextInputs
     * */

    private lateinit var spinnerState : Spinner
    private lateinit var txtCity : EditText
    private lateinit var txtStreetAddress : EditText
    private lateinit var txtZip : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_search_activity)
        supportActionBar!!.hide()

        spinnerState = findViewById(R.id.spnrStateSpinner)
        spinnerState.setOnTouchListener(SpinnerListener())

        findViewById<Button>(R.id.btnSearchAddress).setOnClickListener(ButtonListener())

        txtCity = findViewById(R.id.txtInputCity)
        txtStreetAddress = findViewById(R.id.txtInputStreetAddress)
        txtZip = findViewById(R.id.txtInputZipCode)
    }

    private fun validInput() : Boolean {
        //TODO implement
        return true
    }

    private fun View.hideKeyboard(){
        val inputMethodManager = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }

    inner class SpinnerListener : View.OnTouchListener {
        override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            v!!.hideKeyboard()
            return false
        }
    }

    inner class ButtonListener : View.OnClickListener {
        override fun onClick(v: View?) {
            if(validInput()){}
            //TODO Add all the API functionality

            //TODO Check that all required fields are filled out
        }
    }
}