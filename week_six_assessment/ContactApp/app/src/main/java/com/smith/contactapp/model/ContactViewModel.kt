package com.smith.contactapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.smith.contactapp.database.ContactDatabase

class ContactViewModel : ViewModel() {

    fun addContactItem(
        contactItem: ContactModel,
        database: ContactDatabase
    ) {
        database.contactDao().addContactItem(contactItem)
    }

    fun getAllContactItems(database: ContactDatabase)
            : LiveData<List<ContactModel>> {
        return database.contactDao().getAllContactItems()
    }
}