package com.project.pinjamin.data.network.loaning

import com.project.pinjamin.enum.Status
import com.project.pinjamin.model.entity.Loaning

interface LoaningService {
    fun insert(loaning: Loaning): Status
    fun update(loaning: Loaning): Status
    fun delete(loaning: Loaning): Status
    fun get(): List<Loaning>
}
