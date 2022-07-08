package com.project.pinjamin.data.source.network.admin

interface AdminService {
    fun login(username: String, password: String): Boolean
}
