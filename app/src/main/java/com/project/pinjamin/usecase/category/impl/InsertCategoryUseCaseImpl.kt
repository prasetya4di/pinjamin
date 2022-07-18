package com.project.pinjamin.usecase.category.impl

import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.usecase.category.InsertCategoryUseCase
import javax.inject.Inject

class InsertCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : InsertCategoryUseCase {
    override fun invoke(category: Category) {
        categoryRepository.fetchInsert(category)
        categoryRepository.insert(category)
    }
}
