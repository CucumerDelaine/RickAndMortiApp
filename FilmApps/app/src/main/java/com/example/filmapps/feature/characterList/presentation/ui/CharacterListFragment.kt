package com.example.filmapps.feature.characterList.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.filmapps.ComponentManager
import com.example.filmapps.databinding.FragmentCharacterListListBinding
import com.example.filmapps.feature.characterList.presentation.model.Character
import com.example.filmapps.feature.characterList.presentation.model.CharacterList
import com.example.filmapps.feature.characterList.presentation.viewModel.ListCharacterViewModel


class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListListBinding? = null

    private val binding get() = _binding!!

    private val vm by viewModels<ListCharacterViewModel> {
        ComponentManager.getCharacterListComponent().viewModelsFactory()
    }

    private var status: Boolean = true
    private val stateClickListener: CharacterListRecycleViewAdapter.OnCharacterClickListener =
        object :
            CharacterListRecycleViewAdapter.OnCharacterClickListener {
            override fun onCharacterClick(character: Character, position: Int) {
                vm.goToDetails(character)
            }
        }
    private var adapter = CharacterListRecycleViewAdapter(stateClickListener)

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

        val recyclerView: RecyclerView = binding.list
        val progressBar: ProgressBar = binding.progressBarCharacterList
        recyclerView.adapter = adapter
        lifecycleScope.launchWhenStarted {
            vm.mutableState.collect {
                when (it) {
                    is CharacterList.Success -> {
                        adapter.setData(it.value)
                        progressBar.visibility = ProgressBar.INVISIBLE
                    }
                    is CharacterList.Error -> Toast.makeText(
                        activity,
                        it.message,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    is CharacterList.Loading -> progressBar.visibility = ProgressBar.VISIBLE
                    is CharacterList.Finally -> status = false
                }
            }
        }
        recyclerView.addOnScrollListener(PaginationScrollListener(vm, status, progressBar))
        vm.getCharacterList()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}