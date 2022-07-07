package com.project.pinjamin.data.network.category

import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.Category

interface CategoryService {
    fun insert(category: Category): Status
    fun update(category: Category): Status
    fun delete(category: Category): Status
    fun get(): List<Category>
}
