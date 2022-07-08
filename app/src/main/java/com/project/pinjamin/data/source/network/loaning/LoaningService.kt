package com.project.pinjamin.data.source.network.loaning

import com.project.pinjamin.data.database.entity.Loaning

interface LoaningService {
    fun insert(loaning: Loaning)
    fun update(loaning: Loaning)
    fun delete(loaning: Loaning)
    fun get(): List<Loaning>
}
