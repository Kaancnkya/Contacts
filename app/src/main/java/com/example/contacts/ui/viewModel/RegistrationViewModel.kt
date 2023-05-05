package com.example.contacts.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contacts.data.repostrory.PersonsDaoRepository

class RegistrationViewModel : ViewModel() {
    val repo = PersonsDaoRepository()
    fun register(name : String ,number : String){
        repo.registerPerson(name,number)
    }
}