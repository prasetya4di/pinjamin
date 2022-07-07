package com.project.pinjamin.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.Loaning
import com.project.pinjamin.model.relation.LoaningWithDetails
import kotlinx.coroutines.flow.Flow

interface LoaningRepository {
    fun insert(loaning: Loaning): Flow<Status>
    fun insert(loanings: List<Loaning>): Flow<Status>
    fun update(loaning: Loaning): Flow<Status>
    fun delete(loaning: Loaning): Flow<Status>
    fun get(): LiveData<List<Loaning>>
    fun get(id: Int): LiveData<Loaning>
    fun getLoaningWithDetails(): LiveData<List<LoaningWithDetails>>
}
