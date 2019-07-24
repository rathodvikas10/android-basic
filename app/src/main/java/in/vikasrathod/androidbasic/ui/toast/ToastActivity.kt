package `in`.vikasrathod.androidbasic.ui.toast

import `in`.vikasrathod.androidbasic.R
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_toast.*

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

        custom_toast.setOnClickListener {
            val inflater = layoutInflater
            val layout: ViewGroup = inflater.inflate(R.layout.custom_toast, null) as ViewGroup
            val text: TextView = layout.findViewById(R.id.text)
            text.text = "This is a custom toast"
            with (Toast(applicationContext)) {
                setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        snackbar.setOnClickListener {
            Snackbar.make(it,"Snackbar Text",Snackbar.LENGTH_SHORT).setAction("Action") {
                Toast.makeText(applicationContext, "Action Performed", Toast.LENGTH_SHORT).show()
            }.addCallback(object : Snackbar.Callback() {
                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                    Toast.makeText(applicationContext, "Dismissed", Toast.LENGTH_SHORT).show()
                }
            }).show()
        }
    }
}
