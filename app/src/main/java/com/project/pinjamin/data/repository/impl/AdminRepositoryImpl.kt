package com.project.pinjamin.data.repository.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Admin
import com.project.pinjamin.data.repository.AdminRepository
import com.project.pinjamin.data.source.local.admin.AdminDao
import com.project.pinjamin.data.source.network.admin.AdminService
import javax.inject.Inject

class AdminRepositoryImpl @Inject constructor(
    private val adminDao: AdminDao,
    private val adminService: AdminService
) : AdminRepository {
    override fun login(username: String, password: String): Pair<Boolean, Admin?> =
        adminService.login(username, password)

    override fun getAdmin(): LiveData<Admin> = adminDao.get()
}
