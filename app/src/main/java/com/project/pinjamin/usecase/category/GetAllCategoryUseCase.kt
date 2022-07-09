package com.project.pinjamin.usecase.category

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Category

interface GetAllCategoryUseCase {
    operator fun invoke(): LiveData<List<Category>>
}
