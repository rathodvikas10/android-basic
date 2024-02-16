package `in`.vikasrathod.androidbasic.ui.activityLaunchMode

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import android.content.Intent
import android.os.Bundle
import `in`.vikasrathod.androidbasic.databinding.ActivityLaunchModeBinding

class SingleInstanceActivity : BaseActivity() {

    init {
        setSuperLogEnable(false)
        setLogTag("__")
    }
    private lateinit var binding: ActivityLaunchModeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        printLog("Single Instance : $taskId")
        binding.name.text = "Single Instance"
        NavigationController.navigateToClick(binding.root)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        printLog("onNewIntent : Single Instance : $taskId")
    }
}
