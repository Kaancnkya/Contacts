package com.example.contacts.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contacts.R
import com.example.contacts.databinding.FragmentHomeBinding
import com.example.contacts.databinding.FragmentRegistrationBinding


class RegistrationFragment : Fragment() {
    private lateinit var binding: FragmentRegistrationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater,container,false)
        binding.toolbarRegistration.title = "Registration"
        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val number = binding.editTextNumber.text.toString()

            register(name,number)
        }
        return binding.root
    }

    fun register(name : String ,number : String){
        Log.e("Person Registration" , "$name - $number")
    }

}