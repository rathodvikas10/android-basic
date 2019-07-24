package `in`.vikasrathod.androidbasic.ui.activityLaunchMode

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launch_mode.*

class DActivity : BaseActivity() {

    init {
        setSuperLogEnable(false)
        setLogTag("__")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_mode)
        printLog("D : $taskId")
        name.text = "D"
        NavigationController.navigateToClick(container)
    }
}