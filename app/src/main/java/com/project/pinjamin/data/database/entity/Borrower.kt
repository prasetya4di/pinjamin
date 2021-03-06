package com.project.pinjamin.data.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "peminjam")
@Parcelize
class Borrower(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_peminjam")
    var idPeminjam: Int = 0,
    @ColumnInfo(name = "nama")
    var nama: String,
    @ColumnInfo(name = "alamat")
    var alamat: String,
    @ColumnInfo(name = "no_hp")
    var noHp: String,
    @ColumnInfo(name = "divisi")
    var divisi: String,
) : Parcelable {
    override fun toString(): String {
        return "$idPeminjam - $nama"
    }
}
