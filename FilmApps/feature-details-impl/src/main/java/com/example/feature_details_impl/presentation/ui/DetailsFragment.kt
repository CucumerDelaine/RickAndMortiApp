package com.example.feature_details_impl.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.core.data.model.CoreCharacter
import com.example.core_db_api.model.Character
import com.example.feature_details_impl.databinding.FragmentDetailsBinding
import com.example.feature_details_impl.di.DetailsComponentManager
import com.example.feature_details_impl.presentation.viewModel.CharacterDetailsViewModel


class DetailsFragment : Fragment() {


    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val vm by viewModels<CharacterDetailsViewModel> {
        DetailsComponentManager.getDetailsComponent().viewModelFactory()
    }


    private val charId: Int
        get() = requireArguments().getInt("ID")

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
                    is com.example.feature_details_impl.presentation.model.CharacterDetailsResult.Success -> {
                        binding.imageCharacter.load(it.value?.image)
                        binding.imageCharacter.visibility = ImageView.VISIBLE
                        binding.textName.text = it.value?.name
                        binding.textName.visibility = TextView.VISIBLE
                        binding.textStatus.text = it.value?.status
                        binding.textStatus.visibility = TextView.VISIBLE
                        binding.textSpecies.text = it.value?.species
                        binding.textSpecies.visibility = TextView.VISIBLE
                        binding.textGender.text = it.value?.gender
                        binding.textGender.visibility = TextView.VISIBLE
                        binding.textOrigin.text = it.value?.origin
                        binding.textOrigin.visibility = TextView.VISIBLE
                        binding.textLocation.text = it.value?.location
                        binding.textLocation.visibility = TextView.VISIBLE
                        binding.backToCharList.visibility = Button.VISIBLE
                        binding.toolbarDetails.title = it.value?.titleName
                        binding.progressBarCharacterDetails.visibility = ProgressBar.INVISIBLE
                    }
                    is com.example.feature_details_impl.presentation.model.CharacterDetailsResult.Error -> Toast.makeText(
                        activity,
                        it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    is com.example.feature_details_impl.presentation.model.CharacterDetailsResult.Loading -> binding.progressBarCharacterDetails.visibility =
                        ProgressBar.VISIBLE
                }
            }
        }
        vm.getCharacterDetails(charId)
        binding.backToCharList.setOnClickListener {
            vm.backToCharLIst()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        DetailsComponentManager.clearDetailsComponent()
        _binding = null
    }

    companion object {
        fun getNewInstance(coreCharacter: CoreCharacter): DetailsFragment {
            val character = Character(
                coreCharacter.id,
                coreCharacter.name,
                coreCharacter.status,
                coreCharacter.species,
                coreCharacter.gender,
                coreCharacter.origin,
                coreCharacter.location,
                coreCharacter.image
            )
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    character.id?.let { putInt("ID", it) }
                }
            }
        }
    }
}