package com.smith.profiles

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smith.profiles.data_class.CustomNames
import com.smith.profiles.databinding.ProfileItemsBinding


class ProfileAdapter(val names: List<CustomNames>) :
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    class ProfileViewHolder(val binding: ProfileItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(name: CustomNames) {

            binding.firstNameHolder.text = name.firstName
            binding.lastNameHolder.text = name.lastName
            binding.userImage.setImageResource(name.imageSource)

            binding.root.setOnClickListener { v: View ->

                val context = binding.root.context // context reference
                val intent: Intent = Intent(context, DisplayProfileActivity::class.java)
                intent.putExtra("resId", name.imageSource)
                intent.putExtra("firstName", name.firstName)
                intent.putExtra("lastName", name.lastName)

                context.startActivity(intent) //context referrence

            }

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileAdapter.ProfileViewHolder {
        val binding: ProfileItemsBinding = ProfileItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )//,parent,false remove this and your layout will not match width
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileAdapter.ProfileViewHolder, position: Int) {
        val name = names.get(position)
        holder.bind(name)

    }

    override fun getItemCount(): Int {
        return names.size
    }


}