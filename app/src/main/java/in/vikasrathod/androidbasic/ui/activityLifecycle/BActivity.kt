package `in`.vikasrathod.androidbasic.ui.activityLifecycle

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import `in`.vikasrathod.androidbasic.ui.toast.ToastActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_life_cycle_b.*

class BActivity : BaseActivity() {

    init {
        setLogTag("__B")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_life_cycle_b)

        new_activity.setOnClickListener {
            var intent = Intent(this, ToastActivity::class.java)
            startActivity(intent)
        }

    }

}
