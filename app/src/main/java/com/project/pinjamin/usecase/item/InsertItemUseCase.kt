package com.project.pinjamin.usecase.item

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.enum.Status
import kotlinx.coroutines.flow.Flow

interface InsertItemUseCase {
    operator fun invoke(item: Item): Flow<Status>
}
