package `in`.vikasrathod.androidbasic.ui.activity

import `in`.vikasrathod.androidbasic.ui.fragment.MyDialogFragment
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_lifecycle_a.*


/**
 * Created by vikas on 26/9/16.
 */

class LifeCycleAActivity : BaseActivity() {

    companion object {
        val STATE_METHOD = "method"
    }

    var lastMethodCalled = ""
    var mStackLevel = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setLogTag("__A")

        lastMethodCalled = "onCreate"
        setContentView(`in`.vikasrathod.androidbasic.R.layout.activity_lifecycle_a)

        Handler().post {
            printLog("onCreate")
        }

        if(savedInstanceState != null) {
            with(savedInstanceState) {
                printLog("lastState : " + getString(STATE_METHOD))
            }
        }
        start_activity.setOnClickListener {
            val intent = Intent(this@LifeCycleAActivity, LifeCycleBActivity::class.java)
            startActivityForResult(intent,1001)
        }
        show_dialog.setOnClickListener {
            showMDialog()
        }
    }

    override fun onStart() {
        Handler().post {
            printLog("onStart")
            lastMethodCalled = "onStart"
        }
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        Handler().post {
            printLog("onResume")
            lastMethodCalled = "onResume"
        }
    }

    override fun onPause() {
        super.onPause()
        Handler().post {
            printLog("onPause")
            lastMethodCalled = "onPause"
        }
    }

    override fun onStop() {
        super.onStop()
        Handler().post {
            printLog("onStop")
            lastMethodCalled = "onStop"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Handler().post {
            printLog("onDestroy")
            lastMethodCalled = "onDestroy"
        }
    }

    override fun onRestart() {
        super.onRestart()
        Handler().post {
            printLog("onRestart")
            lastMethodCalled = "onRestart"
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Handler().post {
            printLog("onBackPressed")
            lastMethodCalled = "onBackPressed"
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            putString(STATE_METHOD,lastMethodCalled)
        }
        super.onSaveInstanceState(outState)
        Handler().post {
            printLog("onSaveInstanceState")
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Handler().post {
            printLog("onRestoreInstanceState")
            printLog("lastState : " + savedInstanceState?.getString(STATE_METHOD))
        }
    }

    fun showMDialog() {
        mStackLevel++
        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        val ft = supportFragmentManager.beginTransaction()
        val prev = supportFragmentManager.findFragmentByTag("dialog")
        if (prev != null) {
            ft.remove(prev)
        }
        ft.addToBackStack(null)
        // Create and show the dialog.
        val newFragment = MyDialogFragment.newInstance(mStackLevel)
        newFragment.show(ft, "dialog")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Handler().post {
            printLog("onActivityResult")
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        Handler().post {
            printLog("onConfigurationChanged")
        }
    }

}
