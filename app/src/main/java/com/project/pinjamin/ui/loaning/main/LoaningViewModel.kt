package com.project.pinjamin.ui.loaning.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.pinjamin.data.database.relation.LoaningWithDetails
import com.project.pinjamin.usecase.loaning.GetLoaningsWithDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoaningViewModel @Inject constructor(
    getLoaningsWithDetailUseCase: GetLoaningsWithDetailUseCase
) : ViewModel() {
    val loanings: LiveData<List<LoaningWithDetails>> = getLoaningsWithDetailUseCase()
}
