package com.project.pinjamin.usecase.loaning

import com.project.pinjamin.data.database.entity.Loaning

interface ReturnLoaningUseCase {
    operator fun invoke(loaning: Loaning)
}
