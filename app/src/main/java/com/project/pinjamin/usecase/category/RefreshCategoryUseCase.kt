package com.project.pinjamin.usecase.category

import com.project.pinjamin.enum.Status
import kotlinx.coroutines.flow.Flow

interface RefreshCategoryUseCase {
    operator fun invoke(): Flow<Status>
}
