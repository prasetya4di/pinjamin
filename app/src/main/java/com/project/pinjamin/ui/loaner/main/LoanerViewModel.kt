package com.project.pinjamin.ui.loaner.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.usecase.borrower.DeleteBorrowerUseCase
import com.project.pinjamin.usecase.borrower.GetAllBorrowerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoanerViewModel @Inject constructor(
    getAllBorrowerUseCase: GetAllBorrowerUseCase,
    private val deleteBorrowerUseCase: DeleteBorrowerUseCase
) : ViewModel() {
    val borrowers: LiveData<List<Borrower>> = getAllBorrowerUseCase()

    fun delete(borrower: Borrower) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteBorrowerUseCase(borrower)
        }
    }
}
