package com.project.pinjamin.data.source.local.admin

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.pinjamin.data.database.entity.Admin

@Dao
interface AdminDao {
    @Insert
    fun insert(admin: Admin)

    @Query("Select * from admin limit 1")
    fun get(): LiveData<Admin>

    @Update
    fun update(admin: Admin)

    @Delete
    fun delete(admin: Admin)
}
