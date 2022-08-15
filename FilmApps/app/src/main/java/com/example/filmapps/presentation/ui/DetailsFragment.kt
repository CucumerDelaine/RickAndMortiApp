package com.example.filmapps.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.filmapps.ComponentManager
import com.example.filmapps.databinding.FragmentDetailsBinding
import com.example.filmapps.feature.characterList.presentation.model.Character
import com.example.filmapps.presentation.model.CharacterDetails
import com.example.filmapps.presentation.viewModel.CharacterDetailsViewModel


class DetailsFragment(private val character: Character) : Fragment() {


    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val vm by viewModels<CharacterDetailsViewModel> {
        ComponentManager.getDetailsComponent().viewModelsFactory()
    }

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
        lifecycleScope.launchWhenStarted {
            vm.mutableState.collect {
                when (it) {
                    is CharacterDetails.Success -> {
                        binding.imageCharacter.load(it.value?.image)
                        binding.textName.text = it.value?.name
                        binding.textStatus.text = it.value?.status
                        binding.textSpecies.text = it.value?.species
                        binding.textGender.text = it.value?.gender
                        binding.textOrigin.text = it.value?.origin
                        binding.textLocation.text = it.value?.location
                        binding.progressBarCharacterDetails.visibility = ProgressBar.INVISIBLE
                    }
                    is CharacterDetails.Error -> Toast.makeText(
                        activity,
                        it.message,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    is CharacterDetails.Loading -> binding.progressBarCharacterDetails.visibility =
                        ProgressBar.VISIBLE
                }
            }
        }
        character.id?.let { vm.getCharacterDetails(it) }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}