package com.project.pinjamin.usecase.borrower.impl

import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.repository.BorrowerRepository
import com.project.pinjamin.enum.Status
import com.project.pinjamin.usecase.borrower.DeleteBorrowerUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteBorrowerUseCaseImpl @Inject constructor(
    private val borrowerRepository: BorrowerRepository
) : DeleteBorrowerUseCase {
    override fun invoke(borrower: Borrower): Flow<Status> = flow {
        emit(Status.LOADING)
        borrowerRepository.delete(borrower)
        borrowerRepository.fetchDelete(borrower)
        emit(Status.SUCCESS)
    }
}
