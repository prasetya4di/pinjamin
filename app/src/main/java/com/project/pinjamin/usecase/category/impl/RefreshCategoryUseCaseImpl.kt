package com.project.pinjamin.usecase.category.impl

import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.enums.Status
import com.project.pinjamin.usecase.category.RefreshCategoryUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RefreshCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : RefreshCategoryUseCase {
    override fun invoke(): Flow<Status> = flow {
        emit(Status.LOADING)
        categoryRepository.insert(categoryRepository.fetchCategory())
        emit(Status.SUCCESS)
    }
}
