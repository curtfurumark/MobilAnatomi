package se.curtrune.mobilanatomi.viewModel

import se.curtrune.mobilanatomi.model.ProgrammingLanguage

sealed interface ProgrammingLanguagesEvent {
    data class AddLanguage(val language: ProgrammingLanguage) : ProgrammingLanguagesEvent
    data class DeleteLanguage(val language: ProgrammingLanguage) : ProgrammingLanguagesEvent
    data class UpdateLanguage(val language: ProgrammingLanguage) : ProgrammingLanguagesEvent
    data class OnClickLanguage(val language: ProgrammingLanguage) : ProgrammingLanguagesEvent

}