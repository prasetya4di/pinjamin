package com.project.pinjamin.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.Admin
import kotlinx.coroutines.flow.Flow

interface AdminRepository {
    fun login(username: String, password: String): Flow<Status>
    fun getAdmin(): LiveData<Admin>
}
