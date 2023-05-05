package com.example.contacts.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.contacts.R
import com.example.contacts.databinding.FragmentContactInfoBinding
import com.example.contacts.databinding.FragmentHomeBinding
import com.example.contacts.ui.viewModel.ContactInfoViewModel
import com.example.contacts.ui.viewModel.HomeViewModel
import com.example.contacts.ui.viewModel.RegistrationViewModel

class ContactInfoFragment : Fragment() {
    private lateinit var binding: FragmentContactInfoBinding
    private lateinit var viewModel: ContactInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_contact_info, container, false)
        binding.contactInfoFragment = this
        binding.contactInfoTitle = "Registration"

        val bundle: ContactInfoFragmentArgs by navArgs()
        val person = bundle.person

        binding.personClass = person

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelContactInfo : ContactInfoViewModel by viewModels()
        viewModel = viewModelContactInfo
    }

    fun updateButton(id: Int, name: String, number: String) {
        viewModel.update(id,name, number)
    }
}