package com.project.pinjamin.usecase.borrower

import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.enum.Status
import kotlinx.coroutines.flow.Flow

interface UpdateBorrowerUseCase {
    operator fun invoke(borrower: Borrower): Flow<Status>
}
