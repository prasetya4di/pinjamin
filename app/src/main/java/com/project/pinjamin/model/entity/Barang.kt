package com.project.pinjamin.model.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "barang")
@Parcelize
class Barang(
        @PrimaryKey
        @ColumnInfo(name = "id_barang")
        var idBarang: Int,
        @ColumnInfo(name = "id_kategori")
        var idKategori: Int,
        @ColumnInfo(name = "nama")
        var nama: String,
        @ColumnInfo(name = "stok")
        var stok: Int,
        @ColumnInfo(name = "deskripsi")
        var deskripsi: String,
        @ColumnInfo(name = "status")
        var status: String,
        @ColumnInfo(name = "foto")
        var foto: String
) : Parcelable
