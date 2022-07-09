package com.project.pinjamin.usecase.borrower.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.repository.BorrowerRepository
import com.project.pinjamin.usecase.borrower.GetAllBorrowerUseCase
import javax.inject.Inject

class GetAllBorrowerUseCaseImpl @Inject constructor(
    private val borrowerRepository: BorrowerRepository
) : GetAllBorrowerUseCase {
    override fun invoke(): LiveData<List<Borrower>> = borrowerRepository.get()
}
