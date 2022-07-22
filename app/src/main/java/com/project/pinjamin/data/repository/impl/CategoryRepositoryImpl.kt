package com.project.pinjamin.data.repository.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.database.relation.CategoryWithItems
import com.project.pinjamin.data.repository.CategoryRepository
import com.project.pinjamin.data.source.local.category.CategoryDao
import com.project.pinjamin.data.source.network.category.CategoryService
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao,
    private val categoryService: CategoryService
) : CategoryRepository {
    override fun insert(category: Category) = categoryDao.insert(category)

    override fun insert(categories: List<Category>) = categoryDao.insert(categories)

    override fun fetchInsert(category: Category) = categoryService.insert(category)

    override fun update(category: Category) = categoryDao.update(category)

    override fun fetchUpdate(category: Category) = categoryService.update(category)

    override fun delete(category: Category) = categoryDao.delete(category)

    override fun fetchDelete(category: Category) = categoryService.delete(category)

    override fun get(): LiveData<List<Category>> = categoryDao.get()

    override fun get(id: Int): LiveData<Category> = categoryDao.get(id)

    override fun getCategoryWithItems(id: Int): CategoryWithItems =
        categoryDao.getCategoryWithItems(id)

    override fun fetchCategory(): List<Category> = categoryService.get()
}
