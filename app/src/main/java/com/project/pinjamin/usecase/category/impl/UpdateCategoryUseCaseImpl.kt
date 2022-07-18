package com.project.pinjamin.usecase.category.impl

import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.usecase.category.UpdateCategoryUseCase
import javax.inject.Inject

class UpdateCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : UpdateCategoryUseCase {
    override fun invoke(category: Category) {
        categoryRepository.fetchUpdate(category)
        categoryRepository.update(category)
    }
}
