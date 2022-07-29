package com.example.filmapps.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
            when (val e: Result = vm.registration(
                binding.editTextLoginReg.text.toString(),
                binding.editTextPassReg.text.toString()
            )) {
                is Result.Success -> {
                    vm.goToAuth()
                }
                is Result.Error -> {
                    Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
                }
            }
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