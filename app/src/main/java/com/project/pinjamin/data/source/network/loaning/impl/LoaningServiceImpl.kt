package com.project.pinjamin.data.source.network.loaning.impl

import com.project.pinjamin.data.database.entity.Item
import com.project.pinjamin.data.database.entity.Loaning
import com.project.pinjamin.data.source.network.loaning.LoaningService

class LoaningServiceImpl : LoaningService {
    override fun insert(loaning: Loaning) {
        TODO("Not yet implemented")
    }

    override fun insert(loaning: Loaning, items: List<Item>) {
        TODO("Not yet implemented, and add return based on response")
    }

    override fun update(loaning: Loaning) {
        TODO("Not yet implemented")
    }

    override fun delete(loaning: Loaning) {
        TODO("Not yet implemented")
    }

    override fun get(): List<Loaning> {
        TODO("Not yet implemented")
    }
}
