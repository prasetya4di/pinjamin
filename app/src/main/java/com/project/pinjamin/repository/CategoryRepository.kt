package com.project.pinjamin.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.Category
import com.project.pinjamin.model.relation.CategoryWithItems
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun insert(category: Category): Flow<Status>
    fun update(category: Category): Flow<Status>
    fun delete(category: Category): Flow<Status>
    fun get(): LiveData<List<Category>>
    fun get(id: Int): LiveData<Category>
    fun getCategoryWithItems(id: Int): LiveData<CategoryWithItems>
}
