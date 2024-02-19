package `in`.vikasrathod.androidbasic.notifications.notificaction

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput
import `in`.vikasrathod.androidbasic.notifications.R

class NotificationBroadcastReceiver : BroadcastReceiver() {

    companion object {
        const val ACTION_NOTIFICATION_SIMPLE = "in.notification.simple"
        const val ACTION_TEXT_REPLY = "in.notification.reply"
        const val KEY_TEXT_REPLY = "key_text_reply"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent!!.action) {
            ACTION_NOTIFICATION_SIMPLE ->  Toast.makeText(context, intent!!.getIntExtra(Notification.EXTRA_NOTIFICATION_ID, 0).toString(), Toast.LENGTH_SHORT).show()
            ACTION_TEXT_REPLY ->  {
                val text = RemoteInput.getResultsFromIntent(intent)?.getCharSequence(KEY_TEXT_REPLY)
                Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
                val repliedNotification = NotificationCompat.Builder(context!!, "default_channel")
                        .setSmallIcon(R.drawable.ic_notifications_small_24dp)
                        .setContentText("old text")
                        .setRemoteInputHistory(arrayOf(text))
                        .build()
                // Issue the new notification.
                NotificationManagerCompat.from(context).apply {
                    notify(1, repliedNotification)
                }

            }
        }
    }

}