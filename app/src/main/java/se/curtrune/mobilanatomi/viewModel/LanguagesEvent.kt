package se.curtrune.mobilanatomi.viewModel

import se.curtrune.mobilanatomi.model.ProgrammingLanguage

sealed interface LanguagesEvent {
    data class AddLanguage(val language: ProgrammingLanguage) : LanguagesEvent
    data class DeleteLanguage(val language: ProgrammingLanguage) : LanguagesEvent
    data class UpdateLanguage(val language: ProgrammingLanguage) : LanguagesEvent
    data class OnClickLanguage(val language: ProgrammingLanguage) : LanguagesEvent
}