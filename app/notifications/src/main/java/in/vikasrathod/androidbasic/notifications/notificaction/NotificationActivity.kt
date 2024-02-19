package `in`.vikasrathod.androidbasic.notifications.notificaction

import android.os.Bundle
import `in`.vikasrathod.androidbasic.activity.BaseActivity
import `in`.vikasrathod.androidbasic.notifications.databinding.ActivityNotificationBinding


class NotificationActivity : BaseActivity() {
    private lateinit var binding: ActivityNotificationBinding
    init {
        setLogTag("__N")
    }

    private lateinit var mNotificationManager : NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mNotificationManager = NotificationManager(this)

        binding.registerChannel.setOnClickListener {
            mNotificationManager.createNotificationChannel()
        }

        binding.deleteChannel.setOnClickListener {
            mNotificationManager.deleteNotificationChannel()
        }

        binding.basicNotification.setOnClickListener {
            mNotificationManager.actionNotification()
        }
    }

}