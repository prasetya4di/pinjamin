package com.project.pinjamin.usecase.item.impl

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.enum.Status
import com.project.pinjamin.usecase.item.UpdateItemUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : UpdateItemUseCase {
    override fun invoke(item: Item): Flow<Status> = flow {
        emit(Status.LOADING)
        itemRepository.fetchUpdate(item)
        itemRepository.update(item)
        emit(Status.SUCCESS)
    }
}
