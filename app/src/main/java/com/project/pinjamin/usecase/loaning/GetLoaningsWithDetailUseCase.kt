package com.project.pinjamin.usecase.loaning

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.relation.LoaningWithDetails

interface GetLoaningsWithDetailUseCase {
    operator fun invoke(): LiveData<List<LoaningWithDetails>>
}
