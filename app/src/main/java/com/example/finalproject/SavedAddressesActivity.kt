package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databaseobjects.AddressEntity
import com.example.finalproject.databaseobjects.RoomDatabaseAddresses.Companion.getAddressDatabase

class SavedAddressesActivity : AppCompatActivity() {

    lateinit var adapter: SavedAddressAdapter
    lateinit var savedAddresses : List<AddressEntity>
    lateinit var recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_addresses)

        //FIXME - Threads are not happy =( they crash the program
        recycler = findViewById(R.id.recyclerSavedAddress)
        recycler.layoutManager = LinearLayoutManager(this)

        Thread {
            savedAddresses = getAddressDatabase(application).contactDAO().viewAllAddresses()
        }.start()

        adapter = SavedAddressAdapter(savedAddresses)
        recycler.adapter = adapter
    }
}