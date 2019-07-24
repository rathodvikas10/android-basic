package `in`.vikasrathod.androidbasic.ui.notificaction

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.notificaction.NotificationBroadcastReceiver.Companion.KEY_TEXT_REPLY
import android.app.Activity
import android.app.Notification.EXTRA_NOTIFICATION_ID
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput

class NotificationManager(private val mActivity: Activity) {

    private val CHANNEL_ID = "default_channel"

    fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Basic Notification"
            val descriptionText = "Minimal requirements to show notification"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager = mActivity.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun deleteNotificationChannel() {
        val notificationManager: NotificationManager = mActivity.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.deleteNotificationChannel(CHANNEL_ID)
        }
    }

    fun basicNotification() {
        val builder = NotificationCompat.Builder(mActivity, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_small_24dp)
                .setContentTitle("basic notification")
                .setContentText("Some text to display")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(mActivity)) {
            // notificationId is a unique int for each notification that you must define
            notify(0, builder.build())
        }
    }

    fun actionNotification() {

        val simpleIntent = Intent(mActivity, NotificationBroadcastReceiver::class.java).apply {
            action = NotificationBroadcastReceiver.ACTION_NOTIFICATION_SIMPLE
            putExtra(EXTRA_NOTIFICATION_ID, 1)
        }
        val replyIntent = Intent(mActivity, NotificationBroadcastReceiver::class.java).apply {
            action = NotificationBroadcastReceiver.ACTION_TEXT_REPLY
            putExtra(EXTRA_NOTIFICATION_ID, 1)
        }
        val simplePendingIntent: PendingIntent = PendingIntent.getBroadcast(mActivity, 1001, simpleIntent, 0)
        val replyPendingIntent: PendingIntent = PendingIntent.getBroadcast(mActivity, 1002, replyIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        var remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
            setLabel("reply please")
            build()
        }
        var action: NotificationCompat.Action = NotificationCompat.Action.Builder(R.drawable.ic_notifications_small_24dp,"reply", replyPendingIntent)
                        .addRemoteInput(remoteInput)
                        .build()

        val builder = NotificationCompat.Builder(mActivity, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_small_24dp)
                .setContentTitle("Action notification")
                .setContentText("Some text to display")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(R.drawable.ic_notifications_small_24dp, "primary1", simplePendingIntent)
                .addAction(action)

        with(NotificationManagerCompat.from(mActivity)) {
            // notificationId is a unique int for each notification that you must define
            notify(1, builder.build())
        }
    }

}