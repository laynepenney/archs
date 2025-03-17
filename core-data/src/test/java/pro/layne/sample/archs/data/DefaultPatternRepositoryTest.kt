/*
 * Copyright (c) Layne Penney 2025.
 */

package pro.layne.sample.archs.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import pro.layne.sample.archs.core.data.DefaultPatternRepository
import pro.layne.sample.archs.core.database.Pattern
import pro.layne.sample.archs.core.database.PatternDao

/**
 * Unit tests for [DefaultPatternRepository].
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class DefaultPatternRepositoryTest {

    @Test
    fun patterns_newItemSaved_itemIsReturned() = runTest {
        val repository = DefaultPatternRepository(FakePatternDao())

        repository.add("Repository")

        assertEquals(repository.patterns.first().size, 1)
    }

}

private class FakePatternDao : PatternDao {

    private val data = mutableListOf<Pattern>()

    override fun getPatterns(): Flow<List<Pattern>> = flow {
        emit(data)
    }

    override suspend fun insertPattern(item: Pattern) {
        data.add(0, item)
    }
}
