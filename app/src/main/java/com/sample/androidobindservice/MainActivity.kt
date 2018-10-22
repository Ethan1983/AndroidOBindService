package com.sample.androidobindservice

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if( DYNAMIC_REGISTERED_RECEIVER ) {

            IntentFilter( "com.sample.androidobindservice.receiver_action" ).also { intentFilter ->
                registerReceiver( ToastReceiver(), intentFilter )
                sendBroadcast( Intent( "com.sample.androidobindservice.receiver_action" ) )
            }

        } else {

            Intent( this, AppIdleListenerService::class.java ).also { serviceIntent ->
                startService( serviceIntent )
            }

        }

    }

}
