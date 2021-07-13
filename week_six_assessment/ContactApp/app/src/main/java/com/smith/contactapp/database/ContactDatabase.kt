package com.smith.contactapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.smith.contactapp.ContactDAO
import com.smith.contactapp.model.ContactModel

@Database(
    entities = arrayOf(ContactModel::class),
    version = 1
)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDAO
}