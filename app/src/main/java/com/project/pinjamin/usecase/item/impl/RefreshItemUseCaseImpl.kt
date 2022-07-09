package com.project.pinjamin.usecase.item.impl

import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.enum.Status
import com.project.pinjamin.usecase.item.RefreshItemUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RefreshItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : RefreshItemUseCase {
    override fun invoke(): Flow<Status> = flow {
        emit(Status.LOADING)
        itemRepository.insert(itemRepository.fetchGet())
        emit(Status.SUCCESS)
    }
}
