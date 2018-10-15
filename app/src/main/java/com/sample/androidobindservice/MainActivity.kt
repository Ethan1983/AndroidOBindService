package com.sample.androidobindservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Intent( this, AppIdleListenerService::class.java ).also { serviceIntent ->
            startService( serviceIntent )
        }

    }

}
