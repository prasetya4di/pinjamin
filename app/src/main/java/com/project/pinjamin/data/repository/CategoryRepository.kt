package com.project.pinjamin.data.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.database.relation.CategoryWithItems

interface CategoryRepository {
    fun insert(category: Category): Long
    fun insert(categories: List<Category>)
    fun fetchInsert(category: Category)
    fun update(category: Category)
    fun fetchUpdate(category: Category)
    fun delete(category: Category)
    fun fetchDelete(category: Category)
    fun get(): LiveData<List<Category>>
    fun get(id: Int): LiveData<Category>
    fun getCategoryWithItems(id: Int): CategoryWithItems
    fun fetchCategory(): List<Category>
}
