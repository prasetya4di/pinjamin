package com.project.pinjamin.di

import android.content.Context
import androidx.room.Room
import com.project.pinjamin.data.local.admin.AdminDao
import com.project.pinjamin.data.local.borrower.BorrowerDao
import com.project.pinjamin.data.local.category.CategoryDao
import com.project.pinjamin.data.local.item.ItemDao
import com.project.pinjamin.data.local.loaning.LoaningDao
import com.project.pinjamin.data.local.loaning_detail.LoaningDetailDao
import com.project.pinjamin.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideAdminDao(appDatabase: AppDatabase): AdminDao {
        return appDatabase.adminDao()
    }

    @Provides
    fun provideBorrowerDao(appDatabase: AppDatabase): BorrowerDao {
        return appDatabase.borrowerDao()
    }

    @Provides
    fun provideCategoryDao(appDatabase: AppDatabase): CategoryDao {
        return appDatabase.categoryDao()
    }

    @Provides
    fun provideItemDao(appDatabase: AppDatabase): ItemDao {
        return appDatabase.itemDao()
    }

    @Provides
    fun provideLoaningDao(appDatabase: AppDatabase): LoaningDao {
        return appDatabase.loaningDao()
    }

    @Provides
    fun provideLoaningDetailDao(appDatabase: AppDatabase): LoaningDetailDao {
        return appDatabase.loaningDetailDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "Pinjamin"
        ).build()
    }
}
