package com.project.pinjamin.usecase.borrower

import com.project.pinjamin.enums.Status
import kotlinx.coroutines.flow.Flow

interface RefreshBorrowerUseCase {
    operator fun invoke(): Flow<Status>
}
