package com.project.pinjamin.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.LoaningDetail
import kotlinx.coroutines.flow.Flow

interface LoaningDetailRepository {
    fun insert(loaningDetail: LoaningDetail): Flow<Status>
    fun update(loaningDetail: LoaningDetail): Flow<Status>
    fun delete(loaningDetail: LoaningDetail): Flow<Status>
    fun get(): LiveData<List<LoaningDetail>>
    fun get(id: Int): LiveData<LoaningDetail>
}
