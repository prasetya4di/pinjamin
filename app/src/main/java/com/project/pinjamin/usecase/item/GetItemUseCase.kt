package com.project.pinjamin.usecase.item

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Item

interface GetItemUseCase {
    operator fun invoke(id: Int): LiveData<Item>
}
