package com.example.finalproject

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


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
     */

    /*TODO - Major Components
     *  -Set up Database on SQLlite or Firebase
     *      -Uses
     *          -Saving of favorites to account for persistence across phones
     *          -Storage of static data sets that can't be accessed via API
     *              -Which data sets?
     *  -Write API connections
     *  Implement Landscape modes and use fragments and ViewModel to support it
     */

    private lateinit var spinnerState : Spinner

    private lateinit var txtLayoutCity : TextInputLayout
    private lateinit var txtLayoutStreetAddress : TextInputLayout
    private lateinit var txtLayoutZip : TextInputLayout

    private lateinit var txtInputCity : TextInputEditText
    private lateinit var txtInputStreet : TextInputEditText
    private lateinit var txtInputZip : TextInputEditText

    private lateinit var touchListener : TouchListener
    private lateinit var focusListener: OnFocusListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_search_activity)
        supportActionBar!!.hide()

        findViewById<Button>(R.id.btnSearchAddress).setOnClickListener(ButtonListener())

        touchListener = TouchListener()
        focusListener = OnFocusListener()

        txtInputCity = findViewById(R.id.inputEditTxtCity)
        txtInputStreet = findViewById(R.id.inputEditTxtStreetAddress)
        txtInputZip = findViewById(R.id.inputEditTxtZip)

        spinnerState = findViewById(R.id.spnrStateSpinner)
        spinnerState.setOnTouchListener(touchListener)

        txtLayoutCity = findViewById(R.id.txtInputCity)
        txtLayoutCity.onFocusChangeListener = focusListener

        txtLayoutStreetAddress = findViewById(R.id.txtInputStreetAddress)
        txtLayoutStreetAddress.onFocusChangeListener = focusListener

        txtLayoutZip = findViewById(R.id.txtInputZipCode)
        txtLayoutZip.onFocusChangeListener = (focusListener)
    }

    private fun validAddress() : Boolean {
        return if(txtInputStreet.length() == 0) {
            txtLayoutStreetAddress.error = getString(R.string.missing_street)
            false
        } else true
    }

    private fun validCity() : Boolean {
        return if(txtInputCity.length() == 0) {
            txtLayoutCity.error = getString(R.string.missing_city)
            false
        } else true
    }

    private fun validState(): Boolean {
        return if (spinnerState.selectedItem.toString() == resources.getStringArray(R.array.states_array)[0]) {
            (spinnerState.getSelectedView() as TextView).error = getString(R.string.missing_state)
            false
        } else true
    }

    private fun validZip() : Boolean{
        return if(txtInputZip.length() == 0) {
            txtLayoutZip.error = getString(R.string.missing_zip)
            false
        } else true
    }

    private fun View.hideKeyboard(){
        val inputMethodManager = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }

    inner class TouchListener : View.OnTouchListener {
        override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            v!!.hideKeyboard()
            return false
        }
    }

    inner class ButtonListener : View.OnClickListener {
        override fun onClick(v: View?) {
            var valid : Boolean = true
            if(!validAddress()) valid = false
            if(!validCity()) valid = false
            if(!validZip()) valid = false
            if(!validState()) valid = false
            if(valid){
                //TODO Add all the API functionality
            }
        }
    }

    inner class OnFocusListener : View.OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
            TODO("Not yet implemented")
        }
    }
}