package com.example.filmapps.feature.regAndAuth.authorization.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.filmapps.ComponentManager
import com.example.filmapps.databinding.FragmentSecondBinding
import com.example.filmapps.feature.regAndAuth.Result
import com.example.filmapps.feature.regAndAuth.authorization.presentation.viewModel.AuthorizationViewModel

class AuthorizationFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    private val vm by viewModels<AuthorizationViewModel> {
        ComponentManager.getAuthorizationComponent().viewModelsFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            vm.mutableState.collect {
                when (it) {
                    is Result.Success -> vm.goToFilm()
                    is Result.Error -> Toast.makeText(activity, it.message, Toast.LENGTH_SHORT)
                        .show()
                    else -> {}
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAuth.setOnClickListener {
            vm.auth(
                binding.editTextLoginAuth.text.toString(),
                binding.editTextPassAuth.text.toString()
            )
        }
        binding.backToReg.setOnClickListener {
            vm.goToMain()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}