package se.curtrune.mobilanatomi.viewModel

import se.curtrune.mobilanatomi.model.ProgrammingLanguage

data class ProgrammingLanguagesState(
    val languages: List<ProgrammingLanguage> = emptyList(),
    val isLoading: Boolean = false
)
