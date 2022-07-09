package com.project.pinjamin.usecase.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.repository.BorrowerRepository
import com.project.pinjamin.usecase.GetAllBorrowerUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllBorrowerUseCaseImpl @Inject constructor(
    private val borrowerRepository: BorrowerRepository
) : GetAllBorrowerUseCase {
    override fun invoke(): Flow<LiveData<List<Borrower>>> = flow {
        emit(borrowerRepository.get())
    }
}
