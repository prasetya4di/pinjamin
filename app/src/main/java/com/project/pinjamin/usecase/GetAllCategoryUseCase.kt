package com.project.pinjamin.usecase

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Category

interface GetAllCategoryUseCase {
    operator fun invoke(): LiveData<List<Category>>
}
