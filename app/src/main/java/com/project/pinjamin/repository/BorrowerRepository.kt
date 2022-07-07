package com.project.pinjamin.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.Borrower
import kotlinx.coroutines.flow.Flow

interface BorrowerRepository {
    fun insert(borrower: Borrower): Flow<Status>
    fun insert(borrowers: List<Borrower>): Flow<Status>
    fun update(borrower: Borrower): Flow<Status>
    fun delete(borrower: Borrower): Flow<Status>
    fun get(): LiveData<List<Borrower>>
    fun get(id: Int): LiveData<Borrower>
}
