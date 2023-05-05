package com.example.contacts.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.R
import com.example.contacts.data.entity.Person
import com.example.contacts.databinding.FragmentHomeBinding
import com.example.contacts.ui.adapter.PersonAdapter
import com.example.contacts.ui.viewModel.HomeViewModel
import com.example.contacts.ui.viewModel.RegistrationViewModel
import com.example.contacts.util.switchPage

class HomeFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.homeFragment = this
        binding.homeTitle = "CONTACTS"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHomePage)

        viewModel.personList.observe(viewLifecycleOwner){
            val adapter = PersonAdapter(requireContext(), it, viewModel)
            binding.personAdapter = adapter
        }



        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.homeToRegister)
        }

        requireActivity().addMenuProvider(object  : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner, Lifecycle.State.RESUMED)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelHome : HomeViewModel by viewModels()
        viewModel = viewModelHome
    }

    fun fabClick(it : View){
        Navigation.switchPage(it,R.id.homeToRegister)

    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }



    override fun onResume() {
        super.onResume()
        viewModel.getAll()
    }
}