package com.project.pinjamin.usecase.category.impl

import com.project.pinjamin.data.database.relation.CategoryWithItems
import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.usecase.category.GetCategoryWithItemsUseCase
import javax.inject.Inject

class GetCategoryWithItemsUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetCategoryWithItemsUseCase {
    override fun invoke(idCategory: Int): CategoryWithItems =
        categoryRepository.getCategoryWithItems(idCategory)
}
