package com.project.pinjamin.usecase.loaning.impl

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.database.entity.Loaning
import com.project.pinjamin.data.repository.LoaningDetailRepository
import com.project.pinjamin.data.repository.LoaningRepository
import com.project.pinjamin.enum.Status
import com.project.pinjamin.usecase.loaning.InsertLoaningUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InsertLoaningUseCaseImpl @Inject constructor(
    private val loaningRepository: LoaningRepository,
    private val loaningDetailRepository: LoaningDetailRepository
) : InsertLoaningUseCase {
    override fun invoke(loaning: Loaning, items: List<Item>): Flow<Status> = flow {
        emit(Status.LOADING)
        emit(Status.SUCCESS)
    }
}
