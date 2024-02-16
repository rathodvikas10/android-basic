package `in`.vikasrathod.androidbasic.ui.notificaction

import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import android.os.Bundle
import `in`.vikasrathod.androidbasic.databinding.ActivityNotificationBinding

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