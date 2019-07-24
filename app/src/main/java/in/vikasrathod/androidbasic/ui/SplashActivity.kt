package `in`.vikasrathod.androidbasic.ui

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.activityLaunchMode.AActivity
import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import `in`.vikasrathod.androidbasic.ui.fragmentLifecycle.FragmentTransactionActivity
import `in`.vikasrathod.androidbasic.ui.fragmentLifecycle.XMLFragmentActivity
import `in`.vikasrathod.androidbasic.ui.notificaction.NotificationActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

/**
 * Created by vikas on 26/9/16.
 */

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        launchApplication()
        printLog(Runtime.getRuntime().availableProcessors().toString())
    }

    private fun launchApplication() {
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@SplashActivity, NotificationActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
