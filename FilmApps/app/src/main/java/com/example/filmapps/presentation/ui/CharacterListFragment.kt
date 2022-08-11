package com.example.filmapps.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.filmapps.ComponentManager
import com.example.filmapps.databinding.FragmentCharacterListListBinding
import com.example.filmapps.presentation.model.CharacterList
import com.example.filmapps.presentation.model.CharacterListResponce
import com.example.filmapps.presentation.viewModel.ListCharacterViewModel


class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListListBinding? = null

    private val binding get() = _binding!!

    private val vm by viewModels<ListCharacterViewModel> {
        ComponentManager.getFilmListComponent().viewModelsFactory()
    }

    override fun onStart() {
        super.onStart()

        val recyclerView: RecyclerView = binding.list
        val progressBar: ProgressBar = binding.progressBar
        lifecycleScope.launchWhenStarted {
            vm.mutableState.collect {
                when (it) {
                    is CharacterList.Success -> {
                        recyclerView.adapter = CharacterListRecycleViewAdapter(it.value)
                        progressBar.visibility = ProgressBar.INVISIBLE
                    }
                    is CharacterList.Error -> Toast.makeText(activity, it.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                    is CharacterList.Loading -> progressBar.visibility = ProgressBar.VISIBLE
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCharacterListListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.getCharacterList()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}