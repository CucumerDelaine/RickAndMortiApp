package com.example.feature_characterlist_impl.presentation.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.core_db_api.model.Character
import com.example.feature_characterlist_impl.databinding.FragmentCharacterListListBinding
import com.example.feature_characterlist_impl.di.CharacterListComponentManager
import com.example.feature_characterlist_impl.presentation.model.CharacterListResult
import com.example.feature_characterlist_impl.presentation.viewModel.CharacterListViewModel

class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListListBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun getInstance(): Fragment = CharacterListFragment()
    }

    private val vm by viewModels<CharacterListViewModel> {
        CharacterListComponentManager.getCharacterListComponent().viewModelFactory()
    }


    private var status: Boolean = true
    private val stateClickListener: CharacterListRecycleViewAdapter.OnCharacterClickListener =
        object :
            CharacterListRecycleViewAdapter.OnCharacterClickListener {
            override fun onCharacterClick(characterEntity: Character, position: Int) {
                vm.goToDetails(characterEntity)
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
        val swipeRefresh: SwipeRefreshLayout = binding.swipeRefresh
        recyclerView.adapter = adapter
        lifecycleScope.launchWhenStarted {
            vm.mutableState.collect {
                when (it) {
                    is CharacterListResult.Success -> {
                        adapter.setData(it.value)
                        swipeRefresh.isRefreshing = false
                        progressBar.visibility = ProgressBar.INVISIBLE
                    }
                    is CharacterListResult.Error -> Log.d(
                        TAG,
                        it.message.toString()
                    )
                    is CharacterListResult.Loading -> progressBar.visibility =
                        ProgressBar.VISIBLE
                    is CharacterListResult.Finally -> {
                        status = false
                        progressBar.visibility = ProgressBar.INVISIBLE
                    }
                }
            }
        }
        recyclerView.addOnScrollListener(PaginationScrollListener(vm, status, progressBar))
        swipeRefresh.setOnRefreshListener {
            vm.getCharacterList(firstStart = false, clearCache = true, pagination = false)
        }
        vm.getCharacterList(firstStart = true, clearCache = false, pagination = false)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}