package `in`.vikasrathod.androidbasic.ui.activityLaunchMode

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launch_mode.*

class SingleTaskActivity : BaseActivity() {

    init {
        setSuperLogEnable(false)
        setLogTag("__")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_mode)
        printLog("Single Task : $taskId")
        name.text = "Single Task"
        NavigationController.navigateToClick(container)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        printLog("onNewIntent : Single Instance : $taskId")
    }
}
