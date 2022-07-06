package com.project.pinjamin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.pinjamin.model.entity.*
import com.project.pinjamin.model.reference.LoaningDetailItemCrossRef
import com.project.pinjamin.util.Converters

@Database(
    entities = [Admin::class, Borrower::class, Category::class, Item::class, Loaning::class, LoaningDetail::class, LoaningDetailItemCrossRef::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase()
