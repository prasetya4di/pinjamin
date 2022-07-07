package com.project.pinjamin.data.network.borrower

import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.Borrower
import kotlinx.coroutines.flow.Flow

interface BorrowerService {
    fun insert(borrower: Borrower): Flow<Status>
    fun update(borrower: Borrower): Flow<Status>
    fun delete(borrower: Borrower): Flow<Status>
    fun get(): Flow<List<Borrower>>
}
