package `in`.vikasrathod.androidbasic.ui.notificaction

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notification.*


class NotificationActivity : BaseActivity() {

    init {
        setLogTag("__N")
    }

    private lateinit var mNotificationManager : NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        mNotificationManager = NotificationManager(this)

        register_channel.setOnClickListener {
            mNotificationManager.createNotificationChannel()
        }

        delete_channel.setOnClickListener {
            mNotificationManager.deleteNotificationChannel()
        }

        basic_notification.setOnClickListener {
            mNotificationManager.actionNotification()
        }
    }

}