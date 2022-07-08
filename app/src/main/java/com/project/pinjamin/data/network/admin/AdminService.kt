package com.project.pinjamin.data.network.admin

interface AdminService {
    fun login(username: String, password: String): Boolean
}
