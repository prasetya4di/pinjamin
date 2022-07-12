package com.project.pinjamin.usecase.category.impl

import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.enums.Status
import com.project.pinjamin.usecase.category.InsertCategoryUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InsertCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : InsertCategoryUseCase {
    override fun invoke(category: Category): Flow<Status> = flow {
        emit(Status.LOADING)
        categoryRepository.fetchInsert(category)
        categoryRepository.insert(category)
        emit(Status.SUCCESS)
    }
}
