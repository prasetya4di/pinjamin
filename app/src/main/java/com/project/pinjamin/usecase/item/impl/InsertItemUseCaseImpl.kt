package com.project.pinjamin.usecase.item.impl

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.enums.Status
import com.project.pinjamin.usecase.item.InsertItemUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InsertItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : InsertItemUseCase {
    override fun invoke(item: Item): Flow<Status> = flow {
        emit(Status.LOADING)
        itemRepository.fetchInsert(item)
        itemRepository.insert(item)
        emit(Status.SUCCESS)
    }
}
