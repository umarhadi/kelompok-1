package com.kelompok1.notification

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private const val CHANNEL_ID = "notif_app"
        private const val NOTIFICATION_ID = 999
    }
 //   var btnNotif: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNotif: Button = findViewById(R.id.buttonNotif)
        btnNotif.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonNotif -> {
                val builder = NotificationCompat.Builder(this@MainActivity, CHANNEL_ID)
                builder.setSmallIcon(R.drawable.ic_notification)
                builder.setContentTitle("Kelompok 1")
                builder.setContentText("Ini adalah Notification")
                builder.priority = NotificationCompat.PRIORITY_HIGH
                val notificationManagerCompat = NotificationManagerCompat.from(this@MainActivity)
                notificationManagerCompat.notify(NOTIFICATION_ID, builder.build())
            }
        }
    }
}