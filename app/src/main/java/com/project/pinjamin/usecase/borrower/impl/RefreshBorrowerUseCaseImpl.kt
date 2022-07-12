package com.project.pinjamin.usecase.borrower.impl

import com.project.pinjamin.data.repository.BorrowerRepository
import com.project.pinjamin.enums.Status
import com.project.pinjamin.usecase.borrower.RefreshBorrowerUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RefreshBorrowerUseCaseImpl @Inject constructor(
    private val borrowerRepository: BorrowerRepository
) : RefreshBorrowerUseCase {
    override fun invoke(): Flow<Status> = flow {
        emit(Status.LOADING)
        val borrowers = borrowerRepository.fetchGet()
        borrowerRepository.insert(borrowers)
        emit(Status.SUCCESS)
    }
}
