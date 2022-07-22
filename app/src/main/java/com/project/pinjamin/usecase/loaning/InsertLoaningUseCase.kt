package com.project.pinjamin.usecase.loaning

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.database.entity.Loaning

interface InsertLoaningUseCase {
    operator fun invoke(loaning: Loaning, items: List<Item>)
}
