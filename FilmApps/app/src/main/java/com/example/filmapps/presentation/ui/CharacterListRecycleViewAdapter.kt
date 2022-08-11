package com.example.filmapps.presentation.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import coil.load
import com.example.filmapps.data.model.Results
import com.example.filmapps.databinding.FragmentCharacterListBinding
import com.example.filmapps.presentation.viewModel.Character

class CharacterListRecycleViewAdapter(
    private val values: MutableList<Character>
) : RecyclerView.Adapter<CharacterListRecycleViewAdapter.ViewHolder>() {

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
        val item = values.get(position)
        holder.idView.load(item.img)
    }

    override fun getItemCount(): Int {
        return values.size
    }

    inner class ViewHolder(binding: FragmentCharacterListBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: ImageView = binding.image
    }

}