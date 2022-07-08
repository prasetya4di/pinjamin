package com.project.pinjamin.data.source.network.category

import com.project.pinjamin.data.database.entity.Category

interface CategoryService {
    fun insert(category: Category)
    fun update(category: Category)
    fun delete(category: Category)
    fun get(): List<Category>
}
