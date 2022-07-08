package com.project.pinjamin.data.repository.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Loaning
import com.project.pinjamin.data.database.relation.LoaningWithDetails
import com.project.pinjamin.data.repository.LoaningRepository
import com.project.pinjamin.data.source.local.loaning.LoaningDao
import com.project.pinjamin.data.source.network.loaning.LoaningService
import javax.inject.Inject

class LoaningRepositoryImpl @Inject constructor(
    private val loaningDao: LoaningDao,
    private val loaningService: LoaningService
) : LoaningRepository {
    override fun insert(loaning: Loaning) = loaningDao.insert(loaning)

    override fun insert(loanings: List<Loaning>) = loaningDao.insert(loanings)

    override fun fetchInsert(loaning: Loaning) = loaningService.insert(loaning)

    override fun update(loaning: Loaning) = loaningDao.update(loaning)

    override fun fetchUpdate(loaning: Loaning) = loaningService.update(loaning)

    override fun delete(loaning: Loaning) = loaningDao.delete(loaning)

    override fun fetchDelete(loaning: Loaning) = loaningService.delete(loaning)

    override fun get(): LiveData<List<Loaning>> = loaningDao.get()

    override fun get(id: Int): LiveData<Loaning> = loaningDao.get(id)

    override fun getLoaningWithDetails(): LiveData<List<LoaningWithDetails>> =
        loaningDao.getLoaningWithDetails()

    override fun fetchGet(): List<Loaning> = loaningService.get()
}
