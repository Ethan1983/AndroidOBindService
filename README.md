# AndroidOBindService

App to demonstrate a work around for Android's O Background Service Limitation
(https://developer.android.com/about/versions/oreo/background).

Start the app to launch MainActivity and finish the activity immediately by back key. MainActivity starts
AppIdleListenerService while being in foreground. This service does nothing but just serves as a hook for App idle event.
Android Framework from API level 26 stops this service automatically after certain time by stopSelf() and this invokes its
onDestroy. This is used as a hook to post a broadcast intent to launch ToastReceiver which tries to launch the actual
Toast Service from background.

Set WORK_AROUND_ANDROID_O_BACKGROUND_LIMITATION to true for the work around, false would just crash the application with an
IllegalStateException (app is in background and not allowed to start the service)

        Intent( context, ToastService::class.java ).also { serviceIntent ->
        
            if( WORK_AROUND_ANDROID_O_BACKGROUND_LIMITATION ) {
                context.applicationContext.bindService( serviceIntent, ToastServiceConnection(), Context.BIND_AUTO_CREATE )
            } else {
                context.startService( serviceIntent )
            }
            
        }
        
ToastReceiver uses the application context to bind to the service performing the background operation on top of background
service limitation of Android O. Note that this is just for demonstration, be a responsbile player in Android ecosystem and
use recommended APIs like WorkManager.
