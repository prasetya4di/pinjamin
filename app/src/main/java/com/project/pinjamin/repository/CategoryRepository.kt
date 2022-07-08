package com.project.pinjamin.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.model.entity.Category
import com.project.pinjamin.model.relation.CategoryWithItems

interface CategoryRepository {
    fun insert(category: Category)
    fun insert(categories: List<Category>)
    fun fetchInsert(category: Category)
    fun update(category: Category)
    fun fetchUpdate(category: Category)
    fun delete(category: Category)
    fun fetchDelete(category: Category)
    fun get(): LiveData<List<Category>>
    fun get(id: Int): LiveData<Category>
    fun getCategoryWithItems(id: Int): LiveData<CategoryWithItems>
    fun fetchCategory(): List<Category>
}
