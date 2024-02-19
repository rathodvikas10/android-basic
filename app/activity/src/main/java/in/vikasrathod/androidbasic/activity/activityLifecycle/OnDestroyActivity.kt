package `in`.vikasrathod.androidbasic.activity.activityLifecycle

import android.os.Bundle
import `in`.vikasrathod.androidbasic.activity.BaseActivity

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
