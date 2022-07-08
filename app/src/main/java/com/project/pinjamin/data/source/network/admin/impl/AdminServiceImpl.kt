package com.project.pinjamin.data.source.network.admin.impl

import com.project.pinjamin.data.database.entity.Admin
import com.project.pinjamin.data.source.network.admin.AdminService

class AdminServiceImpl : AdminService {
    override fun login(username: String, password: String): Pair<Boolean, Admin?> {
        TODO("Not yet implemented")
    }
}
