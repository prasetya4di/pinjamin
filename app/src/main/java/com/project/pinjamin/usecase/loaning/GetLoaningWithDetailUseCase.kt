package com.project.pinjamin.usecase.loaning

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.relation.LoaningWithDetails

interface GetLoaningWithDetailUseCase {
    operator fun invoke(id: Int): LiveData<LoaningWithDetails>
}
