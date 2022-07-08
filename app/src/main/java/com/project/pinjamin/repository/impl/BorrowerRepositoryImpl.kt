package com.project.pinjamin.repository.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.local.borrower.BorrowerDao
import com.project.pinjamin.data.network.borrower.BorrowerService
import com.project.pinjamin.model.entity.Borrower
import com.project.pinjamin.repository.BorrowerRepository
import javax.inject.Inject

class BorrowerRepositoryImpl @Inject constructor(
    private val borrowerDao: BorrowerDao,
    private val borrowerService: BorrowerService
) : BorrowerRepository {
    override fun insert(borrower: Borrower) = borrowerDao.insert(borrower)

    override fun insert(borrowers: List<Borrower>) = borrowerDao.insert(borrowers)

    override fun fetchInsert(borrower: Borrower) = borrowerService.insert(borrower)

    override fun update(borrower: Borrower) = borrowerDao.update(borrower)

    override fun fetchUpdate(borrower: Borrower) = borrowerService.update(borrower)

    override fun delete(borrower: Borrower) = borrowerDao.delete(borrower)

    override fun fetchDelete(borrower: Borrower) = borrowerService.delete(borrower)

    override fun get(): LiveData<List<Borrower>> = borrowerDao.get()

    override fun get(id: Int): LiveData<Borrower> = borrowerDao.get(id)

    override fun fetchGet(): List<Borrower> = borrowerService.get()
}
