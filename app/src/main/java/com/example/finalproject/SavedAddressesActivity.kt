package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databaseobjects.AddressEntity
import com.example.finalproject.databaseobjects.RoomDatabaseAddresses.Companion.getAddressDatabase

class SavedAddressesActivity : AppCompatActivity() {

    private lateinit var adapter: SavedAddressAdapter
    private lateinit var recycler : RecyclerView
    private lateinit var txtNoAddresses : TextView

    private val savedAddresses = ArrayList<AddressEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_addresses)
        supportActionBar!!.hide()

        recycler = findViewById(R.id.recyclerSavedAddress)
        txtNoAddresses = findViewById(R.id.txtNoSavedAddresses)

        Thread {
            savedAddresses.addAll(getAddressDatabase(application).contactDAO().viewAllAddresses())
            runOnUiThread{
                if(savedAddresses.isNullOrEmpty())
                    recycler.visibility = View.INVISIBLE
                else {
                    txtNoAddresses.visibility = View.INVISIBLE
                    recycler.layoutManager = LinearLayoutManager(this)
                    adapter = SavedAddressAdapter(savedAddresses)
                    recycler.adapter = adapter
                }
            }
        }.start()
    }
}