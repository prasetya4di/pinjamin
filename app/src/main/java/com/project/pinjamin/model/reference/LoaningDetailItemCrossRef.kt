package com.project.pinjamin.model.reference

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["id_detail_peminjaman", "id_barang"])
data class LoaningDetailItemCrossRef(
    @ColumnInfo(name = "id_detail_peminjaman")
    val idDetailPeminjaman: Int,
    @ColumnInfo(name = "id_barang")
    val idBarang: Int
)
