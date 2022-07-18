package com.project.pinjamin.usecase.item.impl

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.usecase.item.DeleteItemUseCase
import javax.inject.Inject

class DeleteItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : DeleteItemUseCase {
    override fun invoke(item: Item) {
        itemRepository.fetchDelete(item)
        itemRepository.delete(item)
    }
}
