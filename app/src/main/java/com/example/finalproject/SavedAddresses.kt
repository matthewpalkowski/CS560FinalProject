package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SavedAddresses : AppCompatActivity() {

    //FIXME - might need a new data class with database ID and SearchItem?

    lateinit var adapter: SavedAddressAdapter
    lateinit var savedAddresses : List<SavedAddressItem>
    lateinit var recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_addresses)

        adapter = SavedAddressAdapter(savedAddresses)

        recycler = findViewById(R.id.recyclerSavedAddress)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
    }
}