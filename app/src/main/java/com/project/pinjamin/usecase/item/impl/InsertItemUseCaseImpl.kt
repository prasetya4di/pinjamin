package com.project.pinjamin.usecase.item.impl

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.usecase.item.InsertItemUseCase
import javax.inject.Inject

class InsertItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : InsertItemUseCase {
    override fun invoke(item: Item) {
        itemRepository.fetchInsert(item)
        itemRepository.insert(item)
    }
}
