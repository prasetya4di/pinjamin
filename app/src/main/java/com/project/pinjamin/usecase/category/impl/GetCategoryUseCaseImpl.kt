package com.project.pinjamin.usecase.category.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.usecase.category.GetCategoryUseCase
import javax.inject.Inject

class GetCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetCategoryUseCase {
    override fun invoke(id: Int): LiveData<Category> = categoryRepository.get(id)
}
