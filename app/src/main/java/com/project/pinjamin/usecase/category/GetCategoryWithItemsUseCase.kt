package com.project.pinjamin.usecase.category

import com.project.pinjamin.data.database.relation.CategoryWithItems

interface GetCategoryWithItemsUseCase {
    operator fun invoke(idCategory: Int): CategoryWithItems
}
