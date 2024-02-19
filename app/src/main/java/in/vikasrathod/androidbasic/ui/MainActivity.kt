package `in`.vikasrathod.androidbasic.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.RecyclerView
import `in`.vikasrathod.androidbasic.databinding.ActivityMainBinding

/**
 * Created by vikas on 26/9/16.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTopicAdaptor(getTopics())
    }

    private fun setupTopicAdaptor(topics: Array<Topic> = arrayOf()) {
        val adaptor = TopicAdaptor(topics).apply {
            setHasStableIds(true)
        }
        binding.topicList.addItemDecoration(MarginItemDecoration(16))
        binding.topicList.setHasFixedSize(true)
        binding.topicList.adapter = adaptor
    }

    private fun getTopics() = arrayOf(
        Topic("Activity", "Activity related topics"),
        Topic("Fragment", ""),
        Topic("Service", ""),
        Topic("Broadcast Receiver", ""),
        Topic("Content Provider", "")
    )

    class MarginItemDecoration(private val spaceSize: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect, view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            with(outRect) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    top = spaceSize
                }
                left = spaceSize
                right = spaceSize
                bottom = spaceSize
            }
        }
    }
}
