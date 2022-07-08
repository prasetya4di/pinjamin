package com.project.pinjamin.data.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Admin

interface AdminRepository {
    fun login(username: String, password: String): Boolean
    fun getAdmin(): LiveData<Admin>
}
