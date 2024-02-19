package `in`.vikasrathod.androidbasic.activity.activityLaunchMode

import android.os.Bundle
import `in`.vikasrathod.androidbasic.activity.BaseActivity
import `in`.vikasrathod.androidbasic.activity.databinding.ActivityLaunchModeBinding

class AActivity : BaseActivity() {

    init {
        setSuperLogEnable(false)
        setLogTag("__")
    }

    private lateinit var binding: ActivityLaunchModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        printLog("A : $taskId")
        binding.name.text = "A"
        NavigationController.navigateToClick(binding.root)
    }
}