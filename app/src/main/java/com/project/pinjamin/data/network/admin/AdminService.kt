package com.project.pinjamin.data.network.admin

import com.project.pinjamin.enum.Status
import kotlinx.coroutines.flow.Flow

interface AdminService {
    fun login(username: String, password: String): Flow<Status>
}
