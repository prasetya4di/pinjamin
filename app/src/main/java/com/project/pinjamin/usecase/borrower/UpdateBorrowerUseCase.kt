package com.project.pinjamin.usecase.borrower

import com.project.pinjamin.data.database.entity.Borrower

interface UpdateBorrowerUseCase {
    operator fun invoke(borrower: Borrower)
}
