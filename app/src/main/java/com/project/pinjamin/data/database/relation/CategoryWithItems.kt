package com.project.pinjamin.data.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.project.pinjamin.data.database.entity.Category
import com.project.pinjamin.data.database.entity.Item

data class CategoryWithItems(
    @Embedded
    val category: Category,
    @Relation(
        parentColumn = "id_kategori",
        entityColumn = "id_kategori"
    )
    var items: List<Item>
)
