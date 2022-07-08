package com.project.pinjamin.data.source.network.item

import com.project.pinjamin.data.database.entity.Item

interface ItemService {
    fun insert(item: Item)
    fun update(item: Item)
    fun delete(item: Item)
    fun get(): List<Item>
}
