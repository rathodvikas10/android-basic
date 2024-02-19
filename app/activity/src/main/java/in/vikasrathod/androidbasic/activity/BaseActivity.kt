package `in`.vikasrathod.androidbasic.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

/**
 * Created by vikas on 26/9/16.
 */

open class BaseActivity : AppCompatActivity() {

    companion object {
        val STATE_METHOD = "method"
    }

    private var LOG_TAG = "__"
    private var logInitial = ""
    private var mLastMethodCalled = ""
    private var mSuperLogEnable = true

    fun setLogTag(tag: String) {
        LOG_TAG = tag
    }

    fun setLogInitial(initial: String) {
        logInitial = initial
    }

    fun printLog(string: String) {
        Log.d(LOG_TAG, logInitial + string)
    }

    fun setSuperLogEnable(pBoolean : Boolean) {
        this.mSuperLogEnable = pBoolean
    }

    private fun printLogInternal(string: String) {
        if(mSuperLogEnable) printLog(string)
    }

    fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Dialog came up the screen")
        builder.setPositiveButton("Close", null)
        builder.show()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        printLogInternal("onNewIntent")
        mLastMethodCalled = "onNewIntent"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        printLogInternal("onCreate")
        mLastMethodCalled = "onCreate"
        if(savedInstanceState != null) {
            with(savedInstanceState) {
                printLogInternal("lastState : " + getString(STATE_METHOD))
            }
        }
    }

    override fun onStart() {
        super.onStart()
        printLogInternal("onStart")
        mLastMethodCalled = "onStart"
    }

    override fun onResume() {
        super.onResume()
        printLogInternal("onResume")
        mLastMethodCalled = "onResume"
    }

    override fun onPause() {
        super.onPause()
        printLogInternal("onPause")
        mLastMethodCalled = "onPause"
    }

    override fun onRestart() {
        super.onRestart()
        printLogInternal("onRestart")
        mLastMethodCalled = "onRestart"
    }

    override fun onStop() {
        super.onStop()
        printLogInternal("onStop")
        mLastMethodCalled = "onStop"
    }

    override fun onDestroy() {
        super.onDestroy()
        printLogInternal("onDestroy")
        mLastMethodCalled = "onDestroy"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        printLogInternal("onSaveInstanceState")
        mLastMethodCalled = "onSaveInstanceState"
        outState?.run {
            putString(STATE_METHOD,mLastMethodCalled)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        printLogInternal("onRestoreInstanceState")
        mLastMethodCalled = "onRestoreInstanceState"
        printLogInternal("lastState : " + savedInstanceState.getString(STATE_METHOD))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        printLogInternal("onConfigurationChanged")
        mLastMethodCalled = "onConfigurationChanged"
    }

    override fun onBackPressed() {
        super.onBackPressed()
        printLogInternal("onBackPressed")
        mLastMethodCalled = "onBackPressed"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        printLogInternal("onActivityResult")
        mLastMethodCalled = "onActivityResult"
    }
}
