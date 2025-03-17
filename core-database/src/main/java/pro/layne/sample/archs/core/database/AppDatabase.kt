/*
 * Copyright (c) Layne Penney 2025.
 */

package pro.layne.sample.archs.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Pattern::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun patternDao(): PatternDao
}
