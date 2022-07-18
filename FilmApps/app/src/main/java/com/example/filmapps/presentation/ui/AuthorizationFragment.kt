package com.example.filmapps.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.filmapps.ComponentManager
import com.example.filmapps.databinding.FragmentSecondBinding
import com.example.filmapps.presentation.presenters.SaveUserDataViewModel

class AuthorizationFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    private val vm by viewModels<SaveUserDataViewModel> {
        ComponentManager.getAuthorizationComponent().viewModelsFactory()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backToReg.setOnClickListener {
            vm.goToMain()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}