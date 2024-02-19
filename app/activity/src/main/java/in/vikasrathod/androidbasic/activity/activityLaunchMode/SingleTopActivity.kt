package `in`.vikasrathod.androidbasic.activity.activityLaunchMode

import android.content.Intent
import android.os.Bundle
import `in`.vikasrathod.androidbasic.activity.BaseActivity
import `in`.vikasrathod.androidbasic.activity.databinding.ActivityLaunchModeBinding

class SingleTopActivity : BaseActivity() {

    init {
        setSuperLogEnable(false)
        setLogTag("__")
    }

    private lateinit var binding: ActivityLaunchModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        printLog("Single Top : $taskId")
        binding.name.text = "Single Top"
        NavigationController.navigateToClick(binding.root)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        printLog("onNewIntent : Single Top : $taskId")
    }
}
