package com.project.pinjamin.data.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.project.pinjamin.data.database.entity.Admin
import com.project.pinjamin.data.database.entity.Borrower
import com.project.pinjamin.data.database.entity.Loaning
import com.project.pinjamin.data.database.entity.LoaningDetail

data class LoaningWithDetails(
    @Embedded
    val loaning: Loaning,
    @Relation(
        parentColumn = "id_admin",
        entityColumn = "id_admin"
    )
    val admin: Admin,
    @Relation(
        parentColumn = "id_peminjam",
        entityColumn = "id_peminjam"
    )
    val borrower: Borrower,
    @Relation(
        entity = LoaningDetail::class,
        parentColumn = "id_peminjaman",
        entityColumn = "id_peminjaman"
    )
    val loaningDetail: List<LoaningDetailWithItem>
)
