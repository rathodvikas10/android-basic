package `in`.vikasrathod.androidbasic.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import `in`.vikasrathod.androidbasic.databinding.ItemTopicBinding

data class Topic(val title: String, val description: String)

class TopicAdaptor(
    private val topics: Array<Topic>
): RecyclerView.Adapter<TopicAdaptor.ViewHolder>() {

    class ViewHolder(
        private val binding: ItemTopicBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(topic: Topic) {
            binding.topic = topic
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTopicBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = topics.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(topics[position])
    }

}