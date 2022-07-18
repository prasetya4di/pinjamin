package com.project.pinjamin.di

import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.usecase.category.*
import com.project.pinjamin.usecase.category.impl.*
import com.project.pinjamin.usecase.item.*
import com.project.pinjamin.usecase.item.impl.*
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
}
