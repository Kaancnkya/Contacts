package com.example.contacts.data.entity

import java.io.Serializable

data class Person(
    var id : Int,
    var name : String,
    var number : String
) : Serializable