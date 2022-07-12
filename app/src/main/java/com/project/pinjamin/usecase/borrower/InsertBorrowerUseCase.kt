package com.project.pinjamin.usecase.borrower

import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.enums.Status
import kotlinx.coroutines.flow.Flow

interface InsertBorrowerUseCase {
    operator fun invoke(borrower: Borrower): Flow<Status>
}
