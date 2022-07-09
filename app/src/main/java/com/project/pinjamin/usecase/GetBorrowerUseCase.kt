package com.project.pinjamin.usecase

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Borrower

interface GetBorrowerUseCase {
    operator fun invoke(id: Int): LiveData<Borrower>
}
