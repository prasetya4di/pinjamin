package com.project.pinjamin.usecase.loaning.impl

import com.project.pinjamin.data.database.entity.Loaning
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.data.repository.LoaningRepository
import com.project.pinjamin.usecase.loaning.ReturnLoaningUseCase
import javax.inject.Inject

class ReturnLoaningUseCaseImpl @Inject constructor(
    private val loaningRepository: LoaningRepository,
    private val itemRepository: ItemRepository
) : ReturnLoaningUseCase {
    override fun invoke(loaning: Loaning) {
        loaningRepository.fetchUpdate(loaning)
        loaningRepository.update(loaning)
    }
}
