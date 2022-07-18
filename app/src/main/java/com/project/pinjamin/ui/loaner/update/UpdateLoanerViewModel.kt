package com.project.pinjamin.ui.loaner.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.usecase.borrower.GetBorrowerUseCase
import com.project.pinjamin.usecase.borrower.UpdateBorrowerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateLoanerViewModel @Inject constructor(
    private val getBorrowerUseCase: GetBorrowerUseCase,
    private val updateBorrowerUseCase: UpdateBorrowerUseCase
) : ViewModel() {
    private var _borrower = MutableLiveData<Borrower>()
    var borrower: LiveData<Borrower> = _borrower

    fun update(name: String, phoneNumber: String, address: String, division: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val borrower = borrower.value
            borrower?.nama = name
            borrower?.noHp = phoneNumber
            borrower?.alamat = address
            borrower?.divisi = division
            if (borrower != null) {
                updateBorrowerUseCase(borrower)
            }
        }
    }

    fun get(idBorrower: Int) {
        borrower = getBorrowerUseCase(idBorrower)
    }
}
