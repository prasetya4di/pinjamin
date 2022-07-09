package com.project.pinjamin.data.source.local.borrower

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.pinjamin.data.database.entity.Borrower

@Dao
interface BorrowerDao {
    @Insert
    fun insert(borrower: Borrower)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
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
