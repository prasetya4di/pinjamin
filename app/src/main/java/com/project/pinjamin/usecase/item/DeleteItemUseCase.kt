package com.project.pinjamin.usecase.item

import com.project.pinjamin.data.database.entity.Item

interface DeleteItemUseCase {
    operator fun invoke(item: Item)
}
