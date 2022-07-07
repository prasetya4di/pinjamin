package com.project.pinjamin.data.local.admin

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.pinjamin.model.entity.Item

@Dao
interface ItemDao {
    @Insert
    fun insert(item: Item)

    @Query("Select * from barang")
    fun get(): LiveData<List<Item>>

    @Query("Select * from barang where id_barang = :id")
    fun get(id: Int): LiveData<Item>

    @Update
    fun update(item: Item)

    @Delete
    fun delete(item: Item)
}
