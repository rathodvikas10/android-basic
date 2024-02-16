package `in`.vikasrathod.androidbasic.ui.fragmentLifecycle

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import android.os.Bundle

class XMLFragmentActivity : BaseActivity() {

    init {
        setLogTag("__XML")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_life_cycle)
    }

}
