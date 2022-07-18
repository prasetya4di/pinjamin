package com.project.pinjamin.ui.item.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.usecase.category.GetAllCategoryUseCase
import com.project.pinjamin.usecase.item.InsertItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateItemViewModel @Inject constructor(
    private val insertItemUseCase: InsertItemUseCase,
    getAllCategoryUseCase: GetAllCategoryUseCase
) : ViewModel() {
    private var _selectedCategory = MutableLiveData<Category>()
    val selectedCategory: LiveData<Category> = _selectedCategory
    val category: LiveData<List<Category>> = getAllCategoryUseCase()

    fun insert(name: String, stok: String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            insertItemUseCase(
                Item(
                    nama = name,
                    stok = Integer.parseInt(stok),
                    deskripsi = description,
                    idKategori = _selectedCategory.value?.idKategori ?: 0
                )
            )
        }
    }

    fun changeCategory(category: Category) {
        _selectedCategory.postValue(category)
    }
}
