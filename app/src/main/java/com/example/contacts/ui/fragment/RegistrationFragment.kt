package com.example.contacts.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.contacts.R
import com.example.contacts.databinding.FragmentHomeBinding
import com.example.contacts.databinding.FragmentRegistrationBinding
import com.example.contacts.ui.viewModel.HomeViewModel
import com.example.contacts.ui.viewModel.RegistrationViewModel


class RegistrationFragment : Fragment() {
    private lateinit var binding: FragmentRegistrationBinding
    private lateinit var viewModel: RegistrationViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_registration,container,false)
        binding.personRegistrationTitle = "Registration"
        binding.personRegistrationFragment = this

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelRegistration : RegistrationViewModel by viewModels()
        viewModel = viewModelRegistration
    }

    fun registerButton(name : String ,number : String){
        viewModel.register(name,number)
    }

}