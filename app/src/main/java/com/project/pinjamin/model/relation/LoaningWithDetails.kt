package com.project.pinjamin.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.project.pinjamin.model.entity.Admin
import com.project.pinjamin.model.entity.Borrower
import com.project.pinjamin.model.entity.Loaning
import com.project.pinjamin.model.entity.LoaningDetail

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
        parentColumn = "id_kategori",
        entityColumn = "id_kategori"
    )
    val loaningDetail: List<LoaningDetailWithItem>
)
