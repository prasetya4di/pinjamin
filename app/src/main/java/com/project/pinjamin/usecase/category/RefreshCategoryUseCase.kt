package com.project.pinjamin.usecase.category

import com.project.pinjamin.enums.Status
import kotlinx.coroutines.flow.Flow

interface RefreshCategoryUseCase {
    operator fun invoke(): Flow<Status>
}
