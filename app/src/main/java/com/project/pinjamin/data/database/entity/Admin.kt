package com.project.pinjamin.data.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "admin")
@Parcelize
class Admin(
    @PrimaryKey
    @ColumnInfo(name = "id_admin")
    var idAdmin: Int,
    @ColumnInfo(name = "username")
    var username: String,
    @ColumnInfo(name = "nama")
    var nama: String,
    @ColumnInfo(name = "no_hp")
    var noHp: String,
    @ColumnInfo(name = "alamat")
    var alamat: String,
) : Parcelable
