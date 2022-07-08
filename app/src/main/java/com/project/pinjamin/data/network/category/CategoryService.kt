package com.project.pinjamin.data.network.category

import com.project.pinjamin.model.entity.Category

interface CategoryService {
    fun insert(category: Category)
    fun update(category: Category)
    fun delete(category: Category)
    fun get(): List<Category>
}
