package com.project.pinjamin.ui.item.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.usecase.category.GetAllCategoryUseCase
import com.project.pinjamin.usecase.item.GetItemUseCase
import com.project.pinjamin.usecase.item.UpdateItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateItemViewModel @Inject constructor(
    private val getItemUseCase: GetItemUseCase,
    private val updateItemUseCase: UpdateItemUseCase,
    getAllCategoryUseCase: GetAllCategoryUseCase
) : ViewModel() {
    private val _item = MutableLiveData<Item>()
    private val _selectedCategory = MutableLiveData<Category>()
    var item: LiveData<Item> = _item
    val category: LiveData<List<Category>> = getAllCategoryUseCase()
    val selectedCategory: LiveData<Category> = _selectedCategory


    fun updateItem(name: String, stok: String, description: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val item = item.value
            item?.nama = name
            item?.stok = Integer.parseInt(stok)
            item?.deskripsi = description
            selectedCategory.value?.let {
                item?.idKategori = it.idKategori
            }
            if (item != null) {
                updateItemUseCase(item)
            }
        }
    }

    fun getItem(idItem: Int) {
        item = getItemUseCase(idItem)
    }

    fun changeCategory(category: Category) {
        _selectedCategory.postValue(category)
    }
}
