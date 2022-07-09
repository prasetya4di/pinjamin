package com.project.pinjamin.usecase.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.repository.BorrowerRepository
import com.project.pinjamin.usecase.GetBorrowerUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBorrowerUseCaseImpl @Inject constructor(
    private val borrowerRepository: BorrowerRepository
) : GetBorrowerUseCase {
    override fun invoke(id: Int): Flow<LiveData<Borrower>> = flow {
        emit(borrowerRepository.get(id))
    }
}
