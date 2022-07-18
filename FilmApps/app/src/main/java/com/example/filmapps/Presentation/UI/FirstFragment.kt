package com.example.filmapps.Presentation.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.filmapps.Presentation.Presenters.SaveUserDataViewModel
import com.example.filmapps.Presentation.Presenters.ViewModelFactory
import com.example.filmapps.R
import com.example.filmapps.databinding.FragmentFirstBinding
import com.example.filmapps.domain.di.components.AuthorizationComponent
import com.example.filmapps.domain.di.components.DaggerAuthorizationComponent

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private lateinit var vm: SaveUserDataViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val authorizationComponent: AuthorizationComponent = DaggerAuthorizationComponent.create()

        vm = ViewModelProvider(this, authorizationComponent.getViewModelFactory()).get(SaveUserDataViewModel::class.java)
        binding.buttonReg.setOnClickListener {
            Toast.makeText(getActivity(),
                vm.save(binding.editTextLogin.text.toString(),
                    binding.editTextPass.text.toString()),
                Toast.LENGTH_SHORT).show()
        }
        binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}