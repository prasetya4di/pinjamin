package com.project.pinjamin.data.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.database.entity.LoaningDetail
import com.project.pinjamin.data.database.reference.LoaningDetailItemCrossRef

data class LoaningDetailWithItem(
    @Embedded val loaningDetail: LoaningDetail,
    @Relation(
        parentColumn = "id_detail_peminjaman",
        entityColumn = "id_barang",
        associateBy = Junction(LoaningDetailItemCrossRef::class)
    )
    val item: Item
) {
    override fun toString(): String {
        return "${item.nama}"
    }
}
