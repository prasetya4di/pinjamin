package com.project.pinjamin.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.model.entity.Item

interface ItemRepository {
    fun insert(item: Item)
    fun insert(items: List<Item>)
    fun fetchInsert(item: Item)
    fun update(item: Item)
    fun fetchUpdate(item: Item)
    fun delete(item: Item)
    fun fetchDelete(item: Item)
    fun get(): LiveData<List<Item>>
    fun get(id: Int): LiveData<Item>
    fun fetchGet(): List<Item>
}
