package com.project.pinjamin.di

import com.project.pinjamin.data.repository.*
import com.project.pinjamin.data.source.local.loaning_detail.LoaningDetailItemCrossRefDao
import com.project.pinjamin.usecase.borrower.*
import com.project.pinjamin.usecase.borrower.impl.*
import com.project.pinjamin.usecase.category.*
import com.project.pinjamin.usecase.category.impl.*
import com.project.pinjamin.usecase.item.*
import com.project.pinjamin.usecase.item.impl.*
import com.project.pinjamin.usecase.loaning.GetLoaningWithDetailUseCase
import com.project.pinjamin.usecase.loaning.GetLoaningsWithDetailUseCase
import com.project.pinjamin.usecase.loaning.InsertLoaningUseCase
import com.project.pinjamin.usecase.loaning.ReturnLoaningUseCase
import com.project.pinjamin.usecase.loaning.impl.GetLoaningWithDetailUseCaseImpl
import com.project.pinjamin.usecase.loaning.impl.GetLoaningsWithDetailUseCaseImpl
import com.project.pinjamin.usecase.loaning.impl.InsertLoaningUseCaseImpl
import com.project.pinjamin.usecase.loaning.impl.ReturnLoaningUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetCategoryUseCase(
        categoryRepository: CategoryRepository
    ): GetCategoryUseCase = GetCategoryUseCaseImpl(categoryRepository)

    @Provides
    @Singleton
    fun provideGetAllCategoryUseCase(
        categoryRepository: CategoryRepository
    ): GetAllCategoryUseCase = GetAllCategoryUseCaseImpl(categoryRepository)

    @Provides
    @Singleton
    fun provideInsertCategoryUseCase(
        categoryRepository: CategoryRepository,
    ): InsertCategoryUseCase = InsertCategoryUseCaseImpl(categoryRepository)

    @Provides
    @Singleton
    fun provideUpdateCategoryUseCase(
        categoryRepository: CategoryRepository,
    ): UpdateCategoryUseCase = UpdateCategoryUseCaseImpl(categoryRepository)

    @Provides
    @Singleton
    fun provideDeleteCategoryUseCase(
        categoryRepository: CategoryRepository,
    ): DeleteCategoryUseCase = DeleteCategoryUseCaseImpl(categoryRepository)

    @Provides
    @Singleton
    fun provideRereshCategoryUseCase(
        categoryRepository: CategoryRepository,
    ): RefreshCategoryUseCase = RefreshCategoryUseCaseImpl(categoryRepository)

    @Provides
    @Singleton
    fun provideInsertItemUseCase(
        itemRepository: ItemRepository,
    ): InsertItemUseCase = InsertItemUseCaseImpl(itemRepository)

    @Provides
    @Singleton
    fun provideGetAllItemUseCase(
        itemRepository: ItemRepository,
    ): GetAllItemUseCase = GetAllItemUseCaseImpl(itemRepository)

    @Provides
    @Singleton
    fun provideGetItemUseCase(
        itemRepository: ItemRepository,
    ): GetItemUseCase = GetItemUseCaseImpl(itemRepository)

    @Provides
    @Singleton
    fun provideUpdateItemUseCase(
        itemRepository: ItemRepository,
    ): UpdateItemUseCase = UpdateItemUseCaseImpl(itemRepository)

    @Provides
    @Singleton
    fun provideDeleteItemUseCase(
        itemRepository: ItemRepository,
    ): DeleteItemUseCase = DeleteItemUseCaseImpl(itemRepository)

    @Provides
    @Singleton
    fun provideInsertBorrowerUseCase(
        borrowerRepository: BorrowerRepository,
    ): InsertBorrowerUseCase = InsertBorrowerUseCaseImpl(borrowerRepository)

    @Provides
    @Singleton
    fun provideGetAllBorrowerUseCase(
        borrowerRepository: BorrowerRepository,
    ): GetAllBorrowerUseCase = GetAllBorrowerUseCaseImpl(borrowerRepository)

    @Provides
    @Singleton
    fun provideGetBorrowerUseCase(
        borrowerRepository: BorrowerRepository,
    ): GetBorrowerUseCase = GetBorrowerUseCaseImpl(borrowerRepository)

    @Provides
    @Singleton
    fun provideUpdateBorrowerUseCase(
        borrowerRepository: BorrowerRepository,
    ): UpdateBorrowerUseCase = UpdateBorrowerUseCaseImpl(borrowerRepository)

    @Provides
    @Singleton
    fun provideDeleteBorrowerUseCase(
        borrowerRepository: BorrowerRepository,
    ): DeleteBorrowerUseCase = DeleteBorrowerUseCaseImpl(borrowerRepository)

    @Provides
    @Singleton
    fun provideGetAllLoaningsWithDetailUseCase(
        loaningRepository: LoaningRepository
    ): GetLoaningsWithDetailUseCase = GetLoaningsWithDetailUseCaseImpl(loaningRepository)

    @Provides
    @Singleton
    fun provideGetLoaningWithDetailUseCase(
        loaningRepository: LoaningRepository
    ): GetLoaningWithDetailUseCase = GetLoaningWithDetailUseCaseImpl(loaningRepository)

    @Provides
    @Singleton
    fun provideUpdateLoaningUseCase(
        loaningRepository: LoaningRepository,
        itemRepository: ItemRepository
    ): ReturnLoaningUseCase = ReturnLoaningUseCaseImpl(loaningRepository, itemRepository)

    @Provides
    @Singleton
    fun provideInsertLoaningUseCase(
        loaningRepository: LoaningRepository,
        loaningDetailRepository: LoaningDetailRepository,
        loaningDetailItemCrossRefDao: LoaningDetailItemCrossRefDao,
        itemRepository: ItemRepository
    ): InsertLoaningUseCase = InsertLoaningUseCaseImpl(
        loaningRepository,
        loaningDetailRepository,
        loaningDetailItemCrossRefDao,
        itemRepository
    )

    @Provides
    @Singleton
    fun provideGetCategoryWithItemsUseCase(
        categoryRepository: CategoryRepository
    ): GetCategoryWithItemsUseCase = GetCategoryWithItemsUseCaseImpl(categoryRepository)
}
