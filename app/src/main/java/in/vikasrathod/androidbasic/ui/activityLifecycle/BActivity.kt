package `in`.vikasrathod.androidbasic.ui.activityLifecycle

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import `in`.vikasrathod.androidbasic.ui.toast.ToastActivity
import android.content.Intent
import android.os.Bundle
import `in`.vikasrathod.androidbasic.databinding.ActivityLifeCycleBBinding

class BActivity : BaseActivity() {

    init {
        setLogTag("__B")
    }

    private lateinit var binding : ActivityLifeCycleBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifeCycleBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newActivity.setOnClickListener {
            var intent = Intent(this, ToastActivity::class.java)
            startActivity(intent)
        }

    }

}
