package com.project.pinjamin.repository.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.local.category.CategoryDao
import com.project.pinjamin.data.network.category.CategoryService
import com.project.pinjamin.model.entity.Category
import com.project.pinjamin.model.relation.CategoryWithItems
import com.project.pinjamin.repository.CategoryRepository
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

    override fun getCategoryWithItems(id: Int): LiveData<CategoryWithItems> =
        categoryDao.getCategoryWithItems(id)

    override fun fetchCategory(): List<Category> = categoryService.get()
}
