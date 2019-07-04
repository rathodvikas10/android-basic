package `in`.vikasrathod.androidbasic.ui.activity

import android.os.Bundle

/**
 * Created by vikas on 27/9/16.
 */

class OnDestroyActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLogTag("__")
        finish()
        printLog("onCreate")
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
