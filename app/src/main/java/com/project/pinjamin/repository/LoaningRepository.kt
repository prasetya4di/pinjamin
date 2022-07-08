package com.project.pinjamin.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.model.entity.Loaning
import com.project.pinjamin.model.relation.LoaningWithDetails

interface LoaningRepository {
    fun insert(loaning: Loaning)
    fun insert(loanings: List<Loaning>)
    fun fetchInsert(loaning: Loaning)
    fun update(loaning: Loaning)
    fun fetchUpdate(loaning: Loaning)
    fun delete(loaning: Loaning)
    fun fetchDelete(loaning: Loaning)
    fun get(): LiveData<List<Loaning>>
    fun get(id: Int): LiveData<Loaning>
    fun getLoaningWithDetails(): LiveData<List<LoaningWithDetails>>
    fun fetchGet(): List<Loaning>
}
