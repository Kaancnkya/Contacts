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
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.R
import com.example.contacts.data.entity.Person
import com.example.contacts.databinding.FragmentHomeBinding
import com.example.contacts.ui.adapter.PersonAdapter

class HomeFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHomePage)


        binding.toolbarHomePage.title = "CONTACTS"

        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        val personList = ArrayList<Person>()
        val p1 = Person(1 , "Kaan" , "1111")
        val p2 = Person(2 , "Ugur" , "1145")
        val p3 = Person(3 , "Semra" , "1261")
        val p4 = Person(4 , "Deniz" , "1145")
        personList.add(p1)
        personList.add(p2)
        personList.add(p3)
        personList.add(p4)

        val adapter = PersonAdapter(requireContext(), personList)
        binding.rv.adapter = adapter

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

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    fun search(writtenWordOnSearch : String){
        Log.e("Written Word", writtenWordOnSearch)
    }

    override fun onResume() {
        super.onResume()
    }
}