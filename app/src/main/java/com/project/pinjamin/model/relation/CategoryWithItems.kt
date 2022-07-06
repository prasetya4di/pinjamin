package com.project.pinjamin.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.project.pinjamin.model.entity.Category
import com.project.pinjamin.model.entity.Item

data class CategoryWithItems(
    @Embedded
    val category: Category,
    @Relation(
        parentColumn = "id_kategori",
        entityColumn = "id_kategori"
    )
    val items: List<Item>
)
