package com.project.pinjamin.usecase.category

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Category

interface GetCategoryUseCase {
    operator fun invoke(id: Int): LiveData<Category>
}
