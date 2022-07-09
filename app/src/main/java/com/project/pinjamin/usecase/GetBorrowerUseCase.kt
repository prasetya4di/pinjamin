package com.project.pinjamin.usecase

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Borrower
import kotlinx.coroutines.flow.Flow

interface GetBorrowerUseCase {
    operator fun invoke(id: Int): Flow<LiveData<Borrower>>
}
