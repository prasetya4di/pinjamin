package com.project.pinjamin.ui.category.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.usecase.category.DeleteCategoryUseCase
import com.project.pinjamin.usecase.category.GetAllCategoryUseCase
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    getAllCategoryUseCase: GetAllCategoryUseCase,
    private val deleteCategoryUseCase: DeleteCategoryUseCase
) : ViewModel() {
    val categories: LiveData<List<Category>> = getAllCategoryUseCase()
    fun deleteCategory(category: Category) {
        Completable.fromAction {
            deleteCategoryUseCase(category)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .subscribe()
    }
}
