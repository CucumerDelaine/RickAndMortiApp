package com.example.filmapps.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.filmapps.App
import com.example.filmapps.presentation.presenters.SaveUserDataViewModel
import com.example.filmapps.Screens
import com.example.filmapps.databinding.FragmentFirstBinding
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    @Inject
    lateinit var router: Router

    private val vm by viewModels<SaveUserDataViewModel> {
        App.INSTANCE.app.viewModelsFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.INSTANCE.app.inject(this)
        binding.buttonReg.setOnClickListener {
            Toast.makeText(
                activity,
                vm.save(
                    binding.editTextLoginReg.text.toString(),
                    binding.editTextPassReg.text.toString()
                ),
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.goToAuth.setOnClickListener {
            router.newChain(Screens.AddressSearch())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}