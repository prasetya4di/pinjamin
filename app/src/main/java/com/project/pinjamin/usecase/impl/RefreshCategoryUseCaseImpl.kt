package com.project.pinjamin.usecase.impl

import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.enum.Status
import com.project.pinjamin.usecase.RefreshCategoryUseCase
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
