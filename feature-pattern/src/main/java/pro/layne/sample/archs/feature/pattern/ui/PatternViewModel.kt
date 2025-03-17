/*
 * Copyright (c) Layne Penney 2025.
 */

package pro.layne.sample.archs.feature.pattern.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pro.layne.sample.archs.core.data.PatternRepository
import pro.layne.sample.archs.feature.pattern.ui.PatternUiState.Error
import pro.layne.sample.archs.feature.pattern.ui.PatternUiState.Loading
import pro.layne.sample.archs.feature.pattern.ui.PatternUiState.Success
import javax.inject.Inject

@HiltViewModel
class PatternViewModel @Inject constructor(
    private val patternRepository: PatternRepository
) : ViewModel() {

    val uiState: StateFlow<PatternUiState> = patternRepository
        .patterns.map<List<String>, PatternUiState> { Success(data = it) }
        .catch { emit(Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    fun addPattern(name: String) {
        viewModelScope.launch {
            patternRepository.add(name)
        }
    }
}

sealed interface PatternUiState {
    object Loading : PatternUiState
    data class Error(val throwable: Throwable) : PatternUiState
    data class Success(val data: List<String>) : PatternUiState
}
