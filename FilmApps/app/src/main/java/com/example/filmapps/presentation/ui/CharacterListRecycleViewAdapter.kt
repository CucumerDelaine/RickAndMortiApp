package com.example.filmapps.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.filmapps.databinding.FragmentCharacterListBinding
import com.example.filmapps.presentation.model.Character

class CharacterListRecycleViewAdapter() :
    RecyclerView.Adapter<CharacterListRecycleViewAdapter.ViewHolder>() {

    private val values: MutableList<Character> =
        mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCharacterListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.load(item.img)
    }

    override fun getItemCount(): Int {
        return values.size
    }

    fun setData(characterList: List<Character>) {
        values.clear()
        values.addAll(characterList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: FragmentCharacterListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: ImageView = binding.image
    }

}