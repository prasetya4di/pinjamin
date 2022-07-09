package com.project.pinjamin.usecase.category.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.usecase.category.GetAllCategoryUseCase
import javax.inject.Inject

class GetAllCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetAllCategoryUseCase {
    override fun invoke(): LiveData<List<Category>> = categoryRepository.get()
}
