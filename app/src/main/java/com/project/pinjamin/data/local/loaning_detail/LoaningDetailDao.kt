package com.project.pinjamin.data.local.loaning_detail

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.pinjamin.model.entity.LoaningDetail

@Dao
interface LoaningDetailDao {
    @Insert
    fun insert(loaningDetail: LoaningDetail)

    @Insert
    fun insert(loaningDetail: List<LoaningDetail>)

    @Query("Select * from detail_peminjaman")
    fun get(): LiveData<List<LoaningDetail>>

    @Query("Select * from detail_peminjaman where id_detail_peminjaman = :id")
    fun get(id: Int): LiveData<LoaningDetail>

    @Update
    fun update(loaningDetail: LoaningDetail)

    @Delete
    fun delete(loaningDetail: LoaningDetail)
}
