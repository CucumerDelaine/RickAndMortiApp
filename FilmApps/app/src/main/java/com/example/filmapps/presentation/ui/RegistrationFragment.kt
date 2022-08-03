package com.example.filmapps.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.filmapps.ComponentManager
import com.example.filmapps.Result
import com.example.filmapps.databinding.FragmentFirstBinding
import com.example.filmapps.presentation.presenters.SaveUserDataViewModel

class RegistrationFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    private val vm by viewModels<SaveUserDataViewModel> {
        ComponentManager.getRegistrationComponent().viewModelsFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            vm.mutableState.collect {
                when (it) {
                    is Result.Success -> vm.goToAuth()
                    is Result.Error -> Toast.makeText(activity, it.message, Toast.LENGTH_SHORT)
                        .show()
                    else -> {}
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonReg.setOnClickListener {
            vm.registration(
                binding.editTextLoginReg.text.toString(),
                binding.editTextPassReg.text.toString()
            )
        }
        binding.goToAuth.setOnClickListener {
            vm.goToAuth()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}