package com.project.pinjamin.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.model.entity.LoaningDetail

interface LoaningDetailRepository {
    fun insert(loaningDetail: LoaningDetail)
    fun insert(loaningDetail: List<LoaningDetail>)
    fun fetchInsert(loaningDetail: LoaningDetail)
    fun update(loaningDetail: LoaningDetail)
    fun fetchUpdate(loaningDetail: LoaningDetail)
    fun delete(loaningDetail: LoaningDetail)
    fun fetchDelete(loaningDetail: LoaningDetail)
    fun get(): LiveData<List<LoaningDetail>>
    fun get(id: Int): LiveData<LoaningDetail>
    fun fetchGet(): List<LoaningDetail>
}
