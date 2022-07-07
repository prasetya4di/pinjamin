package com.project.pinjamin.repository

import androidx.lifecycle.LiveData
import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun insert(item: Item): Flow<Status>
    fun update(item: Item): Flow<Status>
    fun delete(item: Item): Flow<Status>
    fun get(): LiveData<List<Item>>
    fun get(id: Int): LiveData<Item>
}
