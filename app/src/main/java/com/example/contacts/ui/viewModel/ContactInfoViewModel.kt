package com.example.contacts.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contacts.data.repostrory.PersonsDaoRepository

class ContactInfoViewModel : ViewModel() {
    val repo = PersonsDaoRepository()
    fun update(id: Int, name: String, number: String) {
        repo.updatePerson(id,name,number)
    }
}