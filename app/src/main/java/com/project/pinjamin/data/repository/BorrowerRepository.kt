package com.project.pinjamin.data.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Borrower

interface BorrowerRepository {
    fun insert(borrower: Borrower)
    fun insert(borrowers: List<Borrower>)
    fun fetchInsert(borrower: Borrower)
    fun update(borrower: Borrower)
    fun fetchUpdate(borrower: Borrower)
    fun delete(borrower: Borrower)
    fun fetchDelete(borrower: Borrower)
    fun get(): LiveData<List<Borrower>>
    fun get(id: Int): LiveData<Borrower>
    fun fetchGet(): List<Borrower>
}
