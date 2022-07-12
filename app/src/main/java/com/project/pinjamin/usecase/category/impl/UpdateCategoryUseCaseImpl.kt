package com.project.pinjamin.usecase.category.impl

import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.enums.Status
import com.project.pinjamin.usecase.category.UpdateCategoryUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : UpdateCategoryUseCase {
    override fun invoke(category: Category): Flow<Status> = flow {
        emit(Status.LOADING)
        categoryRepository.fetchUpdate(category)
        categoryRepository.update(category)
        emit(Status.SUCCESS)
    }
}
