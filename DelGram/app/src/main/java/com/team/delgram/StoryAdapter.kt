package com.team.delgram






import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team.delgram.databinding.StoriesBinding

class StoryAdapter(
    var list: List<StoriesBinding>
) : RecyclerView.Adapter<StoryAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: StoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(story: StoriesBinding) {


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: StoriesBinding =
            StoriesBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int): Unit {
        holder.bind(list.get(position))
    }

    override fun getItemCount() = list.size
}


