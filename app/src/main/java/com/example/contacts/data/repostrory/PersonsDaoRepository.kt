package com.example.contacts.data.repostrory

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.contacts.data.entity.Person

class PersonsDaoRepository {
    var personList : MutableLiveData<List<Person>> = MutableLiveData()

    fun bridgeForGettingPersons() : MutableLiveData<List<Person>>{
        return personList
    }

    fun registerPerson(name : String ,number : String){
        Log.e("person Registration" , "$name - $number")
    }
    fun updatePerson(id: Int, name: String, number: String) {
        Log.e("Update", "$id - $name - $number")
    }
    fun searchPerson(writtenWordOnSearch : String){
        Log.e("Written Word", writtenWordOnSearch)
    }
    fun deletePerson(id : Int){
        Log.e("Delete Person" , id.toString())
    }
    fun getAllPersons(){
        val list = ArrayList<Person>()
        val p1 = Person(1 , "Kaan" , "1111")
        val p2 = Person(2 , "Ugur" , "1145")
        val p3 = Person(3 , "Semra" , "1261")
        val p4 = Person(4 , "Deniz" , "1145")
        list.add(p1)
        list.add(p2)
        list.add(p3)
        list.add(p4)
        personList.value = list
    }
}