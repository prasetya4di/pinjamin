package com.project.pinjamin.usecase

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Borrower
import kotlinx.coroutines.flow.Flow

interface GetAllBorrowerUseCase {
    operator fun invoke(): Flow<LiveData<List<Borrower>>>
}
