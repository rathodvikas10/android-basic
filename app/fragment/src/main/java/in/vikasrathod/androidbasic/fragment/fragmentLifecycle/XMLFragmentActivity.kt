package `in`.vikasrathod.androidbasic.fragment.fragmentLifecycle

import android.os.Bundle
import `in`.vikasrathod.androidbasic.activity.BaseActivity
import `in`.vikasrathod.androidbasic.fragment.R

class XMLFragmentActivity : BaseActivity() {

    init {
        setLogTag("__XML")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_life_cycle)
    }

}
