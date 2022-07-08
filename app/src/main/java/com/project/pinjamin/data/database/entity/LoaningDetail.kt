package com.project.pinjamin.data.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "detail_peminjaman")
@Parcelize
class LoaningDetail(
    @PrimaryKey
    @ColumnInfo(name = "id_detail_peminjaman")
    var idDetailPeminjaman: Int,
    @ColumnInfo(name = "id_peminjaman")
    var idPeminjaman: Int
) : Parcelable
