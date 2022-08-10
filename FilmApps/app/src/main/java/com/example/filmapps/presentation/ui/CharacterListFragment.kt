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
import androidx.recyclerview.widget.GridLayoutManager
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

    private var status: Boolean = true
    private val adapter = CharacterListRecycleViewAdapter()



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
        val progressBar: ProgressBar = binding.progressBar
        recyclerView.adapter = adapter
        lifecycleScope.launchWhenStarted {
            vm.mutableState.collect {
                when (it) {
                    is CharacterList.Success -> {
                        adapter.setData(it.value)
                        progressBar.visibility = ProgressBar.INVISIBLE
                    }
                    is CharacterList.Error -> Toast.makeText(activity, it.message, Toast.LENGTH_SHORT)
                        .show()
                    is CharacterList.Loading -> progressBar.visibility = ProgressBar.VISIBLE
                    is CharacterList.Finaly -> status = false
                }
            }
        }
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy > 0) {
                    val layoutManager = recyclerView.layoutManager as GridLayoutManager
                    val visibleItemCount = layoutManager.findLastCompletelyVisibleItemPosition()+1
                    if (visibleItemCount == layoutManager.itemCount && status){
                        vm.getCharacterList()
                        progressBar.visibility = ProgressBar.VISIBLE
                    }
                }
            }
        })

        vm.getCharacterList()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}