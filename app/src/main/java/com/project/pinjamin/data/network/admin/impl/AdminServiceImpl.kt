package com.project.pinjamin.data.network.admin.impl

import com.project.pinjamin.data.network.admin.AdminService
import com.project.pinjamin.enum.Status
import kotlinx.coroutines.flow.Flow

class AdminServiceImpl : AdminService {
    override fun login(username: String, password: String): Flow<Status> {
        TODO("Not yet implemented")
    }
}
