package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class SearchResult : AppCompatActivity() {

    private lateinit var txtCity : TextView
    private lateinit var txtCountry : TextView
    private lateinit var txtState: TextView
    private lateinit var txtStreetAddress : TextView
    private lateinit var txtZip : TextView

    private lateinit var addressThumbnail : ImageView

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
    }

    private fun populateResultData(){
        val intentExtras = intent.extras
        val address = (intentExtras!!.get(getString(R.string.key_address)) as Address)
        txtStreetAddress.text = address.streetAddress
        txtCity.text = address.city
        txtState.text = address.state
        txtCountry.text = address.country
        txtZip.text = address.zipCode
        addressThumbnail.setImageResource(R.drawable.no_image_available)
    }

    private fun saveResult(){
        //TODO implement
    }

    private inner class ButtonListener : View.OnClickListener{
        override fun onClick(v: View?) {
            saveResult()
        }
    }
}