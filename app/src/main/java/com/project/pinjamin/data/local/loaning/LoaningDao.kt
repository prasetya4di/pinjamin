package com.project.pinjamin.data.local.loaning

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.pinjamin.model.entity.Loaning
import com.project.pinjamin.model.relation.LoaningWithDetails

@Dao
interface LoaningDao {
    @Insert
    fun insert(loaning: Loaning)

    @Insert
    fun insert(loanings: List<Loaning>)

    @Query("Select * from peminjaman")
    fun get(): LiveData<List<Loaning>>

    @Query("Select * from peminjaman where id_peminjaman = :id")
    fun get(id: Int): LiveData<Loaning>

    @Transaction
    @Query("Select * from peminjaman")
    fun getLoaningWithDetails(): LiveData<List<LoaningWithDetails>>

    @Update
    fun update(loaning: Loaning)

    @Delete
    fun delete(loaning: Loaning)
}
