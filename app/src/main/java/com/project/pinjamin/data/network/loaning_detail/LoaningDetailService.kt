package com.project.pinjamin.data.network.loaning_detail

import com.project.pinjamin.model.entity.LoaningDetail

interface LoaningDetailService {
    fun insert(loaningDetail: LoaningDetail)
    fun update(loaningDetail: LoaningDetail)
    fun delete(loaningDetail: LoaningDetail)
    fun get(): List<LoaningDetail>
}
