package com.project.pinjamin.usecase.item.impl

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.usecase.item.UpdateItemUseCase
import javax.inject.Inject

class UpdateItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : UpdateItemUseCase {
    override fun invoke(item: Item) {
        itemRepository.fetchUpdate(item)
        itemRepository.update(item)
    }
}
