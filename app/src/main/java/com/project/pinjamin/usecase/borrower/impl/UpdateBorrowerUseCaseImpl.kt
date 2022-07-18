package com.project.pinjamin.usecase.borrower.impl

import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.repository.BorrowerRepository
import com.project.pinjamin.usecase.borrower.UpdateBorrowerUseCase
import javax.inject.Inject

class UpdateBorrowerUseCaseImpl @Inject constructor(
    private val borrowerRepository: BorrowerRepository
) : UpdateBorrowerUseCase {
    override fun invoke(borrower: Borrower) {
        borrowerRepository.fetchUpdate(borrower)
        borrowerRepository.update(borrower)
    }
}
