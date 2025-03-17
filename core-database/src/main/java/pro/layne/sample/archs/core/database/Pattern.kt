/*
 * Copyright (c) Layne Penney 2025.
 */

package pro.layne.sample.archs.core.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity
data class Pattern(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

@Dao
interface PatternDao {
    @Query("SELECT * FROM pattern ORDER BY uid DESC LIMIT 10")
    fun getPatterns(): Flow<List<Pattern>>

    @Insert
    suspend fun insertPattern(item: Pattern)
}
