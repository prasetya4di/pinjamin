package com.project.pinjamin.usecase.loaning.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.relation.LoaningWithDetails
import com.project.pinjamin.data.repository.LoaningRepository
import com.project.pinjamin.usecase.loaning.GetLoaningWithDetailUseCase
import javax.inject.Inject

class GetLoaningWithDetailUseCaseImpl @Inject constructor(
    private val loaningRepository: LoaningRepository
) : GetLoaningWithDetailUseCase {
    override fun invoke(id: Int): LiveData<LoaningWithDetails> =
        loaningRepository.getLoaningWithDetails(id)
}
