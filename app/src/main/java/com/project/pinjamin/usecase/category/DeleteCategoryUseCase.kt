package com.project.pinjamin.usecase.category

import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.enum.Status
import kotlinx.coroutines.flow.Flow

interface DeleteCategoryUseCase {
    operator fun invoke(category: Category): Flow<Status>
}
