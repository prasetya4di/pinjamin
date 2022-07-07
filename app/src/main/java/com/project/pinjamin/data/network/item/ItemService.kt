package com.project.pinjamin.data.network.item

import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.Item

interface ItemService {
    fun insert(item: Item): Status
    fun update(item: Item): Status
    fun delete(item: Item): Status
    fun get(): List<Item>
}
