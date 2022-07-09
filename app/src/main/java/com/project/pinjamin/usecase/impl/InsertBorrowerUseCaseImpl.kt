package com.project.pinjamin.usecase.impl

import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.repository.BorrowerRepository
import com.project.pinjamin.enum.Status
import com.project.pinjamin.usecase.InsertBorrowerUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InsertBorrowerUseCaseImpl @Inject constructor(
    private val borrowerRepository: BorrowerRepository
) : InsertBorrowerUseCase {
    override fun invoke(borrower: Borrower): Flow<Status> = flow {
        emit(Status.LOADING)
        borrowerRepository.fetchInsert(borrower)
        borrowerRepository.insert(borrower)
        emit(Status.SUCCESS)
    }
}
