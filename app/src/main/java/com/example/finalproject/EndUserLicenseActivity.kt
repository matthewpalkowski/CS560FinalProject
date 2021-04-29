package com.example.finalproject

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class EndUserLicenseActivity : AppCompatActivity() {

    private lateinit var eulaTextView: TextView
    private lateinit var btnReject : Button
    private lateinit var btnAccept : Button
    private lateinit var onClickListener: View.OnClickListener

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_user_license)
        supportActionBar!!.hide()

        eulaTextView = findViewById(R.id.txtEULA)
        eulaTextView.movementMethod = ScrollingMovementMethod()
        eulaTextView.setOnScrollChangeListener(scrollListener())

        onClickListener = buttonListener()

        btnAccept = findViewById(R.id.btnAccept)
        btnAccept.setOnClickListener(onClickListener)

        btnReject = findViewById(R.id.btnReject)
        btnReject.setOnClickListener(onClickListener)
    }

    private fun generateDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.alert_title))
        builder.setMessage(getString(R.string.alert_message))
        builder.setPositiveButton(getString(R.string.return_to_application)){
            _: DialogInterface, _: Int ->
        }
        builder.setNegativeButton(getString(R.string.confirm)){
            _: DialogInterface, _: Int ->
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        val dialog = builder.create()
        dialog.show()
    }

    inner class buttonListener : View.OnClickListener{
        override fun onClick(v: View?) {
            if(v!!.equals(findViewById(R.id.btnAccept))){
                val editor = getPreferences(MODE_PRIVATE).edit()
                editor.putBoolean(getString(R.string.eula_acceptance),true)
                setResult(Activity.RESULT_OK)
                finish()
            }

            if(v == findViewById(R.id.btnReject)) generateDialog()
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    inner class scrollListener : View.OnScrollChangeListener{
        override fun onScrollChange(v: View?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int){
            if (!v!!.canScrollVertically(1)) {
                findViewById<Button>(R.id.btnAccept).isEnabled = true
                findViewById<Button>(R.id.btnReject).isEnabled = true
            }
        }

    }
}