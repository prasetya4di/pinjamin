package com.project.pinjamin.data.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "peminjaman")
class Loaning(
    @PrimaryKey
    @ColumnInfo(name = "id_peminjaman")
    var idPeminjaman: Int,
    @ColumnInfo(name = "id_admin")
    var idAdmin: Int,
    @ColumnInfo(name = "id_peminjam")
    var idPeminjam: Int,
    @ColumnInfo(name = "tgl_peminjaman")
    var tglPeminjaman: Date,
    @ColumnInfo(name = "tgl_pengembalian")
    var tglPengembalian: Date,
    @ColumnInfo(name = "status")
    var status: String
) : Parcelable
