package com.project.pinjamin.ui.category.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.usecase.category.GetCategoryUseCase
import com.project.pinjamin.usecase.category.UpdateCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateCategoryViewModel @Inject constructor(
    private val updateCategoryUseCase: UpdateCategoryUseCase,
    private val getCategoryUseCase: GetCategoryUseCase
) : ViewModel() {
    private val _category = MutableLiveData<Category>()
    var category: LiveData<Category> = _category

    fun update(categoryName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val newCategory = category.value
            newCategory?.nama = categoryName
            newCategory?.let { updateCategoryUseCase(it) }
        }
    }

    fun getCategory(idCategory: Int) {
        category = getCategoryUseCase(idCategory)
    }
}
