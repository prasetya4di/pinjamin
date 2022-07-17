package com.project.pinjamin.di

import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.usecase.category.*
import com.project.pinjamin.usecase.category.impl.*
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
}
