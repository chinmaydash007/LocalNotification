package com.example.localnotification

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            scheduleOneTimeNotification(2,TimeUnit.MINUTES)
        }
    }


    fun scheduleOneTimeNotification(interval: Long,timeUnit:TimeUnit) {
        val work =
            PeriodicWorkRequestBuilder<ScheduledNotificationWorker>(interval,timeUnit)
                .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "greet service",
            ExistingPeriodicWorkPolicy.REPLACE,
            work
        )
    }
}