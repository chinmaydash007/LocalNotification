package com.example.localnotification

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlin.random.Random

class ScheduledNotificationWorker(var context: Context, params: WorkerParameters) :
    Worker(context, params) {


    var TAG = this.javaClass.simpleName


    override fun doWork(): Result {
        var CHANNEL_ID = context.getString(R.string.greeting_channel_id)
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Scheduled notification ${Random.nextInt()}")
            .setContentText("Hello from one-time worker!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)


        with(NotificationManagerCompat.from(context)) {
            notify(Random.nextInt(),    builder.build())
        }


        return Result.success()
    }

}