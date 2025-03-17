/*
 * Copyright (c) Layne Penney 2025.
 */

package pro.layne.sample.archs.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import pro.layne.sample.archs.core.data.PatternRepository
import pro.layne.sample.archs.core.data.DefaultPatternRepository
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsPatternRepository(
        patternRepository: DefaultPatternRepository
    ): PatternRepository
}

class FakePatternRepository @Inject constructor() : PatternRepository {
    override val patterns: Flow<List<String>> = flowOf(fakePatterns)

    override suspend fun add(name: String) {
        throw NotImplementedError()
    }
}

val fakePatterns = listOf("One", "Two", "Three")
