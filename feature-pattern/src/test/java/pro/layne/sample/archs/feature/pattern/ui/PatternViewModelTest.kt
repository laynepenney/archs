/*
 * Copyright (c) Layne Penney 2025.
 */

package pro.layne.sample.archs.feature.pattern.ui.pattern


import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import pro.layne.sample.archs.core.data.PatternRepository
import pro.layne.sample.archs.feature.pattern.ui.PatternUiState
import pro.layne.sample.archs.feature.pattern.ui.PatternViewModel

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class PatternViewModelTest {
    @Test
    fun uiState_initiallyLoading() = runTest {
        val viewModel = PatternViewModel(FakePatternRepository())
        assertEquals(viewModel.uiState.first(), PatternUiState.Loading)
    }

    @Test
    fun uiState_onItemSaved_isDisplayed() = runTest {
        val viewModel = PatternViewModel(FakePatternRepository())
        assertEquals(viewModel.uiState.first(), PatternUiState.Loading)
    }
}

private class FakePatternRepository : PatternRepository {

    private val data = mutableListOf<String>()

    override val patterns: Flow<List<String>>
        get() = flow { emit(data.toList()) }

    override suspend fun add(name: String) {
        data.add(0, name)
    }
}
