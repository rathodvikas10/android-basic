package `in`.vikasrathod.androidbasic.ui.fragment

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.activity.LifeCycleAActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment


class MyDialogFragment : DialogFragment() {

    internal var mNum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNum = arguments?.getInt("num") as Int

        // Pick a style based on the num.
        var style = DialogFragment.STYLE_NORMAL
        var theme = 0
        when ((mNum - 1) % 6) {
            1 -> style = DialogFragment.STYLE_NO_TITLE
            2 -> style = DialogFragment.STYLE_NO_FRAME
            3 -> style = DialogFragment.STYLE_NO_INPUT
            4 -> style = DialogFragment.STYLE_NORMAL
            5 -> style = DialogFragment.STYLE_NORMAL
            6 -> style = DialogFragment.STYLE_NO_TITLE
            7 -> style = DialogFragment.STYLE_NO_FRAME
            8 -> style = DialogFragment.STYLE_NORMAL
        }
        when ((mNum - 1) % 6) {
            4 -> theme = android.R.style.Theme_Holo
            5 -> theme = android.R.style.Theme_Holo_Light_Dialog
            6 -> theme = android.R.style.Theme_Holo_Light
            7 -> theme = android.R.style.Theme_Holo_Light_Panel
            8 -> theme = android.R.style.Theme_Holo_Light
        }
        setStyle(style, theme)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_dialog, container, false)
        v.findViewById<TextView>(R.id.text).text = ("Dialog #$mNum: using style ")
        // Watch for button clicks.
        v.findViewById<Button>(R.id.show_dialog).setOnClickListener {
            (activity as LifeCycleAActivity).showMDialog()
        }
        return v
    }

    companion object {
        /**
         * Create a new instance of MyDialogFragment, providing "num"
         * as an argument.
         */
        internal fun newInstance(num: Int): MyDialogFragment {
            val f = MyDialogFragment()
            // Supply num input as an argument.
            val args = Bundle()
            args.putInt("num", num)
            f.setArguments(args)
            return f
        }
    }
}