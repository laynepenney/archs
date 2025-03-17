/*
 * Copyright (c) Layne Penney 2025.
 */

package pro.layne.sample.archs.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pro.layne.sample.archs.core.database.AppDatabase
import pro.layne.sample.archs.core.database.PatternDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun providePatternDao(appDatabase: AppDatabase): PatternDao {
        return appDatabase.patternDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "Pattern"
        ).build()
    }
}
