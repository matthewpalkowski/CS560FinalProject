package com.example.finalproject

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
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
class SearchActivity : AppCompatActivity() {

    /*TODO Requirements (8pts total needed)
    *  !DONE! Use of SharedPreferences for data persistence (Save EULA -- save addresses) 1pt
    *  !DONE! Use of an Android service that requires permissions (gps to grab current loc.) 1pt
    *  !DONE! Use of three or more Activities (3 activities see Activities) 1 pt
    *  !DONE! Use of Async tasks (Multi-threading for database operations and API calls) 1 pt
    *  !Done! Use of RecyclerView with custom adapter and layout (addresses) 1pt
    *  !DONE! Use of SQLite database or Room Database or Remote Database Firebase (Saved Addresses) 2 pt
    *  !DONE! Use of a RESTful HTTP API (API calls) 2 pt
    */

    private val GPS = "gps" //Cannot be moved to strings file due to unexplained crashes inside of getGPSLocation()
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

    private lateinit var currentAddress : GeoCodeSearchableAddress
    private lateinit var resultAddress : Address

    private var currentLocation : Location? = null
    private var currentGeocode : GeocodeResult? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        supportActionBar!!.hide()

        gpsButton = findViewById(R.id.btnCurrentAddressSearch)

        val buttonListener = ButtonListener()
        findViewById<Button>(R.id.btnSearchAddress).setOnClickListener(buttonListener)
        findViewById<Button>(R.id.btnViewSavedAddresses).setOnClickListener(NavButtonListener())
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

    private fun generateQueryMap(gpsSearch : Boolean) : Map<String,String>{
        val queryMap = HashMap<String,String>()
        val stringBuilder = StringBuilder()
        if(gpsSearch) {
            stringBuilder.append(currentLocation!!.latitude.toString())
            stringBuilder.append(",")
            stringBuilder.append(currentLocation!!.longitude.toString())
            queryMap[getString(R.string.key_coordinates)] = stringBuilder.toString()
        }
        else{
            stringBuilder.append(currentAddress.streetAddress)
            stringBuilder.append(" ")
            stringBuilder.append(currentAddress.city)
            stringBuilder.append(" ")
            stringBuilder.append(currentAddress.state)
            queryMap[getString(R.string.key_address)] = stringBuilder.toString()
        }
        queryMap[getString(R.string.key_api_key)] = ApiKeys.GOOGLE_API_KEY
        return queryMap
    }

    private fun generateResultIntent() : Intent{
        //TODO put the extras as required
        val intent = Intent(this, SearchResultActivity::class.java)
        intent.putExtra(
                getString(R.string.key_source_activity),
                getString(R.string.search_activity))
        intent.putExtra(GlobalStrings.ADDRESS_KEY, resultAddress)
        return intent
    }

    private fun generateSavedAddressIntent(): Intent{
        return Intent(this,SavedAddressesActivity::class.java)
    }

    private fun generateWarningDialog(title : String, message : String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(getString(R.string.ok)){_: DialogInterface, _: Int ->}
        val dialog = builder.create()
        dialog.show()
    }

    private fun getAdditionalAddressData(){
        /*FIXME - use the following observer structure to control flow of multiple API calls after first call has finished.
                            * val retrofit = Retrofit.Builder()
                                .baseUrl("https://api.example.com/")
                                .build()

                                val backendApi = retrofit.create(MyBackendAPI::class.java)

                                val requests = ArrayList<Observable<*>>()

                                requests.add(backendApi.getUser())
                                requests.add(backendApi.listPhotos())
                                requests.add(backendApi.listFriends())

                                Observable
                                        .zip(requests) {
                                            // do something with those results and emit new event
                                            Any() // <-- Here we emit just new empty Object(), but you can emit anything
                                        }
                                        // Will be triggered if all requests will end successfully (4xx and 5xx also are successful requests too)
                                        .subscribe({
                                            //Do something on successful completion of all requests
                                        }) {
                                            //Do something on error completion of requests
                                        }
                            */

        /*TODO API Calls for the following
        *   -Streetview picture
        *   -AirQualityAPI (https://openaq.org/#/countries/US)
        *   -ElevationAPI
        *   -WaterQualityAPI
        *   -WaterLevelAPI
        *   -EPA flood data
        *   -Other natural disaster style data (fires, drought, hurricanes etc)
        *   -Crime data
        */
    }

    private fun getAddressInfo(gpsSearch: Boolean){
        val retrofit = Retrofit.Builder()
             .baseUrl(getString(R.string.google_geocoding_base_url))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val googleGeolocationAPI = retrofit.create(IGoogleGeolocation::class.java)

        val queryMap : Map<String,String> = generateQueryMap(gpsSearch)
        googleGeolocationAPI.getGeocode(queryMap)
                .enqueue(object : Callback<GoogleGeocodeResults>{
                    override fun onResponse(
                            call: Call<GoogleGeocodeResults>,
                            response: Response<GoogleGeocodeResults>
                    ) {
                        if(response.body()?.results.isNullOrEmpty())
                            generateWarningDialog(
                                    getString(R.string.alert_title_invalid_address),
                                    getString(R.string.alert_message_invalid_address))

                        else {
                            val resultIt : Iterator<GeocodeResult> = response.body()!!.results.iterator()
                            var result : GeocodeResult
                            while(resultIt.hasNext()){
                                result = resultIt.next()
                                if(result.types.contains(getString(R.string.street_address_type))){
                                    currentGeocode = result
                                    break
                                }
                            }

                            parseAddress()
                            getAdditionalAddressData()
                            val resultIntent = generateResultIntent()
                            startActivity(resultIntent)
                        }
                    }

                    override fun onFailure(call: Call<GoogleGeocodeResults>, t: Throwable) {
                        generateWarningDialog(
                                getString(R.string.alert_title_geocoding),
                                getString(R.string.alert_message_geocoding))
                    }
                })
    }

    @SuppressLint("MissingPermission")
    private fun getGPSListenerResults(){
        val locManager = (getSystemService(LOCATION_SERVICE) as LocationManager)
        val locListener = GPSListener()
        locManager.requestLocationUpdates (GPS,UPDATE_TIME,UPDATE_DIST,locListener) //Calls onLocationChanged() in GPS listener
    }

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

    private fun parseAddress(){
        val componentIt = currentGeocode!!.address_components.iterator()
        var types : List<String>
        var currentComponent : GeoCodeAddressComponent
        var city = ""
        var state = ""
        var country = ""
        var zip = ""
        val streetAddressStringBuilder = StringBuilder()
        while(componentIt.hasNext()) {
            currentComponent = componentIt.next()
            types = currentComponent.types
            if (types.contains(getString(R.string.address_component_type_street_number)))
                streetAddressStringBuilder.append(currentComponent.short_name)
            else if (types.contains(getString(R.string.address_component_type_route))) {
                streetAddressStringBuilder.append(" ")
                streetAddressStringBuilder.append(currentComponent.short_name)
            }
            else if (types.contains(getString(R.string.address_component_type_locality)) ||
                    types.contains(getString(R.string.address_component_type_sublocality)))
                city = currentComponent.long_name
            else if (types.contains(getString(R.string.address_component_type_state)))
                state = currentComponent.long_name
            else if (types.contains(getString(R.string.address_component_type_country)))
                country = currentComponent.long_name
            else if (types.contains(getString(R.string.address_component_type_zip)))
                zip = currentComponent.long_name
        }
        resultAddress = Address(streetAddressStringBuilder.toString(), city, state, country,zip)
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
            Toast.makeText(this,getString(R.string.toast_text_gps_found),Toast.LENGTH_SHORT).show()
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
        override fun onClick(v: View?) {
            var gpsSearch = false
            if(v!! == findViewById(R.id.btnSearchAddress)) {
                var valid = true
                if (!validAddress()) valid = false
                if (!validCity()) valid = false
                if (!validState()) valid = false
                if (valid) {
                    currentAddress = GeoCodeSearchableAddress(
                        txtInputStreet.text.toString(),
                        txtInputCity.text.toString(),
                        spinnerState.selectedItem.toString())
                }
            }

            else{
                if(currentLocation == null) {
                    generateWarningDialog(getString(
                        R.string.alert_message_gps),
                        getString(R.string.alert_message_gps))
                    return
                }
                gpsSearch = true
            }
            getAddressInfo(gpsSearch)
        }
    }

    private inner class NavButtonListener: View.OnClickListener {
        override fun onClick(v: View?) {
            startActivity(generateSavedAddressIntent())
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