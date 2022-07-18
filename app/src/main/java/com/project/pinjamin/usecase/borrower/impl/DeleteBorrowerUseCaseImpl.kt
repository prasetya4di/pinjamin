package com.project.pinjamin.usecase.borrower.impl

import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.repository.BorrowerRepository
import com.project.pinjamin.usecase.borrower.DeleteBorrowerUseCase
import javax.inject.Inject

class DeleteBorrowerUseCaseImpl @Inject constructor(
    private val borrowerRepository: BorrowerRepository
) : DeleteBorrowerUseCase {
    override fun invoke(borrower: Borrower) {
        borrowerRepository.delete(borrower)
        borrowerRepository.fetchDelete(borrower)
    }
}
