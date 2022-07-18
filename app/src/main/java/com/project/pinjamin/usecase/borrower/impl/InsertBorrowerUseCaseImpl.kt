package com.project.pinjamin.usecase.borrower.impl

import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.repository.BorrowerRepository
import com.project.pinjamin.usecase.borrower.InsertBorrowerUseCase
import javax.inject.Inject

class InsertBorrowerUseCaseImpl @Inject constructor(
    private val borrowerRepository: BorrowerRepository
) : InsertBorrowerUseCase {
    override fun invoke(borrower: Borrower) {
        borrowerRepository.fetchInsert(borrower)
        borrowerRepository.insert(borrower)
    }
}
