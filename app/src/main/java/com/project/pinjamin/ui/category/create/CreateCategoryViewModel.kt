package com.project.pinjamin.ui.category.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.enums.Status
import com.project.pinjamin.usecase.category.InsertCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateCategoryViewModel @Inject constructor(
    private val insertCategoryUseCase: InsertCategoryUseCase
) : ViewModel() {
    private val _insertStatus: MutableLiveData<Status> = MutableLiveData()
    var insertStatus: LiveData<Status> = _insertStatus

    fun insertCategory(categoryName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            insertCategoryUseCase(Category(nama = categoryName))
        }
    }

}
