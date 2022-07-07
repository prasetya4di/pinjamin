package com.project.pinjamin.data.local.borrower

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.pinjamin.model.entity.Borrower

@Dao
interface BorrowerDao {
    @Insert
    fun insert(borrower: Borrower)

    @Insert
    fun insert(borrowers: List<Borrower>)

    @Query("Select * from peminjam")
    fun get(): LiveData<List<Borrower>>

    @Query("Select * from peminjam where id_peminjam = :id")
    fun get(id: Int): LiveData<Borrower>

    @Update
    fun update(borrower: Borrower)

    @Delete
    fun delete(borrower: Borrower)
}
