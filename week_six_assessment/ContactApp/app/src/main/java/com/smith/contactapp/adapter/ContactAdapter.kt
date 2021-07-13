package com.smith.contactapp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smith.contactapp.databinding.ContactItemBinding
import com.smith.contactapp.model.ContactModel

class ContactAdapter(
    val contactItems: List<ContactModel>, val clickFnc: (ContactModel) -> Unit
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ContactItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contactModel: ContactModel) {
            binding.contactName.text = "${contactModel.firstName} ${contactModel.lastName}"
            binding.contactNumber.text = contactModel.phoneNumber
            binding.root.setOnClickListener {
                clickFnc(contactModel)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ContactItemBinding =
            ContactItemBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int): Unit {
        holder.bind(contactItems.get(position))
    }

    override fun getItemCount() = contactItems.size
}