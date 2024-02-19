package `in`.vikasrathod.androidbasic.activity.activityLifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import `in`.vikasrathod.androidbasic.activity.R

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
    }
}
