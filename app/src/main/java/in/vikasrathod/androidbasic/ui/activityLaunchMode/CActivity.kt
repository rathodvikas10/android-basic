package `in`.vikasrathod.androidbasic.ui.activityLaunchMode

import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import android.os.Bundle
import `in`.vikasrathod.androidbasic.databinding.ActivityLaunchModeBinding

class CActivity : BaseActivity() {

    init {
        setSuperLogEnable(false)
        setLogTag("__")
    }

    private lateinit var binding: ActivityLaunchModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        printLog("C : $taskId")
        binding.name.text = "C"
        NavigationController.navigateToClick(binding.root)
    }
}