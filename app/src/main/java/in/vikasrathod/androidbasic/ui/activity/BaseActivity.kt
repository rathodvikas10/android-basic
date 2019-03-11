package `in`.vikasrathod.androidbasic.ui.activity

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

/**
 * Created by vikas on 26/9/16.
 */

open class BaseActivity : AppCompatActivity() {

    private var LOG_TAG: String? = null

    fun setLogTag(tag: String) {
        LOG_TAG = tag
    }

    fun printLog(string: String) {
        Log.d(LOG_TAG, string)
    }

    fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Dialog came up the screen")
        builder.setPositiveButton("Close", null)
        builder.show()
    }
}
