package `in`.vikasrathod.androidbasic.ui.activityLifecycle

import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import `in`.vikasrathod.androidbasic.ui.common.CustomDialogFragment
import `in`.vikasrathod.androidbasic.ui.common.DialogActivity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lifecycle_a.*


/**
 * Created by vikas on 26/9/16.
 */

class AActivity : BaseActivity() {

    init {
        setLogTag("__A")
    }

    private var mStackLevel = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(`in`.vikasrathod.androidbasic.R.layout.activity_lifecycle_a)

        start_activity.setOnClickListener {
            val intent = Intent(this@AActivity, BActivity::class.java)
            startActivityForResult(intent,1001)
        }

        on_destroy_activity.setOnClickListener {
            val intent = Intent(this@AActivity, OnDestroyActivity::class.java)
            startActivity(intent)
        }

        show_dialog.setOnClickListener {
            showMDialog()
        }

        show_activity_dialog.setOnClickListener {
            val intent = Intent(this@AActivity, DialogActivity::class.java)
            startActivity(intent)
        }
    }

    fun showMDialog() {
        mStackLevel++
        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        val ft = supportFragmentManager.beginTransaction()
        val prev = supportFragmentManager.findFragmentByTag("dialog")
        if (prev != null) {
            ft.remove(prev)
        }
        ft.addToBackStack(null)
        // Create and show the dialog.
        val newFragment = CustomDialogFragment.newInstance(mStackLevel)
        newFragment.show(ft, "dialog")
    }

}
