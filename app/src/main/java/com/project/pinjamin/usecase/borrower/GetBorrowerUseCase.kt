package com.project.pinjamin.usecase.borrower

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Borrower

interface GetBorrowerUseCase {
    operator fun invoke(id: Int): LiveData<Borrower>
}
