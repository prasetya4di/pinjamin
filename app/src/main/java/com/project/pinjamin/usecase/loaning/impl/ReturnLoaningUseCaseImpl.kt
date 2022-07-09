package com.project.pinjamin.usecase.loaning.impl

import com.project.pinjamin.data.database.entity.Loaning
import com.project.pinjamin.data.repository.LoaningRepository
import com.project.pinjamin.enum.Status
import com.project.pinjamin.usecase.loaning.ReturnLoaningUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ReturnLoaningUseCaseImpl @Inject constructor(
    private val loaningRepository: LoaningRepository
) : ReturnLoaningUseCase {
    override fun invoke(loaning: Loaning): Flow<Status> = flow {
        emit(Status.LOADING)
        loaningRepository.fetchUpdate(loaning)
        loaningRepository.update(loaning)
        emit(Status.SUCCESS)
    }
}
