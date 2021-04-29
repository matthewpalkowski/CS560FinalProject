package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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

    /*TODO Activities
    *  -Loading Screen
    *  -End-user Licence Agreement
    *  -EnterAddress/Entry Form
    *  -Results
    */

    /*TODO Requirements (8pts total needed)
    *  Use of SharedPreferences for data persistence (save addresses) 1pt
    *  Use of an Android service that requires permissions (gps to grab current loc.) 1pt
    *  Use of three or more Activities (3 activities see Activities) 1 pt
    *  Use of Async tasks (API Calls done async) 1 pt
    *  Use of RecyclerView with custom adapter and layout (addresses) 1pt
    *  Use ViewModel (use fragments and view model within results) 1pt
    *  Use of SQLite database or Room Database or Remote Database Firebase (Maybe download FEMA data) 2 pt
    *  Use of a RESTful HTTP API (API calls) 2 pt
    *  Use Broadcast Receiver services 2 pt (Subscribe to changes in WIFI state - needs to be assigned dynamically - only check status when app is running)
    */

    /* FIXME APIs to Connect to
    *   (Air Quality) https://openaq.org/#/countries/US
    *
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_search_activity)
        supportActionBar!!.hide()
    }
}