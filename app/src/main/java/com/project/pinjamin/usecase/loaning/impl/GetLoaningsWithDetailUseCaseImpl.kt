package com.project.pinjamin.usecase.loaning.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.relation.LoaningWithDetails
import com.project.pinjamin.data.repository.LoaningRepository
import com.project.pinjamin.usecase.loaning.GetLoaningsWithDetailUseCase
import javax.inject.Inject

class GetLoaningsWithDetailUseCaseImpl @Inject constructor(
    private val loaningRepository: LoaningRepository
) : GetLoaningsWithDetailUseCase {
    override fun invoke(): LiveData<List<LoaningWithDetails>> =
        loaningRepository.getLoaningWithDetails()
}
