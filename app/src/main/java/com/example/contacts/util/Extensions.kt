package com.example.contacts.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.contacts.R

fun Navigation.switchPage(it : View, id : NavDirections){
    findNavController(it).navigate(id)
}

fun Navigation.switchPage(it : View, id : Int){
    findNavController(it).navigate(R.id.homeToRegister)
}

