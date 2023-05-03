package com.example.contacts.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.contacts.R
import com.example.contacts.databinding.FragmentContactInfoBinding
import com.example.contacts.databinding.FragmentHomeBinding

class ContactInfoFragment : Fragment() {
    private lateinit var binding: FragmentContactInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactInfoBinding.inflate(inflater, container, false)
        binding.toolbarContactInfo.title = "Registration"

        val bundle: ContactInfoFragmentArgs by navArgs()
        val person = bundle.person

        binding.editTextName.setText(person.name.toString())
        binding.editTextNumber.setText(person.number.toString())

        binding.buttonUpdate.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val number = binding.editTextNumber.text.toString()

            update(person.id, name, number)
        }
        return binding.root
    }

    fun update(id: Int, name: String, number: String) {
        Log.e("Update", "$id - $name - $number")
    }
}