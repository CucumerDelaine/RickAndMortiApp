package com.example.filmapps.Presentation.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.filmapps.Presentation.Presenters.MyViewModel
import com.example.filmapps.Presentation.Presenters.MyViewModelFactory
import com.example.filmapps.R
import com.example.filmapps.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var vm: MyViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
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

        vm = ViewModelProvider(this, MyViewModelFactory()).get(MyViewModel::class.java)
        binding.button2.setOnClickListener {
           val login = binding.editTextTextPersonName.text.toString()
            val pass = binding.editTextTextPassword3.text.toString()
            if(vm.save(login, pass))
                Toast.makeText(getActivity(), "Успешная регистрация", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(getActivity(), "Неудачная регистрация", Toast.LENGTH_SHORT).show()
        }
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}