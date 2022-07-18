package com.project.pinjamin.ui.item.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.usecase.item.DeleteItemUseCase
import com.project.pinjamin.usecase.item.GetAllItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    getAllItemUseCase: GetAllItemUseCase,
    private val deleteItemUseCase: DeleteItemUseCase
) : ViewModel() {
    var items = getAllItemUseCase()

    fun delete(item: Item) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteItemUseCase(item)
        }
    }
}
