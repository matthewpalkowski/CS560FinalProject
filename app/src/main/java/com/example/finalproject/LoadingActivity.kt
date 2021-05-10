package com.example.finalproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.finalproject.databaseobjects.RoomDatabaseAddresses

class LoadingActivity : AppCompatActivity() {

    /*TODO
    *   -Check network connection
    *       -if offline alert dialog
    *           -use broadcast receiver listening for network status change
    *               -Change to connected creates toast message "Connection Established" and proceed
    *           -Ok exits app
    *   -Add initialization of room connection here
    * */

    private val EULA_REQUEST_CODE = 577

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        supportActionBar!!.hide()

        val eulaAccepted : Boolean = getSharedPreferences(
                getString(R.string.preferences_file),
                Activity.MODE_PRIVATE).getBoolean(getString(R.string.eula_acceptance),false)

        if(!eulaAccepted){
            val eulaIntent = Intent(this,EndUserLicenseActivity::class.java)
            startActivityForResult(eulaIntent,EULA_REQUEST_CODE)
        }
        else start()
    }

    private fun start(){
        Handler(Looper.getMainLooper()).postDelayed({
            val myIntent = Intent(this, SearchActivity::class.java)
            startActivity(myIntent)
            finish()
        }, 2000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_CANCELED) finishAffinity()
        if(resultCode == Activity.RESULT_OK) start()
    }
}