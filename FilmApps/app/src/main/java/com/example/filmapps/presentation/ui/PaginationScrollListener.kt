package com.example.filmapps.presentation.ui

import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmapps.presentation.viewModel.ListCharacterViewModel


open class PaginationScrollListener(private val vm: ListCharacterViewModel, private val status: Boolean, private val progressBar: ProgressBar): RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (dy > 0) {
                val layoutManager = recyclerView.layoutManager as GridLayoutManager
                val visibleItemCount = layoutManager.findLastCompletelyVisibleItemPosition() + 1
                if (visibleItemCount == layoutManager.itemCount && status) {
                    vm.getCharacterList()
                    progressBar.visibility = ProgressBar.VISIBLE
                }
            }
        }
    }