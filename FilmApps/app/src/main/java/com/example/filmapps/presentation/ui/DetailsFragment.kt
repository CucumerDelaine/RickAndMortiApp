package com.example.filmapps.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.filmapps.R
import com.example.filmapps.databinding.FragmentCharacterListListBinding
import com.example.filmapps.databinding.FragmentDetailsBinding
import com.example.filmapps.presentation.model.Character


class DetailsFragment(private val character: Character) : Fragment() {


    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text1.text = character.id

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}