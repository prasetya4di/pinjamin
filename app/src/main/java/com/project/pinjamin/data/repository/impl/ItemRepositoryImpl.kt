package com.project.pinjamin.data.repository.impl

import androidx.lifecycle.LiveData
import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.repository.ItemRepository
import com.project.pinjamin.data.source.local.item.ItemDao
import com.project.pinjamin.data.source.network.item.ItemService
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
    private val itemService: ItemService
) : ItemRepository {
    override fun insert(item: Item) = itemDao.insert(item)

    override fun insert(items: List<Item>) = itemDao.insert(items)

    override fun fetchInsert(item: Item) = itemDao.insert(item)

    override fun update(item: Item) = itemDao.update(item)

    override fun fetchUpdate(item: Item) = itemService.update(item)

    override fun delete(item: Item) = itemDao.delete(item)

    override fun fetchDelete(item: Item) = itemService.delete(item)

    override fun get(): LiveData<List<Item>> = itemDao.get()

    override fun get(id: Int): LiveData<Item> = itemDao.get(id)

    override fun fetchGet(): List<Item> = itemService.get()
}
