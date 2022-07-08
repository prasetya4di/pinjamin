package com.project.pinjamin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.pinjamin.data.local.admin.AdminDao
import com.project.pinjamin.data.local.borrower.BorrowerDao
import com.project.pinjamin.data.local.category.CategoryDao
import com.project.pinjamin.data.local.item.ItemDao
import com.project.pinjamin.data.local.loaning.LoaningDao
import com.project.pinjamin.data.local.loaning_detail.LoaningDetailDao
import com.project.pinjamin.model.entity.*
import com.project.pinjamin.model.reference.LoaningDetailItemCrossRef
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
}
