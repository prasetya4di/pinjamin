package com.project.pinjamin.data.source.network.admin

import com.project.pinjamin.data.database.entity.Admin

interface AdminService {
    fun login(username: String, password: String): Pair<Boolean, Admin?>
}
