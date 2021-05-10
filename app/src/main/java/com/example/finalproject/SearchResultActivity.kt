package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.finalproject.databaseobjects.AddressEntity
import com.example.finalproject.databaseobjects.RoomDatabaseAddresses
import java.lang.StringBuilder

class SearchResultActivity : AppCompatActivity() {

    private lateinit var txtCity : TextView
    private lateinit var txtCountry : TextView
    private lateinit var txtState: TextView
    private lateinit var txtStreetAddress : TextView
    private lateinit var txtZip : TextView

    private lateinit var addressThumbnail : ImageView
    private lateinit var listener: ButtonListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)
        supportActionBar!!.hide()

        txtStreetAddress = findViewById(R.id.txtStreetAddress_SearchResult)
        txtCity = findViewById(R.id.txtCity_SearchResult)
        txtState = findViewById(R.id.txtState_SearchResult)
        txtCountry = findViewById(R.id.txtCountry_SearchResult)
        txtZip = findViewById(R.id.txtZip_SearchResult)
        addressThumbnail = findViewById(R.id.imgResultThumbNail)
        populateResultData()

        listener = ButtonListener()
        findViewById<Button>(R.id.btnSaveResult).setOnClickListener(listener)
        findViewById<Button>(R.id.btnViewSaved).setOnClickListener(listener)
    }

    private fun populateResultData(){
        val intentExtras = intent.extras
        val address = (intentExtras?.get(getString(R.string.address)) as Address)
        txtStreetAddress.text = address.streetAddress
        txtCity.text = address.city
        txtState.text = address.state
        txtCountry.text = address.country
        txtZip.text = address.zipCode
        addressThumbnail.setImageResource(R.drawable.no_image_available)
    }

    private fun generateId(address : Address): String{
        val stringBuilder = StringBuilder()
        stringBuilder.append(address.streetAddress ?: "")
        stringBuilder.append(address.city ?: "")
        stringBuilder.append(address.state ?: "")
        stringBuilder.append(address.country ?: "")
        stringBuilder.append(address.zipCode ?:"")
        return stringBuilder.toString()
    }

    private fun saveResult(){
        Thread {
//            this.applicationContext.deleteDatabase("address_database")
            val db = RoomDatabaseAddresses.getAddressDatabase(application)

            val address = (intent.extras!!.get(getString(R.string.address)) as Address)

            val id = generateId(address)
            val streetAddress : String = address.streetAddress ?: ""
            val city : String = address.city ?: ""
            val state : String = address.state ?: ""
            val country : String = address.country ?: ""
            val zip : String = address.zipCode ?:""
            //FIXME - have to add URL somehow

            val newAddressEntity = AddressEntity(
                id,
                streetAddress,
                city,
                state,
                country,
                zip,
                "")
            db.contactDAO().insertAddress(newAddressEntity)
            runOnUiThread {
                Toast.makeText(this, getString(R.string.address_saved), Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    private fun getSavedAddressesIntent():Intent{
        return Intent(this,SavedAddressesActivity::class.java)
    }

    private inner class ButtonListener : View.OnClickListener{
        override fun onClick(v: View?) {
            if(v!! == findViewById(R.id.btnSaveResult))
                saveResult()
            else
                startActivity(getSavedAddressesIntent())
        }
    }
}