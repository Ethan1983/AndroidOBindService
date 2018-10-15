package com.sample.androidobindservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class ToastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Log.d( TAG, "onReceive" )

        Intent( context, ToastService::class.java ).also { serviceIntent ->

            if( WORK_AROUND_ANDROID_O_BACKGROUND_LIMITATION ) {

                context.applicationContext.bindService( serviceIntent, ToastServiceConnection(), Context.BIND_AUTO_CREATE )

            } else {

                context.startService( serviceIntent )

            }

        }

    }

    companion object {
        private const val TAG = "ToastReceiver"
        private const val WORK_AROUND_ANDROID_O_BACKGROUND_LIMITATION = true
    }
}
