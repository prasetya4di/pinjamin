package com.project.pinjamin.data.network.borrower

import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.Borrower

interface BorrowerService {
    fun insert(borrower: Borrower): Status
    fun update(borrower: Borrower): Status
    fun delete(borrower: Borrower): Status
    fun get(): List<Borrower>
}
