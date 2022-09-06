package com.example.feature_reg_impl.presentation.ui

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.feature_reg_impl.R
import com.example.feature_reg_impl.databinding.FragmentRegistrationBinding
import com.example.feature_reg_impl.di.RegComponentManager
import com.example.feature_reg_impl.presentation.model.RegResultUI
import com.example.feature_reg_impl.presentation.viewModel.SaveUserDataViewModel

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null

    private val binding get() = _binding!!

    private val vm by viewModels<SaveUserDataViewModel> {
        RegComponentManager.getRegistrationComponent().viewModelFactory()
    }


    companion object {
        fun getInstance(): Fragment = RegistrationFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            vm.mutableState.collect {
                when (it) {
                    is RegResultUI.Success -> Toast.makeText(
                        activity,
                        context?.getString(R.string.goodReg), Toast.LENGTH_SHORT
                    ).show()
                    is RegResultUI.Error -> {
                        Toast.makeText(
                            activity,
                            context?.getString(R.string.badAuth), Toast.LENGTH_SHORT
                        ).show()
                        Log.e(ContentValues.TAG, it.message.toString())
                    }
                    is RegResultUI.EmptyError -> Toast.makeText(
                        activity,
                        context?.getString(R.string.emptyLine), Toast.LENGTH_SHORT
                    ).show()
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
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
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
        RegComponentManager.clearRegistrationComponent()
        _binding = null
    }
}