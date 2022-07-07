package com.project.pinjamin.data.network.loaning_detail

import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.LoaningDetail

interface LoaningDetailInterface {
    fun insert(loaningDetail: LoaningDetail): Status
    fun update(loaningDetail: LoaningDetail): Status
    fun delete(loaningDetail: LoaningDetail): Status
    fun get(): List<LoaningDetail>
}
