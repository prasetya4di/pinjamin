package com.project.pinjamin.usecase.category.impl

import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.usecase.category.DeleteCategoryUseCase
import javax.inject.Inject

class DeleteCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : DeleteCategoryUseCase {
    override fun invoke(category: Category) {
        categoryRepository.fetchDelete(category)
        categoryRepository.delete(category)
    }
}
