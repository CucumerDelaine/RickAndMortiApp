package com.example.feature_characterlist_impl.presentation.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.core_db_api.model.Character


class DiffUtilCharList(
    private val values: List<Character?>,
    private val valuesOld: List<Character?>
) : DiffUtil.Callback() {

    override fun getOldListSize() = valuesOld.size
    override fun getNewListSize() = values.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldChar = valuesOld[oldItemPosition]
        val char = values[newItemPosition]
        return char?.id == oldChar?.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldChar = valuesOld[oldItemPosition]
        val char = values[newItemPosition]
        return char == oldChar
    }
}