package com.project.pinjamin.usecase.category

import com.project.pinjamin.data.database.entity.Category

interface InsertCategoryUseCase {
    operator fun invoke(category: Category)
}
