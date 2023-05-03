package com.example.contacts.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.data.entity.Person
import com.example.contacts.databinding.CardItemBinding
import com.example.contacts.ui.fragment.HomeFragmentDirections
import com.google.android.material.snackbar.Snackbar

class PersonAdapter(val mContext: Context, var personList: List<Person>) :
    RecyclerView.Adapter<PersonAdapter.CardViewHolder>() {

    inner class CardViewHolder(binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: CardItemBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardItemBinding.inflate(layoutInflater, parent, false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val person = personList[position]
        holder.binding.textViewPersonInfo.text = "${person.name} - ${person.number}"

        holder.binding.cardRow.setOnClickListener {
            val homeToInfo = HomeFragmentDirections.homeToInfo(person = person)
            Navigation.findNavController(it).navigate(homeToInfo)
        }

        holder.binding.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"do you want to delete ${person.name}'s number ?", Snackbar.LENGTH_LONG)
                .setAction("YES"){
                    Log.e("Delete Person" , person.id.toString())

                }.show()
        }
    }
}