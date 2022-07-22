package com.project.pinjamin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.pinjamin.data.database.entity.*
import com.project.pinjamin.data.database.reference.LoaningDetailItemCrossRef
import com.project.pinjamin.data.source.local.admin.AdminDao
import com.project.pinjamin.data.source.local.borrower.BorrowerDao
import com.project.pinjamin.data.source.local.category.CategoryDao
import com.project.pinjamin.data.source.local.item.ItemDao
import com.project.pinjamin.data.source.local.loaning.LoaningDao
import com.project.pinjamin.data.source.local.loaning_detail.LoaningDetailDao
import com.project.pinjamin.data.source.local.loaning_detail.LoaningDetailItemCrossRefDao
import com.project.pinjamin.util.Converters

@Database(
    entities = [Admin::class, Borrower::class, Category::class, Item::class, Loaning::class, LoaningDetail::class, LoaningDetailItemCrossRef::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun adminDao(): AdminDao
    abstract fun borrowerDao(): BorrowerDao
    abstract fun categoryDao(): CategoryDao
    abstract fun itemDao(): ItemDao
    abstract fun loaningDao(): LoaningDao
    abstract fun loaningDetailDao(): LoaningDetailDao
    abstract fun loaningDetailItemCrossRefDao(): LoaningDetailItemCrossRefDao
}
