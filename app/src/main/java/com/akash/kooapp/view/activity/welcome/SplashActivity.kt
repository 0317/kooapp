package com.akash.kooapp.view.activity.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.akash.kooapp.R
import com.akash.kooapp.utils.Helper
import com.akash.kooapp.view.activity.home.HomeActivity
import java.util.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()
        if(Helper.isOnline(applicationContext)){
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    val intent = Intent(applicationContext, HomeActivity::class.java)
                    startActivity(intent)
                }
            }, 3000)
        }else{
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Not Internet Connection")
            builder.setNeutralButton("OK") { dialogInterface, which ->
                dialogInterface.cancel()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }
}

