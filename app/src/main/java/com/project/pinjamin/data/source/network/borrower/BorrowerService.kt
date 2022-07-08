package com.project.pinjamin.data.source.network.borrower

import com.project.pinjamin.data.database.entity.Borrower

interface BorrowerService {
    fun insert(borrower: Borrower)
    fun update(borrower: Borrower)
    fun delete(borrower: Borrower)
    fun get(): List<Borrower>
}
