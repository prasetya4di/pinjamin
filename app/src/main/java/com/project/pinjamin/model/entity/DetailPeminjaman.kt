package com.project.pinjamin.model.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "detail_peminjaman")
@Parcelize
class DetailPeminjaman(
    @PrimaryKey
    @ColumnInfo(name = "id_detail_peminjaman")
    var idDetailPeminjaman: Int,
    @ColumnInfo(name = "id_peminjaman")
    var idPeminjaman: Int,
    @ColumnInfo(name = "id_barang")
    var idBarang: Int
) : Parcelable
