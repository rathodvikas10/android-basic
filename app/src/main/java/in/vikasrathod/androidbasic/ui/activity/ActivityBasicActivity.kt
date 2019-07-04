package `in`.vikasrathod.androidbasic.ui.activity

import `in`.vikasrathod.androidbasic.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

/**
 * Created by vikas on 26/9/16.
 */

class ActivityBasicActivity : BaseActivity() {

    private val LOG_TAG = "ACTIVITY_BASIC"
    private var showActivity: Button? = null
    private var showDialog: Button? = null
    private var showExternalDialog: Button? = null
    private var finishActivity: Button? = null
    private var onDestroy: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity_basic)
        this.showDialog = findViewById<View>(R.id.show_dialog) as Button
        this.showActivity = findViewById<View>(R.id.show_activity) as Button
        this.showExternalDialog = findViewById<View>(R.id.show_external_dialog) as Button
        this.finishActivity = findViewById<View>(R.id.finish) as Button
        this.onDestroy = findViewById<View>(R.id.on_destroy) as Button
        findViewById<TextView>(R.id.toast_activity).setOnClickListener {
            val intent = Intent(this,ToastActivity::class.java)
            startActivity(intent)
        }

        showDialog!!.setOnClickListener { showDialog() }

        showActivity!!.setOnClickListener {
            val intent = Intent(this@ActivityBasicActivity, LifeCycleAActivity::class.java)
            startActivity(intent)
        }

        showExternalDialog!!.setOnClickListener {
            val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = "Here is the share content body"
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here")
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Share via"))
        }

        finishActivity!!.setOnClickListener { finish() }

        onDestroy!!.setOnClickListener {
            val intent = Intent(this@ActivityBasicActivity, OnDestroyActivity::class.java)
            startActivity(intent)
        }

        setLogTag(LOG_TAG)
        printLog("onCreate")

        val mHomeWatcher = HomeWatcher(this)
        mHomeWatcher.setOnHomePressedListener(object : HomeWatcher.OnHomePressedListener {
            override fun onHomePressed() {
                printLog("onHomePressed")
            }

            override fun onHomeLongPressed() {
                printLog("onHomeLongPressed")
            }
        })
        mHomeWatcher.startWatch()
    }

    fun isDebuggable() {

    }

    override fun onStart() {
        super.onStart()
        printLog("onStart")
    }

    override fun onResume() {
        super.onResume()
        printLog("onResume")
    }

    override fun onPause() {
        super.onPause()
        printLog("onPause")
    }

    override fun onStop() {
        super.onStop()
        printLog("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        printLog("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        printLog("onRestart")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        printLog("onBackPressed")
    }

}
