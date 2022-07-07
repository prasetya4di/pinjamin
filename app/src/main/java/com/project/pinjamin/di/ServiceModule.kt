package com.project.pinjamin.di

import com.project.pinjamin.data.network.admin.AdminService
import com.project.pinjamin.data.network.admin.impl.AdminServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideAdminService(): AdminService = AdminServiceImpl()
}
