package com.project.pinjamin.data.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Admin

interface AdminRepository {
    fun login(username: String, password: String): Pair<Boolean, Admin?>
    fun getAdmin(): LiveData<Admin>
    fun insert(admin: Admin)
}
