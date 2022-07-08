package com.project.pinjamin.di

import com.project.pinjamin.data.source.network.admin.AdminService
import com.project.pinjamin.data.source.network.admin.impl.AdminServiceImpl
import com.project.pinjamin.data.source.network.borrower.BorrowerService
import com.project.pinjamin.data.source.network.borrower.impl.BorrowerServiceImpl
import com.project.pinjamin.data.source.network.category.CategoryService
import com.project.pinjamin.data.source.network.category.impl.CategoryServiceImpl
import com.project.pinjamin.data.source.network.item.ItemService
import com.project.pinjamin.data.source.network.item.impl.ItemServiceImpl
import com.project.pinjamin.data.source.network.loaning.LoaningService
import com.project.pinjamin.data.source.network.loaning.impl.LoaningServiceImpl
import com.project.pinjamin.data.source.network.loaning_detail.LoaningDetailService
import com.project.pinjamin.data.source.network.loaning_detail.impl.LoaningDetailServiceImpl
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
