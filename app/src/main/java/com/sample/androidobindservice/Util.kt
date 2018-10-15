package com.sample.androidobindservice

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import kotlin.concurrent.thread

internal inline fun forever( delayMilliseconds : Long = 4000, crossinline uiBlock : () -> Unit ) : Thread {

    return thread {

        val mainThreadHandler = Handler( Looper.getMainLooper() )

        while( true ) {

            mainThreadHandler.post {

                uiBlock()

            }

            SystemClock.sleep( delayMilliseconds )
        }

    }

}