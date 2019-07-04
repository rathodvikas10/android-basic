package `in`.vikasrathod.androidbasic.ui.activity

import `in`.vikasrathod.androidbasic.R
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_life_cycle_b.*

class LifeCycleBActivity : BaseActivity() {

    companion object {
        val STATE_METHOD = "method"
    }

    var lastMethodCalled = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLogTag("__B")
        lastMethodCalled = "onCreate"
        setContentView(R.layout.activity_life_cycle_b)
        Handler().post {
            printLog("onCreate")
        }
        if(savedInstanceState != null) {
            with(savedInstanceState) {
                printLog("lastState : " + getString(LifeCycleAActivity.STATE_METHOD))
            }
        }
        new_activity.setOnClickListener {
            var intent = Intent(this,ToastActivity::class.java)
            startActivity(intent)
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
}
