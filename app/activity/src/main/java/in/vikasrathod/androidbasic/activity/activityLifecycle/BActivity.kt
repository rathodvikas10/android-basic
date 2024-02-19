package `in`.vikasrathod.androidbasic.activity.activityLifecycle

import android.os.Bundle
import `in`.vikasrathod.androidbasic.activity.BaseActivity
import android.content.Intent
import `in`.vikasrathod.androidbasic.activity.databinding.ActivityLifeCycleBBinding

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
            //var intent = Intent(this, ToastActivity::class.java)
            //startActivity(intent)
        }

    }

}
