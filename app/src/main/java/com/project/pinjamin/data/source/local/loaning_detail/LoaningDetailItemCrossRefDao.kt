package com.project.pinjamin.data.source.local.loaning_detail

import androidx.room.Dao
import androidx.room.Insert
import com.project.pinjamin.data.database.reference.LoaningDetailItemCrossRef

@Dao
interface LoaningDetailItemCrossRefDao {
    @Insert
    fun insert(loaningDetailItemCrossRef: LoaningDetailItemCrossRef)
}
