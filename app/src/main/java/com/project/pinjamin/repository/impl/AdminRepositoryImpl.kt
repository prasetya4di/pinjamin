package com.project.pinjamin.repository.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.local.admin.AdminDao
import com.project.pinjamin.data.network.admin.AdminService
import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.Admin
import com.project.pinjamin.repository.AdminRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AdminRepositoryImpl @Inject constructor(
    private val adminDao: AdminDao,
    private val adminService: AdminService
) : AdminRepository {
    override fun login(username: String, password: String): Flow<Status> =
        adminService.login(username, password)

    override fun getAdmin(): LiveData<Admin> = adminDao.get()
}
