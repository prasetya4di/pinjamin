package com.project.pinjamin.data.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "kategori")
@Parcelize
class Category(
    @PrimaryKey
    @ColumnInfo(name = "id_kategori")
    var idKategori: Int,
    @ColumnInfo(name = "nama")
    var nama: String
) : Parcelable
