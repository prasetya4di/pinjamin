package com.project.pinjamin.data.network.loaning

import com.project.pinjamin.model.entity.Loaning

interface LoaningService {
    fun insert(loaning: Loaning)
    fun update(loaning: Loaning)
    fun delete(loaning: Loaning)
    fun get(): List<Loaning>
}
