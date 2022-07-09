package com.project.pinjamin.data.source.network.loaning

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.database.entity.Loaning

interface LoaningService {
    fun insert(loaning: Loaning)
    fun insert(loaning: Loaning, items: List<Item>)
    fun update(loaning: Loaning)
    fun delete(loaning: Loaning)
    fun get(): List<Loaning>
}
