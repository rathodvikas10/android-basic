package `in`.vikasrathod.androidbasic.ui.activity

import `in`.vikasrathod.androidbasic.R
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ToastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)
        findViewById<TextView>(R.id.left).setOnClickListener {
            val text = "Hello toast!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.TOP or Gravity.LEFT, 100, 100)
            toast.show()
        }
    }
}
