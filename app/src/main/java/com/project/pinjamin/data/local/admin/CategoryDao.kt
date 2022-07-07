package com.project.pinjamin.data.local.admin

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.pinjamin.model.entity.Category
import com.project.pinjamin.model.relation.CategoryWithItems

@Dao
interface CategoryDao {
    @Insert
    fun insert(category: Category)

    @Query("Select * from kategori")
    fun get(): LiveData<List<Category>>

    @Query("Select * from kategori where id_kategori = :id")
    fun get(id: Int): LiveData<Category>

    @Transaction
    @Query("Select * from kategori where id_kategori = :id")
    fun getCategoryWithItems(id: Int): LiveData<CategoryWithItems>

    @Update
    fun update(category: Category)

    @Delete
    fun delete(category: Category)
}
