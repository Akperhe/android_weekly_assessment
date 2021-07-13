package com.smith.contactapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactModel(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val emailAddress: String,

    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
)
