package com.smith.getandpostapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smith.getandpostapp.dataClass.ItemsItem
import com.smith.getandpostapp.databinding.ItemLayoutBinding

class ItemsItemAdapter(
    var list: List<ItemsItem>
) : RecyclerView.Adapter<ItemsItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemsItem) {
            binding.id.text = item.id.toString()
            binding.name.text = item.name
            binding.price.text = item.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemLayoutBinding =
            ItemLayoutBinding.inflate(
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


