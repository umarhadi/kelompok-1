package com.kelompok1.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.app.Notification
import android.view.View

class MainActivity : AppCompatActivity() {
    /*deklarasi NotificationManager */
    private var notificationManager: NotificationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel("com.kelompok1.notification.send", "Notification", "Send Notification")
    }
    /* membuat Notification Channel*/
    private fun createNotificationChannel(id: String, name: String, description: String) {

        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(id, name, importance)

        channel.description = description
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        notificationManager?.createNotificationChannel(channel)
    }
    /*Method sendNotification yang akan dipanggil oleh attribute onClick pada button di activity_main.xml*/
    fun sendNotification(view: View) {
        val notificationID = 101
        val channelID = "com.kelompok1.notification.send"
        val notification = Notification.Builder(this@MainActivity,
                channelID)
                .setContentTitle("Notifikasi Kelompok 1")
                .setContentText("Ini adalah Notifikasi")
                .setSmallIcon(R.drawable.ic_notification)
                .setChannelId(channelID)
                .build()
        notificationManager?.notify(notificationID, notification)
    }
}