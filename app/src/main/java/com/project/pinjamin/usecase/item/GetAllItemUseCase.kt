package com.project.pinjamin.usecase.item

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Item

interface GetAllItemUseCase {
    operator fun invoke(): LiveData<List<Item>>
}
