package com.project.pinjamin.di

import com.project.pinjamin.data.local.admin.AdminDao
import com.project.pinjamin.data.network.admin.AdminService
import com.project.pinjamin.repository.AdminRepository
import com.project.pinjamin.repository.impl.AdminRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideAdminRepository(adminDao: AdminDao, adminService: AdminService): AdminRepository =
        AdminRepositoryImpl(adminDao, adminService)
}
