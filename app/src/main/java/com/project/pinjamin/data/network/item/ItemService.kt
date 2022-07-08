package com.project.pinjamin.data.network.item

import com.project.pinjamin.model.entity.Item

interface ItemService {
    fun insert(item: Item)
    fun update(item: Item)
    fun delete(item: Item)
    fun get(): List<Item>
}
