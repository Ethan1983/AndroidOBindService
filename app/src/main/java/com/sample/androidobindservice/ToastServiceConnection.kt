package com.sample.androidobindservice

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log

class ToastServiceConnection : ServiceConnection {

    override fun onServiceDisconnected(name: ComponentName) {

        Log.d( TAG, "onServiceDisconnected" )

    }

    override fun onServiceConnected(name: ComponentName, service: IBinder) {

        Log.d( TAG, "onServiceConnected" )

        val interfaceBinder = service as ToastService.InterfaceBinder
        val toastService = interfaceBinder.getService()
        toastService.startOperation()

    }

    companion object {
        private const val TAG = "ToastServiceConnection"
    }

}