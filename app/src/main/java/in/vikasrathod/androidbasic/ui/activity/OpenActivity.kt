package `in`.vikasrathod.androidbasic.ui.activity

import android.os.Bundle

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.activity.BaseActivity

/**
 * Created by vikas on 26/9/16.
 */

class OpenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open)
    }
}
