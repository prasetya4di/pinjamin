package com.project.pinjamin.usecase.loaning

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.database.entity.Loaning
import com.project.pinjamin.enum.Status
import kotlinx.coroutines.flow.Flow

interface InsertLoaningUseCase {
    operator fun invoke(loaning: Loaning, items: List<Item>): Flow<Status>
}
