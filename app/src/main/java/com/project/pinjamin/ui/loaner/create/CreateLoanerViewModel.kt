package com.project.pinjamin.ui.loaner.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.usecase.borrower.InsertBorrowerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateLoanerViewModel @Inject constructor(
    private val insertBorrowerUseCase: InsertBorrowerUseCase
) : ViewModel() {
    fun insert(name: String, phoneNumber: String, address: String, division: String) {
        viewModelScope.launch(Dispatchers.IO) {
            insertBorrowerUseCase(
                Borrower(
                    nama = name,
                    noHp = phoneNumber,
                    alamat = address,
                    divisi = division
                )
            )
        }
    }
}
