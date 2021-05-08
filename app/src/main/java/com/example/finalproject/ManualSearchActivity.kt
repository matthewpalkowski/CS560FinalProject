package com.example.finalproject

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

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
    *  !DONE! Use of an Android service that requires permissions (gps to grab current loc.) 1pt
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
     *  -Need to fix padding on the TextInputs
     *  -Delete ZIP since its not needed for the API calls
     *  -State needs to be 2 letter abbreviation
     *  -Fix consequences of the fact that zip code was removed from the inputs and the Address data class
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

    private val GPS : String = "gps"
    private val TOAST_TEXT : String = "GPS location found"
    private val UPDATE_TIME : Long = 0
    private val UPDATE_DIST : Float = 0F
    private val REQUEST_CODE : Int = 10

    private lateinit var gpsButton : Button

    private lateinit var spinnerState : Spinner

    private lateinit var txtLayoutCity : TextInputLayout
    private lateinit var txtLayoutStreetAddress : TextInputLayout

    private lateinit var txtInputCity : TextInputEditText
    private lateinit var txtInputStreet : TextInputEditText

    private lateinit var touchListener : TouchListener
    private lateinit var focusListener: OnFocusListener

    private lateinit var currentAddress : Address

    private var currentLocation : Location? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_search_activity)
        supportActionBar!!.hide()

        gpsButton = findViewById<Button>(R.id.btnCurrentAddressSearch)

        val buttonListener = ButtonListener()
        findViewById<Button>(R.id.btnSearchAddress).setOnClickListener(buttonListener)
        gpsButton.setOnClickListener(buttonListener)
        gpsButton.isEnabled = false

        touchListener = TouchListener()
        focusListener = OnFocusListener()

        txtInputCity = findViewById(R.id.inputEditTxtCity)
        txtInputCity.onFocusChangeListener = focusListener

        txtInputStreet = findViewById(R.id.inputEditTxtStreetAddress)
        txtInputStreet.onFocusChangeListener = focusListener

        spinnerState = findViewById(R.id.spnrStateSpinner)
        spinnerState.setOnTouchListener(touchListener)

        txtLayoutCity = findViewById(R.id.txtInputCity)
        txtLayoutStreetAddress = findViewById(R.id.txtInputStreetAddress)

        getGPSLocation()
    }

    private fun generateQueryString(reverseGeo: Boolean) : String {
        val stringBuilder = StringBuilder()
        if(reverseGeo) {
            stringBuilder.append(currentLocation!!.latitude.toString())
            stringBuilder.append(",")
            stringBuilder.append(currentLocation!!.longitude.toString())
        }
        else{
            stringBuilder.append(currentAddress.streetAddress)
            stringBuilder.append(" ")
            stringBuilder.append(currentAddress.city)
            stringBuilder.append(" ")
            stringBuilder.append(currentAddress.state)
        }
        return stringBuilder.toString()
    }

    private fun generateWarningDialog(title : String, message : String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(getString(R.string.ok)){_: DialogInterface, _: Int ->}
        val dialog = builder.create()
        dialog.show()
    }

    //FIXME - extract out some of the internal functionality into private functions
    //FIXME - failing to build the query
    private fun getGeocode(reverseGeo : Boolean = false){
        val retrofit = Retrofit.Builder()
             .baseUrl(getString(R.string.google_geocoding_base_url))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val googleGeolocationAPI = retrofit.create(IGoogleGeolocation::class.java)
        val queryString = generateQueryString(reverseGeo)
        if(reverseGeo){
            googleGeolocationAPI.getReverseGeolocation(queryString,ApiKeys.GOOGLE_API_KEY)
                .enqueue(object : Callback<GoogleGeocodeResults> {
                    override fun onResponse(
                        call: Call<GoogleGeocodeResults>,
                        response: Response<GoogleGeocodeResults>
                    ) {
                        when(response.body()!!.status){
                            getString(R.string.ok) -> {TODO("Not yet implemented")}
                            getString(R.string.zero_results) -> generateWarningDialog(
                                getString(R.string.alert_title_invalid_address),
                                getString(R.string.alert_message_invalid_address))
                            else -> generateWarningDialog(
                                getString(R.string.alert_title_geocoding),
                                getString(R.string.alert_message_geocoding))
                        }
                    }

                    override fun onFailure(call: Call<GoogleGeocodeResults>, t: Throwable) {
                        generateWarningDialog(
                            getString(R.string.alert_title_geocoding),
                            getString(R.string.alert_message_geocoding))
                    }
                })
        }
        else{
            googleGeolocationAPI.getGeolocaiton(queryString,ApiKeys.GOOGLE_API_KEY)
                .enqueue(object : Callback<GoogleGeocodeResults>{
                    override fun onResponse(
                        call: Call<GoogleGeocodeResults>,
                        response: Response<GoogleGeocodeResults>
                    ) {
                        TODO("Not yet implemented")
                    }

                    override fun onFailure(call: Call<GoogleGeocodeResults>, t: Throwable) {
                        generateWarningDialog(
                            getString(R.string.alert_title_geocoding),
                            getString(R.string.alert_message_geocoding))
                    }
                })
        }
    }

    @SuppressLint("MissingPermission")
    private fun getGPSListenerResults(){
        val locManager = (getSystemService(LOCATION_SERVICE) as LocationManager)
        val locListener = GPSListener()
        locManager.requestLocationUpdates (GPS,UPDATE_TIME,UPDATE_DIST,locListener) //Calls onLocationChanged() in GPS listener
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getGPSLocation(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                        this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            getGPSListenerResults()
        else{
            val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
            requestPermissions(permissions, REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CODE -> {
                var allAccepted = true
                for(i in grantResults){
                    if(i == PackageManager.PERMISSION_DENIED) allAccepted = false
                }
                if(allAccepted) getGPSListenerResults()
                else generateWarningDialog(
                    getString(R.string.alert_title_gps),
                    getString(R.string.alert_message_gps))
                return
            }
            else -> {}
        }
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
            (spinnerState.selectedView as TextView).error = getString(R.string.missing_state)
            false
        } else true
    }

    private fun updateLocation(location: Location){
        val previousLocation : Location? = currentLocation
        currentLocation = location
        if(previousLocation == null && currentLocation != null){
            Toast.makeText(this,TOAST_TEXT,Toast.LENGTH_SHORT).show()
            gpsButton.isEnabled = true
        }
    }

    private fun View.hideKeyboard(){
        val inputMethodManager = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }

    inner class TouchListener : View.OnTouchListener {
        override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            v!!.hideKeyboard()
            (spinnerState.selectedView as TextView).error = null
            return false
        }
    }

    private inner class ButtonListener : View.OnClickListener {
        @RequiresApi(Build.VERSION_CODES.M)
        override fun onClick(v: View?) {
            if(v!! == findViewById(R.id.btnSearchAddress)) {
                var valid = true
                if (!validAddress()) valid = false
                if (!validCity()) valid = false
                if (!validState()) valid = false
                if (valid) {
                    currentAddress = Address(
                        txtInputStreet.text.toString(),
                        txtInputCity.text.toString(),
                        spinnerState.selectedItem.toString())
                    getGeocode()
                    //TODO Add call to all the API functionality
                }
            }

            else{
                if(currentLocation == null) generateWarningDialog(getString(
                        R.string.alert_message_gps),
                        getString(R.string.alert_message_gps))
                else getGeocode(true)
            }
        }
    }

    private inner class OnFocusListener : View.OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
            if(hasFocus) {
                if(v == txtInputCity) txtLayoutCity.error = null
                if(v == txtInputStreet) txtLayoutStreetAddress.error = null
            }
        }
    }

    private inner class GPSListener : LocationListener {
        override fun onLocationChanged(location: Location) {
            updateLocation(location)
        }
    }
}