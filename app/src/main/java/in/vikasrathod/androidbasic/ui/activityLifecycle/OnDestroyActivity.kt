package `in`.vikasrathod.androidbasic.ui.activityLifecycle

import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import android.os.Bundle

/**
 * Created by vikas on 27/9/16.
 */

class OnDestroyActivity : BaseActivity() {

    init {
        setLogTag("__DA")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()
    }

}
