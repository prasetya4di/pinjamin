package com.project.pinjamin.usecase.item

import com.project.pinjamin.data.database.entity.Item

interface UpdateItemUseCase {
    operator fun invoke(item: Item)
}
