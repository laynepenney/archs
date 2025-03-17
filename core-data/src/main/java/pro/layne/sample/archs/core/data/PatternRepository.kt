/*
 * Copyright (c) Layne Penney 2025.
 */

package pro.layne.sample.archs.core.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pro.layne.sample.archs.core.database.Pattern
import pro.layne.sample.archs.core.database.PatternDao
import javax.inject.Inject

interface PatternRepository {
    val patterns: Flow<List<String>>

    suspend fun add(name: String)
}

class DefaultPatternRepository @Inject constructor(
    private val patternDao: PatternDao
) : PatternRepository {

    override val patterns: Flow<List<String>> =
        patternDao.getPatterns().map { items -> items.map { it.name } }

    override suspend fun add(name: String) {
        patternDao.insertPattern(Pattern(name = name))
    }
}
