package `in`.vikasrathod.androidbasic.fragment

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by vikas on 26/9/16.
 */

open class BaseFragment : Fragment() {

    private var LOG_TAG = "__"
    private var mSuperLogEnable = true

    fun setLogTag(tag: String) {
        LOG_TAG = tag
    }

    fun printLog(string: String) {
        Log.d(LOG_TAG, string)
    }

    fun setSuperLogEnable(pBoolean : Boolean) {
        this.mSuperLogEnable = pBoolean
    }

    private fun printLogInternal(string: String) {
        if(mSuperLogEnable) printLog(string)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        printLogInternal("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        printLogInternal("onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        printLogInternal("onCreateView")
        return null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        printLogInternal("onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        printLogInternal("onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        printLogInternal("onStart")
    }

    override fun onResume() {
        super.onResume()
        printLogInternal("onResume")
    }

    override fun onPause() {
        super.onPause()
        printLogInternal("onPause")
    }

    override fun onStop() {
        super.onStop()
        printLogInternal("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        printLogInternal("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        printLogInternal("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        printLogInternal("onDetach")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        printLogInternal("onSaveInstanceState")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        printLogInternal("onActivityResult")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        printLogInternal("onConfigurationChanged")
    }
}
