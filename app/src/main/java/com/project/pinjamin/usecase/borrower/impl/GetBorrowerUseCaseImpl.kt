package com.project.pinjamin.usecase.borrower.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.repository.BorrowerRepository
import com.project.pinjamin.usecase.borrower.GetBorrowerUseCase
import javax.inject.Inject

class GetBorrowerUseCaseImpl @Inject constructor(
    private val borrowerRepository: BorrowerRepository
) : GetBorrowerUseCase {
    override fun invoke(id: Int): LiveData<Borrower> = borrowerRepository.get(id)
}
