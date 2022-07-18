package com.project.pinjamin.data.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "barang")
@Parcelize
class Item(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id_barang")
        var idBarang: Int = 0,
        @ColumnInfo(name = "id_kategori")
        var idKategori: Int,
        @ColumnInfo(name = "nama")
        var nama: String,
        @ColumnInfo(name = "stok")
        var stok: Int,
        @ColumnInfo(name = "deskripsi")
        var deskripsi: String? = null,
        @ColumnInfo(name = "status")
        var status: String? = null,
        @ColumnInfo(name = "foto")
        var foto: String? = null
) : Parcelable
