package com.project.pinjamin.usecase.category

import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.enums.Status
import kotlinx.coroutines.flow.Flow

interface UpdateCategoryUseCase {
    operator fun invoke(category: Category): Flow<Status>
}
