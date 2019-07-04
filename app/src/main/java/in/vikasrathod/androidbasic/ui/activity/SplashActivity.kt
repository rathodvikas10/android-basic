package `in`.vikasrathod.androidbasic.ui.activity

import `in`.vikasrathod.androidbasic.R
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
    }

    private fun launchApplication() {
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@SplashActivity, LifeCycleAActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
