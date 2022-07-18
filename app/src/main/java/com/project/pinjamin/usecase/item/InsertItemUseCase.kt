package com.project.pinjamin.usecase.item

import com.project.pinjamin.data.database.entity.Item

interface InsertItemUseCase {
    operator fun invoke(item: Item)
}
