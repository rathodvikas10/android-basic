package `in`.vikasrathod.androidbasic.activity.activityLifecycle

import android.os.Bundle
import `in`.vikasrathod.androidbasic.activity.BaseActivity
import android.content.Intent
import `in`.vikasrathod.androidbasic.activity.databinding.ActivityLifecycleABinding
import `in`.vikasrathod.androidbasic.activity.activityLaunchMode.CustomDialogFragment


/**
 * Created by vikas on 26/9/16.
 */

class AActivity : BaseActivity() {

    init {
        setLogInitial("A: ")
    }

    private var mStackLevel = 0
    private lateinit var binding: ActivityLifecycleABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifecycleABinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startActivity.setOnClickListener {
            val intent = Intent(this@AActivity, BActivity::class.java)
            startActivityForResult(intent,1001)
        }

        binding.onDestroyActivity.setOnClickListener {
            val intent = Intent(this@AActivity, OnDestroyActivity::class.java)
            startActivity(intent)
        }

        binding.showDialog.setOnClickListener {
            showMDialog()
        }

        binding.showActivityDialog.setOnClickListener {
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
