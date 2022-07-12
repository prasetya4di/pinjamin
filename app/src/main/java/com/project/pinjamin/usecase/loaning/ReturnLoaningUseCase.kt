package com.project.pinjamin.usecase.loaning

import com.project.pinjamin.data.database.entity.Loaning
import com.project.pinjamin.enums.Status
import kotlinx.coroutines.flow.Flow

interface ReturnLoaningUseCase {
    operator fun invoke(loaning: Loaning): Flow<Status>
}
