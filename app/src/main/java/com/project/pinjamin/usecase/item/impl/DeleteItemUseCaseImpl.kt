package com.project.pinjamin.usecase.item.impl

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.enums.Status
import com.project.pinjamin.usecase.item.DeleteItemUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : DeleteItemUseCase {
    override fun invoke(item: Item): Flow<Status> = flow {
        emit(Status.LOADING)
        itemRepository.fetchDelete(item)
        itemRepository.delete(item)
        emit(Status.SUCCESS)
    }
}
