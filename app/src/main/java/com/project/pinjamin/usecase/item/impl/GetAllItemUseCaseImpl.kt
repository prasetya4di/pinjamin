package com.project.pinjamin.usecase.item.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.usecase.item.GetAllItemUseCase
import javax.inject.Inject

class GetAllItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : GetAllItemUseCase {
    override fun invoke(): LiveData<List<Item>> = itemRepository.get()
}
