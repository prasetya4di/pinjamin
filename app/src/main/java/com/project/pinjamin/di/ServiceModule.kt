package com.project.pinjamin.di

import com.project.pinjamin.data.network.admin.AdminService
import com.project.pinjamin.data.network.admin.impl.AdminServiceImpl
import com.project.pinjamin.data.network.borrower.BorrowerService
import com.project.pinjamin.data.network.borrower.impl.BorrowerServiceImpl
import com.project.pinjamin.data.network.category.CategoryService
import com.project.pinjamin.data.network.category.impl.CategoryServiceImpl
import com.project.pinjamin.data.network.item.ItemService
import com.project.pinjamin.data.network.item.impl.ItemServiceImpl
import com.project.pinjamin.data.network.loaning.LoaningService
import com.project.pinjamin.data.network.loaning.impl.LoaningServiceImpl
import com.project.pinjamin.data.network.loaning_detail.LoaningDetailService
import com.project.pinjamin.data.network.loaning_detail.impl.LoaningDetailServiceImpl
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

    @Provides
    @Singleton
    fun provideBorrowerService(): BorrowerService = BorrowerServiceImpl()

    @Provides
    @Singleton
    fun provideCategoryService(): CategoryService = CategoryServiceImpl()

    @Provides
    @Singleton
    fun provideItemService(): ItemService = ItemServiceImpl()

    @Provides
    @Singleton
    fun provideLoaningService(): LoaningService = LoaningServiceImpl()

    @Provides
    @Singleton
    fun provideLoaningDetailService(): LoaningDetailService = LoaningDetailServiceImpl()
}
