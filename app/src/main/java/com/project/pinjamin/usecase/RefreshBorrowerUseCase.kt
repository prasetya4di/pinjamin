package com.project.pinjamin.usecase

import com.project.pinjamin.enum.Status
import kotlinx.coroutines.flow.Flow

interface RefreshBorrowerUseCase {
    operator fun invoke(): Flow<Status>
}
