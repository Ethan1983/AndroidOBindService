package com.sample.androidobindservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class ToastService : Service() {

    private val mBinder = InterfaceBinder()
    private var counter = 0

    inner class InterfaceBinder : Binder() {

        fun getService() : ToastService = this@ToastService

    }

    override fun onBind(intent: Intent): IBinder = mBinder

    override fun onCreate() {
        super.onCreate()
        Log.d( TAG, "Service onCreate $this" )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Toast.makeText( this, "Toast Service started", Toast.LENGTH_SHORT ).show()

        startOperation()

        return super.onStartCommand(intent, flags, startId)
    }

    fun startOperation() {

        forever {

            counter++

            Toast.makeText( this, "Toasting from Service $counter", Toast.LENGTH_SHORT ).show()

            Log.d( TAG, "Toasting from Service $counter" )

        }

    }

    companion object {
        private const val TAG = "ToastService"
    }
}
