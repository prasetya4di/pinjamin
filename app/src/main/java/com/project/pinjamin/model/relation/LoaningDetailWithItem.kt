package com.project.pinjamin.model.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.project.pinjamin.model.entity.Item
import com.project.pinjamin.model.entity.LoaningDetail
import com.project.pinjamin.model.reference.LoaningDetailItemCrossRef

data class LoaningDetailWithItem(
    @Embedded val loaningDetail: LoaningDetail,
    @Relation(
        parentColumn = "id_detail_peminjaman",
        entityColumn = "id_barang",
        associateBy = Junction(LoaningDetailItemCrossRef::class)
    )
    val item: Item
)
