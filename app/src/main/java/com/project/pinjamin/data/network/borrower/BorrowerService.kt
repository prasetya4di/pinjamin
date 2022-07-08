package com.project.pinjamin.data.network.borrower

import com.project.pinjamin.model.entity.Borrower

interface BorrowerService {
    fun insert(borrower: Borrower)
    fun update(borrower: Borrower)
    fun delete(borrower: Borrower)
    fun get(): List<Borrower>
}
