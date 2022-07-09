package com.project.pinjamin.usecase.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.repository.BorrowerRepository
import com.project.pinjamin.usecase.GetBorrowerUseCase
import javax.inject.Inject

class GetBorrowerUseCaseImpl @Inject constructor(
    private val borrowerRepository: BorrowerRepository
) : GetBorrowerUseCase {
    override fun invoke(id: Int): LiveData<Borrower> = borrowerRepository.get(id)
}
