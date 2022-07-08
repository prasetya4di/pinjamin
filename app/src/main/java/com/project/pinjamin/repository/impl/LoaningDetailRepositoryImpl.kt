package com.project.pinjamin.repository.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.local.loaning_detail.LoaningDetailDao
import com.project.pinjamin.data.network.loaning_detail.LoaningDetailService
import com.project.pinjamin.model.entity.LoaningDetail
import com.project.pinjamin.repository.LoaningDetailRepository
import javax.inject.Inject

class LoaningDetailRepositoryImpl @Inject constructor(
    private val loaningDetailDao: LoaningDetailDao,
    private val loaningDetailService: LoaningDetailService
) : LoaningDetailRepository {
    override fun insert(loaningDetail: LoaningDetail) = loaningDetailDao.insert(loaningDetail)

    override fun insert(loaningDetail: List<LoaningDetail>) = loaningDetailDao.insert(loaningDetail)

    override fun fetchInsert(loaningDetail: LoaningDetail) =
        loaningDetailService.insert(loaningDetail)

    override fun update(loaningDetail: LoaningDetail) = loaningDetailDao.update(loaningDetail)

    override fun fetchUpdate(loaningDetail: LoaningDetail) =
        loaningDetailService.update(loaningDetail)

    override fun delete(loaningDetail: LoaningDetail) = loaningDetailDao.delete(loaningDetail)

    override fun fetchDelete(loaningDetail: LoaningDetail) =
        loaningDetailService.delete(loaningDetail)

    override fun get(): LiveData<List<LoaningDetail>> = loaningDetailDao.get()

    override fun get(id: Int): LiveData<LoaningDetail> = loaningDetailDao.get(id)

    override fun fetchGet(): List<LoaningDetail> = loaningDetailService.get()
}
