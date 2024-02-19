package `in`.vikasrathod.androidbasic.fragment.fragmentLifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.vikasrathod.androidbasic.fragment.BaseFragment
import `in`.vikasrathod.androidbasic.fragment.databinding.FargmentTransactionBinding

class DFragment : BaseFragment() {

    init {
        setLogTag("__D")
    }

    private var _binding: FargmentTransactionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FargmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.fragmentName.text = "D"
    }

}