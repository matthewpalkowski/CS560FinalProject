package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SearchResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)
    }

    private fun saveResult(){
        //TODO implement
    }

    inner class ButtonListener : View.OnClickListener{
        override fun onClick(v: View?) {
            saveResult()
        }
    }
}