package com.project.pinjamin.usecase.item.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.usecase.item.GetItemUseCase
import javax.inject.Inject

class GetItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : GetItemUseCase {
    override fun invoke(id: Int): LiveData<Item> = itemRepository.get(id)
}
