package com.project.pinjamin.usecase.borrower

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Borrower

interface GetAllBorrowerUseCase {
    operator fun invoke(): LiveData<List<Borrower>>
}
