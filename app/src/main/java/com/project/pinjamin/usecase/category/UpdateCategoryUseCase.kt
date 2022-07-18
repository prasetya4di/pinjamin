package com.project.pinjamin.usecase.category

import com.project.pinjamin.data.database.entity.Category

interface UpdateCategoryUseCase {
    operator fun invoke(category: Category)
}
