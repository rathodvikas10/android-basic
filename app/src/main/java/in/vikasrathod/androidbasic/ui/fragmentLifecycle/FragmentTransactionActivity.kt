package `in`.vikasrathod.androidbasic.ui.fragmentLifecycle

import `in`.vikasrathod.androidbasic.R
import `in`.vikasrathod.androidbasic.ui.common.BaseActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment_transactions.*
import java.util.*

class FragmentTransactionActivity : BaseActivity() {

    init {
        setLogTag("__FT")
    }

    private lateinit var mFragmentManager: FragmentManager
    private var mFragmentList = LinkedList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transactions)
        mFragmentManager = supportFragmentManager
        add.setOnClickListener { addFragment() }
        remove.setOnClickListener { removeFragment() }
        replace.setOnClickListener { replaceFragment() }
        pop.setOnClickListener { popBackStack() }
    }

    private fun getSelectedFragment() : Fragment {
        return when(fragment_group.checkedRadioButtonId) {
            R.id.fragment_a -> findFragment(AFragment())
            R.id.fragment_b -> findFragment(BFragment())
            R.id.fragment_c -> findFragment(CFragment())
            R.id.fragment_d -> findFragment(DFragment())
            else -> AFragment()
        }
    }

    private fun findFragment(fragment: Fragment) : Fragment {
        return mFragmentManager.findFragmentByTag(fragment::class.java.simpleName) ?: fragment
    }

    private fun addFragment() {
        val fragmentTransaction = mFragmentManager.beginTransaction()
        val fragment = getSelectedFragment()
        mFragmentList.add(fragment)
        val tag = fragment::class.java.simpleName
        fragmentTransaction.add(R.id.container,fragment,tag)
        if(backstack_enabled.isChecked) fragmentTransaction.addToBackStack("stack_name_$tag")
        fragmentTransaction.commit()
    }

    private fun removeFragment() {
        val fragmentTransaction = mFragmentManager.beginTransaction()
        if(!mFragmentList.isEmpty()) {
            val fragment = getSelectedFragment()
            val tag = fragment::class.java.simpleName
            fragmentTransaction.remove(fragment)
            if(backstack_enabled.isChecked) fragmentTransaction.addToBackStack("stack_name_$tag")
            fragmentTransaction.commit()
        }
    }

    private fun replaceFragment() {
        val fragmentTransaction = mFragmentManager.beginTransaction()
        val fragment = getSelectedFragment()
        val tag = fragment::class.java.simpleName
        mFragmentList.add(fragment)
        fragmentTransaction.replace(R.id.container,fragment,tag)
        if(backstack_enabled.isChecked) fragmentTransaction.addToBackStack("stack_name_$tag")
        fragmentTransaction.commit()
    }

    private fun popBackStack() = mFragmentManager.popBackStack()
}