package com.project.pinjamin.data.source.local.item

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.pinjamin.data.database.entity.Item

@Dao
interface ItemDao {
    @Insert
    fun insert(item: Item)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(items: List<Item>)

    @Query("Select * from barang")
    fun get(): LiveData<List<Item>>

    @Query("Select * from barang where id_barang = :id")
    fun get(id: Int): LiveData<Item>

    @Update
    fun update(item: Item)

    @Delete
    fun delete(item: Item)
}
