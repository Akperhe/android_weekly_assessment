package com.smith.contactapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.smith.contactapp.adapter.ContactAdapter
import com.smith.contactapp.database.ContactDatabase
import com.smith.contactapp.databinding.ActivityMainBinding
import com.smith.contactapp.model.ContactModel
import com.smith.contactapp.model.ContactViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var contactList: MutableList<ContactModel>
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]

        contactList = mutableListOf()

        contactAdapter = ContactAdapter(contactList) {
            val intent = Intent(this, ContactDashboardActivity::class.java)
            intent.putExtra("firstName", it.firstName)
            intent.putExtra("lastName", it.lastName)
            intent.putExtra("phoneNumber", it.phoneNumber)
            intent.putExtra("emailAddress", it.emailAddress)
            startActivity(intent)
        }
        binding.recyclerView.adapter = contactAdapter

        val db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java, "contact-database"
        ).allowMainThreadQueries().build()


        viewModel.getAllContactItems(db).observe(this, {
            contactAdapter = ContactAdapter(it) {
                val intent = Intent(this, ContactDashboardActivity::class.java)
                intent.putExtra("firstName", it.firstName)
                intent.putExtra("lastName", it.lastName)
                intent.putExtra("phoneNumber", it.phoneNumber)
                intent.putExtra("emailAddress", it.emailAddress)
                startActivity(intent)
            }
            binding.recyclerView.adapter = contactAdapter
            contactAdapter.notifyDataSetChanged()
        })

        binding.saveBtn.setOnClickListener {
            val firstName: String = binding.firstName.text.toString()
            val lastName: String = binding.lastName.text.toString()
            val phoneNumber: String = binding.phoneNumber.text.toString()
            val emailAddress: String = binding.emailAddress.text.toString()

            val contactItem = ContactModel(firstName, lastName, phoneNumber, emailAddress)
            viewModel.addContactItem(contactItem, db)

            contactAdapter.notifyDataSetChanged()
        }
    }
}