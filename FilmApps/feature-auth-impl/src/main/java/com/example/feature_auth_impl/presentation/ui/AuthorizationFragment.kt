package com.example.feature_auth_impl.presentation.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.feature_auth_impl.R
import com.example.feature_auth_impl.databinding.FragmentAuthBinding
import com.example.feature_auth_impl.di.AuthComponentManager
import com.example.feature_auth_impl.presentation.model.AuthResultUI
import com.example.feature_auth_impl.presentation.viewModel.AuthorizationViewModel


class AuthorizationFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null

    private val binding get() = _binding!!

    private val vm by viewModels<AuthorizationViewModel> {
        AuthComponentManager.getAuthorizationComponent()!!.viewModelFactory()
    }

    companion object {
        fun getInstance(): Fragment = AuthorizationFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            vm.mutableState.collect {
                when (it) {
                    is AuthResultUI.Success -> Toast.makeText(
                        activity,
                        context?.getString(R.string.welcome), Toast.LENGTH_SHORT
                    ).show()
                    is AuthResultUI.Error -> {
                        Toast.makeText(
                            activity,
                            context?.getString(R.string.badAuth), Toast.LENGTH_SHORT
                        ).show()
                        Log.e(TAG, it.message.toString())
                    }
                    is AuthResultUI.EmptyError -> Toast.makeText(
                        activity,
                        context?.getString(R.string.emptyLine), Toast.LENGTH_SHORT
                    ).show()
                    else -> {}
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
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
//        AuthComponentManager.clearAuthorizationComponent()
        _binding = null
    }
}