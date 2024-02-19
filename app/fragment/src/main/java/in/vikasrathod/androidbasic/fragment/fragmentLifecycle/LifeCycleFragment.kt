package `in`.vikasrathod.androidbasic.fragment.fragmentLifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.vikasrathod.androidbasic.fragment.BaseFragment
import `in`.vikasrathod.androidbasic.fragment.R

class LifeCycleFragment : BaseFragment() {

    init {
        setLogTag("__F")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_life_cycle,container,false)
    }

}