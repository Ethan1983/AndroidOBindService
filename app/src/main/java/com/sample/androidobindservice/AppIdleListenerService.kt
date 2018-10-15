package com.sample.androidobindservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class AppIdleListenerService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d( TAG, "onCreate" )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d( TAG, "onStartCommand" )

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d( TAG, "onDestroy" )

        Intent( this, ToastReceiver::class.java ).also { intent ->
            sendBroadcast( intent )
        }
    }

    companion object {
        private const val TAG = "AppIdleListenerService"
    }
}
