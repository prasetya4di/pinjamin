package com.project.pinjamin.di

import com.project.pinjamin.data.local.admin.AdminDao
import com.project.pinjamin.data.local.borrower.BorrowerDao
import com.project.pinjamin.data.local.category.CategoryDao
import com.project.pinjamin.data.local.item.ItemDao
import com.project.pinjamin.data.local.loaning.LoaningDao
import com.project.pinjamin.data.local.loaning_detail.LoaningDetailDao
import com.project.pinjamin.data.network.admin.AdminService
import com.project.pinjamin.data.network.borrower.BorrowerService
import com.project.pinjamin.data.network.category.CategoryService
import com.project.pinjamin.data.network.item.ItemService
import com.project.pinjamin.data.network.loaning.LoaningService
import com.project.pinjamin.data.network.loaning_detail.LoaningDetailService
import com.project.pinjamin.repository.*
import com.project.pinjamin.repository.impl.*
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

    @Provides
    @Singleton
    fun provideBorrowerRepository(
        borrowerDao: BorrowerDao,
        borrowerService: BorrowerService
    ): BorrowerRepository =
        BorrowerRepositoryImpl(borrowerDao, borrowerService)

    @Provides
    @Singleton
    fun provideCategoryRepository(
        categoryDao: CategoryDao,
        categoryService: CategoryService
    ): CategoryRepository =
        CategoryRepositoryImpl(categoryDao, categoryService)

    @Provides
    @Singleton
    fun provideItemRepository(itemDao: ItemDao, itemService: ItemService): ItemRepository =
        ItemRepositoryImpl(itemDao, itemService)

    @Provides
    @Singleton
    fun provideLoaningRepository(
        loaningDao: LoaningDao,
        loaningService: LoaningService
    ): LoaningRepository =
        LoaningRepositoryImpl(loaningDao, loaningService)

    @Provides
    @Singleton
    fun provideLoaningDetailRepository(
        loaningDetailDao: LoaningDetailDao,
        loaningDetailService: LoaningDetailService
    ): LoaningDetailRepository =
        LoaningDetailRepositoryImpl(loaningDetailDao, loaningDetailService)
}
