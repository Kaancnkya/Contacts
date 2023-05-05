package com.example.contacts.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contacts.data.entity.Person
import com.example.contacts.data.repostrory.PersonsDaoRepository

class HomeViewModel : ViewModel() {
    val repo = PersonsDaoRepository()
    var personList = MutableLiveData<List<Person>>()

    init {
        getAll()
        personList = repo.bridgeForGettingPersons()
    }

    fun search(writtenWordOnSearch : String){
        repo.searchPerson(writtenWordOnSearch)
    }
    fun delete(id : Int){
        repo.deletePerson(id)
    }
    fun getAll(){
        repo.getAllPersons()
    }

}