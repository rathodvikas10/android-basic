package `in`.vikasrathod.androidbasic.ui.activityLaunchMode

import `in`.vikasrathod.androidbasic.R
import android.content.Intent
import android.view.View
import android.widget.TextView

class NavigationController {

    companion object {
        fun navigateToClick(view : View) {
            view.findViewById<TextView>(R.id.activity_a).setOnClickListener {
                it.context.startActivity(Intent(view.context,AActivity::class.java))
            }
            view.findViewById<TextView>(R.id.activity_b).setOnClickListener {
                it.context.startActivity(Intent(view.context,BActivity::class.java))
            }
            view.findViewById<TextView>(R.id.activity_c).setOnClickListener {
                it.context.startActivity(Intent(view.context,CActivity::class.java))
            }
            view.findViewById<TextView>(R.id.activity_d).setOnClickListener {
                it.context.startActivity(Intent(view.context,DActivity::class.java))
            }
            view.findViewById<TextView>(R.id.activity_single_instance).setOnClickListener {
                it.context.startActivity(Intent(view.context,SingleInstanceActivity::class.java))
            }
            view.findViewById<TextView>(R.id.activity_single_top).setOnClickListener {
                it.context.startActivity(Intent(view.context,SingleTopActivity::class.java))
            }
            view.findViewById<TextView>(R.id.activity_single_task).setOnClickListener {
                it.context.startActivity(Intent(view.context,SingleTaskActivity::class.java))
            }
        }
    }

}