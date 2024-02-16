package `in`.vikasrathod.androidbasic.ui.toast

import `in`.vikasrathod.androidbasic.R
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import `in`.vikasrathod.androidbasic.databinding.ActivityToastBinding

class ToastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToastBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.left.setOnClickListener {
            val text = "Hello toast!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.TOP or Gravity.LEFT, 100, 100)
            toast.show()
        }

        binding.customToast.setOnClickListener {
            val inflater = layoutInflater
            val layout: ViewGroup = inflater.inflate(R.layout.custom_toast, null) as ViewGroup
            val text: TextView = layout.findViewById(R.id.text)
            text.text = "This is a custom toast"
            with (Toast(applicationContext)) {
                setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                duration = Toast.LENGTH_LONG
                this.view = layout
                show()
            }
        }

        binding.snackbar.setOnClickListener {
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
