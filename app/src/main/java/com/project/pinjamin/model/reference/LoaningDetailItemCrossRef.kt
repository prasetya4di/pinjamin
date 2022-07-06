package com.project.pinjamin.model.reference

import androidx.room.Entity

@Entity(primaryKeys = ["id_detail_peminjaman", "id_barang"])
data class LoaningDetailItemCrossRef(
    val idDetailPeminjaman: Int,
    val idBarang: Int
)
