package com.project.pinjamin.usecase.item

import com.project.pinjamin.enums.Status
import kotlinx.coroutines.flow.Flow

interface RefreshItemUseCase {
    operator fun invoke(): Flow<Status>
}
