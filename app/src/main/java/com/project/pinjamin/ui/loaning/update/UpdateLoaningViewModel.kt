package com.project.pinjamin.ui.loaning.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.pinjamin.data.database.relation.LoaningWithDetails
import com.project.pinjamin.usecase.loaning.GetLoaningWithDetailUseCase
import com.project.pinjamin.usecase.loaning.ReturnLoaningUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class UpdateLoaningViewModel @Inject constructor(
    private val getLoaningWithDetailUseCase: GetLoaningWithDetailUseCase,
    private val returnLoaningUseCase: ReturnLoaningUseCase
) : ViewModel() {
    private val _loaningWithDetails: MutableLiveData<LoaningWithDetails> = MutableLiveData()
    private var _returnDate: Date? = null
    var loaningWithDetails: LiveData<LoaningWithDetails> = _loaningWithDetails

    fun getLoaningWithDetails(idLoaning: Int) {
        loaningWithDetails = getLoaningWithDetailUseCase(idLoaning)
    }

    fun updateReturnDate(date: Date) {
        _returnDate = date
    }

    fun update() {
        viewModelScope.launch(Dispatchers.IO) {
            val loaningWithDetails = loaningWithDetails.value
            if (loaningWithDetails != null) {
                loaningWithDetails.loaning.tglPengembalian = _returnDate
                loaningWithDetails.loaning.status = "Dikembalikan"
                val items = loaningWithDetails.loaningDetail.map { it.item }
                returnLoaningUseCase(loaningWithDetails.loaning, items)
            }
        }
    }
}
