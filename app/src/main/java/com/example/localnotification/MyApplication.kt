package com.example.localnotification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.work.Configuration

class MyApplication : Application(){
//    , Configuration.Provider
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            val name = getString(R.string.greeting_channel)
            val descriptionText = getString(R.string.greeting_channel_desc)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel =
                NotificationChannel(getString(R.string.greeting_channel_id), name, importance)
            mChannel.description = descriptionText
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }

//    override fun getWorkManagerConfiguration(): Configuration {
//        return Configuration.Builder()
//            .setMinimumLoggingLevel(android.util.Log.DEBUG)
//            .build()
//    }
}