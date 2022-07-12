package com.project.pinjamin.usecase.item

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.enums.Status
import kotlinx.coroutines.flow.Flow

interface DeleteItemUseCase {
    operator fun invoke(item: Item): Flow<Status>
}
