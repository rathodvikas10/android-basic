package `in`.vikasrathod.androidbasic.ui.activity

import android.content.Intent
import android.os.Bundle

/**
 * Created by vikas on 26/9/16.
 */

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,ToastActivity::class.java))
    }
}
