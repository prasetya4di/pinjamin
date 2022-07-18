package com.project.pinjamin.usecase.borrower

import com.project.pinjamin.data.database.entity.Borrower

interface InsertBorrowerUseCase {
    operator fun invoke(borrower: Borrower)
}
