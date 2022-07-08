package com.project.pinjamin.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.model.entity.Admin

interface AdminRepository {
    fun login(username: String, password: String): Boolean
    fun getAdmin(): LiveData<Admin>
}
